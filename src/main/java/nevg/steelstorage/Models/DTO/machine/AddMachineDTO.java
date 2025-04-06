package nevg.steelstorage.Models.DTO.machine;

import jakarta.validation.constraints.NotEmpty;

public class AddMachineDTO {

    @NotEmpty(message = "{add_machine_new_brand}")
    private String brand;

    @NotEmpty(message = "{add_machine_new_brand}")
    private String model;

    @NotEmpty(message = "{add_machine_serialNumber}")
    private String serialNumber;

    public AddMachineDTO() {
    }

    public @NotEmpty(message = "{add_machine_new_brand}") String getBrand() {
        return brand;
    }

    public void setBrand(@NotEmpty(message = "{add_machine_new_brand}") String brand) {
        this.brand = brand;
    }

    public @NotEmpty(message = "{add_machine_new_brand}") String getModel() {
        return model;
    }

    public void setModel(@NotEmpty(message = "{add_machine_new_brand}") String model) {
        this.model = model;
    }

    public @NotEmpty(message = "{add_machine_serialNumber}") String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(@NotEmpty(message = "{add_machine_serialNumber}") String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
