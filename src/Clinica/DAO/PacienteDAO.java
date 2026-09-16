package Clinica.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Clinica.Conexao;
import Clinica.model.Paciente;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PacienteDAO {


    public void cadastrar(Paciente paciente) {
        try {
            String sql = "INSERT INTO pacientes(pacientes_id,nome,email,telefone) VALUES(?, ?, ?, ?)";
            Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, paciente.getPacienteID());
            comando.setString(2, paciente.getNome());
            comando.setString(3, paciente.getEmail());
            comando.setString(4, paciente.getTelefone());
            comando.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Paciente> listarTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        try (Connection conexao = Conexao.conectar()) {
            String sql = "SELECT * FROM pacientes";
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("pacientes_id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                System.out.println(id + " - " + nome + " - " + email + " - " + telefone);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pacientes;
    }
}
