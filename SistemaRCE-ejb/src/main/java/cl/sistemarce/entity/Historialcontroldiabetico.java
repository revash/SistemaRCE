/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "historialcontroldiabetico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historialcontroldiabetico.findAll", query = "SELECT h FROM Historialcontroldiabetico h"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdId", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdId = :hcdId"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdFecha", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdFecha = :hcdFecha"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdEg", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdEg = :hcdEg"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdPeso", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdPeso = :hcdPeso"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdEstNut", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdEstNut = :hcdEstNut"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdPa", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdPa = :hcdPa"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdAu", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdAu = :hcdAu"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdInsulina", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdInsulina = :hcdInsulina"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdGlicemiaAyuna", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdGlicemiaAyuna = :hcdGlicemiaAyuna"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdGlicemiaPostDes", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdGlicemiaPostDes = :hcdGlicemiaPostDes"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdGicemiaPostAlm", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdGicemiaPostAlm = :hcdGicemiaPostAlm"),
    @NamedQuery(name = "Historialcontroldiabetico.findByHcdObservaciones", query = "SELECT h FROM Historialcontroldiabetico h WHERE h.hcdObservaciones = :hcdObservaciones")})
public class Historialcontroldiabetico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "hcd_id")
    private Integer hcdId;
    @Column(name = "hcd_fecha")
    @Temporal(TemporalType.DATE)
    private Date hcdFecha;
    @Size(max = 2147483647)
    @Column(name = "hcd_eg")
    private String hcdEg;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "hcd_peso")
    private Double hcdPeso;
    @Size(max = 2147483647)
    @Column(name = "hcd_est_nut")
    private String hcdEstNut;
    @Column(name = "hcd_pa")
    private Integer hcdPa;
    @Size(max = 2147483647)
    @Column(name = "hcd_au")
    private String hcdAu;
    @Column(name = "hcd_insulina")
    private Integer hcdInsulina;
    @Column(name = "hcd_glicemia_ayuna")
    private Integer hcdGlicemiaAyuna;
    @Column(name = "hcd_glicemia_post_des")
    private Integer hcdGlicemiaPostDes;
    @Column(name = "hcd_gicemia_post_alm")
    private Integer hcdGicemiaPostAlm;
    @Column(name = "hcd_observaciones")
    private Integer hcdObservaciones;
    @JoinColumn(name = "cd_id", referencedColumnName = "cd_id")
    @ManyToOne
    private Controldiabetico cdId;

    public Historialcontroldiabetico() {
    }

    public Historialcontroldiabetico(Integer hcdId) {
        this.hcdId = hcdId;
    }

    public Integer getHcdId() {
        return hcdId;
    }

    public void setHcdId(Integer hcdId) {
        this.hcdId = hcdId;
    }

    public Date getHcdFecha() {
        return hcdFecha;
    }

    public void setHcdFecha(Date hcdFecha) {
        this.hcdFecha = hcdFecha;
    }

    public String getHcdEg() {
        return hcdEg;
    }

    public void setHcdEg(String hcdEg) {
        this.hcdEg = hcdEg;
    }

    public Double getHcdPeso() {
        return hcdPeso;
    }

    public void setHcdPeso(Double hcdPeso) {
        this.hcdPeso = hcdPeso;
    }

    public String getHcdEstNut() {
        return hcdEstNut;
    }

    public void setHcdEstNut(String hcdEstNut) {
        this.hcdEstNut = hcdEstNut;
    }

    public Integer getHcdPa() {
        return hcdPa;
    }

    public void setHcdPa(Integer hcdPa) {
        this.hcdPa = hcdPa;
    }

    public String getHcdAu() {
        return hcdAu;
    }

    public void setHcdAu(String hcdAu) {
        this.hcdAu = hcdAu;
    }

    public Integer getHcdInsulina() {
        return hcdInsulina;
    }

    public void setHcdInsulina(Integer hcdInsulina) {
        this.hcdInsulina = hcdInsulina;
    }

    public Integer getHcdGlicemiaAyuna() {
        return hcdGlicemiaAyuna;
    }

    public void setHcdGlicemiaAyuna(Integer hcdGlicemiaAyuna) {
        this.hcdGlicemiaAyuna = hcdGlicemiaAyuna;
    }

    public Integer getHcdGlicemiaPostDes() {
        return hcdGlicemiaPostDes;
    }

    public void setHcdGlicemiaPostDes(Integer hcdGlicemiaPostDes) {
        this.hcdGlicemiaPostDes = hcdGlicemiaPostDes;
    }

    public Integer getHcdGicemiaPostAlm() {
        return hcdGicemiaPostAlm;
    }

    public void setHcdGicemiaPostAlm(Integer hcdGicemiaPostAlm) {
        this.hcdGicemiaPostAlm = hcdGicemiaPostAlm;
    }

    public Integer getHcdObservaciones() {
        return hcdObservaciones;
    }

    public void setHcdObservaciones(Integer hcdObservaciones) {
        this.hcdObservaciones = hcdObservaciones;
    }

    public Controldiabetico getCdId() {
        return cdId;
    }

    public void setCdId(Controldiabetico cdId) {
        this.cdId = cdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hcdId != null ? hcdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historialcontroldiabetico)) {
            return false;
        }
        Historialcontroldiabetico other = (Historialcontroldiabetico) object;
        if ((this.hcdId == null && other.hcdId != null) || (this.hcdId != null && !this.hcdId.equals(other.hcdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Historialcontroldiabetico[ hcdId=" + hcdId + " ]";
    }
    
}
