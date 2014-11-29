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
import javax.validation.constraints.Size;

/**
 *
 * @author AndresEduardo
 */
@Embeddable
public class ProfesionalPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "profesionalrut")
    private int profesionalrut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "profesional_dv")
    private String profesionalDv;

    public ProfesionalPK() {
    }

    public ProfesionalPK(int profesionalrut, String profesionalDv) {
        this.profesionalrut = profesionalrut;
        this.profesionalDv = profesionalDv;
    }

    public int getProfesionalrut() {
        return profesionalrut;
    }

    public void setProfesionalrut(int profesionalrut) {
        this.profesionalrut = profesionalrut;
    }

    public String getProfesionalDv() {
        return profesionalDv;
    }

    public void setProfesionalDv(String profesionalDv) {
        this.profesionalDv = profesionalDv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) profesionalrut;
        hash += (profesionalDv != null ? profesionalDv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesionalPK)) {
            return false;
        }
        ProfesionalPK other = (ProfesionalPK) object;
        if (this.profesionalrut != other.profesionalrut) {
            return false;
        }
        if ((this.profesionalDv == null && other.profesionalDv != null) || (this.profesionalDv != null && !this.profesionalDv.equals(other.profesionalDv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.ProfesionalPK[ profesionalrut=" + profesionalrut + ", profesionalDv=" + profesionalDv + " ]";
    }
    
}
