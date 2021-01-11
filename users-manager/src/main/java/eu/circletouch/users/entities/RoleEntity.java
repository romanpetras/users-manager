package eu.circletouch.users.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles", schema = "usersmgr")
public class RoleEntity extends BaseEntity {

    @Basic
    @Column(name = "code")
    private String code;

    @Basic
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", orphanRemoval = true)
    private List<CompanyRoleEntity> companiesRole = new LinkedList<>();

}
