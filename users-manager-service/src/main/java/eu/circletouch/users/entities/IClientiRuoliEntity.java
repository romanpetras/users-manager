package eu.circletouch.users.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "i_clienti_ruoli")
public class IClientiRuoliEntity {
    private Integer id;
    private Integer bClientiId;
    private Integer bRuoliId;

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
    @Column(name = "b_ruoli_id")
    public Integer getbRuoliId() {
        return bRuoliId;
    }

    public void setbRuoliId(Integer bRuoliId) {
        this.bRuoliId = bRuoliId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IClientiRuoliEntity that = (IClientiRuoliEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bClientiId, that.bClientiId) &&
                Objects.equals(bRuoliId, that.bRuoliId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bClientiId, bRuoliId);
    }
}
