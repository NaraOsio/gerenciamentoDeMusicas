package exercicio1;

public class Pilha<T> {
    private No<T> topo;

    public Pilha() {
        this.topo = null;
    }

    public void empilhar(T dado) {
        No<T> novo = new No<>(dado);
        novo.proximo = topo;
        topo = novo;
    }

    public T desempilhar() {
        if (topo == null) {
            return null;
        }
        T dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("Pilha vazia.");
            return;
        }
        No<T> atual = topo;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}
