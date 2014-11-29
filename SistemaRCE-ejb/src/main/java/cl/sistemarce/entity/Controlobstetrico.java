/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "controlobstetrico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controlobstetrico.findAll", query = "SELECT c FROM Controlobstetrico c"),
    @NamedQuery(name = "Controlobstetrico.findByControlId", query = "SELECT c FROM Controlobstetrico c WHERE c.controlId = :controlId"),
    @NamedQuery(name = "Controlobstetrico.findByControlFecha", query = "SELECT c FROM Controlobstetrico c WHERE c.controlFecha = :controlFecha"),
    @NamedQuery(name = "Controlobstetrico.findByControlPa", query = "SELECT c FROM Controlobstetrico c WHERE c.controlPa = :controlPa"),
    @NamedQuery(name = "Controlobstetrico.findByControlTemp", query = "SELECT c FROM Controlobstetrico c WHERE c.controlTemp = :controlTemp"),
    @NamedQuery(name = "Controlobstetrico.findByControlPulso", query = "SELECT c FROM Controlobstetrico c WHERE c.controlPulso = :controlPulso"),
    @NamedQuery(name = "Controlobstetrico.findByControlTalla", query = "SELECT c FROM Controlobstetrico c WHERE c.controlTalla = :controlTalla"),
    @NamedQuery(name = "Controlobstetrico.findByControlImc", query = "SELECT c FROM Controlobstetrico c WHERE c.controlImc = :controlImc"),
    @NamedQuery(name = "Controlobstetrico.findByControlExamFisico", query = "SELECT c FROM Controlobstetrico c WHERE c.controlExamFisico = :controlExamFisico"),
    @NamedQuery(name = "Controlobstetrico.findByControlIndicaciones", query = "SELECT c FROM Controlobstetrico c WHERE c.controlIndicaciones = :controlIndicaciones"),
    @NamedQuery(name = "Controlobstetrico.findByControlObservaciones", query = "SELECT c FROM Controlobstetrico c WHERE c.controlObservaciones = :controlObservaciones"),
    @NamedQuery(name = "Controlobstetrico.findByControlEdema", query = "SELECT c FROM Controlobstetrico c WHERE c.controlEdema = :controlEdema"),
    @NamedQuery(name = "Controlobstetrico.findByControlEdadEmbarazo", query = "SELECT c FROM Controlobstetrico c WHERE c.controlEdadEmbarazo = :controlEdadEmbarazo")})
public class Controlobstetrico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_id")
    private Integer controlId;
    @Column(name = "control_fecha")
    @Temporal(TemporalType.DATE)
    private Date controlFecha;
    @Column(name = "control_pa")
    private Integer controlPa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "control_temp")
    private Double controlTemp;
    @Column(name = "control_pulso")
    private Integer controlPulso;
    @Column(name = "control_talla")
    private Double controlTalla;
    @Column(name = "control_imc")
    private Double controlImc;
    @Size(max = 2147483647)
    @Column(name = "control_exam_fisico")
    private String controlExamFisico;
    @Size(max = 2147483647)
    @Column(name = "control_indicaciones")
    private String controlIndicaciones;
    @Size(max = 2147483647)
    @Column(name = "control_observaciones")
    private String controlObservaciones;
    @Size(max = 2147483647)
    @Column(name = "control_edema")
    private String controlEdema;
    @Column(name = "control_edad_embarazo")
    private Integer controlEdadEmbarazo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlId")
    private List<Diagnosticos> diagnosticosList;
    @JoinColumns({
        @JoinColumn(name = "profesionalrut", referencedColumnName = "profesionalrut"),
        @JoinColumn(name = "profesional_dv", referencedColumnName = "profesional_dv")})
    @ManyToOne
    private Profesional profesional;
    @JoinColumn(name = "episodio_numero", referencedColumnName = "episodio_numero")
    @ManyToOne(optional = false)
    private Episodioclinicoobstetrico episodioNumero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "controlId")
    private List<Hipotesis> hipotesisList;

    public Controlobstetrico() {
    }

    public Controlobstetrico(Integer controlId) {
        this.controlId = controlId;
    }

    public Integer getControlId() {
        return controlId;
    }

    public void setControlId(Integer controlId) {
        this.controlId = controlId;
    }

    public Date getControlFecha() {
        return controlFecha;
    }

    public void setControlFecha(Date controlFecha) {
        this.controlFecha = controlFecha;
    }

    public Integer getControlPa() {
        return controlPa;
    }

    public void setControlPa(Integer controlPa) {
        this.controlPa = controlPa;
    }

    public Double getControlTemp() {
        return controlTemp;
    }

    public void setControlTemp(Double controlTemp) {
        this.controlTemp = controlTemp;
    }

    public Integer getControlPulso() {
        return controlPulso;
    }

    public void setControlPulso(Integer controlPulso) {
        this.controlPulso = controlPulso;
    }

    public Double getControlTalla() {
        return controlTalla;
    }

    public void setControlTalla(Double controlTalla) {
        this.controlTalla = controlTalla;
    }

    public Double getControlImc() {
        return controlImc;
    }

    public void setControlImc(Double controlImc) {
        this.controlImc = controlImc;
    }

    public String getControlExamFisico() {
        return controlExamFisico;
    }

    public void setControlExamFisico(String controlExamFisico) {
        this.controlExamFisico = controlExamFisico;
    }

    public String getControlIndicaciones() {
        return controlIndicaciones;
    }

    public void setControlIndicaciones(String controlIndicaciones) {
        this.controlIndicaciones = controlIndicaciones;
    }

    public String getControlObservaciones() {
        return controlObservaciones;
    }

    public void setControlObservaciones(String controlObservaciones) {
        this.controlObservaciones = controlObservaciones;
    }

    public String getControlEdema() {
        return controlEdema;
    }

    public void setControlEdema(String controlEdema) {
        this.controlEdema = controlEdema;
    }

    public Integer getControlEdadEmbarazo() {
        return controlEdadEmbarazo;
    }

    public void setControlEdadEmbarazo(Integer controlEdadEmbarazo) {
        this.controlEdadEmbarazo = controlEdadEmbarazo;
    }

    @XmlTransient
    public List<Diagnosticos> getDiagnosticosList() {
        return diagnosticosList;
    }

    public void setDiagnosticosList(List<Diagnosticos> diagnosticosList) {
        this.diagnosticosList = diagnosticosList;
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

    @XmlTransient
    public List<Hipotesis> getHipotesisList() {
        return hipotesisList;
    }

    public void setHipotesisList(List<Hipotesis> hipotesisList) {
        this.hipotesisList = hipotesisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (controlId != null ? controlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controlobstetrico)) {
            return false;
        }
        Controlobstetrico other = (Controlobstetrico) object;
        if ((this.controlId == null && other.controlId != null) || (this.controlId != null && !this.controlId.equals(other.controlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Controlobstetrico[ controlId=" + controlId + " ]";
    }
    
}
