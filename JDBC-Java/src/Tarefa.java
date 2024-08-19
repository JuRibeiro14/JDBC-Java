public class Tarefa {
    private final int id;
    private final String descricao;
    private final String categoria;
    private final boolean concluida;

     public Tarefa(int id, String descricao, String categoria, boolean concluida) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.concluida = concluida;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isConcluida() {
        return concluida;
    }


    @Override
    public String toString() {
        return "Tarefa{id=" + id + ", descricao='" + descricao + "', categoria='" + categoria + "', concluida=" + concluida + '}';
    }
}
