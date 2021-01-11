package eu.circletouch.users.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "companies_roles", schema = "usersmgr")
public class CompanyRoleEntity extends BaseEntity {

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "role_id")
    private Integer roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private RoleEntity role;

}
