/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "consultanutricional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultanutricional.findAll", query = "SELECT c FROM Consultanutricional c"),
    @NamedQuery(name = "Consultanutricional.findByCnId", query = "SELECT c FROM Consultanutricional c WHERE c.cnId = :cnId"),
    @NamedQuery(name = "Consultanutricional.findByCnHabitosalimenticios", query = "SELECT c FROM Consultanutricional c WHERE c.cnHabitosalimenticios = :cnHabitosalimenticios"),
    @NamedQuery(name = "Consultanutricional.findByCnActividadesfisicas", query = "SELECT c FROM Consultanutricional c WHERE c.cnActividadesfisicas = :cnActividadesfisicas"),
    @NamedQuery(name = "Consultanutricional.findByCnImc", query = "SELECT c FROM Consultanutricional c WHERE c.cnImc = :cnImc"),
    @NamedQuery(name = "Consultanutricional.findByCnTalla", query = "SELECT c FROM Consultanutricional c WHERE c.cnTalla = :cnTalla"),
    @NamedQuery(name = "Consultanutricional.findByCnPeso", query = "SELECT c FROM Consultanutricional c WHERE c.cnPeso = :cnPeso"),
    @NamedQuery(name = "Consultanutricional.findByCnFecha", query = "SELECT c FROM Consultanutricional c WHERE c.cnFecha = :cnFecha"),
    @NamedQuery(name = "Consultanutricional.findByCnAltura", query = "SELECT c FROM Consultanutricional c WHERE c.cnAltura = :cnAltura"),
    @NamedQuery(name = "Consultanutricional.findByCnDieta", query = "SELECT c FROM Consultanutricional c WHERE c.cnDieta = :cnDieta")})
public class Consultanutricional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cn_id")
    private Integer cnId;
    @Size(max = 2147483647)
    @Column(name = "cn_habitosalimenticios")
    private String cnHabitosalimenticios;
    @Size(max = 2147483647)
    @Column(name = "cn_actividadesfisicas")
    private String cnActividadesfisicas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cn_imc")
    private Double cnImc;
    @Column(name = "cn_talla")
    private Double cnTalla;
    @Column(name = "cn_peso")
    private Double cnPeso;
    @Column(name = "cn_fecha")
    @Temporal(TemporalType.DATE)
    private Date cnFecha;
    @Column(name = "cn_altura")
    private Integer cnAltura;
    @Size(max = 2147483647)
    @Column(name = "cn_dieta")
    private String cnDieta;
    @JoinColumns({
        @JoinColumn(name = "profesionalrut", referencedColumnName = "profesionalrut"),
        @JoinColumn(name = "profesional_dv", referencedColumnName = "profesional_dv")})
    @ManyToOne(optional = false)
    private Profesional profesional;
    @JoinColumn(name = "episodio_numero", referencedColumnName = "episodio_numero")
    @ManyToOne(optional = false)
    private Episodioclinicoobstetrico episodioNumero;

    public Consultanutricional() {
    }

    public Consultanutricional(Integer cnId) {
        this.cnId = cnId;
    }

    public Integer getCnId() {
        return cnId;
    }

    public void setCnId(Integer cnId) {
        this.cnId = cnId;
    }

    public String getCnHabitosalimenticios() {
        return cnHabitosalimenticios;
    }

    public void setCnHabitosalimenticios(String cnHabitosalimenticios) {
        this.cnHabitosalimenticios = cnHabitosalimenticios;
    }

    public String getCnActividadesfisicas() {
        return cnActividadesfisicas;
    }

    public void setCnActividadesfisicas(String cnActividadesfisicas) {
        this.cnActividadesfisicas = cnActividadesfisicas;
    }

    public Double getCnImc() {
        return cnImc;
    }

    public void setCnImc(Double cnImc) {
        this.cnImc = cnImc;
    }

    public Double getCnTalla() {
        return cnTalla;
    }

    public void setCnTalla(Double cnTalla) {
        this.cnTalla = cnTalla;
    }

    public Double getCnPeso() {
        return cnPeso;
    }

    public void setCnPeso(Double cnPeso) {
        this.cnPeso = cnPeso;
    }

    public Date getCnFecha() {
        return cnFecha;
    }

    public void setCnFecha(Date cnFecha) {
        this.cnFecha = cnFecha;
    }

    public Integer getCnAltura() {
        return cnAltura;
    }

    public void setCnAltura(Integer cnAltura) {
        this.cnAltura = cnAltura;
    }

    public String getCnDieta() {
        return cnDieta;
    }

    public void setCnDieta(String cnDieta) {
        this.cnDieta = cnDieta;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Episodioclinicoobstetrico getEpisodioNumero() {
        return episodioNumero;
    }

    public void setEpisodioNumero(Episodioclinicoobstetrico episodioNumero) {
        this.episodioNumero = episodioNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnId != null ? cnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultanutricional)) {
            return false;
        }
        Consultanutricional other = (Consultanutricional) object;
        if ((this.cnId == null && other.cnId != null) || (this.cnId != null && !this.cnId.equals(other.cnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Consultanutricional[ cnId=" + cnId + " ]";
    }
    
}
