package Clinica.DAO;

import Clinica.Conexao;
import Clinica.model.Psicologo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
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
        public List<Psicologo> listaDePsicologos() {
           List<Psicologo> psicologos = new ArrayList<>();
           try(Connection conexao = Conexao.conectar()) {
              String sql = "SELECT * FROM psicologos";
              PreparedStatement comando = conexao.prepareStatement(sql);
              ResultSet rs = comando.executeQuery();
              while (rs.next()){
                 int id = rs.getInt("psicologos_Id");
                 String nome = rs.getString("nome");
                 String crp = rs.getString("crp");
                 System.out.println(nome + " - " + crp + " - ");
                 Psicologo psicologo = new Psicologo(id, nome, crp);
                 psicologos.add(psicologo);
              }
          }catch (SQLException e){
              System.out.println(e.getMessage());
          }
          return psicologos;
        }
        public void excluir(int id){
            String sql = "DELETE FROM psicologos WHERE psicologos_id = ?";
            try(Connection conexao = Conexao.conectar()){
                PreparedStatement comando = conexao.prepareStatement(sql);
                comando.setInt(1,id);
                comando.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
}
