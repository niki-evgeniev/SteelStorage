package nevg.steelstorage.Service;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.Steel.AddSteelDTO;
import nevg.steelstorage.Models.DTO.Steel.GetDiametersDTO;
import nevg.steelstorage.Models.DTO.Steel.SteelStorageDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface SteelService {
    void addSteel();

    List<SteelStorageDTO> getAllSteelMaterial();

    List<GetDiametersDTO> getDiameterForAllSteel();

    boolean checkAvailability(String numberOfSteel, String diameter);

    void addCutSteel(@Valid AddSteelDTO addSteelDTO, UserDetails userDetails);
}
