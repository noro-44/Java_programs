package Noro;

public class calculations
{
    //Вычисляет катет прямоугольного треугольника по гипотенузе и другому катету
    //На вход получает вещественные значения c - гипотенузу и a - катет
    //Возвращает вещественное значение - значение второго катета
    public static double cath(double c, double a)
    {
        double res = 0.0;
        res = (double) Math.sqrt(Math.pow(c, 2.0) - Math.pow(a, 2.0));
        return res;
    }


    //Вычисляет радиус вписанной в прямоугольный треугольник окружности по его катетам и гипотенузе
    //На вход получает вещественные значения a и b - катеты, c - гипотенузу
    //Возвращает вещественное значение - радиус окружности
    public static double roic(double a, double b, double c)
    {
        double res = 0.0;
        res = (double) ((a + b - c) / 2.0);
        return res;
    }
}
