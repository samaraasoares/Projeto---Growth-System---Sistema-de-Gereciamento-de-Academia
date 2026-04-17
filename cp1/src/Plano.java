public class Plano {
    private int id;
    private String nome; // Ex: "Plano VIP", "Plano Básico"
    private double valor;
    private int duracaoMeses;

    public Plano(int id, String nome, double valor, int duracaoMeses) {
        setId(id);
        setNome(nome);
        setValor(valor);
        setDuracaoMeses(duracaoMeses);
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID do plano inválido.");
        this.id = id;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome do plano é obrigatório.");
        this.nome = nome;
    }

    public void setValor(double valor) {
        if (valor < 0) throw new IllegalArgumentException("Valor não pode ser negativo.");
        this.valor = valor;
    }

    public void setDuracaoMeses(int duracaoMeses) {
        if (duracaoMeses <= 0) throw new IllegalArgumentException("Duração deve ser de pelo menos 1 mês.");
        this.duracaoMeses = duracaoMeses;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getValor() { return valor; }
    public int getDuracaoMeses() { return duracaoMeses; }

    @Override
    public String toString() {
        return String.format("Plano [ID=%d, Nome=%s, Valor=R$%.2f, Duração=%d meses]", id, nome, valor, duracaoMeses);
    }
}
