/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.DAOS;

import com.emergentes.estudiante.conDB;
import com.emergentes.modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALVARO
 */
public class estudianteDAOimpl extends conDB implements estudianteDAO{
 @Override
    public void insertar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            String sql = "INSERT INTO estudiantes (nombre, apellido, seminario, confirmacion, fecha) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getSeminario());
            ps.setBoolean(4, estudiante.isConfirmacion());
            ps.setDate(5, new java.sql.Date(estudiante.getFecha().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar el estudiante: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
         Logger.getLogger(estudianteDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
     } finally {
            this.desconectar(conn); // Método heredado para cerrar la conexión con la base de datos
        }
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            String sql = "UPDATE estudiantes SET nombre=?, apellido=?, seminario=?, confirmacion=?, fecha=? WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getSeminario());
            ps.setBoolean(4, estudiante.isConfirmacion());
            ps.setDate(5, new java.sql.Date(estudiante.getFecha().getTime()));
            ps.setInt(6, estudiante.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estudiante: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
         Logger.getLogger(estudianteDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
     } finally {
            this.desconectar(conn);
        }
    }
@Override
public void eliminar(int id) {
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = getConnection();
        String sql = "DELETE FROM estudiantes WHERE id=?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al eliminar el estudiante: " + e.getMessage());
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(estudianteDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        desconectar(conn);
    }
}

@Override
public Estudiante getById(int id) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Estudiante estudiante = new Estudiante(); // Se inicializa el objeto Estudiante
    try {
        conn = getConnection();
        String sql = "SELECT * FROM estudiantes WHERE id= ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            estudiante.setId(rs.getInt("id"));
            estudiante.setNombre(rs.getString("nombre"));
            estudiante.setApellido(rs.getString("apellido"));
            estudiante.setSeminario(rs.getString("seminario"));
            estudiante.setConfirmacion(rs.getBoolean("confirmacion"));
            estudiante.setFecha(rs.getDate("fecha"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el estudiante: " + e.getMessage());
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(estudianteDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        desconectar(conn);
    }
    return estudiante;
}

@Override
public List<Estudiante> getAll() {
    List<Estudiante> estu = new ArrayList<Estudiante>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = conDB.getConnection();
        String sql = "SELECT * FROM estudiantes";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(rs.getInt("id"));
            estudiante.setNombre(rs.getString("nombre"));
            estudiante.setApellido(rs.getString("apellido"));
            estudiante.setSeminario(rs.getString("seminario"));
            estudiante.setConfirmacion(rs.getBoolean("confirmacion"));
            estudiante.setFecha(rs.getDate("fecha"));
            estu.add(estudiante);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener la lista de estudiantes: " + e.getMessage());
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(estudianteDAOimpl.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        desconectar(conn);
    }
    return estu;
}

}
