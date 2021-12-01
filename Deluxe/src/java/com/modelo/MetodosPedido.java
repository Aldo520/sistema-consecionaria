/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aldo
 */
public class MetodosPedido extends Conexion {

    public ArrayList<Automovil> MostrarRegistros(String codigo) {

        ArrayList<Automovil> lista = new ArrayList<>();

        this.Conectar();
        try {

            PreparedStatement pre = this.getConexion().prepareStatement("SELECT concat(B.MARCA,' ',A.MODELO)AS MODELO, C.TRANSMISION, C.VERSION,C.ID_ESPECIFICACION FROM ESPECIFICACIONES A \n"
                    + "INNER JOIN MARCA B ON A.ID_MARCA=B.ID_MARCA\n"
                    + "INNER JOIN AUTOMOVIL C ON A.ID_ESPECIFICACION=C.ID_ESPECIFICACION WHERE C.CODIGO_MOTOR="+"'"+codigo+"'");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Automovil obj = new Automovil();
                obj.setModelo(rs.getString(1));
                obj.setTransmision(rs.getString(2));
                obj.setVersion(rs.getString(3));
                obj.setEspecificacion(rs.getInt(4));
                lista.add(obj);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            this.Desconectar();
        }

        return lista;
    }
    
    
     public int Guardar(Pedidos datos) {
        this.Conectar();
        int registro=0;
        int resultado;
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO VENTA(ID_CLIENTE,ID_USUARIO,FECHA)VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1, datos.getCliente());
            pre.setInt(2, datos.getEmpleado());
            pre.setString(3, datos.getFecha());
            resultado=pre.executeUpdate();
           if(resultado==0){
               throw new SQLException("No se pudo guardar");
           }
           ResultSet rs = pre.getGeneratedKeys();
           if(rs.next()){
               registro = rs.getInt(1);
               
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return registro;
    }
     
     
     public void GuardarDetalle(Pedidos datos) {
        this.Conectar();
        try {
            PreparedStatement pre = this.getConexion().prepareStatement("INSERT INTO DETALLE_VENTA(ID_VENTA,CODIGO_MOTOR,PRECIO)VALUES(?,?,?)");
            pre.setInt(1, datos.getVenta());
            pre.setString(2, datos.getMotor());
            pre.setDouble(3, datos.getTotal());
            pre.executeUpdate();
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
     }
}
