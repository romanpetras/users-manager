package eu.circletouch.users.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "create_timestamp")
    protected Timestamp createdAt;

    @Column(name = "create_user_id")
    protected Long createdById;

    @Column(name = "create_user")
    protected String createdByUser;

    @Column(name = "update_timestamp")
    protected Timestamp updatedAt;

    @Column(name = "update_user_id")
    protected Long updatedById;

    @Column(name = "update_user")
    protected String updatedByUser;

    @PrePersist
    protected void prePersist(){
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
    
    @PreUpdate
    protected void preUpdate(){
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

}
