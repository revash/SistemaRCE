/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "profesional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p"),
    @NamedQuery(name = "Profesional.findByProfesionalrut", query = "SELECT p FROM Profesional p WHERE p.profesionalPK.profesionalrut = :profesionalrut"),
    @NamedQuery(name = "Profesional.findByProfesionalDv", query = "SELECT p FROM Profesional p WHERE p.profesionalPK.profesionalDv = :profesionalDv"),
    @NamedQuery(name = "Profesional.findByProfesionalNombres", query = "SELECT p FROM Profesional p WHERE p.profesionalNombres = :profesionalNombres"),
    @NamedQuery(name = "Profesional.findByProfesionalApellido1", query = "SELECT p FROM Profesional p WHERE p.profesionalApellido1 = :profesionalApellido1"),
    @NamedQuery(name = "Profesional.findByProfesionalApellido2", query = "SELECT p FROM Profesional p WHERE p.profesionalApellido2 = :profesionalApellido2"),
    @NamedQuery(name = "Profesional.findByProfesionalTelefono", query = "SELECT p FROM Profesional p WHERE p.profesionalTelefono = :profesionalTelefono"),
    @NamedQuery(name = "Profesional.findByProfesionalCelular", query = "SELECT p FROM Profesional p WHERE p.profesionalCelular = :profesionalCelular"),
    @NamedQuery(name = "Profesional.findByProfesionalEmail", query = "SELECT p FROM Profesional p WHERE p.profesionalEmail = :profesionalEmail"),
    @NamedQuery(name = "Profesional.findByProfesionalClaveacceso", query = "SELECT p FROM Profesional p WHERE p.profesionalClaveacceso = :profesionalClaveacceso")})
public class Profesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfesionalPK profesionalPK;
    @Size(max = 100)
    @Column(name = "profesional_nombres")
    private String profesionalNombres;
    @Size(max = 100)
    @Column(name = "profesional_apellido1")
    private String profesionalApellido1;
    @Size(max = 100)
    @Column(name = "profesional_apellido2")
    private String profesionalApellido2;
    @Size(max = 10)
    @Column(name = "profesional_telefono")
    private String profesionalTelefono;
    @Size(max = 10)
    @Column(name = "profesional_celular")
    private String profesionalCelular;
    @Size(max = 100)
    @Column(name = "profesional_email")
    private String profesionalEmail;
    @Size(max = 2147483647)
    @Column(name = "profesional_claveacceso")
    private String profesionalClaveacceso;
    @OneToMany(mappedBy = "profesional")
    private List<Ficha> fichaList;
    @JoinColumn(name = "rol_codigo", referencedColumnName = "rol_codigo")
    @ManyToOne(optional = false)
    private Rol rolCodigo;
    @JoinColumn(name = "especialidad_codigo", referencedColumnName = "especialidad_codigo")
    @ManyToOne(optional = false)
    private Especialidad especialidadCodigo;

    public Profesional() {
    }

    public Profesional(ProfesionalPK profesionalPK) {
        this.profesionalPK = profesionalPK;
    }

    public Profesional(int profesionalrut, String profesionalDv) {
        this.profesionalPK = new ProfesionalPK(profesionalrut, profesionalDv);
    }

    public ProfesionalPK getProfesionalPK() {
        return profesionalPK;
    }

    public void setProfesionalPK(ProfesionalPK profesionalPK) {
        this.profesionalPK = profesionalPK;
    }

    public String getProfesionalNombres() {
        return profesionalNombres;
    }

    public void setProfesionalNombres(String profesionalNombres) {
        this.profesionalNombres = profesionalNombres;
    }

    public String getProfesionalApellido1() {
        return profesionalApellido1;
    }

    public void setProfesionalApellido1(String profesionalApellido1) {
        this.profesionalApellido1 = profesionalApellido1;
    }

    public String getProfesionalApellido2() {
        return profesionalApellido2;
    }

    public void setProfesionalApellido2(String profesionalApellido2) {
        this.profesionalApellido2 = profesionalApellido2;
    }

    public String getProfesionalTelefono() {
        return profesionalTelefono;
    }

    public void setProfesionalTelefono(String profesionalTelefono) {
        this.profesionalTelefono = profesionalTelefono;
    }

    public String getProfesionalCelular() {
        return profesionalCelular;
    }

    public void setProfesionalCelular(String profesionalCelular) {
        this.profesionalCelular = profesionalCelular;
    }

    public String getProfesionalEmail() {
        return profesionalEmail;
    }

    public void setProfesionalEmail(String profesionalEmail) {
        this.profesionalEmail = profesionalEmail;
    }

    public String getProfesionalClaveacceso() {
        return profesionalClaveacceso;
    }

    public void setProfesionalClaveacceso(String profesionalClaveacceso) {
        this.profesionalClaveacceso = profesionalClaveacceso;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    public Rol getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Rol rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    public Especialidad getEspecialidadCodigo() {
        return especialidadCodigo;
    }

    public void setEspecialidadCodigo(Especialidad especialidadCodigo) {
        this.especialidadCodigo = especialidadCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesionalPK != null ? profesionalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.profesionalPK == null && other.profesionalPK != null) || (this.profesionalPK != null && !this.profesionalPK.equals(other.profesionalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Profesional[ profesionalPK=" + profesionalPK + " ]";
    }
    
}
