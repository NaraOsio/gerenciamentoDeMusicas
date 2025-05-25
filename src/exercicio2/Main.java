package exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Bem-vindo ao seu Gerenciador de Músicas!");
            System.out.println("1. Próxima música");
            System.out.println("2. Música anterior");
            System.out.println("3. Ordenar playlist");
            System.out.println("4. Tocar música");
            System.out.println("5. Adicionar música");
            System.out.println("6. Remover música");
            System.out.println("7. Listar músicas");
            System.out.println("8. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    playlist.proxima();
                    break;
                case 2:
                    playlist.anterior();
                    break;
                case 3:
                    System.out.println(" ");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    if (tipo == 1) {
                        playlist.ordenarPorTitulo();
                    } else if (tipo == 2) {
                        playlist.ordenarPorArtista();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 4:
                    playlist.tocar();
                    break;
                case 5:
                    System.out.print("Título: ");
                    String nome = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Álbum: ");
                    String album = sc.nextLine();
                    System.out.print("Duração (segundos): ");
                    int duracao = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Adicionar em1 Início2 Fim3 ");
                    int onde = sc.nextInt();
                    sc.nextLine();
                    Musica nova = new Musica(nome, artista, album, duracao);
                    if (onde == 1) {
                        playlist.adicionarNoInicio(nova);
                    } else if (onde == 2) {
                        playlist.adicionarNoFim(nova);
                    } else if (onde == 3) {
                        System.out.print("Informe a posição: ");
                        int pos = sc.nextInt();
                        sc.nextLine();
                        playlist.adicionarNaPosicao(nova, pos);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o título da música para remover: ");
                    String tituloRemover = sc.nextLine();
                    playlist.removerPorTitulo(tituloRemover);
                    break;
                case 7:
                    playlist.listar();
                    break;
                case 8:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 8);

        sc.close();
    }
}

