package nevg.steelstorage.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table
@Entity(name = "steel_type")
public class SteelType extends BaseEntity{

    @Column
    private String steelType;

    @Column
    private String steelSize;

    public SteelType() {
    }

    public String getSteelType() {
        return steelType;
    }

    public void setSteelType(String steelType) {
        this.steelType = steelType;
    }

    public String getSteelSize() {
        return steelSize;
    }

    public void setSteelSize(String steelSize) {
        this.steelSize = steelSize;
    }
}
