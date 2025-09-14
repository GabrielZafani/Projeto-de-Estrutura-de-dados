import java.util.Scanner;

public class GerenciadorClinica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaDeAtendimento fila = new FilaDeAtendimento();
        PilhaHistoricoAtendimentos historico = new PilhaHistoricoAtendimentos();
        boolean rodando = true;

        while (rodando) {
            exibirMenu();
            int opcao = 0;
            boolean entradaValida = false;

            while (!entradaValida) {
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    entradaValida = true;
                } else {
                    System.out.println("Opção inválida. Digite um número inteiro.");
                    scanner.next(); // Consome a entrada inválida
                    exibirMenu();
                }
            }

            if (opcao == 1) {
                System.out.println("--- Adicionar Paciente ---");
                System.out.print("Nome: ");
                scanner.nextLine(); // Consome a quebra de linha
                String nome = scanner.nextLine();

                int idade = 0;
                entradaValida = false;
                while (!entradaValida) {
                    System.out.print("Idade: ");
                    if (scanner.hasNextInt()) {
                        idade = scanner.nextInt();
                        entradaValida = true;
                    } else {
                        System.out.println("Idade inválida. Digite um número inteiro.");
                        scanner.next(); // Consome a entrada inválida
                    }
                }
                scanner.nextLine(); // Consome a quebra de linha

                System.out.print("Sintoma: ");
                String sintoma = scanner.nextLine();

                Paciente novoPaciente = new Paciente(nome, idade, sintoma);
                fila.adicionarPaciente(novoPaciente);

            } else if (opcao == 2) {
                System.out.println("--- Atender Paciente ---");
                Paciente pacienteAtendido = fila.atenderPaciente();
                if (pacienteAtendido != null) {
                    System.out.println("Paciente atendido: " + pacienteAtendido.exibirInfo());
                    historico.adicionarAoHistorico(pacienteAtendido);
                }

            } else if (opcao == 3) {
                fila.mostrarFila();

            } else if (opcao == 4) {
                historico.mostrarHistorico();

            } else if (opcao == 5) {
                System.out.println("Saindo do sistema. Obrigado!");
                rodando = false;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===================================================");
        System.out.println("1. Adicionar novo paciente à fila");
        System.out.println("2. Atender próximo paciente");
        System.out.println("3. Exibir fila de atendimento");
        System.out.println("4. Exibir histórico de atendimentos");
        System.out.println("5. Sair");
        System.out.println("===================================================");
        System.out.print("Escolha uma opção: ");
    }
}