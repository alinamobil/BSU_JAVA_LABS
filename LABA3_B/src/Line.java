

import java.text.MessageFormat;
import java.util.Objects;


public final class Line {


    private Fraction a;
    private Fraction b;
    private Fraction c;

    public Fraction getA() {
        return a;
    }

    public Fraction getB() {
        return b;
    }

    public Fraction getC() {
        return c;
    }

    public void setA(Fraction a) {
        this.a = a;
    }

    public void setB(Fraction b) {
        this.b = b;
    }

    public void setC(Fraction c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return a + "x+" + b + "y+" + c + "=0";
    }

    public Line(Fraction a, Fraction b, Fraction c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Fraction divide(Fraction f1, Fraction f2) {
        Fraction end = new Fraction(0, 1);
        end.setnum((-1)*f1.num * f2.den);
        end.setden(f1.den * f2.num);
        return end;
    }

    public Point getIntersectionWithAxis(Axis axis) {
        Args.notNull(axis, "axis");

        switch (axis) {
            case X_AXIS:
                return new Point(divide(c, a), new Fraction(0, 0));
            case Y_AXIS:
                return new Point( new Fraction(0, 0),divide(c, b));
            default:
                throw new AssertionError("Axis not supported: " + axis);
        }
    }
}

