package eu.circletouch.users.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "b_clienti")
public class BClientiEntity {
    private Integer id;
    private String codice;
    private String partitaIva;
    private String ragioneSociale;
    private String email;
    private Timestamp createTime;
    private Integer createBUtentiId;
    private Timestamp updateTime;
    private Integer updateBUtentiId;
    private String indirizzo;
    private String comune;
    private String cap;
    private String provincia;
    private String stato;
    private String telefono;
    private String fax;
    private String annullato;
    private String codiceFiscale;
    private String codiceErp;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "codice")
    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Basic
    @Column(name = "partita_iva")
    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    @Basic
    @Column(name = "ragione_sociale")
    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
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

    @Basic
    @Column(name = "indirizzo")
    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Basic
    @Column(name = "comune")
    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    @Basic
    @Column(name = "cap")
    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @Basic
    @Column(name = "provincia")
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Basic
    @Column(name = "stato")
    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
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
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "annullato")
    public String getAnnullato() {
        return annullato;
    }

    public void setAnnullato(String annullato) {
        this.annullato = annullato;
    }

    @Basic
    @Column(name = "codice_fiscale")
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Basic
    @Column(name = "codice_erp")
    public String getCodiceErp() {
        return codiceErp;
    }

    public void setCodiceErp(String codiceErp) {
        this.codiceErp = codiceErp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BClientiEntity that = (BClientiEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(codice, that.codice) &&
                Objects.equals(partitaIva, that.partitaIva) &&
                Objects.equals(ragioneSociale, that.ragioneSociale) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(createBUtentiId, that.createBUtentiId) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(updateBUtentiId, that.updateBUtentiId) &&
                Objects.equals(indirizzo, that.indirizzo) &&
                Objects.equals(comune, that.comune) &&
                Objects.equals(cap, that.cap) &&
                Objects.equals(provincia, that.provincia) &&
                Objects.equals(stato, that.stato) &&
                Objects.equals(telefono, that.telefono) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(annullato, that.annullato) &&
                Objects.equals(codiceFiscale, that.codiceFiscale) &&
                Objects.equals(codiceErp, that.codiceErp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codice, partitaIva, ragioneSociale, email, createTime, createBUtentiId, updateTime, updateBUtentiId, indirizzo, comune, cap, provincia, stato, telefono, fax, annullato, codiceFiscale, codiceErp);
    }
}
