package exercicio1;

public class Fila<T> {
    private No<T> inicio;
    private No<T> fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public void enqueue(T dado) {
        No<T> novoNo = new No<>(dado);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return dado;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        No<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}
