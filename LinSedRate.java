public class LinSedRate {
    public static double estimateLinSedRate(double deeperDepth, double shallowerDepth, double olderAge, double youngerAge) {
        return (deeperDepth - shallowerDepth) * 100 / (olderAge - youngerAge) * 1000;
    }
}
