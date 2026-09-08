import java.sql.Connection;

public class Main{
    public static void main(String[]args){

        Connection conexao = Conexao.conectar();
        if(conexao != null){
            System.out.println("Conectado!");
        }else{
            System.out.println("Não conectado");
        }

        PacienteDAO inserir = new PacienteDAO();
        Paciente paciente1 = new Paciente(1,"Josival","Josival@gmail.com", "1234567");

        inserir.cadastrar(paciente1);
    }
}