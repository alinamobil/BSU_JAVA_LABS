package payment;
import java.util.Scanner;
public class Payment
{
    Scanner in=new Scanner(System.in);
    Payment() {}
    public class title {
        String record[];
        int kol;
        String new_title;

        title() {
        }

        void input() {
            System.out.println("Введите название магазина: ");
            new_title = in.nextLine();
        }

        void write() {
            System.out.println("Сколько товаров вы хотите приобрести? ");
            kol = in.nextInt();
            kol++;
            record = new String[kol];
            System.out.println("Введите название товара для покупки в магазине " + new_title+":");
            for (int i = 0; i < kol; i++) {
                record[i] = in.nextLine();
            }
        }

        void view() {
            System.out.println("Покупки в магазине " + new_title + ":");
            for (int i = 0; i < kol; i++) {
                System.out.println(record[i]);
            }
        }
    }
    void runInnerClass()
    {
        title a=new title();
        a.input();
        a.write();
        a.view();
    }
}