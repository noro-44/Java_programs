package Noro;

/*
Задача: Задачник БГУ, глава 6, задание 136б;
Текст задачи: Даны натуральное число n, действительные числа a1,..., an.
Вычислить: б) a1 * a2 * ... * an;
*/

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //assert работают только при запуске JVM с параметром -ea
        assert((Math.abs(arrays.comp_double_arr(4, List.of(1.0, 2.0, 3.0, 4.0)) - 24.0)) <= 1e-9): "ошибка в вычислении функции arrays.comp_double_arr()";
        assert((Math.abs(arrays.comp_double_arr(2, List.of(-2.0, 5.0)) - -10.0)) <= 1e-9): "ошибка в вычислении функции arrays.comp_double_arr()";
        assert((Math.abs(arrays.comp_double_arr(1, List.of(1.0)) - 1.0)) <= 1e-9): "ошибка в вычислении функции arrays.comp_double_arr()";
        assert((Math.abs(arrays.comp_double_arr(3, List.of(2.0, -4.0, 0.0)) - 0.0)) <= 1e-9): "ошибка в вычислении функции arrays.comp_double_arr()";

        int n = 0;
        List<Double> a;

        //если при запуске были переданы аргументы
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("--help")) {
                System.out.println("Справка по использованию:\n" +
                        "Для вычисления произведения всех элементов одномерного массива действительных чисел: \n" +
                        "  java Noro.Main <количество_элементов> <первый_элемент> .. <последний_элемент>\n" +
                        "Для вывода справки: \n" +
                        "  java Noro.Main help  \n" +
                        "  java Noro.Main --help\n" +
                        "Пример использования:\n" +
                        "  java Noro.Main 4 3.1 5.8 9.33 -2.0");
                return;
            }

            if (args.length != Double.parseDouble(args[0])+1) {
                throw new IllegalArgumentException("Ожидается " + Double.parseDouble(args[0])+1  + " аргументов: количество элементов и сами элементы массива. Для подсказки используйте help или --help.");
            }

            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException er) {
                throw new NumberFormatException("Некорректное значение: " + args[0]);
            }
            a = new ArrayList<Double>(n);
            for (int w = 0; w < n; w += 1){
                a.add(w, Double.parseDouble(args[w+1]));
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
            //массив задать случайными числами
            a = new ArrayList<Double>(n);
            arrays.rand_double_arr(n, a, -90.0, 90.0);
        }

        arrays.print_double_arr(n, a, 10);

        double p = arrays.comp_double_arr(n, a);
        System.out.printf("\nПроизведение всех членов последовательности: %.4f\n", p);
    }
}
