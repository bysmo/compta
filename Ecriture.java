/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.Models;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ecr")
@NamedQueries({
    @NamedQuery(name = "Ecr.findAll", query = "SELECT e FROM Ecr e")})
public class Ecriture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ecrid")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqnum")
    private long numeroSequence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "strid")
    private long idStructure;
    @Size(max = 20)
    @Column(name = "compte")
    private String compte;
    @Size(max = 20)
    @Column(name = "jnlcod")
    private String codeJournal;
    @Column(name = "pjid")
    private BigInteger idPieceJustificative;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datoper")
    @Temporal(TemporalType.DATE)
    private Date dateOperation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datval")
    @Temporal(TemporalType.DATE)
    private Date dateEffet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ecrmnt")
    private float montantOperation;
    @Size(max = 200)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "opercod")
    private String codeOperation;
    @Column(name = "datech")
    @Temporal(TemporalType.DATE)
    private Date dateEcheance;
    @Size(max = 1)
    @Column(name = "valide")
    private String valide;
    @Size(max = 1)
    @Column(name = "exporte")
    private String exporte;
    @Size(max = 1)
    @Column(name = "cptise")
    private String cptise;

    public Ecriture() {
    }

    public Ecriture(Long ecrid) {
        this.id = ecrid;
    }

    public Ecriture(Long ecrid, long seqnum, long strid, Date datoper, Date datval, float ecrmnt, String opercod) {
        this.id = ecrid;
        this.numeroSequence = seqnum;
        this.idStructure = strid;
        this.dateOperation = datoper;
        this.dateEffet = datval;
        this.montantOperation = ecrmnt;
        this.codeOperation = opercod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumeroSequence() {
        return numeroSequence;
    }

    public void setNumeroSequence(long numeroSequence) {
        this.numeroSequence = numeroSequence;
    }

    public long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(long idStructure) {
        this.idStructure = idStructure;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public String getCodeJournal() {
        return codeJournal;
    }

    public void setCodeJournal(String codeJournal) {
        this.codeJournal = codeJournal;
    }

    public BigInteger getIdPieceJustificative() {
        return idPieceJustificative;
    }

    public void setIdPieceJustificative(BigInteger idPieceJustificative) {
        this.idPieceJustificative = idPieceJustificative;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public float getMontantOperation() {
        return montantOperation;
    }

    public void setMontantOperation(float montantOperation) {
        this.montantOperation = montantOperation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(String codeOperation) {
        this.codeOperation = codeOperation;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    

    public String getValide() {
        return valide;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public String getExporte() {
        return exporte;
    }

    public void setExporte(String exporte) {
        this.exporte = exporte;
    }

    public String getCptise() {
        return cptise;
    }

    public void setCptise(String cptise) {
        this.cptise = cptise;
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
        if (!(object instanceof Ecriture)) {
            return false;
        }
        Ecriture other = (Ecriture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.Ecr[ ecrid=" + id + " ]";
    }
    
}
