package eu.circletouch.users.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "b_utenti")
public class BUtentiEntity {
    private Integer bUtentiId;
    private Timestamp createTime;
    private String codutente;
    private String email;
    private Timestamp updateTime;
    private Integer righegrid;
    private Integer updateBUtentiId;
    private Timestamp datablocco;
    private Integer createBUtentiId;
    private String password;
    private String desutente;
    private String nome;
    private String cognome;
    private String telefono;
    private String uuid;

    @Id
    @Column(name = "b_utenti_id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getbUtentiId() {
        return bUtentiId;
    }

    public void setbUtentiId(Integer bUtentiId) {
        this.bUtentiId = bUtentiId;
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
    @Column(name = "codutente")
    public String getCodutente() {
        return codutente;
    }

    public void setCodutente(String codutente) {
        this.codutente = codutente;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "righegrid")
    public Integer getRighegrid() {
        return righegrid;
    }

    public void setRighegrid(Integer righegrid) {
        this.righegrid = righegrid;
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
    @Column(name = "datablocco")
    public Timestamp getDatablocco() {
        return datablocco;
    }

    public void setDatablocco(Timestamp datablocco) {
        this.datablocco = datablocco;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "desutente")
    public String getDesutente() {
        return desutente;
    }

    public void setDesutente(String desutente) {
        this.desutente = desutente;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "cognome")
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Basic
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BUtentiEntity that = (BUtentiEntity) o;
        return Objects.equals(bUtentiId, that.bUtentiId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(codutente, that.codutente) &&
                Objects.equals(email, that.email) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(righegrid, that.righegrid) &&
                Objects.equals(updateBUtentiId, that.updateBUtentiId) &&
                Objects.equals(datablocco, that.datablocco) &&
                Objects.equals(createBUtentiId, that.createBUtentiId) &&
                Objects.equals(password, that.password) &&
                Objects.equals(desutente, that.desutente) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cognome, that.cognome) &&
                Objects.equals(telefono, that.telefono) &&
                Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bUtentiId, createTime, codutente, email, updateTime, righegrid, updateBUtentiId, datablocco, createBUtentiId, password, desutente, nome, cognome, telefono, uuid);
    }
}
