/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AndresEduardo
 */
@Embeddable
public class DatosembarazoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerocorrelativo")
    private int numerocorrelativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datosembarazoid")
    private int datosembarazoid;

    public DatosembarazoPK() {
    }

    public DatosembarazoPK(int numerocorrelativo, int datosembarazoid) {
        this.numerocorrelativo = numerocorrelativo;
        this.datosembarazoid = datosembarazoid;
    }

    public int getNumerocorrelativo() {
        return numerocorrelativo;
    }

    public void setNumerocorrelativo(int numerocorrelativo) {
        this.numerocorrelativo = numerocorrelativo;
    }

    public int getDatosembarazoid() {
        return datosembarazoid;
    }

    public void setDatosembarazoid(int datosembarazoid) {
        this.datosembarazoid = datosembarazoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numerocorrelativo;
        hash += (int) datosembarazoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosembarazoPK)) {
            return false;
        }
        DatosembarazoPK other = (DatosembarazoPK) object;
        if (this.numerocorrelativo != other.numerocorrelativo) {
            return false;
        }
        if (this.datosembarazoid != other.datosembarazoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.DatosembarazoPK[ numerocorrelativo=" + numerocorrelativo + ", datosembarazoid=" + datosembarazoid + " ]";
    }
    
}
