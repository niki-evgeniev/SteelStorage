package nevg.steelstorage.Service.Impl;

import nevg.steelstorage.Models.DTO.Earnings.AddEarningsDTO;
import nevg.steelstorage.Models.Entity.Earnings;
import nevg.steelstorage.Models.Entity.Machine;
import nevg.steelstorage.Models.Entity.Steel;
import nevg.steelstorage.Models.Entity.User;
import nevg.steelstorage.Repository.EarningRepository;
import nevg.steelstorage.Repository.MachineRepository;
import nevg.steelstorage.Repository.SteelRepository;
import nevg.steelstorage.Repository.UserRepository;
import nevg.steelstorage.Service.EarningsService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EarningsServiceImpl implements EarningsService {


    private final EarningRepository earningRepository;
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final SteelRepository steelRepository;

    public EarningsServiceImpl(EarningRepository earningRepository, MachineRepository machineRepository,
                               UserRepository userRepository, ModelMapper modelMapper,
                               SteelRepository steelRepository) {
        this.earningRepository = earningRepository;
        this.machineRepository = machineRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.steelRepository = steelRepository;
    }

    @Override
    public boolean addEarning(AddEarningsDTO addEarningsDTO, UserDetails userDetails) {
        Earnings earnings = new Earnings();

        Optional<Machine> findMachineByUuid = machineRepository.findByUuid(UUID.fromString(addEarningsDTO.getMachine()));

        earnings.setAddedDate(addEarningsDTO.getTimeAdd());
        int numberOfPart = Integer.parseInt(addEarningsDTO.getNumberOfSteel());
        earnings.setAddedQuantity(numberOfPart);

        Optional<User> userByEmail = userRepository.findByEmail(userDetails.getUsername());
        if (findMachineByUuid.isPresent() && userByEmail.isPresent()) {
            earnings.setUser(userByEmail.get());
            earnings.setMachine(findMachineByUuid.get());
            int diameterOfSteel = Integer.parseInt(addEarningsDTO.getDiameter());
            Optional<Steel> getCountSteel = steelRepository.findBySteelSize(diameterOfSteel);
            if (getCountSteel.isPresent()) {
                Steel steel = getCountSteel.get();
                int steelCount = steel.getCount();
                int numberOfSteel = Integer.parseInt(addEarningsDTO.getNumberOfSteel());
                steel.setCount(steelCount - numberOfSteel);
                steelRepository.save(steel);
                earningRepository.save(earnings);
            }
            return true;
        }
        return false;
    }
}
