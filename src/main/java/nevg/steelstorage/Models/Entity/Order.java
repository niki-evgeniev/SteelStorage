package nevg.steelstorage.Models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table
@Entity(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "added_date")
    private LocalDateTime addedDate;

    @Column(name = "added_quantity")
    private int addedQuantity;

    @Column(name = "worked_quantity")
    private int workedQuantity;

    @ManyToOne
    private User orders;

    public Order() {
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public User getOrders() {
        return orders;
    }

    public void setOrders(User orders) {
        this.orders = orders;
    }
}
