/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_appproyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Karina
 */

//Métodos CRUD, aquí es donde se darán las instrucciones SQL

public class MensajesDAO {
    
    public static void crearMensajesDB(Mensajes mensaje){
        //Crear conexión a la DB
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            
            try{
               String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)"; 
               ps = conexion.prepareStatement(query);
               //Estos datos vendrán de la capa MensajesService.java
               ps.setString(1, mensaje.getMensaje());
               ps.setString(2, mensaje.getAutor_mensaje());
               ps.executeUpdate();
                System.out.println("Mensaje Creado");
            }catch(SQLException e){
                System.out.println(e);
            }         
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
        //Crear conexión a la DB
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            try{
               String query = "SELECT * FROM mensajes"; 
               ps = conexion.prepareStatement(query);
               rs = ps.executeQuery();
              
               while(rs.next()){
                   System.out.println("ID: " + rs.getInt("ID_MENSAJE"));
                   System.out.println("Mensaje: " + rs.getString("MENSAJE"));
                   System.out.println("Autor: " + rs.getString("AUTOR_MENSAJE"));
                   System.out.println("Fecha: " + rs.getString("FECHA_MENSAJE"));
               }
            }catch(SQLException e){
                System.out.println("No se pudieron recuperar los mensajes");
                System.out.println(e);
            }         
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        //Crear conexión a la DB
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            
            try{
               String query = "DELETE FROM mensajes WHERE ID_MENSAJE = ?"; 
               ps = conexion.prepareStatement(query);
               //Estos datos vendrán de la capa MensajesService.java
               ps.setInt(1, id_mensaje);
               ps.executeUpdate();
                System.out.println("Mensaje borrado");
            }catch(SQLException e){
                System.out.println(e);
                System.out.println("No se pudo borrar el mensaje");
            }         
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        
         //Crear conexión a la DB
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            
            try{
               String query = "UPDATE mensajes SET MENSAJE=? WHERE ID_MENSAJE= ? "; 
               ps = conexion.prepareStatement(query);
               //Estos datos vendrán de la capa MensajesService.java
               ps.setString(1, mensaje.getMensaje());
               ps.setInt(2, mensaje.getId_mensaje());
               ps.executeUpdate();
                System.out.println("Mensaje actualizado");
            }catch(SQLException e){
                System.out.println(e);
                System.out.println("No se pudo actualizar el mensaje");
            }         
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
    }
    
}
