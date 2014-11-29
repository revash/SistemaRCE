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
@Table(name = "tiposhipotesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposhipotesis.findAll", query = "SELECT t FROM Tiposhipotesis t"),
    @NamedQuery(name = "Tiposhipotesis.findByTipohId", query = "SELECT t FROM Tiposhipotesis t WHERE t.tipohId = :tipohId"),
    @NamedQuery(name = "Tiposhipotesis.findByTipohDesc", query = "SELECT t FROM Tiposhipotesis t WHERE t.tipohDesc = :tipohDesc")})
public class Tiposhipotesis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoh_id")
    private Integer tipohId;
    @Size(max = 100)
    @Column(name = "tipoh_desc")
    private String tipohDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipohId")
    private List<Hipotesis> hipotesisList;

    public Tiposhipotesis() {
    }

    public Tiposhipotesis(Integer tipohId) {
        this.tipohId = tipohId;
    }

    public Integer getTipohId() {
        return tipohId;
    }

    public void setTipohId(Integer tipohId) {
        this.tipohId = tipohId;
    }

    public String getTipohDesc() {
        return tipohDesc;
    }

    public void setTipohDesc(String tipohDesc) {
        this.tipohDesc = tipohDesc;
    }

    @XmlTransient
    public List<Hipotesis> getHipotesisList() {
        return hipotesisList;
    }

    public void setHipotesisList(List<Hipotesis> hipotesisList) {
        this.hipotesisList = hipotesisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipohId != null ? tipohId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposhipotesis)) {
            return false;
        }
        Tiposhipotesis other = (Tiposhipotesis) object;
        if ((this.tipohId == null && other.tipohId != null) || (this.tipohId != null && !this.tipohId.equals(other.tipohId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Tiposhipotesis[ tipohId=" + tipohId + " ]";
    }
    
}
