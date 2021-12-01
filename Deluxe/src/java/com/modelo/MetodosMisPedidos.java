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
public class MetodosMisPedidos extends Conexion {

    public ArrayList<Mispedidos> MostrarRegistros(int codigo) {

        ArrayList<Mispedidos> lista = new ArrayList<>();
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("SELECT D.ID_DETALLE, A.ID_VENTA, E.NOMBRES,concat(B.MARCA,'',C.MODELO) AS AUTOMOVIL, D.CODIGO_MOTOR,D.PRECIO,A.FECHA FROM VENTA A \n" +
"INNER JOIN DETALLE_VENTA AS D ON A.ID_VENTA =D.ID_VENTA\n" +
"INNER JOIN CLIENTE AS E ON A.ID_CLIENTE=E.ID_CLIENTE\n" +
"INNER JOIN AUTOMOVIL AS G ON G.CODIGO_MOTOR=D.CODIGO_MOTOR\n" +
"INNER JOIN ESPECIFICACIONES AS C ON C.ID_ESPECIFICACION=G.ID_ESPECIFICACION\n" +
"INNER JOIN MARCA AS B ON B.ID_MARCA=C.ID_MARCA WHERE A.ID_USUARIO="+ codigo + " ORDER BY ID_DETALLE DESC;");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Mispedidos obj = new Mispedidos();
                obj.setDetalle(rs.getInt(1));
                obj.setVenta(rs.getInt(2));
                obj.setNombrecliente(rs.getString(3));
                obj.setModelo(rs.getString(4));
                obj.setMotor(rs.getString(5));
                obj.setTotal(rs.getDouble(6));
                obj.setFecha(rs.getString(7));
              lista.add(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;

    }
    
    public void Eliminar(Mispedidos datos){
        
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("DELETE FROM DETALLE_VENTA WHERE ID_DETALLE=?");
            pre.setInt(1, datos.getDetalle());
            pre.executeUpdate();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
