public class Psicologo {
        private int psicologoID;
        private String nome;
        private String crp;

        public Psicologo(int psicologoID, String nome, String crp) {
            this.psicologoID = psicologoID;
            this.nome = nome;
            this.crp = crp;
        }
        public void setPsicologoID(int psicologoID){
            this.psicologoID = psicologoID;
        }
        public void setNome(String nome){
            this.nome = nome;
        }
        public void setCrp(String crp){
            this.crp = crp;
        }
        public int getPsicologoID(){
            return psicologoID;
        }
        public String getNome(){
            return nome;
        }
        public String getCrp(){
            return crp;
        }
        @Override
        public String toString() {
            return "Id: " + getPsicologoID() + " | Nome do psicólogo: " + getNome() + " | CRP: " + getCrp();
        }

}
