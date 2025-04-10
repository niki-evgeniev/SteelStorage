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
        String[] machine = addEarningsDTO.getMachine().split("\\s+");
        int length = machine.length;
        String testModelName = "";

        for (int i = 1; i < length; i++) {
            testModelName = testModelName + " " + machine[i];
        }

//        String machineModel = machine[1];
//        Optional<Machine> machineByBrand = machineRepository.findByBrand(machineModel);
//        Optional<Machine> byModelAndCounting = machineRepository.findByModelAndCounting(machineModel);
//        Optional<Machine> machineByBrand = machineRepository.findByModel(machineModel);

        Optional<Machine> machineByBrand = machineRepository.findOneByModel(testModelName);

        Optional<User> userByEmail = userRepository.findByEmail(userDetails.getUsername());

        earnings.setAddedDate(addEarningsDTO.getTimeAdd());
        earnings.setAddedQuantity(Integer.parseInt(addEarningsDTO.getNumberOfSteel()));
        if (machineByBrand.isPresent() && userByEmail.isPresent()) {
            earnings.setUser(userByEmail.get());
            earnings.setMachine(machineByBrand.get());
            Optional<Steel> getCountSteel = steelRepository.findBySteelSize(Integer.parseInt(addEarningsDTO.getDiameter()));
            if (getCountSteel.isPresent()) {
                Steel steel = getCountSteel.get();
                int count = steel.getCount();
                int numberOfSteel = Integer.parseInt(addEarningsDTO.getNumberOfSteel());
                steel.setCount(count - numberOfSteel);
                steelRepository.save(steel);
                earningRepository.save(earnings);
            }

            return true;
        }
        return false;
    }
}
