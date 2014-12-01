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
@Table(name = "prevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prevision.findAll", query = "SELECT p FROM Prevision p"),
    @NamedQuery(name = "Prevision.findByPrevisionCodigo", query = "SELECT p FROM Prevision p WHERE p.previsionCodigo = :previsionCodigo"),
    @NamedQuery(name = "Prevision.findByPrevisionNombre", query = "SELECT p FROM Prevision p WHERE p.previsionNombre = :previsionNombre")})
public class Prevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prevision_codigo")
    private Integer previsionCodigo;
    @Size(max = 100)
    @Column(name = "prevision_nombre")
    private String previsionNombre;
    @OneToMany(mappedBy = "previsionCodigo")
    private List<Tipoprevision> tipoprevisionList;

    public Prevision() {
    }

    public Prevision(Integer previsionCodigo) {
        this.previsionCodigo = previsionCodigo;
    }

    public Integer getPrevisionCodigo() {
        return previsionCodigo;
    }

    public void setPrevisionCodigo(Integer previsionCodigo) {
        this.previsionCodigo = previsionCodigo;
    }

    public String getPrevisionNombre() {
        return previsionNombre;
    }

    public void setPrevisionNombre(String previsionNombre) {
        this.previsionNombre = previsionNombre;
    }

    @XmlTransient
    public List<Tipoprevision> getTipoprevisionList() {
        return tipoprevisionList;
    }

    public void setTipoprevisionList(List<Tipoprevision> tipoprevisionList) {
        this.tipoprevisionList = tipoprevisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (previsionCodigo != null ? previsionCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prevision)) {
            return false;
        }
        Prevision other = (Prevision) object;
        if ((this.previsionCodigo == null && other.previsionCodigo != null) || (this.previsionCodigo != null && !this.previsionCodigo.equals(other.previsionCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Prevision[ previsionCodigo=" + previsionCodigo + " ]";
    }
    
}
