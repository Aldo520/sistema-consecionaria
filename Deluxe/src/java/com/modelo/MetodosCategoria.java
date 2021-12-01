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
public class MetodosCategoria extends Conexion {

    public ArrayList<Categoria> MostrarRegistros() {

        ArrayList<Categoria> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT * FROM CATEGORIA");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Categoria obj = new Categoria();
                obj.setRegistro(rs.getInt(1));
                obj.setCategoria(rs.getString(2));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public void GuardarCategoria(Categoria categoria) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO CATEGORIA (CATEGORIA) VALUES(?)");
            pre.setString(1, categoria.getCategoria());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ModificarCategoria(Categoria categoria) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE CATEGORIA SET CATEGORIA=? WHERE ID_CATEGORIA=?");
            pre.setString(1, categoria.getCategoria());
            pre.setInt(2, categoria.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void EliminarCategoria(Categoria categoria) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM CATEGORIA  WHERE ID_CATEGORIA=?");
            pre.setInt(1, categoria.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Categoria MostrarCategoria(int categoria) {

        Categoria obj = new Categoria();
        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT * FROM CATEGORIA WHERE ID_CATEGORIA="+categoria);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                obj.setRegistro(rs.getInt(1));
                obj.setCategoria(rs.getString(2));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }
        return obj;
    }

}
