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
@Table(name = "religion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Religion.findAll", query = "SELECT r FROM Religion r"),
    @NamedQuery(name = "Religion.findByReligionCodigo", query = "SELECT r FROM Religion r WHERE r.religionCodigo = :religionCodigo"),
    @NamedQuery(name = "Religion.findByReligionNombre", query = "SELECT r FROM Religion r WHERE r.religionNombre = :religionNombre")})
public class Religion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "religion_codigo")
    private Integer religionCodigo;
    @Size(max = 50)
    @Column(name = "religion_nombre")
    private String religionNombre;
    @OneToMany(mappedBy = "religionCodigo")
    private List<Persona> personaList;

    public Religion() {
    }

    public Religion(Integer religionCodigo) {
        this.religionCodigo = religionCodigo;
    }

    public Integer getReligionCodigo() {
        return religionCodigo;
    }

    public void setReligionCodigo(Integer religionCodigo) {
        this.religionCodigo = religionCodigo;
    }

    public String getReligionNombre() {
        return religionNombre;
    }

    public void setReligionNombre(String religionNombre) {
        this.religionNombre = religionNombre;
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
        hash += (religionCodigo != null ? religionCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Religion)) {
            return false;
        }
        Religion other = (Religion) object;
        if ((this.religionCodigo == null && other.religionCodigo != null) || (this.religionCodigo != null && !this.religionCodigo.equals(other.religionCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Religion[ religionCodigo=" + religionCodigo + " ]";
    }
    
}
