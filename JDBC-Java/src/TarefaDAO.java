import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    public void criarTarefa(Tarefa tarefa) throws SQLException {
        String query = "INSERT INTO tarefas(descricao, categoria, concluida) VALUES (?, ?, ?)";
        try (Connection connection = DB.connect()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, tarefa.getDescricao());
                stmt.setString(2, tarefa.getCategoria());
                stmt.setBoolean(3, tarefa.isConcluida());
                stmt.executeUpdate();
            }
        }
    }

    public List<Tarefa> listarTarefas() throws SQLException {
        List<Tarefa> tarefas = new ArrayList<>();
        String query = "SELECT * FROM tarefas";
        try (Connection connection = DB.connect()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Tarefa tarefa = new Tarefa(rs.getInt("id"),
                            rs.getString("descricao"),
                            rs.getString("categoria"),
                            rs.getBoolean("concluida"));
                    tarefas.add(tarefa);
                }
            }
        }
        return tarefas;
    }

    public void atualizarTarefa(Tarefa tarefa) throws SQLException {
        String query = "UPDATE tarefas SET descricao = ?, categoria = ?, concluida = ? WHERE id = ?";
        try (Connection connection = DB.connect()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, tarefa.getDescricao());
                stmt.setString(2, tarefa.getCategoria());
                stmt.setBoolean(3, tarefa.isConcluida());
                stmt.setInt(4, tarefa.getId());
                stmt.executeUpdate();
            }
        }
    }

    public void excluirTarefa(int id) throws SQLException {
        String query = "DELETE FROM tarefas WHERE id = ?";
        try (Connection connection = DB.connect()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        }
    }

    public List<Tarefa> filtrarPorCategoria(String categoria) throws SQLException {
        List<Tarefa> tarefas = new ArrayList<>();
        String query = "SELECT * FROM tarefas WHERE categoria = ?";
        try (Connection connection = DB.connect()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, categoria);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Tarefa tarefa = new Tarefa(rs.getInt("id"),
                                rs.getString("descricao"),
                                rs.getString("categoria"),
                                rs.getBoolean("concluida"));
                        tarefas.add(tarefa);
                    }
                }
            }
        }
        return tarefas;
    }

    public List<Tarefa> filtrarPorStatus(boolean concluida) throws SQLException {
        List<Tarefa> tarefas = new ArrayList<>();
        String query = "SELECT * FROM tarefas WHERE concluida = ?";
        try (Connection connection = DB.connect()) {
            assert connection != null;
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setBoolean(1, concluida);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Tarefa tarefa = new Tarefa(rs.getInt("id"),
                                rs.getString("descricao"),
                                rs.getString("categoria"),
                                rs.getBoolean("concluida"));
                        tarefas.add(tarefa);
                    }
                }
            }
        }
        return tarefas;
    }
}
