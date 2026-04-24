public class Aluno extends Pessoa {
    private String statusPlano;

    public Aluno(int id, String nome, String cpf) {
        super(id, nome, cpf); 
        this.statusPlano = "Ativo";
    }

    @Override
    public String toString() {

        return super.toString() + " | Status: " + statusPlano + " [ALUNO]";
    }
}