import java.util.Scanner;

public class DateMySample {

    public static double interpolate(double tiePointDepth1, double tiePointAge1, double tiePointDepth2, double tiePointAge2, double sampleDepth) {
        double slope = (tiePointDepth2 - tiePointDepth1) / (tiePointAge2 - tiePointAge1);
        double intercept = -(slope * tiePointAge1) + tiePointDepth1;
        double sampleAge = (sampleDepth - intercept) / slope;
        return Math.round(sampleAge * 100) / 100.00;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please indicate upper tiepoint depth: ");
        double tiePointDepth1 = input.nextDouble();

        System.out.print("Please indicate upper tiepoint age: ");
        double tiePointAge1 = input.nextDouble();

        System.out.print("Please indicate lower tiepoint depth: ");
        double tiePointDepth2 = input.nextDouble();

        System.out.print("Please indicate lower tiepoint age: ");
        double tiePointAge2 = input.nextDouble();

        System.out.print("Please indicate the depth for age interpolation: ");
        double sampleDepth = input.nextDouble();

        if (tiePointDepth2 - tiePointDepth1 > 0) {
            if (sampleDepth > tiePointDepth1 && sampleDepth < tiePointDepth2) {
                System.out.println("Sample age equals: " + interpolate(tiePointDepth1, tiePointAge1, tiePointDepth2, tiePointAge2, sampleDepth) + " Ma");
            } else
                System.out.println("Wrong sample depth.");
        } else
            System.out.println("Wrong tiepoint depths.");
    }
}
