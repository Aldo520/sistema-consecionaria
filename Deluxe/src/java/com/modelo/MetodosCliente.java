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
public class MetodosCliente extends Conexion {

    public void GuardarCliente(Cliente datos) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO CLIENTE (NOMBRES,APELLIDOS,TELEFONO,DIRECCION,DOCUMENTO,SEXO, ID_USUARIO, ID_CATEGORIA_CLIENTE) VALUES(?,?,?,?,?,?,?,?)");
            pre.setString(1, datos.getNombres());
            pre.setString(2, datos.getApellidos());
            pre.setString(3, datos.getTelefono());
            pre.setString(4, datos.getDireccion());
            pre.setString(5, datos.getDocumento());
            pre.setString(6, datos.getSexo());
            pre.setInt(7, datos.getID_Us());
            pre.setInt(8, datos.getID_Cat());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ArrayList<Cliente> MostrarCliente() {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement(
                    "SELECT CL.ID_CLIENTE, CL.NOMBRES, CL.APELLIDOS, A.NOMBRE_USUARIO,CL.TELEFONO, CL.DIRECCION, CL.DOCUMENTO, CL.SEXO, C.CATEGORIA_CLIENTE FROM CLIENTE CL INNER JOIN USUARIO A ON CL.ID_USUARIO = A.ID_USUARIO INNER JOIN CATEGORIA_CLIENTE C ON CL.ID_CATEGORIA_CLIENTE = C.ID_CATEGORIA_CLIENTE");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setID(rs.getInt(1));
                cli.setNombres(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setNombre_usuario(rs.getString(4));
                cli.setTelefono(rs.getString(5));
                cli.setDireccion(rs.getString(6));
                cli.setDocumento(rs.getString(7));
                cli.setSexo(rs.getString(8));
                cli.setCat_cliente(rs.getString(9));
                listaCliente.add(cli);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }
        return listaCliente;
    }

    public void ModificarCliente(Cliente datos) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE CLIENTE SET NOMBRES=?, APELLIDOS=?, TELEFONO =?, DIRECCION=?, DOCUMENTO=?, SEXO=?, ID_USUARIO=?, ID_CATEGORIA_CLIENTE=? WHERE ID_CLIENTE=?");
            pre.setString(1, datos.getNombres());
            pre.setString(2, datos.getApellidos());
            pre.setString(3, datos.getTelefono());
            pre.setString(4, datos.getDireccion());
            pre.setString(5, datos.getDocumento());
            pre.setString(6, datos.getSexo());
            pre.setInt(7, datos.getID_Us());
            pre.setInt(8, datos.getID_Cat());
            pre.setInt(9, datos.getID());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int EliminarCliente(Cliente datos) {
        int respuesta=0;
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM CLIENTE  WHERE ID_CLIENTE=?");
            pre.setInt(1, datos.getID());
            respuesta=pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

}
