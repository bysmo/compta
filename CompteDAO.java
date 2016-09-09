/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.DAO;

/**
 *
 * @author BF0491
 */
import com.softone.compta.Models.Compte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BF0491
 */
public class CompteDAO {

    public String sql_select_all = "SELECT cptid, strid, compte, trscod, rubcptcode, devise, cptlib, datouv, datfrm, posdev "
            + "from cpt";

    public List<Compte> findAll() {
        List<Compte> list = new ArrayList<Compte>();
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql_select_all);
            while (rs.next()) {
                list.add(processSummaryRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return list;
    }

    public List<Compte> findByCompte(String compte) {
        List<Compte> list = new ArrayList<Compte>();
        Connection c = null;
        String sql = sql_select_all + " WHERE compte= ? ";
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, compte);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(processSummaryRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return list;
    }

    public Compte findById(Long id) {
        String sql = sql_select_all + " where cptid=?";
        Compte compte = null;
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                compte = processRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return compte;
    }

    public Compte save(Compte compte) {
        return compte.getId() > 0 ? update(compte) : create(compte);
    }

    public Compte create(Compte compte) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = ConnectionHelper.getConnection();
            ps = c.prepareStatement("INSERT INTO cpt (strid, compte,trscod,rubcptcod,devise,datouv,datfrm,posdev) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?");
            int id = 1;
            ps.setLong(id++, compte.getIdStructure());
            ps.setString(id++, compte.getCompte());
            ps.setString(id++, compte.getCodeTiers());
            ps.setString(id++, compte.getCodeRubriqueComptable());
            ps.setString(id++, compte.getDevise());
            //ps.setDate(id++,(java.util.Date)compte.getDateOuverture());
            id++;
            //ps.setDate(id++,(java.util.Date)compte.getDateFermeture());
            id++;
            ps.setFloat(id++, compte.getSoldeCompte());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            Long idr = rs.getLong(1);
            compte.setId(idr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return compte;
    }

    public Compte update(Compte compte) {
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement("UPDATE cpt SET compte=?, trscod=?, rubcptcod=?, devise=?, datouv=?, datfrm=?, posdev=? WHERE cptid=?");
            int id = 1;
            ps.setString(id++, compte.getCompte());
            ps.setString(id++, compte.getCodeTiers());
            ps.setString(id++, compte.getCodeRubriqueComptable());
            ps.setString(id++, compte.getDevise());
            //ps.setDate(id++,(java.util.Date)compte.getDateOuverture());
            id++;
            //ps.setDate(id++,(java.util.Date)compte.getDateFermeture());
            id++;
            ps.setFloat(id++, compte.getSoldeCompte());
            ps.setLong(id++, compte.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
        return compte;
    }

    public boolean remove(Compte compte) {
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM cpt WHERE id=?");
            ps.setLong(1, compte.getId());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            ConnectionHelper.close(c);
        }
    }

    protected Compte processRow(ResultSet rs) throws SQLException {
        Compte compte = new Compte();
        compte.setId(rs.getLong("id"));
        compte.setCodeRubriqueComptable(rs.getString("rubcptcod"));
        compte.setCodeTiers(rs.getString("trscod"));
        compte.setCompte(rs.getString("compte"));
        compte.setDateFermeture(rs.getDate("datouv"));
        compte.setDateFermeture(rs.getDate("datfrm"));
        compte.setDevise(rs.getString("devise"));
        compte.setIdStructure(rs.getLong("strid"));
        compte.setLibelleCompte(rs.getString("cptlib"));
        compte.setSoldeCompte(rs.getFloat("posdev"));
        return compte;
    }

    protected Compte processSummaryRow(ResultSet rs) throws SQLException {
       Compte compte = new Compte();
        compte.setId(rs.getLong("id"));
        compte.setCodeRubriqueComptable(rs.getString("rubcptcod"));
        compte.setCodeTiers(rs.getString("trscod"));
        compte.setCompte(rs.getString("compte"));
        compte.setDateFermeture(rs.getDate("datouv"));
        compte.setDateFermeture(rs.getDate("datfrm"));
        compte.setDevise(rs.getString("devise"));
        compte.setIdStructure(rs.getLong("strid"));
        compte.setLibelleCompte(rs.getString("cptlib"));
        compte.setSoldeCompte(rs.getFloat("posdev"));
        return compte;
    }

}
