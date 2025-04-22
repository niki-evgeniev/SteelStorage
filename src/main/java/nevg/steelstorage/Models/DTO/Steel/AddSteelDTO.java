package nevg.steelstorage.Models.DTO.Steel;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.Positive;

public class AddSteelDTO {

    @Positive(message = "number must be positive")
    private int cutPieces;

    private String diameter;

    public AddSteelDTO() {
    }

    public int getCutPieces() {
        return cutPieces;
    }

    public void setCutPieces(int cutPieces) {
        this.cutPieces = cutPieces;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }
}
