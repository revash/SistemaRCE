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
@Table(name = "niveleducacional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveleducacional.findAll", query = "SELECT n FROM Niveleducacional n"),
    @NamedQuery(name = "Niveleducacional.findByNiveleducacionalCodigo", query = "SELECT n FROM Niveleducacional n WHERE n.niveleducacionalCodigo = :niveleducacionalCodigo"),
    @NamedQuery(name = "Niveleducacional.findByNiveleducacionalNombre", query = "SELECT n FROM Niveleducacional n WHERE n.niveleducacionalNombre = :niveleducacionalNombre")})
public class Niveleducacional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "niveleducacional_codigo")
    private Integer niveleducacionalCodigo;
    @Size(max = 50)
    @Column(name = "niveleducacional_nombre")
    private String niveleducacionalNombre;
    @OneToMany(mappedBy = "niveleducacionalCodigo")
    private List<Persona> personaList;

    public Niveleducacional() {
    }

    public Niveleducacional(Integer niveleducacionalCodigo) {
        this.niveleducacionalCodigo = niveleducacionalCodigo;
    }

    public Integer getNiveleducacionalCodigo() {
        return niveleducacionalCodigo;
    }

    public void setNiveleducacionalCodigo(Integer niveleducacionalCodigo) {
        this.niveleducacionalCodigo = niveleducacionalCodigo;
    }

    public String getNiveleducacionalNombre() {
        return niveleducacionalNombre;
    }

    public void setNiveleducacionalNombre(String niveleducacionalNombre) {
        this.niveleducacionalNombre = niveleducacionalNombre;
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
        hash += (niveleducacionalCodigo != null ? niveleducacionalCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveleducacional)) {
            return false;
        }
        Niveleducacional other = (Niveleducacional) object;
        if ((this.niveleducacionalCodigo == null && other.niveleducacionalCodigo != null) || (this.niveleducacionalCodigo != null && !this.niveleducacionalCodigo.equals(other.niveleducacionalCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Niveleducacional[ niveleducacionalCodigo=" + niveleducacionalCodigo + " ]";
    }
    
}
