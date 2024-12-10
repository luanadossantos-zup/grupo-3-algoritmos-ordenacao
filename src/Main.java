import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Algoritmo Bubble Sort


        Scanner scanner = new Scanner(System.in);

        int tamanho; //Variavel que define o tamanho da array


        try {                                               //Testa o bloco de código a seguir
            System.out.println("Digite o tamanho do array:");
            tamanho = scanner.nextInt();    //Usuário digita em números o tamanho desejado na array
            int[] array = new int[tamanho]; //Declara a array com tamanho definido anteriormente

            System.out.println("Agora digite os valores da array:");
            for (int i = 0; i < tamanho; i++) {          //Faz uma iteração com base no tamanho da array
                array[i] = scanner.nextInt();           //Recebe os valores para a array pelo usuário
            }

            int menor;                   //Variável que define o valor menor em comparação à variavel seguinte
            int maior;                   //Variável que define o valor maior em comparação a variável anterior
            boolean controle = true;    // Variável que controla se o que foi declarado dentro de If é true dentro da iteração atual


            for (int i = 0; i < array.length && controle == true; i++) {
                controle = false;                       //Variável que controla até quando a iteração irá ocorrer

                for (int j = 0; j < array.length-1; j++) {  //Define a iteração na array com base no tamanho da array -1
                    if(array[j] > array[j + 1]) {       //Compara se o valor da esquerda é maior que o valor da direita(j+1)
                        maior = array[j];               //variável maior memoriza o valor da array[j] temporariamente
                        menor = array[j + 1];           //variável menor memoriza o valor da array[j +1] temporariamente
                        array[j] = menor;               //a array[j] é definida com o valor da variavel menor
                        array[j + 1] = maior;           //a array[j+1] é definida com o valor da variável maior
                        controle = true;                //Controle muda para false quando array[j] for menor que array[j+1]
                    }
                }
            }

            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + " "); // Exibe a lista organizada
            }

        } catch (Exception e) {
            System.out.println("Digite um número válido!");     //Pega o erro caso o usuário digitar algo que não for int e exibe o erro
        }
    }
}
