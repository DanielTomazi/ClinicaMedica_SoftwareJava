public class Paciente {
    private int id;
    private String nome;
    private int idade;

    public Paciente(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e Setters (omiti por brevidade)

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Idade: " + idade;
    }
}


