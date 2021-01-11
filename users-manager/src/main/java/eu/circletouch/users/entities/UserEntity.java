package eu.circletouch.users.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users", schema = "usersmgr")
public class UserEntity extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "password_hash_alg")
    private String passwordHashAlg;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "enabled")
    private Byte enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<UserGroupEntity> userGroups = new LinkedList<>();

}
