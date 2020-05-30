package main;

import student.Abiturient;
import student.zaochnik;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Abiturient[] mas = new Abiturient[]{new zaochnik("Иванов", "Павел", 2, 4, "Дневная"), new zaochnik ("Славутина", "Дарья", 1, 9, "Заочная"), new zaochnik("Васечкин", "Антон", 3, 10, "Дневная"), new zaochnik("Горинятенко", "Евгений", 4, 2, "Заочная"), new zaochnik("Косьмина", "Юлия", 2, 6, "Дневная")};
        Scanner in = new Scanner(System.in);

        while(true) {
            label37:
            while(true) {
                System.out.println("Выберите критерий поиска:\n1)По фамилии\n2)По курсу\n3)По форме ообучения\n4)Выход");
                int p = in.nextInt();
                String temp1;
                int temp2;
                Abiturient[] var5;
                int var6;
                int var7;
                Abiturient ma;
                switch(p) {
                    case 1:
                        System.out.print("Введите фамилию: ");
                        in.nextLine();
                        temp1 = in.nextLine();
                        System.out.println("\n------------------------------");
                        var5 = mas;
                        var6 = mas.length;
                        var7 = 0;

                        while(true) {
                            if (var7 >= var6) {
                                continue label37;
                            }

                            ma = var5[var7];
                            ma.searchBySurname(temp1);
                            ++var7;
                        }
                    case 2:
                        System.out.print("Введите курс: ");
                        temp2 = in.nextInt();
                        System.out.println("\n------------------------------");
                        var5 = mas;
                        var6 = mas.length;
                        var7 = 0;

                        while(true) {
                            if (var7 >= var6) {
                                continue label37;
                            }

                            ma = var5[var7];
                            ma.searchByCourse(temp2);
                            ++var7;
                        }
                    case 3:
                        System.out.print("Введите форму обучения(Заочная или Дневная):");
                        in.nextLine();
                        temp1 = in.nextLine();
                        System.out.println("\n------------------------------");
                        var5 = mas;
                        var6 = mas.length;
                        var7 = 0;

                        while(true) {
                            if (var7 >= var6) {
                                continue label37;
                            }

                            ma = var5[var7];
                            ma.searchType(temp1);
                            ++var7;
                        }
                    case 4:
                        System.exit(0);
                }
            }
        }
    }
}
