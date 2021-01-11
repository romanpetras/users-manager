package eu.circletouch.users.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "b_gruppi")
public class BGruppiEntity {
    private Integer bGruppiId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer updateBUtentiId;
    private String desgruppo;
    private Integer createBUtentiId;
    private String codgruppo;
    private String landingPage;

    @Id
    @Column(name = "b_gruppi_id")
    public Integer getbGruppiId() {
        return bGruppiId;
    }

    public void setbGruppiId(Integer bGruppiId) {
        this.bGruppiId = bGruppiId;
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
    @Column(name = "desgruppo")
    public String getDesgruppo() {
        return desgruppo;
    }

    public void setDesgruppo(String desgruppo) {
        this.desgruppo = desgruppo;
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
    @Column(name = "codgruppo")
    public String getCodgruppo() {
        return codgruppo;
    }

    public void setCodgruppo(String codgruppo) {
        this.codgruppo = codgruppo;
    }

    @Basic
    @Column(name = "landing_page")
    public String getLandingPage() {
        return landingPage;
    }

    public void setLandingPage(String landingPage) {
        this.landingPage = landingPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BGruppiEntity that = (BGruppiEntity) o;
        return Objects.equals(bGruppiId, that.bGruppiId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateBUtentiId, that.updateBUtentiId) &&
                Objects.equals(desgruppo, that.desgruppo) &&
                Objects.equals(createBUtentiId, that.createBUtentiId) &&
                Objects.equals(codgruppo, that.codgruppo) &&
                Objects.equals(landingPage, that.landingPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bGruppiId, createTime, updateTime, updateBUtentiId, desgruppo, createBUtentiId, codgruppo, landingPage);
    }
}
