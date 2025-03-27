package nevg.steelstorage.Models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity(name = "machines")
public class Machine extends BaseEntity {

    @Column(name = "machine_name")
    private String machineName;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    @ManyToOne
    private User machineList;

    public Machine() {
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public User getMachineList() {
        return machineList;
    }

    public void setMachineList(User machineList) {
        this.machineList = machineList;
    }
}
