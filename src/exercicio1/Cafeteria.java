package exercicio1;

import java.util.Scanner;

public class Cafeteria {

    public static void main(String[] args) {
        Fila<Pedido> pedidosPendentes = new Fila<>();
        Pilha<Pedido> pedidosCancelados = new Pilha<>();

        Scanner scan = new Scanner(System.in);
        int opcao;
        int contadorPedidos = 1;

        while (true) {
            System.out.println(" ");
            System.out.println("1 - Inserir pedido");
            System.out.println("2 - Atender pedido");
            System.out.println("3 - Cancelar pedido");
            System.out.println("4 - Restaurar pedido cancelado");
            System.out.println("5 - Listar pedidos");
            System.out.println("0 - Sair");
            System.out.print("Informe uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Informe a descrição do pedido: ");
                    String desc = scan.nextLine();
                    Pedido pedido = new Pedido(String.valueOf(contadorPedidos), desc);
                    pedidosPendentes.enfileirar(pedido);
                    System.out.println("Pedido inserido com sucesso.");
                    contadorPedidos++;
                    break;

                case 2:
                    Pedido atendido = pedidosPendentes.desenfileirar();
                    if (atendido != null) {
                        System.out.println("Pedido atendido: " + atendido);
                    } else {
                        System.out.println("Não há pedidos pendentes.");
                    }
                    break;

                case 3:
                    Pedido cancelado = pedidosPendentes.desenfileirar();
                    if (cancelado != null) {
                        pedidosCancelados.empilhar(cancelado);
                        System.out.println("Pedido cancelado: " + cancelado);
                    } else {
                        System.out.println("Não há pedidos para cancelar.");
                    }
                    break;

                case 4:
                    Pedido restaurado = pedidosCancelados.desempilhar();
                    if (restaurado != null) {
                        pedidosPendentes.enfileirar(restaurado);
                        System.out.println("Pedido restaurado: " + restaurado);
                    } else {
                        System.out.println("Não há pedidos cancelados para restaurar.");
                    }
                    break;

                case 5:
                    System.out.println("\nPedidos Pendentes:");
                    pedidosPendentes.exibir();
                    System.out.println("\nPedidos Cancelados:");
                    pedidosCancelados.exibir();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scan.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
