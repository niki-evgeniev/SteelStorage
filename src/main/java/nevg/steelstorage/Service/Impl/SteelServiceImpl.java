package nevg.steelstorage.Service.Impl;

import nevg.steelstorage.Models.DTO.Steel.GetDiametersDTO;
import nevg.steelstorage.Models.DTO.Steel.SteelStorageDTO;
import nevg.steelstorage.Models.Entity.Steel;
import nevg.steelstorage.Models.Enums.SteelType;
import nevg.steelstorage.Repository.SteelRepository;
import nevg.steelstorage.Service.SteelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SteelServiceImpl implements SteelService {

    private final SteelRepository steelRepository;
    private final ModelMapper modelMapper;

    public SteelServiceImpl(SteelRepository steelRepository, ModelMapper modelMapper) {
        this.steelRepository = steelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addSteel() {
        if (steelRepository.count() == 0) {
            List<Integer> sizeOfSteel = List.of(28, 42, 73, 76);
            for (Integer i : sizeOfSteel) {
                Steel steel = new Steel();
                steel.setLastModified(LocalDateTime.now());
                steel.setSteelSize(i);
                steel.setAddedDate(LocalDateTime.now());
                steel.setCount(i + 5);
                steel.setTotalCount(233 + i);
                if (i.equals(28) || i.equals(42)) {
                    steel.setSteelType(SteelType.Calibrated);
                } else {
                    steel.setSteelType(SteelType.Pipe);
                }
                steelRepository.save(steel);
            }
        }
    }

    @Override
    public List<SteelStorageDTO> getAllSteelMaterial() {
        List<Steel> allSteel = steelRepository.findAll();
        List<SteelStorageDTO> steelStorageDTOS = allSteel
                .stream()
                .map(steel -> {
                    SteelStorageDTO ss = new SteelStorageDTO();
                    return modelMapper.map(steel, SteelStorageDTO.class);
                })
                .sorted(Comparator.comparing(SteelStorageDTO::getSteelSize))
                .collect(Collectors.toList());
        return steelStorageDTOS;
    }

    @Override
    public List<GetDiametersDTO> getDiameterForAllSteel() {
        List<Steel> allSteel = steelRepository.findAll();
        List<GetDiametersDTO> diameterDTOS = allSteel
                .stream()
                .map(steel -> {
                    return modelMapper.map(steel, GetDiametersDTO.class);
                }).sorted(Comparator.comparing(GetDiametersDTO::getSteelSize))
                .collect(Collectors.toList());
        return diameterDTOS;
    }

    @Override
    public boolean checkAvailability(String numberOfSteel, String diameter) {
        int diameterSize = Integer.parseInt(diameter);
        int countOfPieces = Integer.parseInt(numberOfSteel);
        Optional<Steel> steel = steelRepository.findBySteelSize(diameterSize);

        if (steel.isPresent()) {
            Integer count = steel.get().getCount();
            if (count <= 0 || count - countOfPieces <= 0) {
                return false;
            }
        }
        return true;
    }
}
