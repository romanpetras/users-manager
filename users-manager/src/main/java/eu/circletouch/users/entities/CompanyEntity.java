package eu.circletouch.users.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "companies", schema = "usersmgr")
public class CompanyEntity extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "vat_number")
    private String vatNumber;

    @Column(name = "vat_country_code")
    private String vatCountryCode;

    @Column(name = "enabled")
    private Byte enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true)
    private List<CompanyRoleEntity> companyRoles = new LinkedList<>();

}
