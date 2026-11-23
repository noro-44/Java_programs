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
    //Собственное исключение для «пустого» файла
    public static class EmptyFileException extends IOException {
        public EmptyFileException(String namae) {
            super("Файл \"" + namae + "\" не содержит чисел");
        }
    }
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
            //rand.nextDouble() возвращает случайное число в диапазоне [0.0; 1.0)
            //умножение на длину заданного диапазона (op - en) позволяет сдвинуть диапазон на значение длины
            //прибавление начала диапазона op позволяет сдвинуть диапазон на значение начала диапазона, тем самым образовывая необходимый диапазон
            a[i] = (op + rand.nextDouble() * (en - op));
            //вариация nextDouble(min, max)
            //a[i] = rand.nextDouble(op, en);
        }

        return a;
    }
    /*------------------------------------------------------------------------*/
    /** Заполняет одномерный действительный ArrayList случайными числами в диапазоне [op; ed]
     * @param n количество элементов ArrayList
     * @param op начало диапазона
     * @param en конец диапазона
     * @return b одномерный ArrayList
     **/
    public static ArrayList<Double> rand_double_arrlist(int n, double op, double en)
    {

        Random rand = new Random();

        //int n = b.size();
        ArrayList<Double> b = new ArrayList<Double>(n);

        if (op > en)
        {
            double temp = op;
            op = en;
            en = temp;
        }

        //rand.nextDouble() возвращает случайное число в диапазоне [0.0; 1.0)
        //умножение на длину заданного диапазона (op - en) позволяет сдвинуть диапазон на значение длины
        //прибавление начала диапазона op позволяет сдвинуть диапазон на значение начала диапазона, тем самым образовывая необходимый диапазон
        //.add(индекс, элемент) добавляет элемент по индексу
        //вариация .add(элемент) добавляет элемент в конец массива
        b.add((op + rand.nextDouble() * (en - op)));

        return b;
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
    public static double product_double_arrlist(ArrayList<Double> b)
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
    public static void print_double_arrlist(ArrayList<Double> b, int l) //
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
     * @param namae имя файла
     * @return a одномерный массив действительных чисел
     * @throws FileNotFoundException файла нет
     * @throws EmptyFileException в файле не оказалось чисел
     * @throws IOException любая другая ошибка ввода-вывода
     */
    public static double[] read_double_arr_from_text_file(String namae) throws IOException {
        File text = new File(namae);

        //проверка: был ли найден файл с именем namae
        if (!text.isFile()) {
            throw new FileNotFoundException("Файл не найден: " + namae);
        }

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
                    throw new EmptyFileException(namae);
                }
            }

        } finally {
            if (read != null) {
                read.close();             // закрывается второй Scanner
            }
        }

        return a;
    }
    /*------------------------------------------------------------------------*/
    /** Считывает одномерный действительный ArrayList из текстового файла
     * @param namae имя файла
     * @return b одномерный ArrayList действительных чисел
     * @throws FileNotFoundException файла нет
     * @throws EmptyFileException в файле не оказалось чисел
     * @throws IOException любая другая ошибка ввода-вывода
     */
    public static ArrayList<Double> read_double_arrlist_from_text_file(String namae) throws IOException {
        File text = new File(namae);

        //проверка: был ли найден файл с именем namae
        if (!text.isFile()) {
            throw new FileNotFoundException("Файл не найден: " + namae);
        }

        ArrayList<Double> b = new ArrayList<Double>(1);

        Scanner read = null;
        try {
            read = new Scanner(text);
            read.useLocale(Locale.US);

            while (read.hasNextDouble()) {
                b.add(read.nextDouble());
            }
            if (b.isEmpty()) {
                throw new EmptyFileException(namae);
            }

        } finally {
            if (read != null) {
                read.close();             // закрывается Scanner
            }
        }

        return b;
    }
    /*------------------------------------------------------------------------*/
    /** Считывает одномерный действительный массив из бинарного файла
     * @param namae имя файла
     * @return a одномерный массив действительных чисел
     * @throws FileNotFoundException файла нет
     * @throws EmptyFileException в файле не оказалось чисел
     * @throws IOException любая другая ошибка ввода-вывода
     */
    public static double[] read_double_arr_from_bin_file(String namae) throws IOException {
        File bin = new File(namae);

        //проверка: был ли найден файл с именем namae
        if (!bin.isFile()) {
            throw new FileNotFoundException("Файл не найден: " + namae);
        }

        // определение количества чисел в файле
        int n = 0;
        DataInputStream scan = null;
        try {
            scan = new DataInputStream(new BufferedInputStream(new FileInputStream(bin)));

            while (true) {
                try {
                    scan.readDouble();
                    n += 1;
                } catch (EOFException e) {
                    break;
                }
            }
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        double[] a = new double[n];

        DataInputStream read = null;
        try {
            read = new DataInputStream(new BufferedInputStream(new FileInputStream(bin)));

            for (int i = 0; i < n; i += 1) {
                try {
                    a[i] = read.readDouble();
                } catch (EOFException e) {
                    throw new EmptyFileException(namae);
                }
            }
        } finally {
            if (read != null) {
                read.close();
            }
        }

        return a;
    }
    /*------------------------------------------------------------------------*/
    /** Считывает одномерный действительный ArrayList из бинарного файла
     * @param namae имя файла
     * @return b одномерный ArrayList действительных чисел
     * @throws FileNotFoundException файла нет
     * @throws EmptyFileException в файле не оказалось чисел
     * @throws IOException любая другая ошибка ввода-вывода
     */
    public static ArrayList<Double> read_double_arrlist_from_bin_file(String namae) throws IOException {
        File bin = new File(namae);

        // проверка: был ли найден файл с именем namae
        if (!bin.isFile()) {
            throw new FileNotFoundException("Файл не найден: " + namae);
        }

        ArrayList<Double> b = new ArrayList<Double>(1);

        DataInputStream read = null;
        try {
            read = new DataInputStream(new BufferedInputStream(new FileInputStream(bin)));

            while (true) {
                try {
                    b.add(read.readDouble());
                } catch (EOFException e) {
                    break;
                }
            }

            if (b.isEmpty()) {
                throw new EmptyFileException(namae);
            }

        } finally {
            if (read != null) {
                read.close();
            }
        }

        return b;
    }
    /*------------------------------------------------------------------------*/
    /** Выводит одномерный действительный массив в текстовый файл
     * @param namae имя файла
     * @param a одномерный массив действительных чисел
     * @throws IOException любая ошибка записи
     */
    public static void print_double_arr_for_text_file(String namae, double[] a) throws IOException {
        PrintWriter write = null;

        int n = a.length;
        try {
            write = new PrintWriter(new FileWriter(namae));

            for (int i = 0; i < n; i += 1) {
                // Locale.US — чтобы в файле была точка, а не запятая
                write.printf(Locale.US, "%.6f%n", a[i]);
            }

            // т.к. PrintWriter не бросает IOException — используется checkError()
            if (write.checkError()) {
                throw new IOException("Ошибка записи в файл: " + namae);
            }

        } finally {
            if (write != null) {
                write.close();
            }
        }
    }
    /*------------------------------------------------------------------------*/
    /** Выводит одномерный действительный ArrayList в текстовый файл
     * @param namae имя файла
     * @param b одномерный ArrayList действительных чисел
     * @throws IOException любая ошибка записи
     */
    public static void print_double_arr_for_text_file(String namae, ArrayList<Double> b) throws IOException {
        PrintWriter write = null;

        int n = b.size();
        try {
            write = new PrintWriter(new FileWriter(namae));

            for (int i = 0; i < n; i += 1) {
                write.printf(Locale.US, "%.6f%n", b.get(i));
            }

            // т.к. PrintWriter не бросает IOException — используется checkError()
            if (write.checkError()) {
                throw new IOException("Ошибка записи в файл: " + namae);
            }

        } finally {
            if (write != null) {
                write.close();
            }
        }
    }
    /*------------------------------------------------------------------------*/
    /** Выводит одномерный действительный массив в бинарный файл
     * @param namae имя файла
     * @param a одномерный массив действительных чисел
     * @throws IOException любая ошибка записи
     */
    public static void print_double_arr_for_bin_file(String namae, double[] a) throws IOException {
        DataOutputStream write = null;
        int n = a.length;

        try {
            write = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(namae)));

            for (int i = 0; i < n; i += 1) {
                write.writeDouble(a[i]);        // ровно 8 байт
            }

            // т.к. DataOutputStream сам бросает IOException — checkError() не нужен

        } finally {
            if (write != null) {
                write.close();
            }
        }
    }
    /*------------------------------------------------------------------------*/
    /** Выводит одномерный действительный ArrayList в бинарный файл
     * @param namae имя файла
     * @param b одномерный ArrayList действительных чисел
     * @throws IOException любая ошибка записи
     */
    public static void print_double_arrlist_for_bin_file(String namae, ArrayList<Double> b) throws IOException {
        DataOutputStream write = null;
        int n = b.size();

        try {
            write = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(namae)));

            for (int i = 0; i < n; i += 1) {
                write.writeDouble(b.get(i));    // ровно 8 байт
            }

            // т.к. DataOutputStream сам бросает IOException — checkError() не нужен

        } finally {
            if (write != null) {
                write.close();
            }
        }
    }
    /*------------------------------------------------------------------------*/
}
