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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "trs")
@NamedQueries({
    @NamedQuery(name = "Trs.findAll", query = "SELECT t FROM Trs t")})
public class Tiers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trsid")
    private Long id;
    @Size(max = 20)
    @Column(name = "trscod")
    private String codeTiers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "strid")
    private long idStructure;
    @Size(max = 2000)
    @Column(name = "trsnom")
    private String nomTiers;
    @Size(max = 20)
    @Column(name = "trstel")
    private String telephoneTiers;
    @Size(max = 200)
    @Column(name = "trsmail")
    private String emailTiers;
    @Size(max = 200)
    @Column(name = "trsadr")
    private String adresseTiers;
    @JoinColumn(name = "typtrscod", referencedColumnName = "typtrscod")
    @ManyToOne
    private TypeTiers codeTypeTiers;

    public Tiers() {
    }

    public Tiers(Long trsid) {
        this.id = trsid;
    }

    public Tiers(Long trsid, long strid) {
        this.id = trsid;
        this.idStructure = strid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    public long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(long idStructure) {
        this.idStructure = idStructure;
    }


    public String getTelephoneTiers() {
        return telephoneTiers;
    }

    public void setTelephoneTiers(String telephoneTiers) {
        this.telephoneTiers = telephoneTiers;
    }

    public String getEmailTiers() {
        return emailTiers;
    }

    public void setEmailTiers(String emailTiers) {
        this.emailTiers = emailTiers;
    }

    public String getAdresseTiers() {
        return adresseTiers;
    }

    public void setAdresseTiers(String adresseTiers) {
        this.adresseTiers = adresseTiers;
    }

    public TypeTiers getCodeTypeTiers() {
        return codeTypeTiers;
    }

    public void setCodeTypeTiers(TypeTiers codeTypeTiers) {
        this.codeTypeTiers = codeTypeTiers;
    }

    public String getCodeTiers() {
        return codeTiers;
    }

    public void setCodeTiers(String codeTiers) {
        this.codeTiers = codeTiers;
    }

    public String getNomTiers() {
        return nomTiers;
    }

    public void setNomTiers(String nomTiers) {
        this.nomTiers = nomTiers;
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
        if (!(object instanceof Tiers)) {
            return false;
        }
        Tiers other = (Tiers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.Trs[ trsid=" + id + " ]";
    }
    
}
