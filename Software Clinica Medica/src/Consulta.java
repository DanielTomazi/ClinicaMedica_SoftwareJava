import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private int id;
    private Medico medico;
    private Paciente paciente;
    private LocalDate data;
    private LocalTime horario;

    public Consulta(int id, Medico medico, Paciente paciente, LocalDate data, LocalTime horario) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.horario = horario;
    }

    // Getters e Setters (omiti por brevidade)

    public int getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Médico: " + medico.getNome() + ", Paciente: " + paciente.getNome() + ", Data: " + data + ", Horário: " + horario;
    }
}



