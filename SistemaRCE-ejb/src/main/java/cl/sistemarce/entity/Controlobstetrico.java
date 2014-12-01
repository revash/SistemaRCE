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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @NamedQuery(name = "Controlobstetrico.findByCorreltativocontrolobstetrico", query = "SELECT c FROM Controlobstetrico c WHERE c.correltativocontrolobstetrico = :correltativocontrolobstetrico"),
    @NamedQuery(name = "Controlobstetrico.findByFecha", query = "SELECT c FROM Controlobstetrico c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Controlobstetrico.findByPeso", query = "SELECT c FROM Controlobstetrico c WHERE c.peso = :peso"),
    @NamedQuery(name = "Controlobstetrico.findByPa", query = "SELECT c FROM Controlobstetrico c WHERE c.pa = :pa"),
    @NamedQuery(name = "Controlobstetrico.findByTemperatura", query = "SELECT c FROM Controlobstetrico c WHERE c.temperatura = :temperatura"),
    @NamedQuery(name = "Controlobstetrico.findByPulso", query = "SELECT c FROM Controlobstetrico c WHERE c.pulso = :pulso"),
    @NamedQuery(name = "Controlobstetrico.findByTalla", query = "SELECT c FROM Controlobstetrico c WHERE c.talla = :talla"),
    @NamedQuery(name = "Controlobstetrico.findByImc", query = "SELECT c FROM Controlobstetrico c WHERE c.imc = :imc"),
    @NamedQuery(name = "Controlobstetrico.findByExamenFisico", query = "SELECT c FROM Controlobstetrico c WHERE c.examenFisico = :examenFisico"),
    @NamedQuery(name = "Controlobstetrico.findByIndicaciones", query = "SELECT c FROM Controlobstetrico c WHERE c.indicaciones = :indicaciones"),
    @NamedQuery(name = "Controlobstetrico.findByObservaciones", query = "SELECT c FROM Controlobstetrico c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "Controlobstetrico.findByEdema", query = "SELECT c FROM Controlobstetrico c WHERE c.edema = :edema"),
    @NamedQuery(name = "Controlobstetrico.findByEdadEmbarazo", query = "SELECT c FROM Controlobstetrico c WHERE c.edadEmbarazo = :edadEmbarazo"),
    @NamedQuery(name = "Controlobstetrico.findByProfesionalRut", query = "SELECT c FROM Controlobstetrico c WHERE c.profesionalRut = :profesionalRut"),
    @NamedQuery(name = "Controlobstetrico.findByProfesionalDv", query = "SELECT c FROM Controlobstetrico c WHERE c.profesionalDv = :profesionalDv"),
    @NamedQuery(name = "Controlobstetrico.findByHistoria", query = "SELECT c FROM Controlobstetrico c WHERE c.historia = :historia"),
    @NamedQuery(name = "Controlobstetrico.findByEstado", query = "SELECT c FROM Controlobstetrico c WHERE c.estado = :estado")})
public class Controlobstetrico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "correltativocontrolobstetrico")
    private Integer correltativocontrolobstetrico;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Column(name = "pa")
    private Integer pa;
    @Column(name = "temperatura")
    private Double temperatura;
    @Column(name = "pulso")
    private Integer pulso;
    @Column(name = "talla")
    private Double talla;
    @Column(name = "imc")
    private Double imc;
    @Size(max = 2147483647)
    @Column(name = "examen_fisico")
    private String examenFisico;
    @Size(max = 2147483647)
    @Column(name = "indicaciones")
    private String indicaciones;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "edema")
    private Short edema;
    @Column(name = "edad_embarazo")
    private Double edadEmbarazo;
    @Column(name = "profesional_rut")
    private Integer profesionalRut;
    @Size(max = 1)
    @Column(name = "profesional_dv")
    private String profesionalDv;
    @Size(max = 2147483647)
    @Column(name = "historia")
    private String historia;
    @Column(name = "estado")
    private Short estado;
    @OneToMany(mappedBy = "correltativocontrolobstetrico")
    private List<Receta> recetaList;
    @OneToMany(mappedBy = "correltativocontrolobstetrico")
    private List<Diagnosticos> diagnosticosList;
    @OneToMany(mappedBy = "correltativocontrolobstetrico")
    private List<Tratamiento> tratamientoList;
    @JoinColumn(name = "numerocorrelativo", referencedColumnName = "numerocorrelativo")
    @ManyToOne(optional = false)
    private Episodioclinico numerocorrelativo;
    @OneToMany(mappedBy = "correltativocontrolobstetrico")
    private List<Hipotesis> hipotesisList;

    public Controlobstetrico() {
    }

    public Controlobstetrico(Integer correltativocontrolobstetrico) {
        this.correltativocontrolobstetrico = correltativocontrolobstetrico;
    }

    public Integer getCorreltativocontrolobstetrico() {
        return correltativocontrolobstetrico;
    }

    public void setCorreltativocontrolobstetrico(Integer correltativocontrolobstetrico) {
        this.correltativocontrolobstetrico = correltativocontrolobstetrico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getPa() {
        return pa;
    }

    public void setPa(Integer pa) {
        this.pa = pa;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getPulso() {
        return pulso;
    }

    public void setPulso(Integer pulso) {
        this.pulso = pulso;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getExamenFisico() {
        return examenFisico;
    }

    public void setExamenFisico(String examenFisico) {
        this.examenFisico = examenFisico;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Short getEdema() {
        return edema;
    }

    public void setEdema(Short edema) {
        this.edema = edema;
    }

    public Double getEdadEmbarazo() {
        return edadEmbarazo;
    }

    public void setEdadEmbarazo(Double edadEmbarazo) {
        this.edadEmbarazo = edadEmbarazo;
    }

    public Integer getProfesionalRut() {
        return profesionalRut;
    }

    public void setProfesionalRut(Integer profesionalRut) {
        this.profesionalRut = profesionalRut;
    }

    public String getProfesionalDv() {
        return profesionalDv;
    }

    public void setProfesionalDv(String profesionalDv) {
        this.profesionalDv = profesionalDv;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    @XmlTransient
    public List<Diagnosticos> getDiagnosticosList() {
        return diagnosticosList;
    }

    public void setDiagnosticosList(List<Diagnosticos> diagnosticosList) {
        this.diagnosticosList = diagnosticosList;
    }

    @XmlTransient
    public List<Tratamiento> getTratamientoList() {
        return tratamientoList;
    }

    public void setTratamientoList(List<Tratamiento> tratamientoList) {
        this.tratamientoList = tratamientoList;
    }

    public Episodioclinico getNumerocorrelativo() {
        return numerocorrelativo;
    }

    public void setNumerocorrelativo(Episodioclinico numerocorrelativo) {
        this.numerocorrelativo = numerocorrelativo;
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
        hash += (correltativocontrolobstetrico != null ? correltativocontrolobstetrico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controlobstetrico)) {
            return false;
        }
        Controlobstetrico other = (Controlobstetrico) object;
        if ((this.correltativocontrolobstetrico == null && other.correltativocontrolobstetrico != null) || (this.correltativocontrolobstetrico != null && !this.correltativocontrolobstetrico.equals(other.correltativocontrolobstetrico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Controlobstetrico[ correltativocontrolobstetrico=" + correltativocontrolobstetrico + " ]";
    }
    
}
