/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author BF0491
 */
@Entity
@Table(name = "rubcpt")
@NamedQueries({
    @NamedQuery(name = "Rubcpt.findAll", query = "SELECT r FROM Rubcpt r")})
public class RubriqueComptable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rubcptid")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "strid")
    private long idStructure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "rubcptcod")
    private String codeRubriqueComptable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "rubcptlib")
    private String libelleRubriqueComptable;

    public RubriqueComptable() {
    }

    public RubriqueComptable(Long rubcptid) {
        this.id = rubcptid;
    }

    public RubriqueComptable(Long rubcptid, long strid, String rubcptcod, String rubcptlib) {
        this.id = rubcptid;
        this.idStructure = strid;
        this.codeRubriqueComptable = rubcptcod;
        this.libelleRubriqueComptable = rubcptlib;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long rubcptid) {
        this.id = rubcptid;
    }

    public long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(long strid) {
        this.idStructure = strid;
    }

    public String getCodeRubriqueComptable() {
        return codeRubriqueComptable;
    }

    public void setCodeRubriqueComptable(String codeRubriqueComptable) {
        this.codeRubriqueComptable = codeRubriqueComptable;
    }

    public String getLibelleRubriqueComptable() {
        return libelleRubriqueComptable;
    }

    public void setLibelleRubriqueComptable(String libelleRubriqueComptable) {
        this.libelleRubriqueComptable = libelleRubriqueComptable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RubriqueComptable)) {
            return false;
        }
        RubriqueComptable other = (RubriqueComptable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.Rubcpt[ rubcptid=" + id + " ]";
    }
    
}
