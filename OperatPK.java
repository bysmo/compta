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
public class OperatPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "opercod")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "strid")
    private long idStructure;

    public OperatPK() {
    }

    public OperatPK(String code, long idStructure) {
        this.code = code;
        this.idStructure = idStructure;
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
        if (!(object instanceof OperatPK)) {
            return false;
        }
        OperatPK other = (OperatPK) object;
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
        return "com.softone.compta.Models.OperatPK[ code=" + code + ", idStructure=" + idStructure + " ]";
    }
    
}
