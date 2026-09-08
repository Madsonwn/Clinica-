import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class PacienteDAO {
    public void cadastrar(Paciente paciente){
        try {
            String sql = "INSERT INTO pacientes(pacientes_id,nome,email,telefone) VALUES(?, ?, ?, ?)";

            Connection conexao = Conexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1,paciente.getPacienteID());
            comando.setString(2,paciente.getNome());
            comando.setString(3, paciente.getEmail());
            comando.setString(4, paciente.getTelefone());

            comando.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
