import java.util.Scanner;

public class Stratigraphy {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

//określa liczbę punktów węzłowych modelu wiekowego i tworzy tabelę ageModel[][]
        System.out.println("Podaj liczbę punktów węzłowych: ");
        int numberOfTiepoints = input.nextInt();
        double[][] ageModel = new double[numberOfTiepoints][2];

        //definiowanie punktów węzłowych modelu wiekowego
        for (int i = 0; i < numberOfTiepoints; i++) {

            System.out.println("Podaj głębokość minimalną: ");
            double minDepth = input.nextDouble();
            System.out.println("Podaj głębokość maksymalną: ");
            double maxDepth = input.nextDouble();

            //sprawdza czy głębokość maksymalna punktu węzłowego nie jest mniejsza od głębokości minimalnej
            if (maxDepth < minDepth) {
                System.out.println("Głębokość maksymalna mniejsza od głębokości minimalnej");
                break;
            }

            //oblicza średnią głębokość dla punktu węzłowego
            ageModel[i][0] = (minDepth + maxDepth) / 2;

            System.out.println("Podaj wiek: ");
            double Age = input.nextDouble();

            ageModel[i][1] = Age;

        }

        //wyświetla tabelę ageModel[][]
        System.out.println("Głęb.  Wiek");
        for (int row = 0; row < numberOfTiepoints; row++) {
            System.out.print(ageModel[row][0] + "   ");
            System.out.println(ageModel[row][1]);
        }

        //Wprowadzanie głębokości próbki do wydatowania
        System.out.println("Podaj głębokość do interpolacji wieku: ");
        double sampleDepth = input.nextDouble();

        //Interpolacja liniowa wieku dla danej głębokości, na podstawie punktów węzłowych modelu wiekowego.
        for (int i = 0; i < numberOfTiepoints; i++) {
            if (ageModel[i][0] > sampleDepth && ageModel[i - 1][0] < sampleDepth)
                System.out.println("Wiek próbki wynosi: " + Tiepoint.interpolate(ageModel[i - 1][0], ageModel[i - 1][1], ageModel[i][0], ageModel[i][1], sampleDepth) + " mln lat");
        }
    }
}

