/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByPersonaRut", query = "SELECT p FROM Paciente p WHERE p.pacientePK.personaRut = :personaRut"),
    @NamedQuery(name = "Paciente.findByPersonaDv", query = "SELECT p FROM Paciente p WHERE p.pacientePK.personaDv = :personaDv"),
    @NamedQuery(name = "Paciente.findByNacionalidadCodigo", query = "SELECT p FROM Paciente p WHERE p.pacientePK.nacionalidadCodigo = :nacionalidadCodigo"),
    @NamedQuery(name = "Paciente.findByFichaNumero", query = "SELECT p FROM Paciente p WHERE p.pacientePK.fichaNumero = :fichaNumero"),
    @NamedQuery(name = "Paciente.findByCorrelativoep", query = "SELECT p FROM Paciente p WHERE p.correlativoep = :correlativoep")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacientePK pacientePK;
    @Column(name = "correlativoep")
    private Integer correlativoep;
    @JoinColumns({
        @JoinColumn(name = "persona_rut", referencedColumnName = "persona_rut", insertable = false, updatable = false),
        @JoinColumn(name = "persona_dv", referencedColumnName = "persona_dv", insertable = false, updatable = false),
        @JoinColumn(name = "nacionalidad_codigo", referencedColumnName = "nacionalidad_codigo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "ficha_numero", referencedColumnName = "ficha_numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ficha ficha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Agendamiento> agendamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Episodioclinico> episodioclinicoList;
    @OneToMany(mappedBy = "paciente")
    private List<Datosobstetricos> datosobstetricosList;

    public Paciente() {
    }

    public Paciente(PacientePK pacientePK) {
        this.pacientePK = pacientePK;
    }

    public Paciente(int personaRut, String personaDv, int nacionalidadCodigo, int fichaNumero) {
        this.pacientePK = new PacientePK(personaRut, personaDv, nacionalidadCodigo, fichaNumero);
    }

    public PacientePK getPacientePK() {
        return pacientePK;
    }

    public void setPacientePK(PacientePK pacientePK) {
        this.pacientePK = pacientePK;
    }

    public Integer getCorrelativoep() {
        return correlativoep;
    }

    public void setCorrelativoep(Integer correlativoep) {
        this.correlativoep = correlativoep;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    @XmlTransient
    public List<Agendamiento> getAgendamientoList() {
        return agendamientoList;
    }

    public void setAgendamientoList(List<Agendamiento> agendamientoList) {
        this.agendamientoList = agendamientoList;
    }

    @XmlTransient
    public List<Episodioclinico> getEpisodioclinicoList() {
        return episodioclinicoList;
    }

    public void setEpisodioclinicoList(List<Episodioclinico> episodioclinicoList) {
        this.episodioclinicoList = episodioclinicoList;
    }

    @XmlTransient
    public List<Datosobstetricos> getDatosobstetricosList() {
        return datosobstetricosList;
    }

    public void setDatosobstetricosList(List<Datosobstetricos> datosobstetricosList) {
        this.datosobstetricosList = datosobstetricosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacientePK != null ? pacientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacientePK == null && other.pacientePK != null) || (this.pacientePK != null && !this.pacientePK.equals(other.pacientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Paciente[ pacientePK=" + pacientePK + " ]";
    }
    
}
