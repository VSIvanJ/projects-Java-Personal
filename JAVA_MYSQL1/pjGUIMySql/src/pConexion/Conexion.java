package pConexion;

// Importa la clase Connection para establecer la conexión con la base de datos
import java.sql.Connection;

// Importa DriverManager para obtener la conexión usando la URL, usuario y contraseña
import java.sql.DriverManager;

// Importa SQLException para capturar errores relacionados con SQL
import java.sql.SQLException;

public class Conexion {
    
    private static String bd;
    
    // Usuario de la base de datos
    private static String usuario;

    // Contraseña del usuario
    private static String clave;
    
    // URL de conexión a la base de datos MySQL (nombre de la base)
    private static String url;
    
    public static void guardarConexion(String bd, String usuario, String clave){
        Conexion.bd = bd;
        Conexion.usuario = usuario;
        Conexion.clave = clave;
        Conexion.url = String.format("jdbc:mysql://localhost:3306/%s", bd);
    }
    
    public static Connection conectarBD() throws SQLException{
        
        return DriverManager.getConnection(url,usuario,clave);            
        
    }
    
}