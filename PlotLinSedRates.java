import java.util.Arrays;

public class PlotLinSedRates {

    public static double estimateLinSedRate(double deeperDepth, double shallowerDepth, double olderAge, double youngerAge) {
        return ((deeperDepth - shallowerDepth) * 100) / ((olderAge - youngerAge) * 1000);
    }

    public static void main(String[] args) {
        Site site = new Site("1050", "A,C");

        Tiepoint tiepoint0 = new Tiepoint("Tiepoint 0", "pmag", "B C19n", 4.2, 11.23, 41.39);

        Tiepoint tiepoint1 = new Tiepoint("Tiepoint 1", "pmag", "B C19r", 24.14, 26.41, 42.30);

        Tiepoint tiepoint2 = new Tiepoint("Tiepoint 2", "pmag", "B C20n", 61.62, 62.19, 43.43);

        Tiepoint tiepoint3 = new Tiepoint("Tiepoint 3", "pmag", "B C20r", 137.27, 140.28, 45.72);

        Tiepoint tiepoint4 = new Tiepoint("Tiepoint 4", "pmag", "B C21n", 151.603, 153.190, 47.35);

        Tiepoint tiepoint5 = new Tiepoint("Tiepoint 5", "nanno", "B NP14a", 151.603, 153.190, 49.11);

        Tiepoint tiepoint6 = new Tiepoint("Tiepoint 6", "pmag", "B C22n", 153.71, 154.43, 49.34);

        Tiepoint tiepoint7 = new Tiepoint("Tiepoint 7", "pmag", "T C23n", 182.657, 183.359, 50.63);

        Tiepoint tiepoint8 = new Tiepoint("Tiepoint 8", "nanno", "B C. crassus", 193.2, 194.64, 51.64);

        Tiepoint tiepoint9 = new Tiepoint("Tiepoint 9", "nanno", "B NP12", 193.2, 194.64, 53.7);

        Tiepoint tiepoint10 = new Tiepoint("Tiepoint 10", "pmag", "B C24n", 198.37, 199.08, 53.98);

        /* Tiepoint tiepoint = new Tiepoint(" ", "pmag", " ", 198.37, 199.08, 53.98); // repeat last tiepoint */

        double[] maxDepths = {
                tiepoint0.maxDepth,
                tiepoint1.maxDepth,
                tiepoint2.maxDepth,
                tiepoint3.maxDepth,
                tiepoint4.maxDepth,
                tiepoint5.maxDepth,
                tiepoint6.maxDepth,
                tiepoint7.maxDepth,
                tiepoint8.maxDepth,
                tiepoint9.maxDepth,
                tiepoint10.maxDepth
                // tiepoint.maxDepth
        };

        double[] minDepths = {
                tiepoint0.minDepth,
                tiepoint1.minDepth,
                tiepoint2.minDepth,
                tiepoint3.minDepth,
                tiepoint4.minDepth,
                tiepoint5.minDepth,
                tiepoint6.minDepth,
                tiepoint7.minDepth,
                tiepoint8.minDepth,
                tiepoint9.minDepth,
                tiepoint10.minDepth
                //   tiepoint.minDepth
        };

        double[] ages = {
                tiepoint0.age,
                tiepoint1.age,
                tiepoint2.age,
                tiepoint3.age,
                tiepoint4.age,
                tiepoint5.age,
                tiepoint6.age,
                tiepoint7.age,
                tiepoint8.age,
                tiepoint9.age,
                tiepoint10.age
                //    tiepoint.age
        };

        double[] averageDepths = new double[maxDepths.length];
        for (int i = 0; i < maxDepths.length; i++)
            averageDepths[i] = (maxDepths[i] + minDepths[i]) / 2;

        for (int i = 0; i < averageDepths.length; i++)
            System.out.println(averageDepths[i]);

        System.out.println(" ");

        double[] linSedRates = new double[averageDepths.length];
        for (int i = 0; i < averageDepths.length - 1; i++)
            linSedRates[i] = estimateLinSedRate(averageDepths[i + 1], averageDepths[i], ages[i + 1], ages[i]);

        for (int i = 0; i < linSedRates.length - 1; i++)
            System.out.println("Dla przedziału od: " + averageDepths[i + 1] + " do: " + averageDepths[i] + " LSR wynosi: " + linSedRates[i] + " cm/kyr");

        //estimate Y axis length
        double[] linSedRatesSorted = new double[linSedRates.length];
        for (int i = 0; i < linSedRates.length; i++)
            linSedRatesSorted[i] = linSedRates[i];

        Arrays.sort(linSedRatesSorted);
        double yMax = Math.ceil(linSedRatesSorted[10]);

        //estimate X axis onset and terminus
        double xMin = Math.floor(ages[0]);
        double xMax = Math.ceil(ages[ages.length - 1]);

     /*
        System.out.println("Y max wynosi: " + yMax);
        System.out.println("X min wynosi: " + xMin);
        System.out.println("X max wynosi: " + xMax);
      */

        //establishing margins around the plot:
        double verticalMargin = yMax / 4;
        double horizontalMargin = (xMax - xMin) / 10;

        //setting horizontal and vertical scales
        StdDraw.setXscale(xMin - 2 * horizontalMargin, xMax + horizontalMargin);
        StdDraw.setYscale(-verticalMargin, yMax + verticalMargin);

        //plotting Linear Sedimentation Rates - curve
        for (int i = 0; i < linSedRates.length - 1; i++) {
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.setPenRadius(0.0035);
            StdDraw.rectangle(((ages[i] + ages[i + 1]) / 2), (linSedRates[i] / 2), ((ages[i + 1] - ages[i]) / 2), (linSedRates[i] / 2));
        }

        //plotting Linear Sedimentation Rates - boxes
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < linSedRates.length - 1; i++) {
            StdDraw.line(ages[i], linSedRates[i], ages[i + 1], linSedRates[i]);
            StdDraw.line(ages[i + 1], linSedRates[i], ages[i + 1], linSedRates[i + 1]);
        }

        //plotting axes
        //printing horizontal axis
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(xMin, 0, xMax, 0);

        //printing tick marks on horizontal axis
        for (int i = (int) xMin; i <= xMax; i++) {
            //   if (i % 5 == 0)
            StdDraw.line(i, 0, i, -(verticalMargin / 20));
        }

        //printing tick mark labels on horizontal axis
        for (int i = (int) xMin; i <= xMax; i++) {
            //    if (i % 5 == 0)
            StdDraw.text(i, -0.225, String.valueOf(i));
        }

        //printing horizontal axis label
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text((xMin + xMax) / 2, -(verticalMargin / 2), "Age (Ma, GTS2012)");

        //vertical axis
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(xMin, 0, xMin, yMax);

        //tick marks on vertical axis
        for (int i = 0; i <= yMax; i++)
            StdDraw.line(xMin, i, xMin - (horizontalMargin / 10), i);

        //printing tick mark labels on vertical axis
        for (int i = 0; i <= yMax; i++)
            StdDraw.text(xMin - 0.5, i, String.valueOf(i));

        //printing vertical axis label
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(xMin - horizontalMargin, yMax / 2, "Linear Sedimentation Rate (cm/kyr)", 90);

        //printing plot title centered relative to horizontal axis
        String plotTitle = "LSR through time plot for Hole ";
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text((xMin + xMax) / 2, yMax + (verticalMargin / 2), plotTitle + site.siteNumber + site.hole);
    }
}

