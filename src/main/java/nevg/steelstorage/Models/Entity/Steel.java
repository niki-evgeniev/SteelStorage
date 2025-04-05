package nevg.steelstorage.Models.Entity;

import jakarta.persistence.*;
import nevg.steelstorage.Models.Enums.SteelType;

import java.time.LocalDateTime;

@Table
@Entity(name = "steel")
public class Steel extends BaseEntity {

    @Column(name = "steel_code")
    private String steelCode;

    @Column(name = "steel_size", nullable = false)
    private Integer steelSize;

    @Column(name = "count")
    private Integer count;

    @Column(name = "total_count")
    private Integer totalCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "steel_type")
    private SteelType steelType;

    @Column(name = "added_date", columnDefinition = "DATETIME(0)")
    private LocalDateTime addedDate;

    @Column(name = "last_modified", columnDefinition = "DATETIME(0)")
    private LocalDateTime lastModified;

    public Steel() {
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getSteelCode() {
        return steelCode;
    }

    public void setSteelCode(String steelCode) {
        this.steelCode = steelCode;
    }

    public Integer getSteelSize() {
        return steelSize;
    }

    public void setSteelSize(Integer steelSize) {
        this.steelSize = steelSize;
    }

    public SteelType getSteelType() {
        return steelType;
    }

    public void setSteelType(SteelType steelType) {
        this.steelType = steelType;
    }
}
