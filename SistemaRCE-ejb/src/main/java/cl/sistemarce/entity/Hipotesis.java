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
@Table(name = "hipotesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hipotesis.findAll", query = "SELECT h FROM Hipotesis h"),
    @NamedQuery(name = "Hipotesis.findByObservaciones", query = "SELECT h FROM Hipotesis h WHERE h.observaciones = :observaciones"),
    @NamedQuery(name = "Hipotesis.findByHipotesisId", query = "SELECT h FROM Hipotesis h WHERE h.hipotesisId = :hipotesisId"),
    @NamedQuery(name = "Hipotesis.findByControlId", query = "SELECT h FROM Hipotesis h WHERE h.controlId = :controlId")})
public class Hipotesis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "hipotesis_id")
    private Integer hipotesisId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_id")
    private int controlId;
    @JoinColumn(name = "tipoh_id", referencedColumnName = "tipoh_id")
    @ManyToOne(optional = false)
    private Tiposhipotesis tipohId;
    @JoinColumn(name = "estado_id", referencedColumnName = "estado_id")
    @ManyToOne(optional = false)
    private Estados estadoId;
    @JoinColumn(name = "correltativocontrolobstetrico", referencedColumnName = "correltativocontrolobstetrico")
    @ManyToOne
    private Controlobstetrico correltativocontrolobstetrico;

    public Hipotesis() {
    }

    public Hipotesis(Integer hipotesisId) {
        this.hipotesisId = hipotesisId;
    }

    public Hipotesis(Integer hipotesisId, int controlId) {
        this.hipotesisId = hipotesisId;
        this.controlId = controlId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getHipotesisId() {
        return hipotesisId;
    }

    public void setHipotesisId(Integer hipotesisId) {
        this.hipotesisId = hipotesisId;
    }

    public int getControlId() {
        return controlId;
    }

    public void setControlId(int controlId) {
        this.controlId = controlId;
    }

    public Tiposhipotesis getTipohId() {
        return tipohId;
    }

    public void setTipohId(Tiposhipotesis tipohId) {
        this.tipohId = tipohId;
    }

    public Estados getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estados estadoId) {
        this.estadoId = estadoId;
    }

    public Controlobstetrico getCorreltativocontrolobstetrico() {
        return correltativocontrolobstetrico;
    }

    public void setCorreltativocontrolobstetrico(Controlobstetrico correltativocontrolobstetrico) {
        this.correltativocontrolobstetrico = correltativocontrolobstetrico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hipotesisId != null ? hipotesisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hipotesis)) {
            return false;
        }
        Hipotesis other = (Hipotesis) object;
        if ((this.hipotesisId == null && other.hipotesisId != null) || (this.hipotesisId != null && !this.hipotesisId.equals(other.hipotesisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Hipotesis[ hipotesisId=" + hipotesisId + " ]";
    }
    
}
