import java.util.Scanner;

public class Operations { //Определить точки пересечения прямой с осями координат
    public static void Intersection(Line[] lines, int n, Scanner in) {
        System.out.println("Выберите две прямые: ");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " линия: " + lines[i]);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        Point p;
        Fraction det = Det(lines[a - 1].getA(), lines[a - 1].getB(), lines[b - 1].getA(), lines[b - 1].getB());
        if (det.getnum() == 0) {
            System.out.println("Пересечений нет");
        } else {
            Fraction x = Det(lines[a - 1].getC(), lines[a - 1].getB(), lines[b - 1].getC(), lines[b - 1].getB());
            x = x.divide(x, det);
            x = x.invert();
            Fraction y = Det(lines[a - 1].getA(), lines[a - 1].getC(), lines[b - 1].getA(), lines[b - 1].getC());
            y = y.divide(y, det);
            y = y.invert();
            p = new Point(x, y);
            System.out.println("Прямые " + lines[a - 1] + " и " + lines[b - 1] + " пересекаются в точке " + p);
        }

    }

    public static void Parallel(Line[] lines, int n, Scanner in) {  //определить группы параллельных прямых
        for (int i=0; i<n; i++){
            System.out.println("Прямые, параллельные прямой "+lines[i]+" :");
            for(int j=0; j<n; j++){
                if (Det(lines[i].getA(), lines[i].getB(), lines[j].getA(), lines[j].getB()).getnum()==0&&i!=j){
                    System.out.println(lines[j]);
                }
            }
        }
    }

    private static int NOD(int n1, int n2) {
        int div;
        if (n1 == n2) return n1;
        int d = n1 - n2;
        if (d < 0) {
            d = -d;
            div = NOD(n1, d);
        } else
            div = NOD(n2, d);
        return div;
    }

    private static int NOK(int d, Fraction f2) {
        return d * f2.getden() / NOD(d, f2.getden());
    }

    private static int NumiratorDifference(int n, int m, Fraction f2) {
        int det = NOK(m, f2);
        int num = n * (det / m) - f2.getnum() * (det / f2.getden());
        return num;
    }

    private static int DeterminatorDifference(int m, Fraction f2) {
        int det = NOK(m, f2);
        return det;
    }

    private static Fraction Det(Fraction a, Fraction b, Fraction c, Fraction d) {
        Fraction f1 = new Fraction(0, 1);
        Fraction f2 = new Fraction(0, 1);
        f1.setnum(a.getnum() * d.getnum());
        f1.setden(a.getden() * d.getden());
        f2.setnum(b.getnum() * c.getnum());
        f2.setden(b.getden() * c.getden());
        Fraction end = new Fraction(NumiratorDifference(f1.getnum(), f1.getden(), f2), DeterminatorDifference(f1.getden(), f2));
        return end;
    }
}

