package nevg.steelstorage.Models.DTO.Earnings;

import java.time.LocalDateTime;

public class AddEarningsDTO {

    private String numberOfSteel;

    private LocalDateTime timeAdd;

    private String description;

    private String diameter;

    private String machine;

    private String uuid;

    public AddEarningsDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getNumberOfSteel() {
        return numberOfSteel;
    }

    public void setNumberOfSteel(String numberOfSteel) {
        this.numberOfSteel = numberOfSteel;
    }

    public LocalDateTime getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(LocalDateTime timeAdd) {
        this.timeAdd = timeAdd;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
