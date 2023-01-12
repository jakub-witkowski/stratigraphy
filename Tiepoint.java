public class Tiepoint {
    private String name; // ogólna nazwa punktu węzłowego
    String type; // pmag, nannofossil, etc.
    String label; // szczegółowa nazwa punktu węzłowego
    double minDepth; // upper depth range (mbsf, cmbsf, etc.)
    double maxDepth; // lower depth range (mbsf, cmbsf, etc.)
    double age; // age in million years ago

    public Tiepoint(String name, String type, String label, double minDepth, double maxDepth, double age) {
        this.name = name;
        this.type = type;
        this.label = label;
        this.minDepth = minDepth;
        this.maxDepth = maxDepth;
        this.age = age;
    }

    public static double averageDepth(double minDepth, double maxDepth) {
        return (minDepth + maxDepth) / 2;
    }

    public static double interpolate(double tiePointDepth1, double tiePointAge1, double tiePointDepth2,
                                     double tiePointAge2, double sampleDepth) {
        double slope = (tiePointDepth2 - tiePointDepth1) / (tiePointAge2 - tiePointAge1);
        double intercept = -(slope * tiePointAge1) + tiePointDepth1;
        double sampleAge = (sampleDepth - intercept) / slope;
        return Math.round(sampleAge * 100) / 100.00;
    }

}
