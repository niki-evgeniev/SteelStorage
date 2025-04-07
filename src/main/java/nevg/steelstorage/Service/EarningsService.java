package nevg.steelstorage.Service;

import jakarta.validation.Valid;
import nevg.steelstorage.Models.DTO.Earnings.AddEarningsDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface EarningsService {

    boolean addEarning(@Valid AddEarningsDTO addEarningsDTO, UserDetails userDetails);
}
