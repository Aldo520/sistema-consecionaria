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
public class MetodosCategoriaCliente extends Conexion{
    
    public void GuardarCategoriaCliente(CategoriaCliente datos) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO CATEGORIA_CLIENTE (CATEGORIA_CLIENTE) VALUES(?)");
            pre.setString(1, datos.getCatClie());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<CategoriaCliente> MostrarRegistros() {
        ArrayList<CategoriaCliente> lista = new ArrayList<>();
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("SELECT * FROM CATEGORIA_CLIENTE");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CategoriaCliente catCli = new CategoriaCliente();
                catCli.setCodigoCatCli(rs.getInt(1));
                catCli.setCatClie(rs.getString(2));
                lista.add(catCli);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }
        return lista;
    }
    
    public void ModificarCategoriaCliente(CategoriaCliente categoria) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE CATEGORIA_CLIENTE SET CATEGORIA_CLIENTE=? WHERE ID_CATEGORIA_CLIENTE=?");
            pre.setString(1, categoria.getCatClie());
            pre.setInt(2, categoria.getCodigoCatCli());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void EliminarCategoriaCliente(CategoriaCliente categoria) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM CATEGORIA_CLIENTE  WHERE ID_CATEGORIA_CLIENTE=?");
            pre.setInt(1, categoria.getCodigoCatCli());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
