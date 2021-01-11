package eu.circletouch.users.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "b_ruoli")
public class BRuoliEntity {
    private Integer id;
    private String descrizione;
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
    @Column(name = "descrizione")
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
        BRuoliEntity that = (BRuoliEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(descrizione, that.descrizione) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createBUtentiId, that.createBUtentiId) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateBUtentiId, that.updateBUtentiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descrizione, createTime, createBUtentiId, updateTime, updateBUtentiId);
    }
}
