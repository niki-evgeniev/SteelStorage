package nevg.steelstorage.Models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table
@Entity(name = "steel")
public class Steel extends BaseEntity{

    @Column(name = "steel_type")
    private String steelType;

    @Column(name = "steel_size", nullable = false)
    private Integer steelSize;

    @Column(name = "count")
    private Integer count;

    @Column(name = "last_modified", columnDefinition = "DATETIME(0)")
    private LocalDateTime lastModified;

    public Steel() {
    }

    public String getSteelType() {
        return steelType;
    }

    public void setSteelType(String steelType) {
        this.steelType = steelType;
    }

    public Integer getSteelSize() {
        return steelSize;
    }

    public void setSteelSize(Integer steelSize) {
        this.steelSize = steelSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
}
