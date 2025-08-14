package pUsuario;

import pConexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class UsuarioDAO{
    
    public void registrarUsuario(String nombre){
        String sql = "INSERT INTO USUARIO (nombre) VALUES (?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        
        //Establecer conexion a db || Preparar la consulta SQL
        try{
            conn = Conexion.conectarBD();
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nombre); //Asignará el valor de nombre a la db
            stmt.executeUpdate(); // Ejecutará la consulta de agregar
            JOptionPane.showMessageDialog(null,"Se agregó correctamente a "+nombre,"REGISTRO",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al registrar: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        } finally {
            
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al intentar cerrar consulta SQL"+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión a la BD"+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            
        }
        
    }
    
    public void consultarUsuario(String nombre){
        String sql = "SELECT * FROM USUARIO WHERE nombre = ?";
        
        
        try (Connection conn = Conexion.conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, nombre);
            
            try (ResultSet rs = stmt.executeQuery()) {
                
                if(rs.next()){ //Si encuentra
                    int id = rs.getInt("id");
                    String nom = rs.getString("nombre");
                    JOptionPane.showMessageDialog(null, "Usuario Encontrado\nID: "+id+"\nNombre: "+nom);
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario "+nombre+" no existe en la base de datos","ERROR",JOptionPane.WARNING_MESSAGE);
                }
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, "Error al consultar"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                            
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }
    
    //List<Object[]> para reutilizarlo más adelante
    public List<Object[]> listaUsuarios() throws SQLException{
        String sql="SELECT * FROM USUARIO";
        List<Object[]> lista = new ArrayList<>();
        
        try (Connection conn = Conexion.conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
                            
            while(rs.next()) { //Si encuentra se almacena en un Object
                Object[] fila = {
                    rs.getInt("id"),
                    rs.getString("nombre")
                };
                //Agregar al arraylist
                lista.add(fila);
            }              
           
        } catch (SQLException e) {
            System.out.println("Error al intentar inciar la conexion o consultar:\n" + e.getMessage());
        }
        
        return lista;
        
    }
    
    public void actualizarUsuario(int id,String nombre){
        
    }
    
    public void eliminarUsuario(int id,String nombre){
        
    }
    
    
    
}