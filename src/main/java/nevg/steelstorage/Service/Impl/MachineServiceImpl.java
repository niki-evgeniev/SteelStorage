package nevg.steelstorage.Service.Impl;

import nevg.steelstorage.Models.DTO.machine.AddMachineDTO;
import nevg.steelstorage.Models.Entity.Machine;
import nevg.steelstorage.Models.Entity.User;
import nevg.steelstorage.Repository.MachineRepository;
import nevg.steelstorage.Repository.UserRepository;
import nevg.steelstorage.Service.MachineService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MachineServiceImpl implements MachineService {

    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public MachineServiceImpl(MachineRepository machineRepository, UserRepository userRepository,
                              ModelMapper modelMapper) {
        this.machineRepository = machineRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addNewMachine(AddMachineDTO addMachineDTO, UserDetails userDetails) {

        Optional<Machine> bySerialNumber = machineRepository.findBySerialNumber(addMachineDTO.getSerialNumber());
        if (bySerialNumber.isPresent()) {
            return false;
        }

        Machine newMachine = new Machine();
        newMachine = modelMapper.map(addMachineDTO, Machine.class);
        String username = userDetails.getUsername();
        Optional<User> findUserAddMachine = userRepository.findByEmail(userDetails.getUsername());
        if (findUserAddMachine.isPresent()) {
            newMachine.setMachineList(findUserAddMachine.get());
            machineRepository.save(newMachine);
        }
        return true;
    }
}
