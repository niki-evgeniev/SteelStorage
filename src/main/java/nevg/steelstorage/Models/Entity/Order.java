package nevg.steelstorage.Models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table
@Entity(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "added_date", columnDefinition = "DATETIME(0)")
    private LocalDateTime addedDate;

    @Column(name = "added_quantity")
    private int addedQuantity;

    @Column(name = "worked_quantity")
    private int workedQuantity;

    @ManyToOne
    private User user;

    public Order() {
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public int getAddedQuantity() {
        return addedQuantity;
    }

    public void setAddedQuantity(int addedQuantity) {
        this.addedQuantity = addedQuantity;
    }

    public int getWorkedQuantity() {
        return workedQuantity;
    }

    public void setWorkedQuantity(int workedQuantity) {
        this.workedQuantity = workedQuantity;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User users) {
        this.user = users;
    }
}
