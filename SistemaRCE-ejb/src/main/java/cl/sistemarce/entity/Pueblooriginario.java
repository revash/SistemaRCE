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
@Table(name = "pueblooriginario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pueblooriginario.findAll", query = "SELECT p FROM Pueblooriginario p"),
    @NamedQuery(name = "Pueblooriginario.findByPueblooriginarioCodigo", query = "SELECT p FROM Pueblooriginario p WHERE p.pueblooriginarioCodigo = :pueblooriginarioCodigo"),
    @NamedQuery(name = "Pueblooriginario.findByPueblooriginarioNombre", query = "SELECT p FROM Pueblooriginario p WHERE p.pueblooriginarioNombre = :pueblooriginarioNombre")})
public class Pueblooriginario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pueblooriginario_codigo")
    private Integer pueblooriginarioCodigo;
    @Size(max = 50)
    @Column(name = "pueblooriginario_nombre")
    private String pueblooriginarioNombre;
    @OneToMany(mappedBy = "pueblooriginarioCodigo")
    private List<Persona> personaList;

    public Pueblooriginario() {
    }

    public Pueblooriginario(Integer pueblooriginarioCodigo) {
        this.pueblooriginarioCodigo = pueblooriginarioCodigo;
    }

    public Integer getPueblooriginarioCodigo() {
        return pueblooriginarioCodigo;
    }

    public void setPueblooriginarioCodigo(Integer pueblooriginarioCodigo) {
        this.pueblooriginarioCodigo = pueblooriginarioCodigo;
    }

    public String getPueblooriginarioNombre() {
        return pueblooriginarioNombre;
    }

    public void setPueblooriginarioNombre(String pueblooriginarioNombre) {
        this.pueblooriginarioNombre = pueblooriginarioNombre;
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
        hash += (pueblooriginarioCodigo != null ? pueblooriginarioCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pueblooriginario)) {
            return false;
        }
        Pueblooriginario other = (Pueblooriginario) object;
        if ((this.pueblooriginarioCodigo == null && other.pueblooriginarioCodigo != null) || (this.pueblooriginarioCodigo != null && !this.pueblooriginarioCodigo.equals(other.pueblooriginarioCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Pueblooriginario[ pueblooriginarioCodigo=" + pueblooriginarioCodigo + " ]";
    }
    
}
