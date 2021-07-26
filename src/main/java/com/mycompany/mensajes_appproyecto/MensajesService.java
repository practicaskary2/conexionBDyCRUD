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
        
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe nombre del autor");
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
        
    }
    
    public static void editarMensaje(){
        
    }
    
}
