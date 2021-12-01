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
public class MetodosUsuario extends Conexion {

    public ArrayList<Usuario> MostrarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("SELECT * FROM USUARIO WHERE ESTADO_USUARIO = 'ASIGNADO' OR ESTADO_USUARIO = 'NO ASIGNADO' ");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getInt(1));
                user.setNombre_usuario(rs.getString(2));
                user.setCorreo(rs.getString(3));
                user.setContrasenia(rs.getString(4));
                user.setTipo_usuario(rs.getString(5));
                user.setEstado_usuario(rs.getString(6));
                user.setFoto_perfil(rs.getBytes(7));
                lista.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }
        return lista;
    }

    public int GuardarUsuario(Usuario datos) {

        int retorno = 0;
        this.Conectar();
        try {
            String Estado = "NO ASIGNADO";
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO USUARIO (NOMBRE_USUARIO,CORREO_ELECTRONICO, CONTRASEÑA,TIPO_USUARIO,ESTADO_USUARIO,FOTO) VALUES(?,?,AES_ENCRYPT('" + datos.getContrasenia() + "','DELUXE'),?,?,?)");
            pre.setString(1, datos.getNombre_usuario());
            pre.setString(2, datos.getCorreo());
            pre.setString(3, datos.getTipo_usuario());
            pre.setString(4, Estado);
            pre.setBinaryStream(5, datos.getFoto());
            retorno = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    public int ModificarUsuario(Usuario datos) {
        this.Conectar();
        int respuesta = 0;
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE USUARIO SET NOMBRE_USUARIO=?, CORREO_ELECTRONICO=?, TIPO_USUARIO =?, FOTO=? WHERE ID_USUARIO=?");
            pre.setString(1, datos.getNombre_usuario());
            pre.setString(2, datos.getCorreo());
            pre.setString(3, datos.getTipo_usuario());
            pre.setBinaryStream(4, datos.getFoto());
            pre.setInt(5, datos.getId());
            respuesta = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public int Modificar(Usuario datos) {
        this.Conectar();
        int retorno = 0;
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE USUARIO SET NOMBRE_USUARIO=?, CORREO_ELECTRONICO=?, TIPO_USUARIO=? WHERE ID_USUARIO=?");
            pre.setString(1, datos.getNombre_usuario());
            pre.setString(2, datos.getCorreo());
            pre.setString(3, datos.getTipo_usuario());
            pre.setInt(4, datos.getId());
            retorno = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    public int EliminarUsuario(Usuario datos) {
        this.Conectar();
        int retorno = 0;
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM USUARIO WHERE ID_USUARIO=?");
            pre.setInt(1, datos.getId());
            retorno = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    public ArrayList<Empleado> MostrarUsuarios(String dato) {
        ArrayList<Empleado> listaU = new ArrayList<>();
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("SELECT ID_USUARIO, NOMBRE_USUARIO FROM USUARIO WHERE " + dato);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setID_Us(rs.getInt(1));
                emp.setNombre_usuario(rs.getString(2));
                listaU.add(emp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }
        return listaU;
    }

}
