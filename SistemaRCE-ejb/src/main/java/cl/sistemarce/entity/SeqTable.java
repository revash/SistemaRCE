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
@Table(name = "seq_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeqTable.findAll", query = "SELECT s FROM SeqTable s"),
    @NamedQuery(name = "SeqTable.findBySeqName", query = "SELECT s FROM SeqTable s WHERE s.seqName = :seqName"),
    @NamedQuery(name = "SeqTable.findBySeqId", query = "SELECT s FROM SeqTable s WHERE s.seqId = :seqId")})
public class SeqTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "seq_name")
    private String seqName;
    @Column(name = "seq_id")
    private Integer seqId;

    public SeqTable() {
    }

    public SeqTable(String seqName) {
        this.seqName = seqName;
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public Integer getSeqId() {
        return seqId;
    }

    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqName != null ? seqName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeqTable)) {
            return false;
        }
        SeqTable other = (SeqTable) object;
        if ((this.seqName == null && other.seqName != null) || (this.seqName != null && !this.seqName.equals(other.seqName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.SeqTable[ seqName=" + seqName + " ]";
    }
    
}
