package nevg.steelstorage.Service;

import nevg.steelstorage.Models.DTO.Steel.GetDiameterDTO;
import nevg.steelstorage.Models.DTO.Steel.SteelStorageDTO;

import java.util.List;

public interface SteelService {
    void addSteel();

    List<SteelStorageDTO> getAllSteelMaterial();

    List<GetDiameterDTO> getDiameterForAllSteel();
}
