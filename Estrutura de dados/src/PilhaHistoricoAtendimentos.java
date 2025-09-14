import java.util.Stack;

public class PilhaHistoricoAtendimentos {
    private Stack<Paciente> historico = new Stack<>();

    public void adicionarAoHistorico(Paciente p) {
        historico.push(p);
    }

    public Paciente verUltimoAtendido() {
        if (historico.empty()) {
            return null;
        }
        return historico.peek();
    }

    public void mostrarHistorico() {
        if (historico.empty()) {
            System.out.println("O histórico de atendimentos está vazio.");
        } else {
            System.out.println("--- Histórico de Atendimentos (Recente -> Antigo) ---");
            for (int i = historico.size() - 1; i >= 0; i--) {
                System.out.println(historico.get(i).exibirInfo());
            }
            System.out.println("---------------------------------------------------");
        }
    }
}