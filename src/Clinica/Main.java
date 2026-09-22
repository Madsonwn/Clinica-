package Clinica;

import Clinica.DAO.PacienteDAO;
import Clinica.DAO.PsicologoDAO;
import Clinica.model.Paciente;
import Clinica.model.Psicologo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
        Paciente paciente2 = new Paciente(2,"Ivanilde","Ivanilde@gmail.com","453535");
        inserir.cadastrar(paciente1);
        inserir.cadastrar(paciente2);
        List<Paciente> resultado = inserir.listarTodos();
        System.out.println(resultado);

        PsicologoDAO inserirPs = new PsicologoDAO();
        Psicologo psicologo1 = new Psicologo(1,"Dra.Geovanna","980107");
        Psicologo psicologo2 = new Psicologo(2,"Dra.Amanda","123456");
        inserirPs.cadastrar(psicologo1);
        inserirPs.cadastrar(psicologo2);
        inserirPs.excluir(2);
        List<Psicologo> resultadoPs = inserirPs.listaDePsicologos();
        System.out.println(resultadoPs);


    }
}