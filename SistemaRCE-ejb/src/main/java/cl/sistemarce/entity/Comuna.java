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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "comuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c"),
    @NamedQuery(name = "Comuna.findByComunaCodigo", query = "SELECT c FROM Comuna c WHERE c.comunaCodigo = :comunaCodigo"),
    @NamedQuery(name = "Comuna.findByComunaNombre", query = "SELECT c FROM Comuna c WHERE c.comunaNombre = :comunaNombre")})
public class Comuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "comuna_codigo")
    private Integer comunaCodigo;
    @Size(max = 100)
    @Column(name = "comuna_nombre")
    private String comunaNombre;
    @JoinColumn(name = "ciudad_codigo", referencedColumnName = "ciudad_codigo")
    @ManyToOne
    private Ciudad ciudadCodigo;
    @OneToMany(mappedBy = "comunaCodigo")
    private List<Persona> personaList;

    public Comuna() {
    }

    public Comuna(Integer comunaCodigo) {
        this.comunaCodigo = comunaCodigo;
    }

    public Integer getComunaCodigo() {
        return comunaCodigo;
    }

    public void setComunaCodigo(Integer comunaCodigo) {
        this.comunaCodigo = comunaCodigo;
    }

    public String getComunaNombre() {
        return comunaNombre;
    }

    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }

    public Ciudad getCiudadCodigo() {
        return ciudadCodigo;
    }

    public void setCiudadCodigo(Ciudad ciudadCodigo) {
        this.ciudadCodigo = ciudadCodigo;
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
        hash += (comunaCodigo != null ? comunaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comuna)) {
            return false;
        }
        Comuna other = (Comuna) object;
        if ((this.comunaCodigo == null && other.comunaCodigo != null) || (this.comunaCodigo != null && !this.comunaCodigo.equals(other.comunaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Comuna[ comunaCodigo=" + comunaCodigo + " ]";
    }
    
}
