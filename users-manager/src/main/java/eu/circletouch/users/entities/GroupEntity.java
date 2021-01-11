package eu.circletouch.users.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "groups", schema = "usersmgr")
public class GroupEntity extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", orphanRemoval = true)
    private List<UserGroupEntity> usersGroup = new LinkedList<>();

}
