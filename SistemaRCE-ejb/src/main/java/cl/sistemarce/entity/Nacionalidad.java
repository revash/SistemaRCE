/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "nacionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacionalidad.findAll", query = "SELECT n FROM Nacionalidad n"),
    @NamedQuery(name = "Nacionalidad.findByNacionalidadCodigo", query = "SELECT n FROM Nacionalidad n WHERE n.nacionalidadCodigo = :nacionalidadCodigo"),
    @NamedQuery(name = "Nacionalidad.findByNacionalidadNombre", query = "SELECT n FROM Nacionalidad n WHERE n.nacionalidadNombre = :nacionalidadNombre")})
public class Nacionalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nacionalidad_codigo")
    private Integer nacionalidadCodigo;
    @Size(max = 100)
    @Column(name = "nacionalidad_nombre")
    private String nacionalidadNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad")
    private List<Persona> personaList;

    public Nacionalidad() {
    }

    public Nacionalidad(Integer nacionalidadCodigo) {
        this.nacionalidadCodigo = nacionalidadCodigo;
    }

    public Integer getNacionalidadCodigo() {
        return nacionalidadCodigo;
    }

    public void setNacionalidadCodigo(Integer nacionalidadCodigo) {
        this.nacionalidadCodigo = nacionalidadCodigo;
    }

    public String getNacionalidadNombre() {
        return nacionalidadNombre;
    }

    public void setNacionalidadNombre(String nacionalidadNombre) {
        this.nacionalidadNombre = nacionalidadNombre;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nacionalidadCodigo != null ? nacionalidadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidad)) {
            return false;
        }
        Nacionalidad other = (Nacionalidad) object;
        if ((this.nacionalidadCodigo == null && other.nacionalidadCodigo != null) || (this.nacionalidadCodigo != null && !this.nacionalidadCodigo.equals(other.nacionalidadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Nacionalidad[ nacionalidadCodigo=" + nacionalidadCodigo + " ]";
    }
    
}
