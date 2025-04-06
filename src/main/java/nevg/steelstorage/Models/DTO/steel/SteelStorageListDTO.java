package nevg.steelstorage.Models.DTO.steel;

import java.util.List;

public class SteelStorageListDTO {

    private List<SteelStorageDTO> material;

    public SteelStorageListDTO() {
    }

    public List<SteelStorageDTO> getMaterial() {
        return material;
    }

    public void setMaterial(List<SteelStorageDTO> material) {
        this.material = material;
    }
}
