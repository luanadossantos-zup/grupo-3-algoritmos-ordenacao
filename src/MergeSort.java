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
    /**
     * O método mergeSort é responsável por dividir recursivamente o vetor
     * em duas metades e ordená-las utilizando o algoritmo MergeSort.
     * teste
     * @param v     O vetor original a ser ordenado
     * @param w     O vetor auxiliar utilizado para a intercalagem
     * @param inicio O índice inicial do subvetor
     * @param fim    O índice final do subvetor
     */

    private static void mergeSort(int[] v, int[] w, int inicio, int fim) {
        // Condição de parada: se o subvetor tiver mais de um elemento
        if (inicio < fim) {
            // Encontrar o ponto médio do vetor
            int meio = (inicio + fim) / 2;

            // Ordena recursivamente a primeira metade
            mergeSort(v, w, inicio, meio);

            // Ordena recursivamente a segunda metade
            mergeSort(v, w, meio + 1, fim);

            // Intercala as duas metades ordenadas
            intercalar(v, w, inicio, meio, fim);
        }
    }
    /**
     * O método intercalar é responsável por juntar dois subvetores ordenados
     * em um único vetor ordenado. A intercalagem é feita comparando os
     * elementos dos dois subvetores e colocando o menor no vetor final.
     *
     * @param v     O vetor original que será ordenado
     * @param w     O vetor auxiliar utilizado para armazenar os elementos temporários
     * @param inicio O índice inicial do subvetor
     * @param meio   O índice que divide os dois subvetores
     * @param fim    O índice final do subvetor
     */
    private static void intercalar(int[] v, int[] w, int inicio, int meio, int fim) {
        // Copia os elementos do vetor v para o vetor auxiliar w
        for (int k = inicio; k <= fim; k++) {
            w[k] = v[k];
        }

        // Índices para percorrer as duas metades do vetor
        int i = inicio;          // Início da primeira metade
        int j = meio + 1;        // Início da segunda metade

        // Intercala os dois subvetores no vetor v
        for (int k = inicio; k <= fim; k++) {
            if (i > meio) {
                // Se a primeira metade foi completamente copiada, pega da segunda metade
                v[k] = w[j++];
            } else if (j > fim) {
                // Se a segunda metade foi completamente copiada, pega da primeira metade
                v[k] = w[i++];
            } else if (w[i] < w[j]) {
                // Se o elemento da primeira metade for menor, copia para o vetor v
                v[k] = w[i++];
            } else {
                // Caso contrário, copia o elemento da segunda metade
                v[k] = w[j++];
            }
        }
    }
}
