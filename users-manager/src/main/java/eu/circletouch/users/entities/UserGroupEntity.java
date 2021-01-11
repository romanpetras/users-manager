package eu.circletouch.users.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users_groups", schema = "usersmgr")
public class UserGroupEntity extends BaseEntity {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "group_id")
    private Integer groupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private GroupEntity group;

}
