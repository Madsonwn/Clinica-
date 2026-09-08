import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica","clinica_user","1122");
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
