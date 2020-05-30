public final class Point {

    private Fraction x;
    private Fraction y;

    public Point(Fraction x, Fraction y) {
        this.x = x;
        this.y = y;
    }


    public static Point of(Fraction x, Fraction y) {
        return new Point(x, y);
    }

    public Fraction getX() {
        return x;
    }

    public Fraction getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

