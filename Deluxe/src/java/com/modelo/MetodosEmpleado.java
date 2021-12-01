/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Alvarado
 */
public class MetodosEmpleado extends Conexion {

    public ArrayList<Empleado> MostrarEmpleado() {
        ArrayList<Empleado> listaE = new ArrayList<>();
        
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement(
                    "SELECT E.ID_EMPLEADO, E.NOMBRES, E.APELLIDOS, A.NOMBRE_USUARIO,E.TELEFONO, E.DIRECCION, E.DOCUMENTO, E.SEXO  FROM EMPLEADO E INNER JOIN USUARIO A ON E.ID_USUARIO = A.ID_USUARIO");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setID(rs.getInt(1));
                emp.setNombres(rs.getString(2));
                emp.setApellidos(rs.getString(3));
                emp.setNombre_usuario(rs.getString(4));
                emp.setTelefono(rs.getString(5));
                emp.setDireccion(rs.getString(6));
                emp.setDocumento(rs.getString(7));
                emp.setSexo(rs.getString(8));
                listaE.add(emp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }
        return listaE;
    }

    public void GuardarEmpleado(Empleado datos) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO EMPLEADO (NOMBRES,APELLIDOS,TELEFONO,DIRECCION,DOCUMENTO,SEXO, ID_USUARIO) VALUES(?,?,?,?,?,?,?)");
            pre.setString(1, datos.getNombres());
            pre.setString(2, datos.getApellidos());
            pre.setString(3, datos.getTelefono());
            pre.setString(4, datos.getDireccion());
            pre.setString(5, datos.getDocumento());
            pre.setString(6, datos.getSexo());
            pre.setInt(7, datos.getID_Us());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

   
    public void ModificarEmpleado(Empleado datos) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE EMPLEADO SET NOMBRES=?, APELLIDOS=?, TELEFONO =?, DIRECCION=?, DOCUMENTO=?, SEXO=?, ID_USUARIO=? WHERE ID_EMPLEADO=?");
            pre.setString(1, datos.getNombres());
            pre.setString(2, datos.getApellidos());
            pre.setString(3, datos.getTelefono());
            pre.setString(4, datos.getDireccion());
            pre.setString(5, datos.getDocumento());
            pre.setString(6, datos.getSexo());
            pre.setInt(7, datos.getID_Us());
            pre.setInt(8, datos.getID());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
        public void EliminarEmpleado(Empleado datos) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM EMPLEADO WHERE ID_EMPLEADO=?");
            pre.setInt(1, datos.getID());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        
       
        
        
        
    
}
