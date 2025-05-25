package exercicio1;

public class Pedido {
    int id;
    String descricao;

    public Pedido(String id, String descricao) {
        this.id = Integer.parseInt(id);
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Pedido " + id + ", descrição: " + descricao;
    }
}
