/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;

import java.sql.Date;

/**
 *
 * @author ALVARO
 */
public class Estudiante {
   
    private int id;
    private String nombre;
    private String apellido;
    private String seminario;
    private boolean confirmacion;
   private Date fecha;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, String apellido, String seminario, boolean confirmacion, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.seminario = seminario;
        this.confirmacion = confirmacion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    public boolean isConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(boolean confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
   
}
