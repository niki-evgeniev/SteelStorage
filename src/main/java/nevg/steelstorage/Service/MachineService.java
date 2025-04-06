package nevg.steelstorage.Service;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.machine.AddMachineDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface MachineService {
    boolean addNewMachine(@Valid AddMachineDTO addMachineDTO, UserDetails userDetails);
}
