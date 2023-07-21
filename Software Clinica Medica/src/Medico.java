public class Medico {
    private int id;
    private String nome;
    private String especialidade;

    public Medico(int id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    // Getters e Setters (omiti por brevidade)

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Especialidade: " + especialidade;
    }
}
