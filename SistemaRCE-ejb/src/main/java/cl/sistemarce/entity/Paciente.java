/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
    @NamedQuery(name = "Paciente.findByFichaNumero", query = "SELECT p FROM Paciente p WHERE p.pacientePK.fichaNumero = :fichaNumero")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacientePK pacientePK;
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
    private List<Receta> recetaList;
    @OneToMany(mappedBy = "paciente")
    private List<Registroclinicoobstetrico> registroclinicoobstetricoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Tratamiento> tratamientoList;

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
    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    @XmlTransient
    public List<Registroclinicoobstetrico> getRegistroclinicoobstetricoList() {
        return registroclinicoobstetricoList;
    }

    public void setRegistroclinicoobstetricoList(List<Registroclinicoobstetrico> registroclinicoobstetricoList) {
        this.registroclinicoobstetricoList = registroclinicoobstetricoList;
    }

    @XmlTransient
    public List<Tratamiento> getTratamientoList() {
        return tratamientoList;
    }

    public void setTratamientoList(List<Tratamiento> tratamientoList) {
        this.tratamientoList = tratamientoList;
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
