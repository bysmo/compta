/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author BF0491
 */
@Embeddable
public class NatoperatPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "natopercod")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "strid")
    private long idStructure;

    public NatoperatPK() {
    }

    public NatoperatPK(String natopercod, long strid) {
        this.code = natopercod;
        this.idStructure = strid;
    }

    public String getCode() {
        return code;
    }

    public void setCOde(String natopercod) {
        this.code = natopercod;
    }

    public long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(long strid) {
        this.idStructure = strid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        hash += (int) idStructure;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NatoperatPK)) {
            return false;
        }
        NatoperatPK other = (NatoperatPK) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        if (this.idStructure != other.idStructure) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.NatoperatPK[ natopercod=" + code + ", strid=" + idStructure + " ]";
    }
    
}
