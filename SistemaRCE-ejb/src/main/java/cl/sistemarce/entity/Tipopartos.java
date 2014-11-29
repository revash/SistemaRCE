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
@Table(name = "tipopartos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopartos.findAll", query = "SELECT t FROM Tipopartos t"),
    @NamedQuery(name = "Tipopartos.findByTipopartoId", query = "SELECT t FROM Tipopartos t WHERE t.tipopartoId = :tipopartoId"),
    @NamedQuery(name = "Tipopartos.findByTipopartoDesc", query = "SELECT t FROM Tipopartos t WHERE t.tipopartoDesc = :tipopartoDesc")})
public class Tipopartos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoparto_id")
    private Integer tipopartoId;
    @Size(max = 100)
    @Column(name = "tipoparto_desc")
    private String tipopartoDesc;
    @OneToMany(mappedBy = "tipopartoId")
    private List<Partos> partosList;

    public Tipopartos() {
    }

    public Tipopartos(Integer tipopartoId) {
        this.tipopartoId = tipopartoId;
    }

    public Integer getTipopartoId() {
        return tipopartoId;
    }

    public void setTipopartoId(Integer tipopartoId) {
        this.tipopartoId = tipopartoId;
    }

    public String getTipopartoDesc() {
        return tipopartoDesc;
    }

    public void setTipopartoDesc(String tipopartoDesc) {
        this.tipopartoDesc = tipopartoDesc;
    }

    @XmlTransient
    public List<Partos> getPartosList() {
        return partosList;
    }

    public void setPartosList(List<Partos> partosList) {
        this.partosList = partosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipopartoId != null ? tipopartoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopartos)) {
            return false;
        }
        Tipopartos other = (Tipopartos) object;
        if ((this.tipopartoId == null && other.tipopartoId != null) || (this.tipopartoId != null && !this.tipopartoId.equals(other.tipopartoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Tipopartos[ tipopartoId=" + tipopartoId + " ]";
    }
    
}
