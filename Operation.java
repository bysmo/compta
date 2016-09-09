/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author BF0491
 */
@Entity
@Table(name = "operat")
@NamedQueries({
    @NamedQuery(name = "Operat.findAll", query = "SELECT o FROM Operat o")})
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OperatPK operatPK;
    @Size(max = 200)
    @Column(name = "operlib")
    private String libelle;
    @JoinColumn(name = "natopercod", referencedColumnName = "natopercod")
    @ManyToOne
    private NatureOperation codeNatureOperation;

    public Operation() {
    }

    public Operation(OperatPK operatPK) {
        this.operatPK = operatPK;
    }

    public Operation(String opercod, long strid) {
        this.operatPK = new OperatPK(opercod, strid);
    }

    public OperatPK getOperatPK() {
        return operatPK;
    }

    public void setOperatPK(OperatPK operatPK) {
        this.operatPK = operatPK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public NatureOperation getCodeNatureOperation() {
        return codeNatureOperation;
    }

    public void setCodeNatureOperation(NatureOperation codeNatureOperation) {
        this.codeNatureOperation = codeNatureOperation;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operatPK != null ? operatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.operatPK == null && other.operatPK != null) || (this.operatPK != null && !this.operatPK.equals(other.operatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.Operat[ operatPK=" + operatPK + " ]";
    }
    
}
