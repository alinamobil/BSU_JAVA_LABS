import java.util.Scanner;

public class Input {
    public static void in(Line[] lines, int n, Scanner in) {
        for (int i = 0; i < n; i++) {
            Fraction[] fill = new Fraction[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("Введите числитель и знаменатель " + (j + 1) + " коэффицента: ");
                int a = in.nextInt();
                int b = in.nextInt();
                while (b == 0) {
                    System.out.print("Знаменатель не можеть быть равен 0, введите другое число: ");
                    b = in.nextInt();
                }
                fill[j] = new Fraction(a, b);
            }
            lines[i] = new Line(fill[0], fill[1], fill[2]);
        }
    }
}

