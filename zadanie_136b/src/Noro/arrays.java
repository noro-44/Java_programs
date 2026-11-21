package Noro;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.io.*;

public class arrays
{
    /*------------------------------------------------------------------------*/
    /** Заполняет одномерный действительный массив случайными числами в диапазоне [op; en]
     * @param n длина одномерного массива (количество элементов)
     * @param op начало диапазона
     * @param en конец диапазона
     * @return одномерный действительный массив
     **/
    public static double[] rand_double_arr(int n, double op, double en)
    {
        double[] a = new double[n];

        Random rand = new Random();

        if (op > en)
        {
            double temp = op;
            op = en;
            en = temp;
        }
        for (int i = 0; i < n; i += 1)
        {
            a[i] = (op + rand.nextDouble() * (en - op));
            //вариация nextDouble(min, max)
            //a[i] = rand.nextDouble(op, en);
        }

        return a;
    }
    /*------------------------------------------------------------------------*/
    /** Заполняет одномерный действительный ArrayList случайными числами в диапазоне [op; ed]
     * @param b одномерный ArrayList
     * @param op начало диапазона
     * @param en конец диапазона
     **/
    public static void rand_double_arr(ArrayList<Double> b, double op, double en)
    {

        Random rand = new Random();

        int n = b.size();
        //ArrayList<Double> b = new ArrayList<Double>(n);

        if (op > en)
        {
            double temp = op;
            op = en;
            en = temp;
        }
        for (int i = 0; i < n; i += 1)
        {
            //.add(индекс, элемент) добавляет элемент по индексу
            //вариация .add(элемент) добавляет элемент в конец массива
            b.set(i, (op + rand.nextDouble() * (en - op)));
            //b.add(i, rand.nextDouble(op, en));
        }
    }
    /*------------------------------------------------------------------------*/
    /** Вычисляет произведение всех членов одномерного действительнго массива
     * @param n длина одномерного массива (количество элементов)
     * @param a одномерный массив
     * @return произведение всех элементов массива a
     **/
    public static double product_double_arr(int n, double[] a)
    {
        double comp = 1.0;
        for (int y = 0; y < n; y += 1)
        {
            comp *= a[y];
        }
        return comp;
    }    /*------------------------------------------------------------------------*/
    /** Вычисляет произведение всех членов одномерного действительнго ArrayList
     * @param b одномерный ArrayList
     * @return произведение всех элементов массива b
     **/
    public static double product_double_arr(ArrayList<Double> b)
    {
        int n = b.size();
        double comp = 1.0;
        for (int y = 0; y < n; y += 1)
        {
            //.get(индекс) возвращает элемент по заданному индексу
            comp *= b.get(y);
        }
        return comp;
    }
    /*------------------------------------------------------------------------*/
    /** Выводит на экран одномерный действительный массив по l элементов в каждой
     * @param n количество элементов в массиве
     * @param a одномерный массив действительных чисел
     * @param l количество элементов в одной строке
     **/
    public static void print_double_arr(int n, double[] a, int l) //
    {
        for (int j = 0; j < n; j += 1)
        {
            if (j % l == 0)
            {
                System.out.printf("\n");
            }
            System.out.printf("%8.4f  ", a[j]);
        }
    }
    /*------------------------------------------------------------------------*/
    /** Выводит на экран одномерный действительный ArrayList по l элементов в каждой
     * @param b одномерный ArrayList действительных чисел
     * @param l количество элементов в одной строке
     **/
    public static void print_double_arr(ArrayList<Double> b, int l) //
    {
        int n = b.size();
        for (int j = 0; j < n; j += 1)
        {
            if (j % l == 0)
            {
                System.out.printf("\n");
            }
            System.out.printf("%8.4f  ", b.get(j)); //.get(индекс) возвращает элемент по заданному индексу
        }
    }
    /*------------------------------------------------------------------------*/
    /** Считывает одномерный действительный массив из текстового файла
     * @param text текстовый файл
     * @param namae имя файла
     * @param n количество элементов в массиве
     * @param a одномерный массив действительных чисел
     */
    public static double[] read_double_arr_from_text_file(String namae) {
        File text = new File(namae);

        //определение количества чисел в файле
        int n = 0;
        Scanner scan = null;
        try {
            scan = new Scanner(text);
            scan.useLocale(Locale.US);
            while (scan.hasNextDouble()) {
                scan.nextDouble();
                n += 1;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + namae);
        } finally {
            //закрытие файла
            if (scan != null) {
                scan.close();       // закрывается первый Scanner
            }
        }
        double[] a = new double[n];

        Scanner read = null;
        try {
            read = new Scanner(text);
            read.useLocale(Locale.US);

            for (int i = 0; i < n; i += 1) {
                if (read.hasNextDouble()) {
                    a[i] = read.nextDouble();
                } else {
                    System.err.printf("Файл %s содержит меньше %d чисел%n", namae, n);
                    return new double[0];
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + namae);
        } finally {
            if (read != null) {
                read.close();             // закрывается второй Scanner
            }
        }

        return a;
    }
    /*------------------------------------------------------------------------*/
    /** Считывает одномерный действительный ArrayList из текстового файла
     * @param text текстовый файл
     * @param namae имя файла
     * @param b одномерный ArrayList действительных чисел
     */
    public static void read_double_arr_from_text_file(File text, String namae, ArrayList<Double> b) {
        //
    }
    /*------------------------------------------------------------------------*/
    /** Считывает одномерный действительный массив из бинарного файла
     * @param bin бинарный файл
     * @param namae имя файла
     * @param n количество элементов в массиве
     * @param a одномерный массив действительных чисел
     */
    public static void read_double_arr_from_bin_file(File bin, String namae, int n, double[] a) {
        //
    }
    /*------------------------------------------------------------------------*/
    /** Считывает одномерный действительный ArrayList из бинарного файла
     * @param bin бинарный файл
     * @param namae имя файла
     * @param b одномерный ArrayList действительных чисел
     */
    public static void read_double_arr_from_bin_file(File bin, String namae, ArrayList<Double> b) {
        //
    }
    /*------------------------------------------------------------------------*/
    /** Выводит одномерный действительный массив в текстовый файл
     * @param text текстовый файл
     * @param namae имя файла
     * @param n количество элементов в массиве
     * @param a одномерный массив действительных чисел
     */
    public static void print_double_arr_for_text_file(File text, String namae, int n, double[] a) {
        //
    }
    /*------------------------------------------------------------------------*/
    /** Выводит одномерный действительный ArrayList в текстовый файл
     * @param text текстовый файл
     * @param namae имя файла
     * @param b одномерный ArrayList действительных чисел
     */
    public static void print_double_arr_for_text_file(File text, String namae, ArrayList<Double> b) {
        //
    }
    /*------------------------------------------------------------------------*/
    /** Выводит одномерный действительный массив в бинарный файл
     * @param bin бинарный файл
     * @param namae имя файла
     * @param n количество элементов в массиве
     * @param a одномерный массив действительных чисел
     */
    public static void print_double_arr_for_bin_file(File bin, String namae, int n, double[] a) {
        //
    }
    /*------------------------------------------------------------------------*/
    /** Выводит одномерный действительный ArrayList в бинарный файл
     * @param bin бинарный файл
     * @param namae имя файла
     * @param b одномерный ArrayList действительных чисел
     */
    public static void print_double_arr_for_bin_file(File bin, String namae, ArrayList<Double> b) {
        //
    }
    /*------------------------------------------------------------------------*/
}
