package pUsuario;

import pConexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO{
    
        public void registrarUsuario(String nombre){
        String sql = "INSERT INTO USUARIO (nombre) VALUES (?)";
        
        //Establecer conexion a db || Preparar la consulta SQL
        try{
            Connection conn = Conexion.conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nombre); //Asignará el valor de nombre a la db
            stmt.executeUpdate(); // Ejecutará la consulta de agregar
            System.out.println("Usuario agregado: " + nombre);
        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
        
    }
    
    public void consultarUsuario(String nombre){
        String sql = "SELECT * FROM USUARIO WHERE nombre = ?";
        try (Connection conn = Conexion.conectarBD(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }
    
    public void actualizarUsuario(int id,String nombre){
        
    }
    
    public void eliminarUsuario(int id,String nombre){
        
    }
    
    
    
}
