import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criação de um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        try {
            // Perguntar ao usuário quantos números ele quer inserir
            System.out.print("Digite o número de elementos: ");
            int n = scanner.nextInt(); // Leitura do número de elementos

            // Criar o vetor v com o tamanho especificado pelo usuário
            int[] v = new int[n];

            // Ler os números do usuário
            System.out.println("Digite os elementos:");
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt(); // Preenche o vetor v com os números digitados
            }

            // Criar o vetor auxiliar w com o mesmo tamanho do vetor v
            int[] w = new int[v.length];

            // Chama o algoritmo de MergeSort para ordenar o vetor v
            mergeSort(v, w, 0, v.length - 1);

            // Imprime o vetor ordenado
            System.out.println("Vetor ordenado:");
            System.out.println(Arrays.toString(v)); // Exibe o vetor ordenado

        } catch (Exception e) {
            // Captura qualquer erro relacionado à entrada de dados
            System.out.println("Erro ao ler os dados: " + e.getMessage());
        }
    }
