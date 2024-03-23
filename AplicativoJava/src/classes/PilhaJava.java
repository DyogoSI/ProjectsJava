/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author dyogo
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PilhaJava {
    private static int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Menu Pilha ---");
        System.out.println("1. Inserir elemento");
        System.out.println("2. Remover elemento");
        System.out.println("3. Mostrar topo");
        System.out.println("4. Mostrar pilha");
        System.out.println("0. Sair");
        System.out.print("Digite a opção desejada: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        int tamanho, op;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tamanho da pilha: ");
        tamanho = scanner.nextInt();
        Pilha<Recorde> pilha = new Pilha<>(tamanho);
        do {
            op = mostrarMenu();
            switch (op) {
                case 1:
                    System.out.println("Dados do recorde:");
                    scanner.nextLine(); // Consume newline left after previous nextInt()
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data [dd/mm/aaaa]: ");
                    String dataRecorde = scanner.nextLine();
                    LocalDate dataFormatada = LocalDate.parse(dataRecorde, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.print("Tempo: ");
                    double tempo = scanner.nextDouble();
                    Recorde novoRecorde = new Recorde("Nome do Recorde", "Data do Recorde", "Tempo do Recorde");

                    if (pilha.push(novoRecorde))
                        System.out.println("Inserção realizada");
                    else
                        System.out.println("Stack Overflow!");
                    break;
                case 2:
                    if (!pilha.isEmpty())
                        System.out.println("Elemento removido: " + pilha.pop());
                    else
                        System.out.println("Pilha vazia!");
                    break;
                case 3:
                    if (!pilha.isEmpty())
                        System.out.println("Elemento do topo: " + pilha.peek());
                    else
                        System.out.println("Pilha vazia!");
                    break;
                case 4:
                    System.out.println("Elementos da pilha:\n" + pilha);
                    break;
            }
            System.out.println("Pressione Enter para continuar");
            scanner.nextLine(); // Consume newline left after previous nextInt()
            scanner.nextLine(); // Wait for user to press Enter
        } while (op != 0);
        scanner.close();
    }
}

