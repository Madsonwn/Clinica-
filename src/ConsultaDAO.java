import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO {

    public void cadastrar(Consulta consulta) {

        try {

            String sql = "INSERT INTO consultas(consultas_id, data, pacientes_id, psicologos_id) VALUES (?, ?, ?, ?)";

            Connection conexao = Conexao.conectar();

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, consulta.getConsultaID());
            comando.setString(2, consulta.getData());
            comando.setInt(3, consulta.getPaciente().getPacienteID());
            comando.setInt(4, consulta.getPsicologo().getPsicologoID());
            comando.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }
}