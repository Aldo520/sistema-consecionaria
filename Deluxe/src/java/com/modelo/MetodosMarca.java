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
public class MetodosMarca extends Conexion {
    public ArrayList<Marca> MostrarRegistros() {
        ArrayList<Marca> lista = new ArrayList<>();
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("SELECT * FROM MARCA");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Marca obj = new Marca();
                obj.setRegistro(rs.getInt(1));
                obj.setMarca(rs.getString(2));
                lista.add(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }
        return lista;
    }

    public void GuardarMarca(Marca marca) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO MARCA (MARCA) VALUES(?)");
            pre.setString(1, marca.getMarca());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ModificarMarca(Marca marca) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE MARCA SET MARCA=? WHERE ID_MARCA=?");
            pre.setString(1, marca.getMarca());
            pre.setInt(2, marca.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void EliminarMarca(Marca marca) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM MARCA  WHERE ID_MARCA=?");
            pre.setInt(1, marca.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Marca MostrarMarca(int codigo) {
        Marca obj = new Marca();
        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT * FROM MARCA WHERE ID_MARCA=" + codigo);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                obj.setRegistro(rs.getInt(1));
                obj.setMarca(rs.getString(2));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return obj;
    }
}
