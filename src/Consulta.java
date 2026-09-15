public class Consulta {
        private int consultaID;
        private String data;
        private Paciente paciente;
        private Psicologo psicologo;

        public Consulta(int consultaID,String data,Paciente paciente, Psicologo psicologo){
            this.consultaID = consultaID;
            this.data = data;
            this.paciente = paciente;
            this.psicologo = psicologo;
        }

        public void setConsultaID(int consultaID) {
            this.consultaID = consultaID;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setPaciente(Paciente paciente) {
            this.paciente = paciente;
        }

        public void setPsicologo(Psicologo psicologo) {
            this.psicologo = psicologo;
        }

        public int getConsultaID() {
            return consultaID;
        }

        public String getData() {
            return data;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public Psicologo getPsicologo() {
            return psicologo;
        }
}

