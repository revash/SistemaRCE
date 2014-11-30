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
@Table(name = "datosobstetricos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datosobstetricos.findAll", query = "SELECT d FROM Datosobstetricos d"),
    @NamedQuery(name = "Datosobstetricos.findByAbortos", query = "SELECT d FROM Datosobstetricos d WHERE d.abortos = :abortos"),
    @NamedQuery(name = "Datosobstetricos.findByVaginales", query = "SELECT d FROM Datosobstetricos d WHERE d.vaginales = :vaginales"),
    @NamedQuery(name = "Datosobstetricos.findByCesareas", query = "SELECT d FROM Datosobstetricos d WHERE d.cesareas = :cesareas"),
    @NamedQuery(name = "Datosobstetricos.findByFechasUltimoEmbarazo", query = "SELECT d FROM Datosobstetricos d WHERE d.fechasUltimoEmbarazo = :fechasUltimoEmbarazo"),
    @NamedQuery(name = "Datosobstetricos.findByRnMayorPeso", query = "SELECT d FROM Datosobstetricos d WHERE d.rnMayorPeso = :rnMayorPeso"),
    @NamedQuery(name = "Datosobstetricos.findByRnMenorPeso", query = "SELECT d FROM Datosobstetricos d WHERE d.rnMenorPeso = :rnMenorPeso"),
    @NamedQuery(name = "Datosobstetricos.findByCesareasObs", query = "SELECT d FROM Datosobstetricos d WHERE d.cesareasObs = :cesareasObs"),
    @NamedQuery(name = "Datosobstetricos.findByVaginalesObs", query = "SELECT d FROM Datosobstetricos d WHERE d.vaginalesObs = :vaginalesObs"),
    @NamedQuery(name = "Datosobstetricos.findByAbortosObs", query = "SELECT d FROM Datosobstetricos d WHERE d.abortosObs = :abortosObs"),
    @NamedQuery(name = "Datosobstetricos.findByDatosobstetricosid", query = "SELECT d FROM Datosobstetricos d WHERE d.datosobstetricosid = :datosobstetricosid")})
public class Datosobstetricos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "abortos")
    private Integer abortos;
    @Column(name = "vaginales")
    private Integer vaginales;
    @Column(name = "cesareas")
    private Integer cesareas;
    @Column(name = "fechas_ultimo_embarazo")
    @Temporal(TemporalType.DATE)
    private Date fechasUltimoEmbarazo;
    @Column(name = "rn_mayor_peso")
    private Integer rnMayorPeso;
    @Column(name = "rn_menor_peso")
    private Integer rnMenorPeso;
    @Size(max = 2147483647)
    @Column(name = "cesareas_obs")
    private String cesareasObs;
    @Size(max = 2147483647)
    @Column(name = "vaginales_obs")
    private String vaginalesObs;
    @Size(max = 2147483647)
    @Column(name = "abortos_obs")
    private String abortosObs;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "datosobstetricosid")
    private Integer datosobstetricosid;
    @JoinColumns({
        @JoinColumn(name = "persona_rut", referencedColumnName = "persona_rut"),
        @JoinColumn(name = "persona_dv", referencedColumnName = "persona_dv"),
        @JoinColumn(name = "nacionalidad_codigo", referencedColumnName = "nacionalidad_codigo"),
        @JoinColumn(name = "ficha_numero", referencedColumnName = "ficha_numero")})
    @ManyToOne
    private Paciente paciente;

    public Datosobstetricos() {
    }

    public Datosobstetricos(Integer datosobstetricosid) {
        this.datosobstetricosid = datosobstetricosid;
    }

    public Integer getAbortos() {
        return abortos;
    }

    public void setAbortos(Integer abortos) {
        this.abortos = abortos;
    }

    public Integer getVaginales() {
        return vaginales;
    }

    public void setVaginales(Integer vaginales) {
        this.vaginales = vaginales;
    }

    public Integer getCesareas() {
        return cesareas;
    }

    public void setCesareas(Integer cesareas) {
        this.cesareas = cesareas;
    }

    public Date getFechasUltimoEmbarazo() {
        return fechasUltimoEmbarazo;
    }

    public void setFechasUltimoEmbarazo(Date fechasUltimoEmbarazo) {
        this.fechasUltimoEmbarazo = fechasUltimoEmbarazo;
    }

    public Integer getRnMayorPeso() {
        return rnMayorPeso;
    }

    public void setRnMayorPeso(Integer rnMayorPeso) {
        this.rnMayorPeso = rnMayorPeso;
    }

    public Integer getRnMenorPeso() {
        return rnMenorPeso;
    }

    public void setRnMenorPeso(Integer rnMenorPeso) {
        this.rnMenorPeso = rnMenorPeso;
    }

    public String getCesareasObs() {
        return cesareasObs;
    }

    public void setCesareasObs(String cesareasObs) {
        this.cesareasObs = cesareasObs;
    }

    public String getVaginalesObs() {
        return vaginalesObs;
    }

    public void setVaginalesObs(String vaginalesObs) {
        this.vaginalesObs = vaginalesObs;
    }

    public String getAbortosObs() {
        return abortosObs;
    }

    public void setAbortosObs(String abortosObs) {
        this.abortosObs = abortosObs;
    }

    public Integer getDatosobstetricosid() {
        return datosobstetricosid;
    }

    public void setDatosobstetricosid(Integer datosobstetricosid) {
        this.datosobstetricosid = datosobstetricosid;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datosobstetricosid != null ? datosobstetricosid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datosobstetricos)) {
            return false;
        }
        Datosobstetricos other = (Datosobstetricos) object;
        if ((this.datosobstetricosid == null && other.datosobstetricosid != null) || (this.datosobstetricosid != null && !this.datosobstetricosid.equals(other.datosobstetricosid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Datosobstetricos[ datosobstetricosid=" + datosobstetricosid + " ]";
    }
    
}
