package nevg.steelstorage.Service;

import nevg.steelstorage.Models.DTO.Steel.GetDiametersDTO;
import nevg.steelstorage.Models.DTO.Steel.SteelStorageDTO;

import java.util.List;

public interface SteelService {
    void addSteel();

    List<SteelStorageDTO> getAllSteelMaterial();

    List<GetDiametersDTO> getDiameterForAllSteel();

    boolean checkAvailability(String numberOfSteel, String diameter);
}
