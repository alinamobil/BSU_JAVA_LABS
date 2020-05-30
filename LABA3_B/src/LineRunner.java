import java.util.Scanner;

public class LineRunner { // пересечение 2 прямых

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество прямых: ");
        int n = in.nextInt();
        //Line b = new Line(new Fraction(1, 6), new Fraction(1, 5), new Fraction(1, 8));
        Line[] lines = new Line[n];
        Input.in(lines, n, in);
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " линия: "+lines[i]);
            System.out.println("Пересечение с Ох и Оу: ");
            System.out.println(lines[i].getIntersectionWithAxis(Axis.X_AXIS));
            System.out.println(lines[i].getIntersectionWithAxis(Axis.Y_AXIS));
        }
        Operations.Intersection(lines, n ,in);
        Operations.Parallel(lines,n,in);
        //System.out.println(a.isParallel(b));
    }
}

