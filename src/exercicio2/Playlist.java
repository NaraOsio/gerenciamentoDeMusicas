package exercicio2;

public class Playlist {
    Musica primeira;
    Musica ultima;
    Musica atual;

    public Playlist() {
        this.primeira = null;
        this.ultima = null;
        this.atual = null;
    }

    public boolean estaVazia() {
        return primeira == null;
    }

    public void adicionarNoFim(Musica nova) {
        if (estaVazia()) {
            primeira = nova;
            ultima = nova;
            atual = nova;
        } else {
            ultima.proxima = nova;
            nova.anterior = ultima;
            ultima = nova;
        }
    }

    public void adicionarNoInicio(Musica nova) {
        if (estaVazia()) {
            primeira = nova;
            ultima = nova;
            atual = nova;
        } else {
            nova.proxima = primeira;
            primeira.anterior = nova;
            primeira = nova;
        }
    }

    public void adicionarNaPosicao(Musica nova, int posicao) {
        if (posicao <= 1) {
            adicionarNoInicio(nova);
        } else {
            Musica temp = primeira;
            int count = 1;
            while (temp != null && count < posicao - 1) {
                temp = temp.proxima;
                count++;
            }
            if (temp == null || temp.proxima == null) {
                adicionarNoFim(nova);
            } else {
                nova.proxima = temp.proxima;
                nova.anterior = temp;
                temp.proxima.anterior = nova;
                temp.proxima = nova;
            }
        }
    }

    public void removerPorTitulo(String titulo) {
        Musica temp = primeira;
        while (temp != null) {
            if (temp.nome.equalsIgnoreCase(titulo)) {
                if (temp == primeira) {
                    primeira = temp.proxima;
                    if (primeira != null) {
                        primeira.anterior = null;
                    }
                } else if (temp == ultima) {
                    ultima = temp.anterior;
                    if (ultima != null) {
                        ultima.proxima = null;
                    }
                } else {
                    temp.anterior.proxima = temp.proxima;
                    temp.proxima.anterior = temp.anterior;
                }
                if (atual == temp) {
                    atual = temp.proxima != null ? temp.proxima : temp.anterior;
                }
                System.out.println("Música removida com sucesso.");
                return;
            }
            temp = temp.proxima;
        }
        System.out.println("Música não encontrada.");
    }

    public void listar() {
        if (estaVazia()) {
            System.out.println("A playlist está vazia.");
            return;
        }
        Musica temp = primeira;
        while (temp != null) {
            temp.exibir();
            temp = temp.proxima;
        }
    }

    public void tocar() {
        if (atual != null) {
            System.out.println("Reproduzindo...");
            atual.exibir();
        } else {
            System.out.println("Nenhuma música selecionada.");
        }
    }

    public void proxima() {
        if (atual != null && atual.proxima != null) {
            atual = atual.proxima;
            tocar();
        } else {
            System.out.println("Você está na última música.");
        }
    }

    public void anterior() {
        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
            tocar();
        } else {
            System.out.println("Você está na primeira música.");
        }
    }

    public void ordenarPorTitulo() {
        if (estaVazia() || primeira.proxima == null) {
            return;
        }
        boolean trocou;
        do {
            trocou = false;
            Musica atual = primeira;
            while (atual.proxima != null) {
                if (atual.nome.compareToIgnoreCase(atual.proxima.nome) > 0) {
                    trocarDados(atual, atual.proxima);
                    trocou = true;
                }
                atual = atual.proxima;
            }
        } while (trocou);
        System.out.println("Playlist ordenada por título.");
    }

    public void ordenarPorArtista() {
        if (estaVazia() || primeira.proxima == null) {
            return;
        }
        boolean trocou;
        do {
            trocou = false;
            Musica atual = primeira;
            while (atual.proxima != null) {
                if (atual.artista.compareToIgnoreCase(atual.proxima.artista) > 0) {
                    trocarDados(atual, atual.proxima);
                    trocou = true;
                }
                atual = atual.proxima;
            }
        } while (trocou);
        System.out.println("Playlist ordenada por artista.");
    }

    private void trocarDados(Musica m1, Musica m2) {
        String nome = m1.nome;
        String artista = m1.artista;
        String album = m1.album;
        int duracao = m1.duracao;

        m1.nome = m2.nome;
        m1.artista = m2.artista;
        m1.album = m2.album;
        m1.duracao = m2.duracao;

        m2.nome = nome;
        m2.artista = artista;
        m2.album = album;
        m2.duracao = duracao;
    }
}


