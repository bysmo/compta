/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author BF0491
 */
@Entity
@Table(name = "natoperat")
@NamedQueries({
    @NamedQuery(name = "Natoperat.findAll", query = "SELECT n FROM Natoperat n")})
public class NatureOperation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NatoperatPK natoperatPK;
    @Size(max = 200)
    @Column(name = "natoperlib")
    private String libelle;
    @OneToMany(mappedBy = "natopercod")
    private List<Operation> operatList;

    public NatureOperation() {
    }

    public NatureOperation(NatoperatPK natoperatPK) {
        this.natoperatPK = natoperatPK;
    }

    public NatureOperation(String natopercod, long strid) {
        this.natoperatPK = new NatoperatPK(natopercod, strid);
    }

    public NatoperatPK getNatoperatPK() {
        return natoperatPK;
    }

    public void setNatoperatPK(NatoperatPK natoperatPK) {
        this.natoperatPK = natoperatPK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String natoperlib) {
        this.libelle = natoperlib;
    }

    public List<Operation> getOperatList() {
        return operatList;
    }

    public void setOperatList(List<Operation> operatList) {
        this.operatList = operatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (natoperatPK != null ? natoperatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NatureOperation)) {
            return false;
        }
        NatureOperation other = (NatureOperation) object;
        if ((this.natoperatPK == null && other.natoperatPK != null) || (this.natoperatPK != null && !this.natoperatPK.equals(other.natoperatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.Natoperat[ natoperatPK=" + natoperatPK + " ]";
    }
    
}
