/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_appproyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        
    }
    
}
