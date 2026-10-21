package Noro;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество чисел последовательности: ");
        int n = scan.nextInt();

        double[] a = new double[n];

        arrays.rdarr(n, a, -5.0, 5.0);
        for (int j = 0; j < n; j += 1){ //вывод массива на экран
            System.out.printf("%.4f  ", a[j]);
        }
        double p = arrays.comdarr(n, a);
        System.out.printf("\nПроизведение всех членов последовательности: %.4f\n", p);
    }
}
