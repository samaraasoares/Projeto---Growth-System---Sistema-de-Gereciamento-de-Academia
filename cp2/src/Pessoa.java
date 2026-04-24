public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String cpf;

    public Pessoa(int id, String nome, String cpf) {
        setId(id);
        setNome(nome);
        setCpf(cpf);
    }


    public void exibirInfo() {
        System.out.println(this.toString());
    }

    public void exibirInfo(String mensagemAdicional) {
        System.out.println(mensagemAdicional + " " + this.toString());
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID deve ser positivo!");
        this.id = id;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome inválido!");
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) throw new IllegalArgumentException("CPF deve ter 11 dígitos!");
        this.cpf = cpf;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }

    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | CPF: %s", id, nome, cpf);
    }
}