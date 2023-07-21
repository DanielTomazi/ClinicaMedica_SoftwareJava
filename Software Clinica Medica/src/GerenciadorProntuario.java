import java.util.ArrayList;

public class GerenciadorProntuario {
    private ArrayList<ProntuarioMedico> prontuarios = new ArrayList<>();

    public void adicionarProntuario(ProntuarioMedico prontuario) {
        prontuarios.add(prontuario);
    }

    public void atualizarProntuario(Paciente paciente, String novaDescricao) {
        for (ProntuarioMedico prontuario : prontuarios) {
            if (prontuario.getPaciente().equals(paciente)) {
                prontuario.setDescricao(novaDescricao);
            }
        }
    }

    public void listarProntuarios() {
        System.out.println("=== Lista de Prontuários ===");
        for (ProntuarioMedico prontuario : prontuarios) {
            System.out.println(prontuario);
        }
    }

    public ProntuarioMedico buscarProntuarioPorPaciente(Paciente paciente) {
        for (ProntuarioMedico prontuario : prontuarios) {
            if (prontuario.getPaciente().equals(paciente)) {
                return prontuario;
            }
        }
        return null;
    }
}

