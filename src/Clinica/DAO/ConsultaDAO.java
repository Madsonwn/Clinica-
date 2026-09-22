package Clinica.DAO;

import Clinica.Conexao;
import Clinica.model.Consulta;
import java.sql.ResultSet;
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
    public void  buscarConsultas(int id) {
        String sql = "SELECT consultas.consultas_id, consultas.data, pacientes.nome AS nome_paciente, psicologos.nome AS nome_psicologo " +
                "FROM consultas " +
                "JOIN pacientes ON consultas.pacientes_id = pacientes.pacientes_id " +
                "JOIN psicologos ON consultas.psicologos_id = psicologos.psicologos_id " +
                "WHERE consultas_id = ?";
        try (Connection conexao = Conexao.conectar()) {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                int idConsulta = rs.getInt("consultas_id");
                String data = rs.getString("data");
                String nomePc = rs.getString("nome_paciente");
                String nomePs = rs.getString("nome_psicologo");

                System.out.println("Numero da consulta:" + id +
                        "Data: " + data +
                        "Nome do paciente: " + nomePc +
                        "Nome do Psicologo: " + nomePs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM consultas WHERE consultas_id = ?";
        try(Connection conexao = Conexao.conectar()){
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1,id);
            comando.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}