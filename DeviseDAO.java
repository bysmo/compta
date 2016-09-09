/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softone.compta.DAO;

import com.softone.compta.Models.Compte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BF0491
 */
public class DeviseDAO {
    public List<Compte> findAll() {
        List<Compte> list = new ArrayList<Compte>();
        Connection c = null;
    	String sql = "SELECT devise, libelle, cours from devise";
        
        try {
            c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
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

    public List<Compte> findByName(String name) {
        List<Compte> list = new ArrayList<Compte>();
        Connection c = null;
    	String sql = "SELECT e.id, e.firstName, e.lastName, e.title, e.picture, count(r.id) reportCount FROM compte as e " +
			"LEFT JOIN compte r ON e.id = r.managerId " +
			"WHERE UPPER(CONCAT(e.firstName, ' ', e.lastName)) LIKE ? " +	
			"GROUP BY e.id " +
			"ORDER BY e.firstName, e.lastName";
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "%" + name.toUpperCase() + "%");
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
    
    public List<Compte> findByManager(int managerId) {
    	List<Compte> list = new ArrayList<Compte>();
    	Connection c = null;
    	String sql = "SELECT e.id, e.firstName, e.lastName, e.title, e.picture, count(r.id) reportCount FROM compte as e " +
			"LEFT JOIN compte r ON e.id = r.managerId " +
			"WHERE e.managerId=? " +	
			"GROUP BY e.id " +
			"ORDER BY e.firstName, e.lastName";
    	try {
    		c = ConnectionHelper.getConnection();
    		PreparedStatement ps = c.prepareStatement(sql);
    		ps.setInt(1, managerId);
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
    
    public Compte findById(int id) {
    	String sql = "SELECT e.id, e.firstName, e.lastName, e.managerId, e.title, e.department, e.city, e.officePhone, e.cellPhone, " + 
			"e.email, e.picture, m.firstName managerFirstName, m.lastName managerLastName, count(r.id) reportCount FROM compte as e " +
			"LEFT JOIN compte m ON e.managerId = m.id " + 
			"LEFT JOIN compte r ON e.id = r.managerId " +
			"WHERE e.id = ? " +
			"GROUP BY e.id";
        Compte compte = null;
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
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

    public Compte save(Compte compte){
		return compte.getId()> 0 ? update(compte) : create(compte);
	}    
    
    public Compte create(Compte compte) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = ConnectionHelper.getConnection();
            ps = c.prepareStatement("INSERT INTO compte (,,,,cptid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",new String[] { "ID" });
             ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            Long id = rs.getLong(1);
            compte.setId(id);
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
            PreparedStatement ps = c.prepareStatement("UPDATE compte SET firstName=?, lastName=?, title=?, deptartment=?, managerId=?, city=?, officePhone, cellPhone=?, email=?, picture=? WHERE id=?");
            //ps.setInt(5, compte.getManager().getId());
             ps.setLong(11, compte.getId());
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
            PreparedStatement ps = c.prepareStatement("DELETE FROM compte WHERE id=?");
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
        /*if (managerId>0)
        {
        	Compte manager = new Compte();
        	manager.setId(managerId);
            manager.setFirstName(rs.getString("managerFirstName"));
            manager.setLastName(rs.getString("managerLastName"));
        	compte.setManager(manager);
        }
                */
        //compte.setReportCount(rs.getInt("reportCount"));
        return compte;
    }
    
    protected Compte processSummaryRow(ResultSet rs) throws SQLException {
    	Compte compte = new Compte();
    	compte.setId(rs.getLong("id"));
    	//compte.setReportCount(rs.getInt("reportCount"));
    	return compte;
    }
}
