package nevg.steelstorage.Service.Impl;

import nevg.steelstorage.Models.Entity.Steel;
import nevg.steelstorage.Repository.SteelRepository;
import nevg.steelstorage.Service.SteelService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SteelServiceImpl implements SteelService {

    private final SteelRepository steelRepository;

    public SteelServiceImpl(SteelRepository steelRepository) {
        this.steelRepository = steelRepository;
    }

    @Override
    public void addSteel() {
        if (steelRepository.count() == 0) {
            List<Integer> sizeOfSteel = List.of(28, 42, 73, 76);
            for (Integer i : sizeOfSteel) {
                Steel steel = new Steel();
                steel.setLastModified(LocalDateTime.now());
                steel.setSteelSize(i);
                steelRepository.save(steel);
            }
        }
    }
}
