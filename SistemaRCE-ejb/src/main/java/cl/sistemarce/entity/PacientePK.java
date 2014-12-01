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
public class PacientePK implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ficha_numero")
    private int fichaNumero;

    public PacientePK() {
    }

    public PacientePK(int personaRut, String personaDv, int nacionalidadCodigo, int fichaNumero) {
        this.personaRut = personaRut;
        this.personaDv = personaDv;
        this.nacionalidadCodigo = nacionalidadCodigo;
        this.fichaNumero = fichaNumero;
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

    public int getFichaNumero() {
        return fichaNumero;
    }

    public void setFichaNumero(int fichaNumero) {
        this.fichaNumero = fichaNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personaRut;
        hash += (personaDv != null ? personaDv.hashCode() : 0);
        hash += (int) nacionalidadCodigo;
        hash += (int) fichaNumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacientePK)) {
            return false;
        }
        PacientePK other = (PacientePK) object;
        if (this.personaRut != other.personaRut) {
            return false;
        }
        if ((this.personaDv == null && other.personaDv != null) || (this.personaDv != null && !this.personaDv.equals(other.personaDv))) {
            return false;
        }
        if (this.nacionalidadCodigo != other.nacionalidadCodigo) {
            return false;
        }
        if (this.fichaNumero != other.fichaNumero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.PacientePK[ personaRut=" + personaRut + ", personaDv=" + personaDv + ", nacionalidadCodigo=" + nacionalidadCodigo + ", fichaNumero=" + fichaNumero + " ]";
    }
    
}
