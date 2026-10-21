package Noro;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class arrays
{
    /*------------------------------------------------------------------------*/
    /** Заполняет одномерный действительный массив случайными числами в диапазоне [op; ed]
     * @param n длина одномерного массива (количество элементов)
     * @param a одномерный массив
     * @param op начало диапазона
     * @param ed конец диапазона
     **/
    public static void rand_double_arr(int n, List<Double> a, double op, double ed)
    {

        Random rand = new Random();

        if (op > ed)
        {
            double temp = op;
            op = ed;
            ed = temp;
        }
        for (int i = 0; i < n; i += 1)
        {
            a.add(i, (op + rand.nextDouble() * (ed - op)));
        }
    }
    /*------------------------------------------------------------------------*/
    /** Вычисляет произведение всех членов одномерного действительнго массива
     * @param n длина одномерного массива (количество элементов)
     * @param a одномерный массив
     * @return произведение всех элементов массива a
     **/
    public static double comp_double_arr(int n, List<Double> a)
    {
        double comp = 1.0;
        for (int y = 0; y < n; y += 1)
        {
            comp *= a.get(y);
        }
        return comp;
    }
    /*------------------------------------------------------------------------*/

    /** Выводит на экран одномерный действительный массив по l элементов в каждой
     * @param n количество элементов в массиве
     * @param a одномерный массив действительных чисел
     * @param l количество элементов в одной строке
     **/
    public static void print_double_arr(int n, List<Double> a, int l)
    {
        for (int j = 0; j < n; j += 1)
        {
            if (j % l == 0)
            {
                System.out.printf("\n");
            }
            System.out.printf("%8.4f  ", a.get(j));
        }
    }
    /*------------------------------------------------------------------------*/
}
