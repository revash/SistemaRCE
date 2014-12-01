/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "estadocivil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadocivil.findAll", query = "SELECT e FROM Estadocivil e"),
    @NamedQuery(name = "Estadocivil.findByEstadocivilCodigo", query = "SELECT e FROM Estadocivil e WHERE e.estadocivilCodigo = :estadocivilCodigo"),
    @NamedQuery(name = "Estadocivil.findByEstadocivilDescripcion", query = "SELECT e FROM Estadocivil e WHERE e.estadocivilDescripcion = :estadocivilDescripcion")})
public class Estadocivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadocivil_codigo")
    private Integer estadocivilCodigo;
    @Size(max = 50)
    @Column(name = "estadocivil_descripcion")
    private String estadocivilDescripcion;
    @OneToMany(mappedBy = "estadocivilCodigo")
    private List<Persona> personaList;

    public Estadocivil() {
    }

    public Estadocivil(Integer estadocivilCodigo) {
        this.estadocivilCodigo = estadocivilCodigo;
    }

    public Integer getEstadocivilCodigo() {
        return estadocivilCodigo;
    }

    public void setEstadocivilCodigo(Integer estadocivilCodigo) {
        this.estadocivilCodigo = estadocivilCodigo;
    }

    public String getEstadocivilDescripcion() {
        return estadocivilDescripcion;
    }

    public void setEstadocivilDescripcion(String estadocivilDescripcion) {
        this.estadocivilDescripcion = estadocivilDescripcion;
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
        hash += (estadocivilCodigo != null ? estadocivilCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocivil)) {
            return false;
        }
        Estadocivil other = (Estadocivil) object;
        if ((this.estadocivilCodigo == null && other.estadocivilCodigo != null) || (this.estadocivilCodigo != null && !this.estadocivilCodigo.equals(other.estadocivilCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Estadocivil[ estadocivilCodigo=" + estadocivilCodigo + " ]";
    }
    
}
