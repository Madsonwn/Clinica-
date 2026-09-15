import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
public class PsicologoDAO {

        public void cadastrar(Psicologo psicologo) {
            try {
                String sql = "INSERT INTO psicologos(psicologos_id, nome, crp) VALUES(?, ?, ?)";

                Connection conexao = Conexao.conectar();
                PreparedStatement comando = conexao.prepareStatement(sql);
                comando.setInt(1,psicologo.getPsicologoID());
                comando.setString(2,psicologo.getNome());
                comando.setString(3,psicologo.getCrp());
                comando.executeUpdate();
            }catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}
