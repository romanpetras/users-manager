package eu.circletouch.users.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "i_clienti_sedi")
public class IClientiSediEntity {
    private Integer id;
    private Integer bClientiId;
    private Integer bSediId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer createBUtentiId;
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
    @Column(name = "b_clienti_id")
    public Integer getbClientiId() {
        return bClientiId;
    }

    public void setbClientiId(Integer bClientiId) {
        this.bClientiId = bClientiId;
    }

    @Basic
    @Column(name = "b_sedi_id")
    public Integer getbSediId() {
        return bSediId;
    }

    public void setbSediId(Integer bSediId) {
        this.bSediId = bSediId;
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
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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
        IClientiSediEntity that = (IClientiSediEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bClientiId, that.bClientiId) &&
                Objects.equals(bSediId, that.bSediId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(createBUtentiId, that.createBUtentiId) &&
                Objects.equals(updateBUtentiId, that.updateBUtentiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bClientiId, bSediId, createTime, updateTime, createBUtentiId, updateBUtentiId);
    }
}
