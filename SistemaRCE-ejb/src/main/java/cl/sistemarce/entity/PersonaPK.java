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
public class PersonaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "persona_rut")
    private int personaRut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "persona_dv")
    private String personaDv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nacionalidad_codigo")
    private int nacionalidadCodigo;

    public PersonaPK() {
    }

    public PersonaPK(int personaRut, String personaDv, int nacionalidadCodigo) {
        this.personaRut = personaRut;
        this.personaDv = personaDv;
        this.nacionalidadCodigo = nacionalidadCodigo;
    }

    public int getPersonaRut() {
        return personaRut;
    }

    public void setPersonaRut(int personaRut) {
        this.personaRut = personaRut;
    }

    public String getPersonaDv() {
        return personaDv;
    }

    public void setPersonaDv(String personaDv) {
        this.personaDv = personaDv;
    }

    public int getNacionalidadCodigo() {
        return nacionalidadCodigo;
    }

    public void setNacionalidadCodigo(int nacionalidadCodigo) {
        this.nacionalidadCodigo = nacionalidadCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personaRut;
        hash += (personaDv != null ? personaDv.hashCode() : 0);
        hash += (int) nacionalidadCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaPK)) {
            return false;
        }
        PersonaPK other = (PersonaPK) object;
        if (this.personaRut != other.personaRut) {
            return false;
        }
        if ((this.personaDv == null && other.personaDv != null) || (this.personaDv != null && !this.personaDv.equals(other.personaDv))) {
            return false;
        }
        if (this.nacionalidadCodigo != other.nacionalidadCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.PersonaPK[ personaRut=" + personaRut + ", personaDv=" + personaDv + ", nacionalidadCodigo=" + nacionalidadCodigo + " ]";
    }
    
}
