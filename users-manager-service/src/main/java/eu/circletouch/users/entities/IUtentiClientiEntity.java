package eu.circletouch.users.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "i_utenti_clienti")
public class IUtentiClientiEntity {
    private Integer id;
    private Integer bUtentiId;
    private Integer bClientiId;
    private Timestamp createTime;
    private Integer createBUtentiId;
    private Timestamp updateTime;
    private Integer updateBUtentiId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "b_utenti_id")
    public Integer getbUtentiId() {
        return bUtentiId;
    }

    public void setbUtentiId(Integer bUtentiId) {
        this.bUtentiId = bUtentiId;
    }

    @Basic
    @Column(name = "b_clienti_id")
    public Integer getbClientiId() {
        return bClientiId;
    }

    public void setbClientiId(Integer bClientiId) {
        this.bClientiId = bClientiId;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "create_b_utenti_id")
    public Integer getCreateBUtentiId() {
        return createBUtentiId;
    }

    public void setCreateBUtentiId(Integer createBUtentiId) {
        this.createBUtentiId = createBUtentiId;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "update_b_utenti_id")
    public Integer getUpdateBUtentiId() {
        return updateBUtentiId;
    }

    public void setUpdateBUtentiId(Integer updateBUtentiId) {
        this.updateBUtentiId = updateBUtentiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IUtentiClientiEntity that = (IUtentiClientiEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bUtentiId, that.bUtentiId) &&
                Objects.equals(bClientiId, that.bClientiId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createBUtentiId, that.createBUtentiId) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateBUtentiId, that.updateBUtentiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bUtentiId, bClientiId, createTime, createBUtentiId, updateTime, updateBUtentiId);
    }
}
