/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.DAOS;

import com.emergentes.modelo.Estudiante;
import java.util.List;

/**
 *
 * @author ALVARO
 */
public interface estudianteDAO {
     public void insertar(Estudiante estudiante);
    
    public void actualizar(Estudiante estudiante);
    
    public void eliminar(int id);
    
    public Estudiante getById(int id);
    
    public List<Estudiante> getAll();
}
