import java.util.Objects;

public class PlotAgeVsDepth {
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

        Tiepoint tiepoint = new Tiepoint(" ", "pmag", " ", 198.37, 199.08, 53.98); // repeat last tiepoint

        double[] depths = {
                Tiepoint.averageDepth(tiepoint0.minDepth, tiepoint0.maxDepth),
                Tiepoint.averageDepth(tiepoint1.minDepth, tiepoint1.maxDepth),
                Tiepoint.averageDepth(tiepoint2.minDepth, tiepoint2.maxDepth),
                Tiepoint.averageDepth(tiepoint3.minDepth, tiepoint3.maxDepth),
                Tiepoint.averageDepth(tiepoint4.minDepth, tiepoint4.maxDepth),
                Tiepoint.averageDepth(tiepoint5.minDepth, tiepoint6.maxDepth),
                Tiepoint.averageDepth(tiepoint7.minDepth, tiepoint7.maxDepth),
                Tiepoint.averageDepth(tiepoint8.minDepth, tiepoint8.maxDepth),
                Tiepoint.averageDepth(tiepoint9.minDepth, tiepoint9.maxDepth),
                Tiepoint.averageDepth(tiepoint10.minDepth, tiepoint10.maxDepth),
                Tiepoint.averageDepth(tiepoint.minDepth, tiepoint.maxDepth)
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
                tiepoint10.age,
                tiepoint.age
        };

        String[] labels = {
                tiepoint0.label,
                tiepoint1.label,
                tiepoint2.label,
                tiepoint3.label,
                tiepoint4.label,
                tiepoint5.label,
                tiepoint6.label,
                tiepoint7.label,
                tiepoint8.label,
                tiepoint9.label,
                tiepoint10.label,
                tiepoint.label
        };

        String[] types = {
                tiepoint0.type,
                tiepoint1.type,
                tiepoint2.type,
                tiepoint3.type,
                tiepoint4.type,
                tiepoint5.type,
                tiepoint6.type,
                tiepoint7.type,
                tiepoint8.type,
                tiepoint9.type,
                tiepoint10.type,
                tiepoint.type
        };

        //estimate Y axis length
        double yMin = Math.floor(depths[0]);
        double yMax = Math.ceil(depths[depths.length - 1]);

        //estimate X axis onset and terminus
        double xMin = Math.floor(ages[0]);
        double xMax = Math.ceil(ages[ages.length - 1]);

        //establishing margins around the plot:
        double verticalMargin = yMax / 10;
        double horizontalMargin = (xMax - xMin) / 10;

        //setting horizontal and vertical scales:
        StdDraw.setXscale(xMin - horizontalMargin * 2, xMax + horizontalMargin);
        StdDraw.setYscale(yMax + verticalMargin, yMin - verticalMargin * 3);

        //plotting the age vs depth curve
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < depths.length - 1; i++)
            StdDraw.line(ages[i], depths[i], ages[i + 1], depths[i + 1]);

        //plotting tiepoints
        for (int i = 0; i < depths.length; i++) {
            double[] xd = {ages[i], ages[i] + 0.2, ages[i], ages[i] - 0.2};
            double[] yd = {depths[i] - 3, depths[i], depths[i] + 3, depths[i]};
            if (Objects.equals(types[i], "pmag")) {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledPolygon(xd, yd);
                StdDraw.setPenRadius(0.0025);
                StdDraw.setPenColor(StdDraw.DARK_GRAY);
                StdDraw.polygon(xd, yd);
            } else if (Objects.equals(types[i], "nanno")) {
                StdDraw.setPenColor(StdDraw.CYAN);
                StdDraw.filledPolygon(xd, yd);
                StdDraw.setPenRadius(0.0025);
                StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                StdDraw.polygon(xd, yd);
            } else if (Objects.equals(types[i], "foram")) {
                StdDraw.setPenColor(StdDraw.ORANGE);
                StdDraw.filledPolygon(xd, yd);
                StdDraw.setPenRadius(0.0025);
                StdDraw.setPenColor(StdDraw.BOOK_RED);
                StdDraw.polygon(xd, yd);
            }
        }
//plotting axes
        //printing horizontal axis
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(xMin, 0, xMax, 0);

        //printing tick marks on horizontal axis
        for (int i = (int) xMin; i <= xMax; i++)
            StdDraw.line(i, 0, i, -(verticalMargin / 10));

        //printing tick mark labels on horizontal axis
        for (int i = (int) xMin; i <= xMax; i++)
            StdDraw.text(i, -(verticalMargin * 0.4), String.valueOf(i));

        //printing horizontal axis label
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text((xMin + xMax) / 2, -verticalMargin, "Age (Ma, GTS2012)");

        //vertical axis
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(xMin, 0, xMin, yMax);

        //tick marks on vertical axis
        for (int i = 0; i <= yMax; i++) {
            if (i % 10 == 0)
                StdDraw.line(xMin, i, xMin - (horizontalMargin / 10), i);
        }

        //printing tick mark labels on vertical axis
        for (int i = 0; i <= yMax; i++) {
            if (i % 10 == 0)
                StdDraw.text(xMin - (horizontalMargin * 0.75), i, String.valueOf(i));
        }

        //printing vertical axis label
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(xMin - horizontalMargin * 1.5, yMax / 2, "Depth (cmbsf)", 90);

        //printing plot title centered relative to horizontal axis
        String plotTitle = "Age vs depth plot for Hole ";
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text((xMin + xMax) / 2, yMin - (verticalMargin * 2.5), plotTitle + site.siteNumber + site.hole);

        /*
        //plotting tiepoint labels
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < depths.length; i++)
            StdDraw.text(ages[i] + 1.1, depths[i] - 4, labels[i]);
         */
    }
}
