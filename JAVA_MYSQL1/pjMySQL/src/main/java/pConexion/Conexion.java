package pConexion;

// Importa la clase Connection para establecer la conexión con la base de datos
import java.sql.Connection;

// Importa DriverManager para obtener la conexión usando la URL, usuario y contraseña
import java.sql.DriverManager;

// Importa SQLException para capturar errores relacionados con SQL
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    // URL de conexión a la base de datos MySQL (nombre de la base)
    private static String url = "jdbc:mysql://localhost:3306/pruebadb";

    // Usuario de la base de datos (por defecto en XAMPP suele ser "root")
    private static String usuario = "root";

    // Contraseña del usuario (vacía si no has configurado una)
    private static String clave = "";
    
    public static Connection conectarBD(){
        
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(url,usuario,clave);
            JOptionPane.showMessageDialog(null, "Se conectó a la base de datos", "CONEXIÓN", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar conectar a la base de datos: "+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return conn;
        
    }
    
}