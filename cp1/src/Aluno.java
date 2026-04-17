<<<<<<< HEAD
public class Aluno {

    private int id;
    private String nome;
    private String cpf;
    private String statusPlano;

    public Aluno(int id, String nome, String cpf) {
        setId(id); 

        setNome(nome);
        setCpf(cpf);
        this.statusPlano = "Ativo"; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero!");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio!");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos!");
        }
        this.cpf = cpf;
    }

    public String getStatusPlano() {
        return statusPlano;
    }

    public void setStatusPlano(String statusPlano) {
        this.statusPlano = statusPlano;
    }

    @Override
    public String toString() {
        return String.format("Aluno [ID=%d, Nome=%s, CPF=%s, Status=%s]", 
                id, nome, cpf, statusPlano);
    }
=======
public class Aluno {

    private int id;
    private String nome;
    private String cpf;
    private String statusPlano;

    public Aluno(int id, String nome, String cpf) {
        setId(id); 

        setNome(nome);
        setCpf(cpf);
        this.statusPlano = "Ativo"; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero!");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio!");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos!");
        }
        this.cpf = cpf;
    }

    public String getStatusPlano() {
        return statusPlano;
    }

    public void setStatusPlano(String statusPlano) {
        this.statusPlano = statusPlano;
    }

    @Override
    public String toString() {
        return String.format("Aluno [ID=%d, Nome=%s, CPF=%s, Status=%s]", 
                id, nome, cpf, statusPlano);
    }
>>>>>>> 02e9cd8af30fc56ae23947483ebf0245215e4fc3
}