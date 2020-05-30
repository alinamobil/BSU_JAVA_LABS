public final class DoubleUtils {

    private DoubleUtils() {
    }

    public static boolean doubleEquals(double a, double b, double precision) {
        return Math.abs(a - b) < precision;
    }
}
