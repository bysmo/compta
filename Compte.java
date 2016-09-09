/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author BF0491
 */
@Entity
@Table(name = "cpt")
@NamedQueries({
    @NamedQuery(name = "Cpt.findAll", query = "SELECT c FROM Cpt c")})
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cptid")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "strid")
    private long idStructure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "compte")
    private String compte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "trscod")
    private String codeTiers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "rubcptcod")
    private String codeRubriqueComptable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "devise")
    private String devise;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cptlib")
    private String libelleCompte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datouv")
    @Temporal(TemporalType.DATE)
    private Date dateOuverture;
    @Column(name = "datfrm")
    @Temporal(TemporalType.DATE)
    private Date dateFermeture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posdev")
    private float soldeCompte;

    public Compte() {
    }

    public Compte(Long idcompte) {
        this.id = idcompte;
    }

    public Compte(Long IdCompte, long IdStructure, String compte, String codeTiers, String codeRubriqueComptable, String devise, String libelleCompte, Date dateOuverture, float solde) {
        this.id = IdCompte;
        this.idStructure = IdStructure;
        this.compte = compte;
        this.codeTiers = codeTiers;
        this.codeRubriqueComptable = codeRubriqueComptable;
        this.devise = devise;
        this.libelleCompte = libelleCompte;
        this.dateOuverture = dateFermeture;
        this.soldeCompte = solde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(long IdStructure) {
        this.idStructure = IdStructure;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public String getCodeTiers() {
        return codeTiers;
    }

    public void setCodeTiers(String trscod) {
        this.codeTiers = trscod;
    }

    public String getCodeRubriqueComptable() {
        return codeRubriqueComptable;
    }

    public void setCodeRubriqueComptable(String codeRubriqueComptable) {
        this.codeRubriqueComptable = codeRubriqueComptable;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getLibelleCompte() {
        return libelleCompte;
    }

    public void setLibelleCompte(String libelleCompte) {
        this.libelleCompte = libelleCompte;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public Date getDateFermeture() {
        return dateFermeture;
    }

    public void setDateFermeture(Date dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    public float getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(float soldeCompte) {
        this.soldeCompte = soldeCompte;
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
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.Cpt[ Id=" + id + " ]";
    }
    
}
