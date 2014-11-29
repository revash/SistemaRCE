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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "registroclinicoobstetrico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroclinicoobstetrico.findAll", query = "SELECT r FROM Registroclinicoobstetrico r"),
    @NamedQuery(name = "Registroclinicoobstetrico.findByNumeroRegistroInterno", query = "SELECT r FROM Registroclinicoobstetrico r WHERE r.numeroRegistroInterno = :numeroRegistroInterno"),
    @NamedQuery(name = "Registroclinicoobstetrico.findByAbortos", query = "SELECT r FROM Registroclinicoobstetrico r WHERE r.abortos = :abortos"),
    @NamedQuery(name = "Registroclinicoobstetrico.findByCesarias", query = "SELECT r FROM Registroclinicoobstetrico r WHERE r.cesarias = :cesarias"),
    @NamedQuery(name = "Registroclinicoobstetrico.findByVaginales", query = "SELECT r FROM Registroclinicoobstetrico r WHERE r.vaginales = :vaginales"),
    @NamedQuery(name = "Registroclinicoobstetrico.findByFechaUltimoEmbarazo", query = "SELECT r FROM Registroclinicoobstetrico r WHERE r.fechaUltimoEmbarazo = :fechaUltimoEmbarazo"),
    @NamedQuery(name = "Registroclinicoobstetrico.findByRnMayorpeso", query = "SELECT r FROM Registroclinicoobstetrico r WHERE r.rnMayorpeso = :rnMayorpeso"),
    @NamedQuery(name = "Registroclinicoobstetrico.findByRnMenorpeso", query = "SELECT r FROM Registroclinicoobstetrico r WHERE r.rnMenorpeso = :rnMenorpeso")})
public class Registroclinicoobstetrico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_registro_interno")
    private Integer numeroRegistroInterno;
    @Column(name = "abortos")
    private Integer abortos;
    @Column(name = "cesarias")
    private Integer cesarias;
    @Column(name = "vaginales")
    private Integer vaginales;
    @Column(name = "fecha_ultimo_embarazo")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoEmbarazo;
    @Column(name = "rn_mayorpeso")
    private Integer rnMayorpeso;
    @Column(name = "rn_menorpeso")
    private Integer rnMenorpeso;
    @OneToMany(mappedBy = "numeroRegistroInterno")
    private List<Episodioclinicoobstetrico> episodioclinicoobstetricoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroRegistroInterno")
    private List<Partos> partosList;
    @JoinColumns({
        @JoinColumn(name = "persona_rut", referencedColumnName = "persona_rut"),
        @JoinColumn(name = "persona_dv", referencedColumnName = "persona_dv"),
        @JoinColumn(name = "nacionalidad_codigo", referencedColumnName = "nacionalidad_codigo"),
        @JoinColumn(name = "ficha_numero", referencedColumnName = "ficha_numero")})
    @ManyToOne
    private Paciente paciente;

    public Registroclinicoobstetrico() {
    }

    public Registroclinicoobstetrico(Integer numeroRegistroInterno) {
        this.numeroRegistroInterno = numeroRegistroInterno;
    }

    public Integer getNumeroRegistroInterno() {
        return numeroRegistroInterno;
    }

    public void setNumeroRegistroInterno(Integer numeroRegistroInterno) {
        this.numeroRegistroInterno = numeroRegistroInterno;
    }

    public Integer getAbortos() {
        return abortos;
    }

    public void setAbortos(Integer abortos) {
        this.abortos = abortos;
    }

    public Integer getCesarias() {
        return cesarias;
    }

    public void setCesarias(Integer cesarias) {
        this.cesarias = cesarias;
    }

    public Integer getVaginales() {
        return vaginales;
    }

    public void setVaginales(Integer vaginales) {
        this.vaginales = vaginales;
    }

    public Date getFechaUltimoEmbarazo() {
        return fechaUltimoEmbarazo;
    }

    public void setFechaUltimoEmbarazo(Date fechaUltimoEmbarazo) {
        this.fechaUltimoEmbarazo = fechaUltimoEmbarazo;
    }

    public Integer getRnMayorpeso() {
        return rnMayorpeso;
    }

    public void setRnMayorpeso(Integer rnMayorpeso) {
        this.rnMayorpeso = rnMayorpeso;
    }

    public Integer getRnMenorpeso() {
        return rnMenorpeso;
    }

    public void setRnMenorpeso(Integer rnMenorpeso) {
        this.rnMenorpeso = rnMenorpeso;
    }

    @XmlTransient
    public List<Episodioclinicoobstetrico> getEpisodioclinicoobstetricoList() {
        return episodioclinicoobstetricoList;
    }

    public void setEpisodioclinicoobstetricoList(List<Episodioclinicoobstetrico> episodioclinicoobstetricoList) {
        this.episodioclinicoobstetricoList = episodioclinicoobstetricoList;
    }

    @XmlTransient
    public List<Partos> getPartosList() {
        return partosList;
    }

    public void setPartosList(List<Partos> partosList) {
        this.partosList = partosList;
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
        hash += (numeroRegistroInterno != null ? numeroRegistroInterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registroclinicoobstetrico)) {
            return false;
        }
        Registroclinicoobstetrico other = (Registroclinicoobstetrico) object;
        if ((this.numeroRegistroInterno == null && other.numeroRegistroInterno != null) || (this.numeroRegistroInterno != null && !this.numeroRegistroInterno.equals(other.numeroRegistroInterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Registroclinicoobstetrico[ numeroRegistroInterno=" + numeroRegistroInterno + " ]";
    }
    
}
