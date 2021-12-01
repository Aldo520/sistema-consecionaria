/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.conexion.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.websocket.Decoder.BinaryStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author Aldo
 */
public class MetodosEspecificaciones extends Conexion {

    public ArrayList<Especificaciones> MostrarRegistros() {

        ArrayList<Especificaciones> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT *  FROM ESPECIFICACIONES");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Especificaciones obj = new Especificaciones();
                obj.setRegistro(rs.getInt(1));
                obj.setCategoria(rs.getInt(2));
                obj.setMarca(rs.getInt(3));
                obj.setModelo(rs.getString(4));
                obj.setArchivoimg2(rs.getBytes(5));
                obj.setDescripcion(rs.getString(6));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public void GuardarEspecificaciones(Especificaciones datos) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO ESPECIFICACIONES (ID_CATEGORIA,ID_MARCA,MODELO,FOTO,DESCRIPCION) VALUES(?,?,?,?,?)");
            pre.setInt(1, datos.getCategoria());
            pre.setInt(2, datos.getMarca());
            pre.setString(3, datos.getModelo());
            pre.setBinaryStream(4, datos.getFoto());
            pre.setString(5, datos.getDescripcion());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ModificarEspecificaciones(Especificaciones datos) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE ESPECIFICACIONES SET ID_CATEGORIA=?, ID_MARCA=?, MODELO=?,FOTO=?, DESCRIPCION=? WHERE ID_ESPECIFICACION=?");
            pre.setInt(1, datos.getCategoria());
            pre.setInt(2, datos.getMarca());
            pre.setString(3, datos.getModelo());
            pre.setBinaryStream(4, datos.getFoto());
            pre.setString(5, datos.getDescripcion());
            pre.setInt(6, datos.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void Modificar(Especificaciones datos) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("UPDATE ESPECIFICACIONES SET ID_CATEGORIA=?, ID_MARCA=?, MODELO=?, DESCRIPCION=? WHERE ID_ESPECIFICACION=?");
            pre.setInt(1, datos.getCategoria());
            pre.setInt(2, datos.getMarca());
            pre.setString(3, datos.getModelo());
            pre.setString(4, datos.getDescripcion());
            pre.setInt(5, datos.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void EliminarEspecificaciones(Especificaciones especificacion) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM ESPECIFICACIONES WHERE ID_ESPECIFICACION=?");
            pre.setInt(1, especificacion.getRegistro());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Especificaciones MostrarCantidad(int codigo) {

        Especificaciones obj = new Especificaciones();
        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT COUNT(*) FROM AUTOMOVIL WHERE ESTADO='DISPONIBLE' AND ID_ESPECIFICACION=" + codigo);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                obj.setCantidad(rs.getInt(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return obj;
    }

    public Especificaciones MostrarEspecificacion(int codigo) {

        Especificaciones obj = new Especificaciones();
        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT  concat(A.MARCA,' ', B.MODELO) AS ESPECIFICACION FROM ESPECIFICACIONES B "
                    + "INNER JOIN MARCA A ON A.ID_MARCA=B.ID_MARCA WHERE B.ID_ESPECIFICACION=" + codigo);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                obj.setModelo(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return obj;
    }

    public ArrayList<Especificaciones> MarcaModelo() {

        ArrayList<Especificaciones> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT B.ID_ESPECIFICACION, concat(A.MARCA,' ', B.MODELO) AS ESPECIFICACION FROM ESPECIFICACIONES B"
                    + " INNER JOIN MARCA A ON A.ID_MARCA=B.ID_MARCA");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Especificaciones obj = new Especificaciones();
                obj.setRegistro(rs.getInt(1));
                obj.setModelo(rs.getString(2));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

}
