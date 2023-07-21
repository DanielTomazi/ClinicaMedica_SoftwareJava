public class ProntuarioMedico {
    private Paciente paciente;
    private String descricao;

    public ProntuarioMedico(Paciente paciente, String descricao) {
        this.paciente = paciente;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Paciente: " + paciente.getNome() + ", Descrição: " + descricao;
    }
}
