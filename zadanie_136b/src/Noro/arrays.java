package Noro;

import java.util.Random;

public class arrays {
    /*------------------------------------------------------------------------*/
    /** Заполняет одномерный действительный массив случайными числами в диапазоне [op; ed]
     * @param n длина одномерного массива (количество элементов)
     * @param a одномерный массив
     * @param op начало диапазона
     * @param ed конец диапазона
     */
    public static void rdarr(int n, double a[], double op, double ed){

        Random rand = new Random();

        if (op > ed) {
            double temp = op;
            op = ed;
            ed = temp;
        }
        for (int i = 0; i < n; i += 1){
            a[i] = op + rand.nextDouble() * (ed - op);
        }
    }
    /*------------------------------------------------------------------------*/
    /** Вычисляет произведение всех членов одномерного действительнго массива
     * @param n длина одномерного массива (количество элементов)
     * @param a одномерный массив
     * @return произведение всех элементов массива a
     */
    public static double comdarr(int n, double a[]){
        double comp = 1.0;
        for (int y = 0; y < n; y += 1){
            comp *= a[y];
        }
        return comp;
    }
    /*------------------------------------------------------------------------*/
}
