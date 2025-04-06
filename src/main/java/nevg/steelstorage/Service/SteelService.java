package nevg.steelstorage.Service;

import nevg.steelstorage.Models.DTO.steel.GetDiameterDTO;
import nevg.steelstorage.Models.DTO.steel.SteelStorageDTO;

import java.util.List;

public interface SteelService {
    void addSteel();

    List<SteelStorageDTO> getAllSteelMaterial();

    List<GetDiameterDTO> getDiameterForAllSteel();
}
