package Noro;

/*
Задача: Задачник БГУ, глава 1, задание 15;
Текст задачи: Даны гипотенуза и катет прямоугольного треугольника.
Найти второй катет и радиус вписанной окружности.
*/

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        assert ((Math.abs(calculations.cath(4.9, 2.0) - 4.4732)) <= 1e-9): "ошибка в вычислении функции calculations.cath()";
        assert ((Math.abs(calculations.cath(1.04, 0.55) - 0.8826)) <= 1e-9): "ошибка в вычислении функции calculations.cath()";
        assert ((Math.abs(calculations.cath(235.685, 87.234) - 218.9144)) <= 1e-9): "ошибка в вычислении функции calculations.cath()";
        assert ((Math.abs(calculations.cath(84.8631, 76.9873) - 35.7029)) <= 1e-9): "ошибка в вычислении функции calculations.cath()";

        assert ((Math.abs(calculations.roic(2.0, 4.4, 4.9) - 0.7866)) <= 1e-9): "ошибка в вычислении функции calculations.roic()";
        assert ((Math.abs(calculations.roic(0.55, 0.88, 1.04) - 0.1963)) <= 1e-9): "ошибка в вычислении функции calculations.roic()";
        assert ((Math.abs(calculations.roic(87.234, 218.914, 235.685) - 35.2478)) <= 1e-9): "ошибка в вычислении функции calculations.roic()";
        assert ((Math.abs(calculations.roic(76.9873, 35.7029, 84.8631) - 13.9135)) <= 1e-9): "ошибка в вычислении функции calculations.roic()";

        Scanner scan = new Scanner(System.in);
        double c = 0.0;
        double a = 0.0, b = 0.0;
        double r = 0.0;

        try {
            System.out.print("Введите значение гипотенузы прямоугольного треугольника: ");
            c = scan.nextDouble();
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Некорректное число");
        }
        if (c < 0) {
            throw new IllegalArgumentException("Гипотенуза не может быть меньше 0");
        }
        if (c == 0) {
            throw new IllegalArgumentException("Гипотенуза не может быть равна 0");
        }

        try {
            System.out.print("Введите значение одного из катетов прямоугольного треугольника: ");
            a = scan.nextDouble();
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Некорректное число");
        }
        if (a < 0) {
            throw new IllegalArgumentException("Катет не может быть меньше 0");
        }
        if (a == 0) {
            throw new IllegalArgumentException("Катет не может быть равен 0");
        }

        if (a == c) {
            throw new IllegalArgumentException("Катет не может быть равен гипотенузе");
        }
        if (a > c) {
            throw new IllegalArgumentException("Катет не может быть больше гипотенузы");
        }

        /*if (NumberFormatException e)
        {
            System.out.print("bkktufkargument");
        }*/

        b = calculations.cath(c, a);
        //assert (b > 0.0): "Катет меньше или равен нулю :(";

        r = calculations.roic(a, b, c);
        //assert (r > 0.0): "Радиус окружности меньше или равен нулю :(";

        System.out.printf("Второй катет прямоугольного треугольника равен: %.4f\n", b);
        System.out.printf("Радиус вписанной в прямоугольный треугольник окружности равен: %.4f\n", r);
    }
}