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
public class MetodosBlog extends Conexion {

    public ArrayList<Home> MostraEmpleados() {

        ArrayList<Home> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT contador,nombres,ID_USUARIO FROM \n"
                    + "(SELECT A.NOMBRE_USUARIO as nombres, COUNT(F.ID_USUARIO) contador, F.ID_USUARIO\n"
                    + "FROM VENTA AS F\n"
                    + "INNER JOIN USUARIO AS A ON F.ID_USUARIO=A.ID_USUARIO \n"
                    + "GROUP BY F.ID_USUARIO) AS T ORDER BY contador desc Limit 3");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Home obj = new Home();
                obj.setCliente(rs.getInt(1));
                obj.setNombreCliente(rs.getString(2));
                obj.setUsuario(rs.getInt(3));

                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public ArrayList<Home> MostrarVehiculos() {

        ArrayList<Home> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT contador,ID_ESPECIFICACION, AUTOMOVIL,DESCRIPCION FROM\n"
                    + "(SELECT T.ID_ESPECIFICACION, COUNT(T.ID_ESPECIFICACION) contador, Y.DESCRIPCION, concat(MARCA,' ',Y.MODELO) AS AUTOMOVIL FROM AUTOMOVIL AS T  INNER JOIN ESPECIFICACIONES AS Y ON T.ID_ESPECIFICACION=Y.ID_ESPECIFICACION INNER JOIN MARCA AS S ON S.ID_MARCA=Y.ID_MARCA  INNER JOIN DETALLE_VENTA AS A ON T.CODIGO_MOTOR=A.CODIGO_MOTOR GROUP BY ID_ESPECIFICACION) AS T ORDER BY contador desc Limit 3;");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Home obj = new Home();
                obj.setCantidad(rs.getInt(1));
                obj.setEspecificacion(rs.getInt(2));
                obj.setCategoria(rs.getString(3));
                obj.setDescripcion(rs.getString(4));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public Home MostrarVehiculo(int especificacion) {

        Home obj = new Home();
        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT A.DESCRIPCION,B.PRECIO FROM ESPECIFICACIONES AS A INNER JOIN AUTOMOVIL AS B ON A.ID_ESPECIFICACION=B.ID_ESPECIFICACION WHERE A.ID_ESPECIFICACION=" + "'" + especificacion + "'" + "GROUP BY B.PRECIO ASC");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                obj.setDescripcion(rs.getString(1));
                obj.setPrecio(rs.getDouble(2));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return obj;
    }

    public ArrayList<Automovil> MostrarVersion(int especificacion) {

        ArrayList<Automovil> lista = new ArrayList<Automovil>();
        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT  DISTINCT CONCAT(C.MARCA,' ',B.MODELO)AS AUTOMOVIL, A.VERSION FROM AUTOMOVIL AS A  INNER JOIN  ESPECIFICACIONES AS B ON A.ID_ESPECIFICACION=B.ID_ESPECIFICACION INNER JOIN MARCA AS C ON B.ID_MARCA=C.ID_MARCA WHERE A.ID_ESPECIFICACION=" + especificacion + " GROUP BY  A.VERSION");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Automovil obj = new Automovil();
                obj.setModelo(rs.getString(1));
                obj.setVersion(rs.getString(2));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public ArrayList<Automovil> MostrarTransmision(String version, int especificacion) {
        ArrayList<Automovil> lista = new ArrayList<Automovil>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT  DISTINCT  A.TRANSMISION FROM AUTOMOVIL AS A  INNER JOIN  ESPECIFICACIONES AS B ON A.ID_ESPECIFICACION=B.ID_ESPECIFICACION INNER JOIN MARCA AS C ON B.ID_MARCA=C.ID_MARCA WHERE A.VERSION=" + "'" + version + "'" + " AND A.ID_ESPECIFICACION=" + "'" + especificacion + "'" + "");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Automovil obj = new Automovil();
                obj.setTransmision(rs.getString(1));
                lista.add(obj);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public ArrayList<Automovil> MostrarColor(String version, int especificacion) {
        
        ArrayList<Automovil> lista = new ArrayList<Automovil>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT D.COLOR FROM AUTOMOVIL AS A  INNER JOIN  ESPECIFICACIONES AS B ON A.ID_ESPECIFICACION=B.ID_ESPECIFICACION  INNER JOIN COLOR AS D ON D.ID_COLOR=A.ID_COLOR WHERE VERSION=" + "'" + version + "'" + "  AND A.ID_ESPECIFICACION=" + "'" + especificacion + "'" + " ");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Automovil obj = new Automovil();
                obj.setEstado(rs.getString(1));
                lista.add(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public ArrayList<Comentarios> MostrarComentarios(int especificacion) {

        ArrayList<Comentarios> lista = new ArrayList<Comentarios>();
        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT A.ID_USUARIO,B.NOMBRE_USUARIO,A.COMENTARIO FROM COMENTARIO AS A INNER JOIN USUARIO AS B ON A.ID_USUARIO = B.ID_USUARIO WHERE A.ID_ESPECIFICACION=" + especificacion);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Comentarios obj = new Comentarios();
                obj.setId_usuario(rs.getInt(1));
                obj.setNombre_usuario(rs.getString(2));
                obj.setComentario(rs.getString(3));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }

    public void guardarcomentario(Comentarios datos) {

        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO COMENTARIO(ID_USUARIO,ID_ESPECIFICACION,COMENTARIO)VALUES(?,?,?)");
            pre.setInt(1, datos.getId_usuario());
            pre.setInt(2, datos.getEspecificacion());
            pre.setString(3, datos.getComentario());
            pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
