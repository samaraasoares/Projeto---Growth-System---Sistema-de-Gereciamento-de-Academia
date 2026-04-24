public class Funcionario extends Pessoa {
    private String departamento;

    public Funcionario(int id, String nome, String cpf, String departamento) {
        super(id, nome, cpf);
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + " | Depto: " + departamento + " [FUNCIONÁRIO]";
    }
}