import java.util.LinkedList;

public class FilaDeAtendimento {
    private LinkedList<Paciente> fila = new LinkedList<>();

    public void adicionarPaciente(Paciente p) {
        fila.addLast(p);
        System.out.println("Paciente " + p.getNome() + " adicionado à fila.");
    }

    public Paciente atenderPaciente() {
        if (!estaVazia()) {
            return fila.removeFirst();
        }
        System.out.println("A fila de atendimento está vazia.");
        return null;
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public void mostrarFila() {
        if (estaVazia()) {
            System.out.println("A fila de atendimento está vazia.");
        } else {
            System.out.println("--- Fila de Atendimento ---");
            for (Paciente p : fila) {
                System.out.println(p.exibirInfo());
            }
            System.out.println("--------------------------");
        }
    }
}