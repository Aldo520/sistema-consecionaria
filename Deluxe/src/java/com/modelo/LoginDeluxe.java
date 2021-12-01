/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author Jonathan Alvarado
 */
public class LoginDeluxe extends Conexion{
    
    public Usuario validarLogin(String usuario, String password){
         Usuario obj = new Usuario();
        try {
            this.Conectar();
            String sql = "SELECT  TIPO_USUARIO, ID_USUARIO FROM USUARIO WHERE NOMBRE_USUARIO=? AND CONTRASEÑA= AES_ENCRYPT('"+password+ "', 'DELUXE')";
            PreparedStatement pre = this.getConexion().prepareStatement(sql);
            pre.setString(1, usuario);
            ResultSet rs;
            rs = pre.executeQuery();
            while(rs.next()){         
                obj.setTipo_usuario(rs.getString(1));
                obj.setId(rs.getInt(2));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally{
            this.Desconectar();
        }
        return obj;
    }
   
}
