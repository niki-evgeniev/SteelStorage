package nevg.steelstorage.Models.DTO.steel;

public class SteelStorageDTO {

    private String uuid;

    private Integer steelCount;

    private Integer steelSize;

    private String steelType;

    private Integer totalCount;

    public SteelStorageDTO() {
    }

    public Integer getSteelCount() {
        return steelCount;
    }

    public void setSteelCount(Integer steelCount) {
        this.steelCount = steelCount;
    }

    public Integer getSteelSize() {
        return steelSize;
    }

    public void setSteelSize(Integer steelSize) {
        this.steelSize = steelSize;
    }

    public String getSteelType() {
        return steelType;
    }

    public void setSteelType(String steelType) {
        this.steelType = steelType;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
