package Noro;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 0;

        //если при запуске были переданы аргументы
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("--help")) {
                System.out.println("Справка по использованию:\n" +
                        "Для вычисления произведения всех элементов одномерного массива действительных чисел: \n" +
                        "  java Noro.Main <количество_элементов_массива>\n" +
                        "Для вывода справки: \n" +
                        "  java Noro.Main help  \n" +
                        "  java Noro.Main --help\n" +
                        "Пример использования:\n" +
                        "  java Noro.Main 4");
                return;
            }

            if (args.length != 1) {
                throw new IllegalArgumentException("Ожидается один аргумент: количество элементов массива. Для подсказки используйте help или --help.");
            }

            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException er) {
                throw new NumberFormatException("Некорректное значение: " + args[0]);
            }
        }
        //если при запуске не были переданы аргументы - запросить у пользователя
        else {
            Scanner scan = new Scanner(System.in);

            System.out.print("Введите количество элементов массива: ");
            String ni = scan.next();
            try {
                n = Integer.parseInt(ni);
            } catch (NumberFormatException er) {
                throw new NumberFormatException("Некорректное значение: " + ni);
            }
        }

        double[] a = new double[n];

        arrays.rdarr(n, a, -5.0, 5.0);

        for (int j = 0; j < n; j += 1){ //вывод массива на экран
            System.out.printf("%.4f  ", a[j]);
        }
        double p = arrays.comdarr(n, a);
        System.out.printf("\nПроизведение всех членов последовательности: %.4f\n", p);
    }
}
