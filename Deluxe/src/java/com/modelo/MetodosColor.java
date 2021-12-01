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
public class MetodosColor extends Conexion {

    public ArrayList<Color> MostrarRegistros() {

        ArrayList<Color> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT * FROM COLOR");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Color obj = new Color();
                obj.setRegistro(rs.getInt(1));
                obj.setColor(rs.getString(2));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public void GuardarColor(Color color) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO COLOR (COLOR) VALUES(?)");
            pre.setString(1, color.getColor());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ModificarColor(Color color) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE COLOR SET COLOR=? WHERE ID_COLOR=?");
            pre.setString(1, color.getColor());
            pre.setInt(2, color.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void EliminarColor(Color color) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM COLOR  WHERE ID_COLOR=?");
            pre.setInt(1, color.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Color MostrarColor(int codigo) {

        Color obj = new Color();
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("SELECT * FROM COLOR WHERE ID_COLOR="+codigo);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                obj.setRegistro(rs.getInt(1));
                obj.setColor(rs.getString(2));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return obj;
    }
}
