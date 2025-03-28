package nevg.steelstorage.Models.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import nevg.steelstorage.Models.Enums.RoleType;

@Table
@Entity(name = "user_roles")
public class UserRole extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public UserRole() {
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
