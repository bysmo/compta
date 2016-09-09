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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author BF0491
 */
@Entity
@Table(name = "pcejustif")
@NamedQueries({
    @NamedQuery(name = "Pcejustif.findAll", query = "SELECT p FROM Pcejustif p")})
public class PieceJustificative implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pjid")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "strid")
    private long idStructure;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "piece")
    private byte[] piece;

    public PieceJustificative() {
    }

    public PieceJustificative(Long pjid) {
        this.id = pjid;
    }

    public PieceJustificative(Long pjid, long strid, byte[] piece) {
        this.id = pjid;
        this.idStructure = strid;
        this.piece = piece;
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

    

    public byte[] getPiece() {
        return piece;
    }

    public void setPiece(byte[] piece) {
        this.piece = piece;
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
        if (!(object instanceof PieceJustificative)) {
            return false;
        }
        PieceJustificative other = (PieceJustificative) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.softone.compta.Models.Pcejustif[ pjid=" + id + " ]";
    }
    
}
