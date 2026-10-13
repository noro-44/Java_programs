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

        //assert работают только при запуске JVM с параметром -ea
        assert ((Math.abs(calculations.cath(4.9, 2.0) - 4.4732)) <= 1e-9): "ошибка в вычислении функции calculations.cath()";
        assert ((Math.abs(calculations.cath(1.04, 0.55) - 0.8826)) <= 1e-9): "ошибка в вычислении функции calculations.cath()";
        assert ((Math.abs(calculations.cath(235.685, 87.234) - 218.9144)) <= 1e-9): "ошибка в вычислении функции calculations.cath()";
        assert ((Math.abs(calculations.cath(84.8631, 76.9873) - 35.7029)) <= 1e-9): "ошибка в вычислении функции calculations.cath()";

        //assert работают только при запуске JVM с параметром -ea
        assert ((Math.abs(calculations.roic(2.0, 4.4, 4.9) - 0.7866)) <= 1e-9): "ошибка в вычислении функции calculations.roic()";
        assert ((Math.abs(calculations.roic(0.55, 0.88, 1.04) - 0.1963)) <= 1e-9): "ошибка в вычислении функции calculations.roic()";
        assert ((Math.abs(calculations.roic(87.234, 218.914, 235.685) - 35.2478)) <= 1e-9): "ошибка в вычислении функции calculations.roic()";
        assert ((Math.abs(calculations.roic(76.9873, 35.7029, 84.8631) - 13.9135)) <= 1e-9): "ошибка в вычислении функции calculations.roic()";


        //try..catch для обнаружения и обработки возможных ошибок
        try {
            double c = 0.0;
            double a = 0.0, b = 0.0;
            double r = 0.0;


            //если при запуске были переданы аргументы
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("--help")) {
                    System.out.println("Справка по использованию:\n" +
                            "Для вычисления второго катета и радиуса вписанной окружности: \n" +
                            "  java Noro.Main <гипотенуза> <катет>\n" +
                            "Для вывода справки: \n" +
                            "  java Noro.Main help  \n" +
                            "  java Noro.Main --help\n" +
                            "Пример использования:\n" +
                            "  java Noro.Main 5 3");
                    return;
                }

                if (args.length != 2) {
                    throw new IllegalArgumentException("Ожидаются два аргумента: гипотенуза и катет. Для подсказки используйте help или --help.");
                }

                try {
                    c = Double.parseDouble(args[0]);
                } catch (NumberFormatException er) {
                    throw new NumberFormatException("Некорректное значение гипотенузы: " + args[0]);
                }

                try {
                    a = Double.parseDouble(args[1]);
                } catch (NumberFormatException er) {
                    throw new NumberFormatException("Некорректное значение катета: " + args[1]);
                }
            }
            //если при запуске не были переданы аргументы - запросить у пользователя
            else {
                Scanner scan = new Scanner(System.in);

                System.out.print("Введите значение гипотенузы прямоугольного треугольника: ");
                String ci = scan.next();
                try {
                    c = Double.parseDouble(ci);
                } catch (NumberFormatException er) {
                    throw new NumberFormatException("Некорректное значение гипотенузы: " + ci);
                }

                System.out.print("Введите значение одного из катетов прямоугольного треугольника: ");
                String ai = scan.next();
                try {
                    a = Double.parseDouble(ai);
                } catch (NumberFormatException er) {
                    throw new NumberFormatException("Некорректное значение катета: " + ai);
                }
            }

            valid(c, a);

            b = calculations.cath(c, a);
            r = calculations.roic(a, b, c);

            System.out.printf("Второй катет прямоугольного треугольника равен: %.4f\n", b);
            System.out.printf("Радиус вписанной в прямоугольный треугольник окружности равен: %.4f\n", r);

        }
        //ошибка преобразования строки в число
        catch (NumberFormatException er) {
            System.err.println("Ошибка формата числа: " + er.getMessage());
        }
        //ошибка данных (неудовлетворяющие задаче данные)
        catch (IllegalArgumentException er) {
            System.err.println("Ошибка данных: " + er.getMessage());
        }
        //иная ошибка
        catch (Exception er) {
            System.err.println("Непредвиденная ошибка: " + er.getMessage());
        }
    }

    /*------------------------------------------------------------------------*/
    /** Проверяет корректность вводимых данных <br>
     * (private) может использоваться только внутри класса Main
     * @param c гипотенуза прямоугольного треугольника
     * @param a катет прямоугольного треугольника
     * @return ничего не возвращает
     * @throws IllegalArgumentException если: <br>
     * * хотя бы одно из чисел бесконечно или не является чилом; <br>
     * * гипотенуза меньше или рана 0; <br>
     * * катет меньше или равен 0; <br>
     * * катет больше или равен гипотенузе <br>
     **/
    private static void valid(double c, double a) {
        if (Double.isNaN(c) || Double.isInfinite(c)) {
            throw new IllegalArgumentException("Гипотенуза должна быть конечным числом");
        }
        if (Double.isNaN(a) || Double.isInfinite(a)) {
            throw new IllegalArgumentException("Катет должен быть конечным числом");
        }
        if (c < 0) {
            throw new IllegalArgumentException("Гипотенуза не может быть меньше 0");
        }
        if (c == 0) {
            throw new IllegalArgumentException("Гипотенуза не может быть равна 0");
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
    }
    /*------------------------------------------------------------------------*/
}