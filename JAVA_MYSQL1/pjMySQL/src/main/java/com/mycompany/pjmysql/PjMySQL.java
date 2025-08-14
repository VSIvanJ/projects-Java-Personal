package com.mycompany.pjmysql;
/*
Importa PreparedStatement para ejecutar consultas SQL con parámetros
import java.sql.PreparedStatement;

Importa ResultSet para manejar los resultados de una consulta SELECT
import java.sql.ResultSet;
*/

import java.sql.Connection;
import pUsuario.UsuarioDAO;
import pConexion.Conexion;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PjMySQL {

    public static void main(String[] args) {
        
        Conexion c = new Conexion();
        UsuarioDAO u = new UsuarioDAO();
        Scanner s = new Scanner(System.in);
        
        c.conectarBD();
        
        System.out.println("Bienvenido. Por favor ingrese los nombres para subirlos a la base de datos\n");
        System.out.println("Ingrese nombre: ");
        String nombre = s.next();

        if(!nombre.isEmpty()){
            u.registrarUsuario(nombre);
            JOptionPane.showMessageDialog(null, "Se agregó el nombre "+ nombre+" a la base de datos correctamente","REGISTRO",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre, no puede estar vacío","ERROR",JOptionPane.ERROR_MESSAGE);
        }
               
    }
}