package nevg.steelstorage.Models.DTO.Machines;

public class GetMachineModelDTO {

    private String brand;
    private String model;

    public GetMachineModelDTO() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
