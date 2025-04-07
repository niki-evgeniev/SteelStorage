package nevg.steelstorage.Service;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.Machines.AddMachineDTO;
import nevg.steelstorage.Models.DTO.Machines.GetMachineModelDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface MachineService {
    boolean addNewMachine(@Valid AddMachineDTO addMachineDTO, UserDetails userDetails);

    List<GetMachineModelDTO> getMachineBrandsAndModel();
}
