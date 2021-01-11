package eu.circletouch.users.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "b_sedi")
public class BSediEntity {
    private Integer bSediId;
    private String smstype;
    private String dessede;
    private String mailauth;
    private String smsserver;
    private String aidaPath;
    private String aidausername;
    private Timestamp updateTime;
    private String mailsender;
    private String imglogo;
    private Timestamp createTime;
    private String smsauth;
    private String richiedente;
    private String mailtype;
    private String aidapwd;
    private String doganamagazzino;
    private String codiceua;
    private Integer updateBUtentiId;
    private Integer createBUtentiId;
    private String smssender;
    private String mailserver;
    private String progressivo;
    private String codiceeori;
    private String eportDbase;
    private String eportPath;
    private String ftpmmphost;
    private String ftpmmpuser;
    private String ftpmmppwd;
    private String ftppath;
    private String stepiiPath;
    private String stepiiPathreleaseorder;
    private String stepiiUsername;
    private String stepiiPassword;
    private String proprietario;
    private String indirizzo;
    private String comune;
    private String cap;
    private String provincia;
    private String pfTheme;

    @Id
    @Column(name = "b_sedi_id")
    public Integer getbSediId() {
        return bSediId;
    }

    public void setbSediId(Integer bSediId) {
        this.bSediId = bSediId;
    }

    @Basic
    @Column(name = "smstype")
    public String getSmstype() {
        return smstype;
    }

    public void setSmstype(String smstype) {
        this.smstype = smstype;
    }

    @Basic
    @Column(name = "dessede")
    public String getDessede() {
        return dessede;
    }

    public void setDessede(String dessede) {
        this.dessede = dessede;
    }

    @Basic
    @Column(name = "mailauth")
    public String getMailauth() {
        return mailauth;
    }

    public void setMailauth(String mailauth) {
        this.mailauth = mailauth;
    }

    @Basic
    @Column(name = "smsserver")
    public String getSmsserver() {
        return smsserver;
    }

    public void setSmsserver(String smsserver) {
        this.smsserver = smsserver;
    }

    @Basic
    @Column(name = "aida_path")
    public String getAidaPath() {
        return aidaPath;
    }

    public void setAidaPath(String aidaPath) {
        this.aidaPath = aidaPath;
    }

    @Basic
    @Column(name = "aidausername")
    public String getAidausername() {
        return aidausername;
    }

    public void setAidausername(String aidausername) {
        this.aidausername = aidausername;
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
    @Column(name = "mailsender")
    public String getMailsender() {
        return mailsender;
    }

    public void setMailsender(String mailsender) {
        this.mailsender = mailsender;
    }

    @Basic
    @Column(name = "imglogo")
    public String getImglogo() {
        return imglogo;
    }

    public void setImglogo(String imglogo) {
        this.imglogo = imglogo;
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
    @Column(name = "smsauth")
    public String getSmsauth() {
        return smsauth;
    }

    public void setSmsauth(String smsauth) {
        this.smsauth = smsauth;
    }

    @Basic
    @Column(name = "richiedente")
    public String getRichiedente() {
        return richiedente;
    }

    public void setRichiedente(String richiedente) {
        this.richiedente = richiedente;
    }

    @Basic
    @Column(name = "mailtype")
    public String getMailtype() {
        return mailtype;
    }

    public void setMailtype(String mailtype) {
        this.mailtype = mailtype;
    }

    @Basic
    @Column(name = "aidapwd")
    public String getAidapwd() {
        return aidapwd;
    }

    public void setAidapwd(String aidapwd) {
        this.aidapwd = aidapwd;
    }

    @Basic
    @Column(name = "doganamagazzino")
    public String getDoganamagazzino() {
        return doganamagazzino;
    }

    public void setDoganamagazzino(String doganamagazzino) {
        this.doganamagazzino = doganamagazzino;
    }

    @Basic
    @Column(name = "codiceua")
    public String getCodiceua() {
        return codiceua;
    }

    public void setCodiceua(String codiceua) {
        this.codiceua = codiceua;
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
    @Column(name = "smssender")
    public String getSmssender() {
        return smssender;
    }

    public void setSmssender(String smssender) {
        this.smssender = smssender;
    }

    @Basic
    @Column(name = "mailserver")
    public String getMailserver() {
        return mailserver;
    }

    public void setMailserver(String mailserver) {
        this.mailserver = mailserver;
    }

    @Basic
    @Column(name = "progressivo")
    public String getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(String progressivo) {
        this.progressivo = progressivo;
    }

    @Basic
    @Column(name = "codiceeori")
    public String getCodiceeori() {
        return codiceeori;
    }

    public void setCodiceeori(String codiceeori) {
        this.codiceeori = codiceeori;
    }

    @Basic
    @Column(name = "eport_dbase")
    public String getEportDbase() {
        return eportDbase;
    }

    public void setEportDbase(String eportDbase) {
        this.eportDbase = eportDbase;
    }

    @Basic
    @Column(name = "eport_path")
    public String getEportPath() {
        return eportPath;
    }

    public void setEportPath(String eportPath) {
        this.eportPath = eportPath;
    }

    @Basic
    @Column(name = "ftpmmphost")
    public String getFtpmmphost() {
        return ftpmmphost;
    }

    public void setFtpmmphost(String ftpmmphost) {
        this.ftpmmphost = ftpmmphost;
    }

    @Basic
    @Column(name = "ftpmmpuser")
    public String getFtpmmpuser() {
        return ftpmmpuser;
    }

    public void setFtpmmpuser(String ftpmmpuser) {
        this.ftpmmpuser = ftpmmpuser;
    }

    @Basic
    @Column(name = "ftpmmppwd")
    public String getFtpmmppwd() {
        return ftpmmppwd;
    }

    public void setFtpmmppwd(String ftpmmppwd) {
        this.ftpmmppwd = ftpmmppwd;
    }

    @Basic
    @Column(name = "ftppath")
    public String getFtppath() {
        return ftppath;
    }

    public void setFtppath(String ftppath) {
        this.ftppath = ftppath;
    }

    @Basic
    @Column(name = "stepii_path")
    public String getStepiiPath() {
        return stepiiPath;
    }

    public void setStepiiPath(String stepiiPath) {
        this.stepiiPath = stepiiPath;
    }

    @Basic
    @Column(name = "stepii_pathreleaseorder")
    public String getStepiiPathreleaseorder() {
        return stepiiPathreleaseorder;
    }

    public void setStepiiPathreleaseorder(String stepiiPathreleaseorder) {
        this.stepiiPathreleaseorder = stepiiPathreleaseorder;
    }

    @Basic
    @Column(name = "stepii_username")
    public String getStepiiUsername() {
        return stepiiUsername;
    }

    public void setStepiiUsername(String stepiiUsername) {
        this.stepiiUsername = stepiiUsername;
    }

    @Basic
    @Column(name = "stepii_password")
    public String getStepiiPassword() {
        return stepiiPassword;
    }

    public void setStepiiPassword(String stepiiPassword) {
        this.stepiiPassword = stepiiPassword;
    }

    @Basic
    @Column(name = "proprietario")
    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
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
    @Column(name = "pf_theme")
    public String getPfTheme() {
        return pfTheme;
    }

    public void setPfTheme(String pfTheme) {
        this.pfTheme = pfTheme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BSediEntity that = (BSediEntity) o;
        return Objects.equals(bSediId, that.bSediId) &&
                Objects.equals(smstype, that.smstype) &&
                Objects.equals(dessede, that.dessede) &&
                Objects.equals(mailauth, that.mailauth) &&
                Objects.equals(smsserver, that.smsserver) &&
                Objects.equals(aidaPath, that.aidaPath) &&
                Objects.equals(aidausername, that.aidausername) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(mailsender, that.mailsender) &&
                Objects.equals(imglogo, that.imglogo) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(smsauth, that.smsauth) &&
                Objects.equals(richiedente, that.richiedente) &&
                Objects.equals(mailtype, that.mailtype) &&
                Objects.equals(aidapwd, that.aidapwd) &&
                Objects.equals(doganamagazzino, that.doganamagazzino) &&
                Objects.equals(codiceua, that.codiceua) &&
                Objects.equals(updateBUtentiId, that.updateBUtentiId) &&
                Objects.equals(createBUtentiId, that.createBUtentiId) &&
                Objects.equals(smssender, that.smssender) &&
                Objects.equals(mailserver, that.mailserver) &&
                Objects.equals(progressivo, that.progressivo) &&
                Objects.equals(codiceeori, that.codiceeori) &&
                Objects.equals(eportDbase, that.eportDbase) &&
                Objects.equals(eportPath, that.eportPath) &&
                Objects.equals(ftpmmphost, that.ftpmmphost) &&
                Objects.equals(ftpmmpuser, that.ftpmmpuser) &&
                Objects.equals(ftpmmppwd, that.ftpmmppwd) &&
                Objects.equals(ftppath, that.ftppath) &&
                Objects.equals(stepiiPath, that.stepiiPath) &&
                Objects.equals(stepiiPathreleaseorder, that.stepiiPathreleaseorder) &&
                Objects.equals(stepiiUsername, that.stepiiUsername) &&
                Objects.equals(stepiiPassword, that.stepiiPassword) &&
                Objects.equals(proprietario, that.proprietario) &&
                Objects.equals(indirizzo, that.indirizzo) &&
                Objects.equals(comune, that.comune) &&
                Objects.equals(cap, that.cap) &&
                Objects.equals(provincia, that.provincia) &&
                Objects.equals(pfTheme, that.pfTheme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bSediId, smstype, dessede, mailauth, smsserver, aidaPath, aidausername, updateTime, mailsender, imglogo, createTime, smsauth, richiedente, mailtype, aidapwd, doganamagazzino, codiceua, updateBUtentiId, createBUtentiId, smssender, mailserver, progressivo, codiceeori, eportDbase, eportPath, ftpmmphost, ftpmmpuser, ftpmmppwd, ftppath, stepiiPath, stepiiPathreleaseorder, stepiiUsername, stepiiPassword, proprietario, indirizzo, comune, cap, provincia, pfTheme);
    }
}
