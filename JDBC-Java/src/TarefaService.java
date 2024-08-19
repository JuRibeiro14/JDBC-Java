import java.sql.SQLException;
import java.util.List;

public class TarefaService {
    private final TarefaDAO tarefaDAO = new TarefaDAO();

    public void criarTarefa(String descricao, String categoria, boolean concluida) throws SQLException {
        Tarefa tarefa = new Tarefa(0, descricao, categoria, concluida);
        tarefaDAO.criarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() throws SQLException {
        return tarefaDAO.listarTarefas();
    }

    public void atualizarTarefa(int id, String descricao, String categoria, boolean concluida) throws SQLException {
        Tarefa tarefa = new Tarefa(id, descricao, categoria, concluida);
        tarefaDAO.atualizarTarefa(tarefa);
    }

    public void excluirTarefa(int id) throws SQLException {
        tarefaDAO.excluirTarefa(id);
    }

    public List<Tarefa> filtrarPorCategoria(String categoria) throws SQLException {
        return tarefaDAO.filtrarPorCategoria(categoria);
    }

    public List<Tarefa> filtrarPorStatus(boolean concluida) throws SQLException {
        return tarefaDAO.filtrarPorStatus(concluida);
    }
}
