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
public class MetodosHome extends Conexion {

    public ArrayList<Home> MostraCategorias() {

        ArrayList<Home> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT contador,CATEGORIA FROM\n"
                    + "(SELECT CATEGORIA, COUNT(F.ID_CATEGORIA) contador FROM CATEGORIA AS F INNER JOIN ESPECIFICACIONES AS G  ON  F.ID_CATEGORIA=G.ID_CATEGORIA  INNER JOIN AUTOMOVIL AS T ON T.ID_ESPECIFICACION=G.ID_ESPECIFICACION  INNER JOIN DETALLE_VENTA AS A ON T.CODIGO_MOTOR=A.CODIGO_MOTOR GROUP BY CATEGORIA) AS T ORDER BY contador desc Limit 3");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Home obj = new Home();
                obj.setCantidad(rs.getInt(1));
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

    public Home MostraClientes() {

        Home obj = new Home();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT COUNT(*)AS CLIENTES FROM CLIENTE;");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                obj.setCliente(rs.getInt(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return obj;
    }

    public Home MostraEmpleados() {

        Home obj = new Home();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT COUNT(*)AS EMPLEADOS FROM EMPLEADO;");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                obj.setEmpleados(rs.getInt(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return obj;
    }

    public Home MostraAutomovil() {

        Home obj = new Home();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT COUNT(*)AS AUTOMOVIL FROM AUTOMOVIL WHERE ESTADO='DISPONIBLE'");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                obj.setAutomovil(rs.getInt(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return obj;
    }

    public Home AutomovildelMes() {

        Home obj = new Home();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT contador,ID_ESPECIFICACION,DESCRIPCION FROM\n"
                    + "(SELECT T.ID_ESPECIFICACION, COUNT(T.ID_ESPECIFICACION) contador, Y.DESCRIPCION FROM AUTOMOVIL AS T INNER JOIN ESPECIFICACIONES AS Y ON T.ID_ESPECIFICACION=Y.ID_ESPECIFICACION  INNER JOIN DETALLE_VENTA AS A ON T.CODIGO_MOTOR=A.CODIGO_MOTOR GROUP BY ID_ESPECIFICACION) AS T ORDER BY contador desc Limit 1");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                obj.setVentas(rs.getInt(1));
                obj.setEspecificacion(rs.getInt(2));
                obj.setDescripcion(rs.getString(3));

            }

        } catch (Exception e) {
            
        } finally {
            this.Desconectar();
        }

        return obj;
    }

}
