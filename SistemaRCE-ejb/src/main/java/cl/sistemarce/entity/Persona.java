/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPersonaRut", query = "SELECT p FROM Persona p WHERE p.personaPK.personaRut = :personaRut"),
    @NamedQuery(name = "Persona.findByPersonaDv", query = "SELECT p FROM Persona p WHERE p.personaPK.personaDv = :personaDv"),
    @NamedQuery(name = "Persona.findByNacionalidadCodigo", query = "SELECT p FROM Persona p WHERE p.personaPK.nacionalidadCodigo = :nacionalidadCodigo"),
    @NamedQuery(name = "Persona.findByPersonaNombres", query = "SELECT p FROM Persona p WHERE p.personaNombres = :personaNombres"),
    @NamedQuery(name = "Persona.findByPersonaApellido1", query = "SELECT p FROM Persona p WHERE p.personaApellido1 = :personaApellido1"),
    @NamedQuery(name = "Persona.findByPersonaApellido2", query = "SELECT p FROM Persona p WHERE p.personaApellido2 = :personaApellido2"),
    @NamedQuery(name = "Persona.findByPersonaFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.personaFechaNacimiento = :personaFechaNacimiento"),
    @NamedQuery(name = "Persona.findByPersonaTelefono", query = "SELECT p FROM Persona p WHERE p.personaTelefono = :personaTelefono"),
    @NamedQuery(name = "Persona.findByPersonaCelular", query = "SELECT p FROM Persona p WHERE p.personaCelular = :personaCelular"),
    @NamedQuery(name = "Persona.findByPersonaDireccion", query = "SELECT p FROM Persona p WHERE p.personaDireccion = :personaDireccion"),
    @NamedQuery(name = "Persona.findByPersonaEmail", query = "SELECT p FROM Persona p WHERE p.personaEmail = :personaEmail")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonaPK personaPK;
    @Size(max = 100)
    @Column(name = "persona_nombres")
    private String personaNombres;
    @Size(max = 100)
    @Column(name = "persona_apellido1")
    private String personaApellido1;
    @Size(max = 100)
    @Column(name = "persona_apellido2")
    private String personaApellido2;
    @Column(name = "persona_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date personaFechaNacimiento;
    @Size(max = 10)
    @Column(name = "persona_telefono")
    private String personaTelefono;
    @Size(max = 10)
    @Column(name = "persona_celular")
    private String personaCelular;
    @Size(max = 150)
    @Column(name = "persona_direccion")
    private String personaDireccion;
    @Size(max = 100)
    @Column(name = "persona_email")
    private String personaEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Paciente> pacienteList;
    @JoinColumn(name = "tipoprevision_codigo", referencedColumnName = "tipoprevision_codigo")
    @ManyToOne
    private Tipoprevision tipoprevisionCodigo;
    @JoinColumn(name = "sexo_codigo", referencedColumnName = "sexo_codigo")
    @ManyToOne
    private Sexo sexoCodigo;
    @JoinColumn(name = "religion_codigo", referencedColumnName = "religion_codigo")
    @ManyToOne
    private Religion religionCodigo;
    @JoinColumn(name = "pueblooriginario_codigo", referencedColumnName = "pueblooriginario_codigo")
    @ManyToOne
    private Pueblooriginario pueblooriginarioCodigo;
    @JoinColumn(name = "niveleducacional_codigo", referencedColumnName = "niveleducacional_codigo")
    @ManyToOne
    private Niveleducacional niveleducacionalCodigo;
    @JoinColumn(name = "nacionalidad_codigo", referencedColumnName = "nacionalidad_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidad;
    @JoinColumn(name = "estadocivil_codigo", referencedColumnName = "estadocivil_codigo")
    @ManyToOne
    private Estadocivil estadocivilCodigo;
    @JoinColumn(name = "comuna_codigo", referencedColumnName = "comuna_codigo")
    @ManyToOne
    private Comuna comunaCodigo;

    public Persona() {
    }

    public Persona(PersonaPK personaPK) {
        this.personaPK = personaPK;
    }

    public Persona(int personaRut, String personaDv, int nacionalidadCodigo) {
        this.personaPK = new PersonaPK(personaRut, personaDv, nacionalidadCodigo);
    }

    public PersonaPK getPersonaPK() {
        return personaPK;
    }

    public void setPersonaPK(PersonaPK personaPK) {
        this.personaPK = personaPK;
    }

    public String getPersonaNombres() {
        return personaNombres;
    }

    public void setPersonaNombres(String personaNombres) {
        this.personaNombres = personaNombres;
    }

    public String getPersonaApellido1() {
        return personaApellido1;
    }

    public void setPersonaApellido1(String personaApellido1) {
        this.personaApellido1 = personaApellido1;
    }

    public String getPersonaApellido2() {
        return personaApellido2;
    }

    public void setPersonaApellido2(String personaApellido2) {
        this.personaApellido2 = personaApellido2;
    }

    public Date getPersonaFechaNacimiento() {
        return personaFechaNacimiento;
    }

    public void setPersonaFechaNacimiento(Date personaFechaNacimiento) {
        this.personaFechaNacimiento = personaFechaNacimiento;
    }

    public String getPersonaTelefono() {
        return personaTelefono;
    }

    public void setPersonaTelefono(String personaTelefono) {
        this.personaTelefono = personaTelefono;
    }

    public String getPersonaCelular() {
        return personaCelular;
    }

    public void setPersonaCelular(String personaCelular) {
        this.personaCelular = personaCelular;
    }

    public String getPersonaDireccion() {
        return personaDireccion;
    }

    public void setPersonaDireccion(String personaDireccion) {
        this.personaDireccion = personaDireccion;
    }

    public String getPersonaEmail() {
        return personaEmail;
    }

    public void setPersonaEmail(String personaEmail) {
        this.personaEmail = personaEmail;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public Tipoprevision getTipoprevisionCodigo() {
        return tipoprevisionCodigo;
    }

    public void setTipoprevisionCodigo(Tipoprevision tipoprevisionCodigo) {
        this.tipoprevisionCodigo = tipoprevisionCodigo;
    }

    public Sexo getSexoCodigo() {
        return sexoCodigo;
    }

    public void setSexoCodigo(Sexo sexoCodigo) {
        this.sexoCodigo = sexoCodigo;
    }

    public Religion getReligionCodigo() {
        return religionCodigo;
    }

    public void setReligionCodigo(Religion religionCodigo) {
        this.religionCodigo = religionCodigo;
    }

    public Pueblooriginario getPueblooriginarioCodigo() {
        return pueblooriginarioCodigo;
    }

    public void setPueblooriginarioCodigo(Pueblooriginario pueblooriginarioCodigo) {
        this.pueblooriginarioCodigo = pueblooriginarioCodigo;
    }

    public Niveleducacional getNiveleducacionalCodigo() {
        return niveleducacionalCodigo;
    }

    public void setNiveleducacionalCodigo(Niveleducacional niveleducacionalCodigo) {
        this.niveleducacionalCodigo = niveleducacionalCodigo;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Estadocivil getEstadocivilCodigo() {
        return estadocivilCodigo;
    }

    public void setEstadocivilCodigo(Estadocivil estadocivilCodigo) {
        this.estadocivilCodigo = estadocivilCodigo;
    }

    public Comuna getComunaCodigo() {
        return comunaCodigo;
    }

    public void setComunaCodigo(Comuna comunaCodigo) {
        this.comunaCodigo = comunaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaPK != null ? personaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaPK == null && other.personaPK != null) || (this.personaPK != null && !this.personaPK.equals(other.personaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Persona[ personaPK=" + personaPK + " ]";
    }
    
}
