public class TestTiepoint {
    public static void main(String[] args) {

        int tiepointCount = 0;

        //Site site = new Site("1050", "A,C");

        Tiepoint tiepoint0 = new Tiepoint(0, "pmag", "B C19n", 4.2, 11.23, 41.39);
        tiepointCount++;

        Tiepoint tiepoint1 = new Tiepoint(1, "pmag", "B C19r", 24.14, 26.41, 42.30);
        tiepointCount++;

        Tiepoint tiepoint2 = new Tiepoint(2, "pmag", "B C20n", 61.62, 62.19, 43.43);
        tiepointCount++;

        Tiepoint tiepoint3 = new Tiepoint(3, "pmag", "B C20r", 137.27, 140.28, 45.72);
        tiepointCount++;

        Tiepoint tiepoint4 = new Tiepoint(4, "pmag", "B C21n", 151.603, 153.190, 47.35);
        tiepointCount++;

        Tiepoint tiepoint5 = new Tiepoint(5, "nanno", "B NP14a", 151.603, 153.190, 49.11);
        tiepointCount++;

        Tiepoint tiepoint6 = new Tiepoint(6, "pmag", "B C22n", 153.71, 154.43, 49.34);
        tiepointCount++;

        Tiepoint tiepoint7 = new Tiepoint(7, "pmag", "T C23n", 182.657, 183.359, 50.63);
        tiepointCount++;

        Tiepoint tiepoint8 = new Tiepoint(8, "nanno", "B C. crassus", 193.2, 194.64, 51.64);
        tiepointCount++;

        Tiepoint tiepoint9 = new Tiepoint(9, "nanno", "B NP12", 193.2, 194.64, 53.7);
        tiepointCount++;

        Tiepoint tiepoint10 = new Tiepoint(10, "pmag", "B C24n", 198.37, 199.08, 53.98);
        tiepointCount++;

        Tiepoint tiepoint11 = new Tiepoint(11, "pmag", " ", 198.37, 199.08, 53.98); // repeat last tiepoint
        tiepointCount++;
        
        double depths[] = new double[tiepointCount];
        depths[tiepoint0.id] = Tiepoint.averageDepth(tiepoint0.minDepth, tiepoint0.maxDepth);
        depths[tiepoint1.id] = Tiepoint.averageDepth(tiepoint1.minDepth, tiepoint1.maxDepth);
        depths[tiepoint2.id] = Tiepoint.averageDepth(tiepoint2.minDepth, tiepoint2.maxDepth);
        depths[tiepoint3.id] = Tiepoint.averageDepth(tiepoint3.minDepth, tiepoint3.maxDepth);
        depths[tiepoint4.id] = Tiepoint.averageDepth(tiepoint4.minDepth, tiepoint4.maxDepth);
        depths[tiepoint5.id] = Tiepoint.averageDepth(tiepoint5.minDepth, tiepoint5.maxDepth);
        depths[tiepoint6.id] = Tiepoint.averageDepth(tiepoint6.minDepth, tiepoint6.maxDepth);
        depths[tiepoint7.id] = Tiepoint.averageDepth(tiepoint7.minDepth, tiepoint7.maxDepth);
        depths[tiepoint8.id] = Tiepoint.averageDepth(tiepoint8.minDepth, tiepoint8.maxDepth);
        depths[tiepoint9.id] = Tiepoint.averageDepth(tiepoint9.minDepth, tiepoint9.maxDepth);
        depths[tiepoint10.id] = Tiepoint.averageDepth(tiepoint10.minDepth, tiepoint10.maxDepth);
        depths[tiepoint11.id] = Tiepoint.averageDepth(tiepoint11.minDepth, tiepoint11.maxDepth);

        System.out.print(depths[10]);
    }
}
