/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.Models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author BF0491
 */
@Entity
@Table(name = "typtrs")
@NamedQueries({
    @NamedQuery(name = "Typtrs.findAll", query = "SELECT t FROM Typtrs t")})
public class TypeTiers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "typtrscod")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "typtrslib")
    private String libelle;
    @OneToMany(mappedBy = "codeTypeTiers")
    private List<Tiers> tiers;

    public TypeTiers() {
    }

    public TypeTiers(String typtrscod) {
        this.code = typtrscod;
    }

    public TypeTiers(String typtrscod, String typtrslib) {
        this.code = typtrscod;
        this.libelle = typtrslib;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Tiers> getTiers() {
        return tiers;
    }

    public void setTiers(List<Tiers> tiers) {
        this.tiers = tiers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeTiers)) {
            return false;
        }
        TypeTiers other = (TypeTiers) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.Typtrs[ typtrscod=" + code + " ]";
    }
    
}
