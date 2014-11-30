/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "datosembarazo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datosembarazo.findAll", query = "SELECT d FROM Datosembarazo d"),
    @NamedQuery(name = "Datosembarazo.findByNumerocorrelativo", query = "SELECT d FROM Datosembarazo d WHERE d.datosembarazoPK.numerocorrelativo = :numerocorrelativo"),
    @NamedQuery(name = "Datosembarazo.findByAntecedentes", query = "SELECT d FROM Datosembarazo d WHERE d.antecedentes = :antecedentes"),
    @NamedQuery(name = "Datosembarazo.findByFur", query = "SELECT d FROM Datosembarazo d WHERE d.fur = :fur"),
    @NamedQuery(name = "Datosembarazo.findByFurop", query = "SELECT d FROM Datosembarazo d WHERE d.furop = :furop"),
    @NamedQuery(name = "Datosembarazo.findByFpp", query = "SELECT d FROM Datosembarazo d WHERE d.fpp = :fpp"),
    @NamedQuery(name = "Datosembarazo.findByEcoPrecoz", query = "SELECT d FROM Datosembarazo d WHERE d.ecoPrecoz = :ecoPrecoz"),
    @NamedQuery(name = "Datosembarazo.findByEg", query = "SELECT d FROM Datosembarazo d WHERE d.eg = :eg"),
    @NamedQuery(name = "Datosembarazo.findByEgSem", query = "SELECT d FROM Datosembarazo d WHERE d.egSem = :egSem"),
    @NamedQuery(name = "Datosembarazo.findByNombreProgenitor", query = "SELECT d FROM Datosembarazo d WHERE d.nombreProgenitor = :nombreProgenitor"),
    @NamedQuery(name = "Datosembarazo.findByMotivoDerivacion", query = "SELECT d FROM Datosembarazo d WHERE d.motivoDerivacion = :motivoDerivacion"),
    @NamedQuery(name = "Datosembarazo.findByDatosembarazoid", query = "SELECT d FROM Datosembarazo d WHERE d.datosembarazoPK.datosembarazoid = :datosembarazoid")})
public class Datosembarazo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatosembarazoPK datosembarazoPK;
    @Size(max = 2147483647)
    @Column(name = "antecedentes")
    private String antecedentes;
    @Column(name = "fur")
    @Temporal(TemporalType.DATE)
    private Date fur;
    @Column(name = "furop")
    @Temporal(TemporalType.DATE)
    private Date furop;
    @Column(name = "fpp")
    @Temporal(TemporalType.DATE)
    private Date fpp;
    @Column(name = "eco_precoz")
    private Integer ecoPrecoz;
    @Column(name = "eg")
    private Integer eg;
    @Column(name = "eg_sem")
    private Integer egSem;
    @Size(max = 100)
    @Column(name = "nombre_progenitor")
    private String nombreProgenitor;
    @Size(max = 100)
    @Column(name = "motivo_derivacion")
    private String motivoDerivacion;
    @JoinColumn(name = "numerocorrelativo", referencedColumnName = "numerocorrelativo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Episodioclinico episodioclinico;

    public Datosembarazo() {
    }

    public Datosembarazo(DatosembarazoPK datosembarazoPK) {
        this.datosembarazoPK = datosembarazoPK;
    }

    public Datosembarazo(int numerocorrelativo, int datosembarazoid) {
        this.datosembarazoPK = new DatosembarazoPK(numerocorrelativo, datosembarazoid);
    }

    public DatosembarazoPK getDatosembarazoPK() {
        return datosembarazoPK;
    }

    public void setDatosembarazoPK(DatosembarazoPK datosembarazoPK) {
        this.datosembarazoPK = datosembarazoPK;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public Date getFur() {
        return fur;
    }

    public void setFur(Date fur) {
        this.fur = fur;
    }

    public Date getFurop() {
        return furop;
    }

    public void setFurop(Date furop) {
        this.furop = furop;
    }

    public Date getFpp() {
        return fpp;
    }

    public void setFpp(Date fpp) {
        this.fpp = fpp;
    }

    public Integer getEcoPrecoz() {
        return ecoPrecoz;
    }

    public void setEcoPrecoz(Integer ecoPrecoz) {
        this.ecoPrecoz = ecoPrecoz;
    }

    public Integer getEg() {
        return eg;
    }

    public void setEg(Integer eg) {
        this.eg = eg;
    }

    public Integer getEgSem() {
        return egSem;
    }

    public void setEgSem(Integer egSem) {
        this.egSem = egSem;
    }

    public String getNombreProgenitor() {
        return nombreProgenitor;
    }

    public void setNombreProgenitor(String nombreProgenitor) {
        this.nombreProgenitor = nombreProgenitor;
    }

    public String getMotivoDerivacion() {
        return motivoDerivacion;
    }

    public void setMotivoDerivacion(String motivoDerivacion) {
        this.motivoDerivacion = motivoDerivacion;
    }

    public Episodioclinico getEpisodioclinico() {
        return episodioclinico;
    }

    public void setEpisodioclinico(Episodioclinico episodioclinico) {
        this.episodioclinico = episodioclinico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datosembarazoPK != null ? datosembarazoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datosembarazo)) {
            return false;
        }
        Datosembarazo other = (Datosembarazo) object;
        if ((this.datosembarazoPK == null && other.datosembarazoPK != null) || (this.datosembarazoPK != null && !this.datosembarazoPK.equals(other.datosembarazoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Datosembarazo[ datosembarazoPK=" + datosembarazoPK + " ]";
    }
    
}
