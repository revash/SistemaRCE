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
@Table(name = "episodioclinicoobstetrico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Episodioclinicoobstetrico.findAll", query = "SELECT e FROM Episodioclinicoobstetrico e"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByEpisodioNumero", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.episodioNumero = :episodioNumero"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByEpisodioAntecedentes", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.episodioAntecedentes = :episodioAntecedentes"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByEpisodioFechaInicio", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.episodioFechaInicio = :episodioFechaInicio"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByEpisodioFechaTermino", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.episodioFechaTermino = :episodioFechaTermino"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByFur", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.fur = :fur"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByFurop", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.furop = :furop"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByFpp", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.fpp = :fpp"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByEcoPrecoz", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.ecoPrecoz = :ecoPrecoz"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByEg", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.eg = :eg"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByEgSem", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.egSem = :egSem"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByAcorde", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.acorde = :acorde"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByNombreProgenitor", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.nombreProgenitor = :nombreProgenitor"),
    @NamedQuery(name = "Episodioclinicoobstetrico.findByMotivoDerivacion", query = "SELECT e FROM Episodioclinicoobstetrico e WHERE e.motivoDerivacion = :motivoDerivacion")})
public class Episodioclinicoobstetrico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "episodio_numero")
    private Integer episodioNumero;
    @Size(max = 2147483647)
    @Column(name = "episodio_antecedentes")
    private String episodioAntecedentes;
    @Column(name = "episodio_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date episodioFechaInicio;
    @Column(name = "episodio_fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date episodioFechaTermino;
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
    @Temporal(TemporalType.DATE)
    private Date ecoPrecoz;
    @Column(name = "eg")
    @Temporal(TemporalType.DATE)
    private Date eg;
    @Column(name = "eg_sem")
    private Integer egSem;
    @Column(name = "acorde")
    private Boolean acorde;
    @Size(max = 100)
    @Column(name = "nombre_progenitor")
    private String nombreProgenitor;
    @Size(max = 2147483647)
    @Column(name = "motivo_derivacion")
    private String motivoDerivacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodioNumero")
    private List<Receta> recetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodioNumero")
    private List<Controldiabetico> controldiabeticoList;
    @JoinColumn(name = "numero_registro_interno", referencedColumnName = "numero_registro_interno")
    @ManyToOne
    private Registroclinicoobstetrico numeroRegistroInterno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodioNumero")
    private List<Consultanutricional> consultanutricionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodioNumero")
    private List<Tratamiento> tratamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodioNumero")
    private List<Controlobstetrico> controlobstetricoList;

    public Episodioclinicoobstetrico() {
    }

    public Episodioclinicoobstetrico(Integer episodioNumero) {
        this.episodioNumero = episodioNumero;
    }

    public Integer getEpisodioNumero() {
        return episodioNumero;
    }

    public void setEpisodioNumero(Integer episodioNumero) {
        this.episodioNumero = episodioNumero;
    }

    public String getEpisodioAntecedentes() {
        return episodioAntecedentes;
    }

    public void setEpisodioAntecedentes(String episodioAntecedentes) {
        this.episodioAntecedentes = episodioAntecedentes;
    }

    public Date getEpisodioFechaInicio() {
        return episodioFechaInicio;
    }

    public void setEpisodioFechaInicio(Date episodioFechaInicio) {
        this.episodioFechaInicio = episodioFechaInicio;
    }

    public Date getEpisodioFechaTermino() {
        return episodioFechaTermino;
    }

    public void setEpisodioFechaTermino(Date episodioFechaTermino) {
        this.episodioFechaTermino = episodioFechaTermino;
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

    public Date getEcoPrecoz() {
        return ecoPrecoz;
    }

    public void setEcoPrecoz(Date ecoPrecoz) {
        this.ecoPrecoz = ecoPrecoz;
    }

    public Date getEg() {
        return eg;
    }

    public void setEg(Date eg) {
        this.eg = eg;
    }

    public Integer getEgSem() {
        return egSem;
    }

    public void setEgSem(Integer egSem) {
        this.egSem = egSem;
    }

    public Boolean getAcorde() {
        return acorde;
    }

    public void setAcorde(Boolean acorde) {
        this.acorde = acorde;
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

    @XmlTransient
    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    @XmlTransient
    public List<Controldiabetico> getControldiabeticoList() {
        return controldiabeticoList;
    }

    public void setControldiabeticoList(List<Controldiabetico> controldiabeticoList) {
        this.controldiabeticoList = controldiabeticoList;
    }

    public Registroclinicoobstetrico getNumeroRegistroInterno() {
        return numeroRegistroInterno;
    }

    public void setNumeroRegistroInterno(Registroclinicoobstetrico numeroRegistroInterno) {
        this.numeroRegistroInterno = numeroRegistroInterno;
    }

    @XmlTransient
    public List<Consultanutricional> getConsultanutricionalList() {
        return consultanutricionalList;
    }

    public void setConsultanutricionalList(List<Consultanutricional> consultanutricionalList) {
        this.consultanutricionalList = consultanutricionalList;
    }

    @XmlTransient
    public List<Tratamiento> getTratamientoList() {
        return tratamientoList;
    }

    public void setTratamientoList(List<Tratamiento> tratamientoList) {
        this.tratamientoList = tratamientoList;
    }

    @XmlTransient
    public List<Controlobstetrico> getControlobstetricoList() {
        return controlobstetricoList;
    }

    public void setControlobstetricoList(List<Controlobstetrico> controlobstetricoList) {
        this.controlobstetricoList = controlobstetricoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (episodioNumero != null ? episodioNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Episodioclinicoobstetrico)) {
            return false;
        }
        Episodioclinicoobstetrico other = (Episodioclinicoobstetrico) object;
        if ((this.episodioNumero == null && other.episodioNumero != null) || (this.episodioNumero != null && !this.episodioNumero.equals(other.episodioNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Episodioclinicoobstetrico[ episodioNumero=" + episodioNumero + " ]";
    }
    
}
