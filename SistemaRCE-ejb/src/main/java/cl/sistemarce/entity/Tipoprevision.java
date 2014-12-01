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
@Table(name = "tipoprevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoprevision.findAll", query = "SELECT t FROM Tipoprevision t"),
    @NamedQuery(name = "Tipoprevision.findByTipoprevisionCodigo", query = "SELECT t FROM Tipoprevision t WHERE t.tipoprevisionCodigo = :tipoprevisionCodigo"),
    @NamedQuery(name = "Tipoprevision.findByTipoprevisionNombre", query = "SELECT t FROM Tipoprevision t WHERE t.tipoprevisionNombre = :tipoprevisionNombre")})
public class Tipoprevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoprevision_codigo")
    private Integer tipoprevisionCodigo;
    @Size(max = 100)
    @Column(name = "tipoprevision_nombre")
    private String tipoprevisionNombre;
    @JoinColumn(name = "prevision_codigo", referencedColumnName = "prevision_codigo")
    @ManyToOne
    private Prevision previsionCodigo;
    @OneToMany(mappedBy = "tipoprevisionCodigo")
    private List<Persona> personaList;

    public Tipoprevision() {
    }

    public Tipoprevision(Integer tipoprevisionCodigo) {
        this.tipoprevisionCodigo = tipoprevisionCodigo;
    }

    public Integer getTipoprevisionCodigo() {
        return tipoprevisionCodigo;
    }

    public void setTipoprevisionCodigo(Integer tipoprevisionCodigo) {
        this.tipoprevisionCodigo = tipoprevisionCodigo;
    }

    public String getTipoprevisionNombre() {
        return tipoprevisionNombre;
    }

    public void setTipoprevisionNombre(String tipoprevisionNombre) {
        this.tipoprevisionNombre = tipoprevisionNombre;
    }

    public Prevision getPrevisionCodigo() {
        return previsionCodigo;
    }

    public void setPrevisionCodigo(Prevision previsionCodigo) {
        this.previsionCodigo = previsionCodigo;
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
        hash += (tipoprevisionCodigo != null ? tipoprevisionCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoprevision)) {
            return false;
        }
        Tipoprevision other = (Tipoprevision) object;
        if ((this.tipoprevisionCodigo == null && other.tipoprevisionCodigo != null) || (this.tipoprevisionCodigo != null && !this.tipoprevisionCodigo.equals(other.tipoprevisionCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Tipoprevision[ tipoprevisionCodigo=" + tipoprevisionCodigo + " ]";
    }
    
}
