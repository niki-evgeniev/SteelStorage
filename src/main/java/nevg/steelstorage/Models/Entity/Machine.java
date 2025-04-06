package nevg.steelstorage.Models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity(name = "machines")
public class Machine extends BaseEntity {

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    @ManyToOne
    private User machineList;

    public Machine() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public User getMachineList() {
        return machineList;
    }

    public void setMachineList(User machineList) {
        this.machineList = machineList;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
