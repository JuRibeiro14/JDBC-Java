import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TarefaService tarefaService = new TarefaService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("4. Excluir Tarefa");
            System.out.println("5. Filtrar por Categoria");
            System.out.println("6. Filtrar por Status");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Descrição: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Categoria: ");
                        String categoria = scanner.nextLine();
                        tarefaService.criarTarefa(descricao, categoria, false);
                        System.out.println("Tarefa criada!");
                    }
                    case 2 -> {
                        List<Tarefa> tarefas = tarefaService.listarTarefas();
                        tarefas.forEach(System.out::println);
                    }
                    case 3 -> {
                        System.out.print("ID da Tarefa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nova Descrição: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Nova Categoria: ");
                        String categoria = scanner.nextLine();
                        System.out.print("Concluída (true/false): ");
                        boolean concluida = scanner.nextBoolean();
                        tarefaService.atualizarTarefa(id, descricao, categoria, concluida);
                        System.out.println("Tarefa atualizada!");
                    }
                    case 4 -> {
                        System.out.print("ID da Tarefa a ser excluída: ");
                        int id = scanner.nextInt();
                        tarefaService.excluirTarefa(id);
                        System.out.println("Tarefa excluída!");
                    }
                    case 5 -> {
                        System.out.print("Categoria: ");
                        String categoria = scanner.nextLine();
                        List<Tarefa> tarefas = tarefaService.filtrarPorCategoria(categoria);
                        tarefas.forEach(System.out::println);
                    }
                    case 6 -> {
                        System.out.print("Concluída (true/false): ");
                        boolean concluida = scanner.nextBoolean();
                        List<Tarefa> tarefas = tarefaService.filtrarPorStatus(concluida);
                        tarefas.forEach(System.out::println);
                    }
                    case 7 -> {
                        System.out.println("Saindo...");
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (SQLException e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }
}
