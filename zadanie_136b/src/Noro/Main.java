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
import java.lang.String;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        //assert работают только при запуске JVM с параметром -ea
        //проверки для массива
        assert((Math.abs(arrays.product_double_arr(4, new double[]{1.0, 2.0, 3.0, 4.0}) - 24.0)) <= 1e-9): "ошибка в вычислении функции arrays.product_double_arr()";
        assert((Math.abs(arrays.product_double_arr(2, new double[]{-2.0, 5.0}) - -10.0)) <= 1e-9): "ошибка в вычислении функции arrays.product_double_arr()";
        assert((Math.abs(arrays.product_double_arr(1, new double[]{1.0}) - 1.0)) <= 1e-9): "ошибка в вычислении функции arrays.product_double_arr()";
        assert((Math.abs(arrays.product_double_arr(3, new double[]{2.0, -4.0, 0.0}) - 0.0)) <= 1e-9): "ошибка в вычислении функции arrays.product_double_arr()";
        //проверки для ArrayList
        assert((Math.abs(arrays.product_double_arrlist(new ArrayList<>(List.of(1.0, 2.0, 3.0, 4.0))) - 24.0)) <= 1e-9): "ошибка в вычислении функции arrays.product_double_arr()";
        assert((Math.abs(arrays.product_double_arrlist(new ArrayList<>(List.of(-2.0, 5.0))) - -10.0)) <= 1e-9): "ошибка в вычислении функции arrays.product_double_arr()";
        assert((Math.abs(arrays.product_double_arrlist(new ArrayList<>(List.of(1.0))) - 1.0)) <= 1e-9): "ошибка в вычислении функции arrays.product_double_arr()";
        assert((Math.abs(arrays.product_double_arrlist(new ArrayList<>(List.of(2.0, -4.0, 0.0))) - 0.0)) <= 1e-9): "ошибка в вычислении функции arrays.product_double_arr()";

        int n = 0;
        double[] a;
        ArrayList<Double> b;

        //если при запуске были переданы аргументы
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("--help")) {
                System.out.println("Справка по использованию:\n" +
                        "Для вычисления произведения всех элементов одномерного массива действительных чисел: \n" +
                        "  java Noro.Main <количество_элементов> <первый_элемент> .. <последний_элемент>\n" +
                        "  java Noro.Main <имя_файла>\n" +
                        "Для вывода справки: \n" +
                        "  java Noro.Main help  \n" +
                        "  java Noro.Main --help\n" +
                        "Пример использования:\n" +
                        "  java Noro.Main 4 3.1 5.8 9.33 -2.0\n" +
                        "  java Noro.Main tch.txt\n" +
                        "  java Noro.Main 'tch.txt'\n" +
                        "  java Noro.Main \"tch.bin\"");
                return;
            }

            if (args.length == 1) {
                try {
                    String fnamae = args[0];
                    a = arrays.read_double_arr_from_text_file(fnamae);
                    n = a.length;
                    //b = arrays.read_double_arrlist_from_text_file(fnamae);
                    //n = b.size();
                } catch (FileNotFoundException er) {
                    System.err.println(er.getMessage());
                    return;
                } catch (arrays.EmptyFileException er) {
                    System.err.println(er.getMessage());
                    return;
                } catch (IOException er) {
                    System.err.println("Ошибка чтения: " + er.getMessage());
                    return;
                }

            } else {

                if (args.length != Double.parseDouble(args[0]) + 1) {
                    throw new IllegalArgumentException("Ожидается " + Double.parseDouble(args[0]) + 1 + " аргументов: количество элементов и сами элементы массива. Для подсказки используйте help или --help.");
                }

                try {
                    n = Integer.parseInt(args[0]);
                } catch (NumberFormatException er) {
                    throw new NumberFormatException("Некорректное значение: " + args[0]);
                }

                //создание массива
                a = new double[n];
                //заполнение массива аргумаентами из командной строки
                for (int w = 0; w < n; w += 1) {
                    a[w] = Double.parseDouble(args[w + 1]);
                }
                /*
                //создание ArrayList
                 b = new ArrayList<Double>(n);
                //заполнение ArrayList аргументами из командной строки
                for (int w = 0; w < n; w += 1) {
                    b.add(Double.parseDouble(args[w+1]));
                }
                */
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
            a = new double[n];
            a = arrays.rand_double_arr(n, -90.0, 90.0);

            /*
            //ArrayList задать случайными числами
            b = new ArrayList<Double>(n);
            //заполнение ArrayList нулями (чтобы задать размерность size и не передавать её как аргумент в функци)
            for (int i = 0; i < n; i += 1) {
                b.add(0.0);
            }
            b = arrays.rand_double_arrlist(n, -90.0, 90.0);
            */

            /*
            //массив задать из текстового файла
            a = arrays.read_double_arr_from_text_file("tch.txt");
            n = a.length;
            */

            /*
            //Arraylist задать из текстового файла
            b = arrays.read_double_arrlist_from_text_file("tch.txt");
            n = b.size();
            */

            /*
            //массив задать из бинарного файла
            a = arrays.read_double_arr_from_bin_file("tch.bin");
            n = a.length;
            */

            /*
            //ArrayList задать из бинарного файла
            b = arrays.read_double_arrlist_from_bin_file("tch.bin");
            n = b.size();
            */
        }

        arrays.print_double_arr(n, a, 10);
        //arrays.print_double_arrlist(b, 10);

        double p = arrays.product_double_arr(n, a);
        //double p = arrays.product_double_arrlist(b);
        System.out.printf("\nПроизведение всех членов последовательности:\n%.4f\n", p);
    }
}
