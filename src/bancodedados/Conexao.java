package bancodedados;

import com.sun.jdi.connect.spi.Connection;

public class Conexao {
    private static Connection con;
    
    public static Connection getConnection(){      
        return con;        
    }
}