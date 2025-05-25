package exercicio2;

public class Musica {
    String nome;
    String artista;
    String album;
    int duracao;
    Musica proxima;
    Musica anterior;

    public Musica(String nome, String artista, String album, int duracao) {
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.duracao = duracao;
        this.proxima = null;
        this.anterior = null;
    }








    public void exibir() {
        System.out.println("Título: " + nome);
        System.out.println("Artista: " + artista);
        System.out.println("Álbum: " + album);
        System.out.println("Duração: " + duracao + " segundos");
        System.out.println(" ");
    }
}

