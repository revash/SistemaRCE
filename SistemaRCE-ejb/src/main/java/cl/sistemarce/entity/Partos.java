/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "partos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partos.findAll", query = "SELECT p FROM Partos p"),
    @NamedQuery(name = "Partos.findByPartoObservacion", query = "SELECT p FROM Partos p WHERE p.partoObservacion = :partoObservacion"),
    @NamedQuery(name = "Partos.findByPartoId", query = "SELECT p FROM Partos p WHERE p.partoId = :partoId")})
public class Partos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "parto_observacion")
    private String partoObservacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "parto_id")
    private Integer partoId;
    @JoinColumn(name = "tipoparto_id", referencedColumnName = "tipoparto_id")
    @ManyToOne
    private Tipopartos tipopartoId;
    @JoinColumn(name = "numero_registro_interno", referencedColumnName = "numero_registro_interno")
    @ManyToOne(optional = false)
    private Registroclinicoobstetrico numeroRegistroInterno;

    public Partos() {
    }

    public Partos(Integer partoId) {
        this.partoId = partoId;
    }

    public String getPartoObservacion() {
        return partoObservacion;
    }

    public void setPartoObservacion(String partoObservacion) {
        this.partoObservacion = partoObservacion;
    }

    public Integer getPartoId() {
        return partoId;
    }

    public void setPartoId(Integer partoId) {
        this.partoId = partoId;
    }

    public Tipopartos getTipopartoId() {
        return tipopartoId;
    }

    public void setTipopartoId(Tipopartos tipopartoId) {
        this.tipopartoId = tipopartoId;
    }

    public Registroclinicoobstetrico getNumeroRegistroInterno() {
        return numeroRegistroInterno;
    }

    public void setNumeroRegistroInterno(Registroclinicoobstetrico numeroRegistroInterno) {
        this.numeroRegistroInterno = numeroRegistroInterno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partoId != null ? partoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partos)) {
            return false;
        }
        Partos other = (Partos) object;
        if ((this.partoId == null && other.partoId != null) || (this.partoId != null && !this.partoId.equals(other.partoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Partos[ partoId=" + partoId + " ]";
    }
    
}
