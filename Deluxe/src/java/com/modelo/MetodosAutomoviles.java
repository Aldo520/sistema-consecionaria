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
 * @author Aldo
 */
public class MetodosAutomoviles extends Conexion {
    
    
    public ArrayList<Automovil> MostrarRegistros() {

        ArrayList<Automovil> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT *  FROM AUTOMOVIL WHERE ESTADO='DISPONIBLE'");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Automovil obj = new Automovil();
                obj.setCodigo_Motor(rs.getString(1));
                obj.setEspecificacion(rs.getInt(2));
                obj.setColor(rs.getInt(3));
                obj.setVersion(rs.getString(4));
                obj.setTransmision(rs.getString(5));
                obj.setPrecio(rs.getDouble(6));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }
 

    public void GuardarAutomovil(Automovil datos) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO AUTOMOVIL (CODIGO_MOTOR,ID_ESPECIFICACION,ID_COLOR,VERSION,TRANSMISION,PRECIO,ESTADO) VALUES(?,?,?,?,?,?,?)");
            pre.setString(1, datos.getCodigo_Motor());
            pre.setInt(2, datos.getEspecificacion());
            pre.setInt(3, datos.getColor());
            pre.setString(4, datos.getVersion());
            pre.setString(5, datos.getTransmision());
            pre.setDouble(6, datos.getPrecio());
            pre.setString(7, datos.getEstado());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ModificarAutomovil(Automovil datos) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE AUTOMOVIL SET ID_ESPECIFICACION=?,ID_COLOR=?,VERSION=?,TRANSMISION=?,PRECIO=? WHERE CODIGO_MOTOR=?");
            pre.setInt(1, datos.getEspecificacion());
            pre.setInt(2, datos.getColor());
            pre.setString(3, datos.getVersion());
            pre.setString(4, datos.getTransmision());
            pre.setDouble(5, datos.getPrecio());
            pre.setString(6, datos.getCodigo_Motor());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
     

        public void EliminarAutomovil(Automovil datos) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM AUTOMOVIL WHERE CODIGO_MOTOR=?");
            pre.setString(1, datos.getCodigo_Motor());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
