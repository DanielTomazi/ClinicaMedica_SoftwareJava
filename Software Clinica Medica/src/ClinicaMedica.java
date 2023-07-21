import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ClinicaMedica {
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private GerenciadorProntuario gerenciadorProntuario = new GerenciadorProntuario();

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agendarConsulta(int idConsulta, Medico medico, Paciente paciente, LocalDate data, LocalTime horario) {
        Consulta consulta = new Consulta(idConsulta, medico, paciente, data, horario);
        consultas.add(consulta);
    }

    public void cancelarConsulta(int idConsulta) {
        consultas.removeIf(consulta -> consulta.getId() == idConsulta);
    }

    public void listarMedicos() {
        System.out.println("=== Lista de Médicos ===");
        for (Medico medico : medicos) {
            System.out.println(medico);
        }
    }

    public void listarPacientes() {
        System.out.println("=== Lista de Pacientes ===");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void listarConsultas() {
        System.out.println("=== Lista de Consultas ===");
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }

    public ArrayList<Medico> getMedicosDisponiveis(LocalDate data) {
        ArrayList<Medico> medicosDisponiveis = new ArrayList<>();
        for (Medico medico : medicos) {
            boolean disponivel = true;
            for (Consulta consulta : consultas) {
                if (consulta.getMedico().equals(medico) && consulta.getData().equals(data)) {
                    disponivel = false;
                    break;
                }
            }
            if (disponivel) {
                medicosDisponiveis.add(medico);
            }
        }
        return medicosDisponiveis;
    }

    public void adicionarProntuario(ProntuarioMedico prontuario) {
        gerenciadorProntuario.adicionarProntuario(prontuario);
    }

    public void atualizarProntuario(Paciente paciente, String novaDescricao) {
        gerenciadorProntuario.atualizarProntuario(paciente, novaDescricao);
    }

    public void listarProntuarios() {
        gerenciadorProntuario.listarProntuarios();
    }

    public ProntuarioMedico buscarProntuarioPorPaciente(Paciente paciente) {
        return gerenciadorProntuario.buscarProntuarioPorPaciente(paciente);
    }

    public static void main(String[] args) {
        ClinicaMedica clinica = new ClinicaMedica();

        // Criar médicos e pacientes
        Medico medico1 = new Medico(1, "Dr. João", "Cardiologista");
        Medico medico2 = new Medico(2, "Dra. Maria", "Dermatologista");
        Paciente paciente1 = new Paciente(1, "Maria", 30);
        Paciente paciente2 = new Paciente(2, "João", 25);

        // Adicionar médicos e pacientes à clínica
        clinica.adicionarMedico(medico1);
        clinica.adicionarMedico(medico2);
        clinica.adicionarPaciente(paciente1);
        clinica.adicionarPaciente(paciente2);

        // Agendar consulta
        LocalDate dataConsulta = LocalDate.of(2023, 7, 25);
        LocalTime horarioConsulta = LocalTime.of(10, 30);
        clinica.agendarConsulta(1, medico1, paciente1, dataConsulta, horarioConsulta);

        // Listar médicos, pacientes e consultas
        clinica.listarMedicos();
        clinica.listarPacientes();
        clinica.listarConsultas();

        // Listar médicos disponíveis em uma determinada data
        LocalDate dataVerificar = LocalDate.of(2023, 7, 25);
        ArrayList<Medico> medicosDisponiveis = clinica.getMedicosDisponiveis(dataVerificar);
        System.out.println("=== Médicos disponíveis em " + dataVerificar + " ===");
        for (Medico medico : medicosDisponiveis) {
            System.out.println(medico);
        }

        // Criar e adicionar prontuários
        ProntuarioMedico prontuario1 = new ProntuarioMedico(paciente1, "Paciente com febre e dor de cabeça.");
        ProntuarioMedico prontuario2 = new ProntuarioMedico(paciente2, "Paciente com alergia de pele.");
        clinica.adicionarProntuario(prontuario1);
        clinica.adicionarProntuario(prontuario2);
    }
}
