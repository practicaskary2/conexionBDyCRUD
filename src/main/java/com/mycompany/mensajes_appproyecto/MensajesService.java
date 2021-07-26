/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_appproyecto;

import java.util.Scanner;

/**
 *
 * @author Karina
 */
public class MensajesService {
    
    public static void crearMensaje(){
        //Esta información se le pasará a la capa MensajesDAO.java para que ejecute las sentencias SQL
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe tu mensaje:");
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe nombre del autor:");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        
        //Pasar la información a la capa MensajesDAO
        MensajesDAO.crearMensajesDB(registro);
        
    }
    
    public static void leerMensajes(){
        //Pasar la información a la capa MensajesDAO
        MensajesDAO.leerMensajesDB();
        
    }
    
    public static void borrarMensaje(){
        
        //Esta información se le pasará a la capa MensajesDAO.java para que ejecute las sentencias SQL
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe el número de ID del mensaje a eliminar:");
        int id_numero = sc.nextInt();
           
        Mensajes registro = new Mensajes();      
        //Pasar la información a la capa MensajesDAO
        MensajesDAO.borrarMensajeDB(id_numero);
        
    }
    
    public static void editarMensaje(){
        
        //Esta información se le pasará a la capa MensajesDAO.java para que ejecute las sentencias SQL
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe tu nuevo mensaje:");
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe el número de ID del mensaje que quieres actualizar: ");
        int id_numero = sc.nextInt();
         
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id_numero);
        actualizacion.setMensaje(mensaje);
        
        //Pasar la información a la capa MensajesDAO
        MensajesDAO.actualizarMensajeDB(actualizacion);
        
    }
    
}
