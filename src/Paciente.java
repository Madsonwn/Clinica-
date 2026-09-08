public class Paciente {
    private int  pacienteID;
    private String nome;
    private String email;
    private String telefone;

    public Paciente(int pacienteID,String nome, String email, String telefone){
        this.pacienteID = pacienteID;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void setPacienteID(int pacienteID){
        this.pacienteID = pacienteID;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public int getPacienteID(){
        return pacienteID;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public String getTelefone(){
        return telefone;
    }
    @Override
    public String toString(){
        return "Id: "+getPacienteID() + " | " + "Nome do paciente: " + getNome() + " | " + "Email: " + getEmail() + " | " + "telefone: " + getTelefone();
    }
}
