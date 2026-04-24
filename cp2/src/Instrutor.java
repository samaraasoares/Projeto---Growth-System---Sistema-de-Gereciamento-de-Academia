    public class Instrutor extends Pessoa {
        private String especialidade;

        public Instrutor(int id, String nome, String cpf, String especialidade) {
            super(id, nome, cpf);
            setEspecialidade(especialidade);
        }

        public void setEspecialidade(String especialidade) {
            if (especialidade == null || especialidade.trim().isEmpty()) 
                throw new IllegalArgumentException("Especialidade obrigatória.");
            this.especialidade = especialidade;
        }

        @Override
        public String toString() {
            return super.toString() + " | Especialidade: " + especialidade + " [INSTRUTOR]";
        }
    }