package eu.circletouch.users.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "i_utenti_gruppi_sedi")
public class IUtentiGruppiSediEntity {
    private Integer iUtentiGruppiSediId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer updateBUtentiId;
    private Integer createBUtentiId;
    private Integer bGruppiId;
    private Integer bUtentiId;
    private Integer bSediId;

    private BUtentiEntity bUtentiEntity;
    private BGruppiEntity bGruppiEntity;
    private BSediEntity bSediEntity;

    @Id
    @Column(name = "i_utenti_gruppi_sedi_id")
    public Integer getiUtentiGruppiSediId() {
        return iUtentiGruppiSediId;
    }

    public void setiUtentiGruppiSediId(Integer iUtentiGruppiSediId) {
        this.iUtentiGruppiSediId = iUtentiGruppiSediId;
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
    @Column(name = "update_b_utenti_id")
    public Integer getUpdateBUtentiId() {
        return updateBUtentiId;
    }

    public void setUpdateBUtentiId(Integer updateBUtentiId) {
        this.updateBUtentiId = updateBUtentiId;
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
    @Column(name = "b_gruppi_id")
    public Integer getBGruppiId() {
        return bGruppiId;
    }

    public void setBGruppiId(Integer bGruppiId) {
        this.bGruppiId = bGruppiId;
    }

    @Basic
    @Column(name = "b_utenti_id")
    public Integer getBUtentiId() {
        return bUtentiId;
    }

    public void setBUtentiId(Integer bUtentiId) {
        this.bUtentiId = bUtentiId;
    }

    @Basic
    @Column(name = "b_sedi_id")
    public Integer getBSediId() {
        return bSediId;
    }

    public void setBSediId(Integer bSediId) {
        this.bSediId = bSediId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "b_utenti_id", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    public BUtentiEntity getbUtentiEntity() {
        return bUtentiEntity;
    }

    public void setbUtentiEntity(BUtentiEntity bUtentiEntity) {
        this.bUtentiEntity = bUtentiEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "b_gruppi_id", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    public BGruppiEntity getbGruppiEntity() {
        return bGruppiEntity;
    }

    public void setbGruppiEntity(BGruppiEntity bGruppiEntity) {
        this.bGruppiEntity = bGruppiEntity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "b_sedi_id", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    public BSediEntity getbSediEntity() {
        return bSediEntity;
    }

    public void setbSediEntity(BSediEntity bSediEntity) {
        this.bSediEntity = bSediEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IUtentiGruppiSediEntity that = (IUtentiGruppiSediEntity) o;
        return Objects.equals(iUtentiGruppiSediId, that.iUtentiGruppiSediId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateBUtentiId, that.updateBUtentiId) &&
                Objects.equals(createBUtentiId, that.createBUtentiId) &&
                Objects.equals(bGruppiId, that.bGruppiId) &&
                Objects.equals(bUtentiId, that.bUtentiId) &&
                Objects.equals(bSediId, that.bSediId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iUtentiGruppiSediId, createTime, updateTime, updateBUtentiId, createBUtentiId, bGruppiId, bUtentiId, bSediId);
    }
}
