package Noro;

public class BlackHole {
    //поля класса
    public double weight; //масса (в килограммах (кг))
    public double electric_charge; //электрический заряд (в кулонах (Кл))
    public double angular_moment; //момент импульса (в кг * м^2 / с)

    //методы класса
    /*-------------------------------------------------------*/
    /**
     * Задаёт минимально возможные параметры (массу, электрический заряд, момент импульса) для чёрной дыры
     */
    public BlackHole() {
        weight = Math.pow(10, -8);
        electric_charge = 0.0;
        angular_moment = 0.0;
    }
    /*-------------------------------------------------------*/
    /**
     * Задаёт чёрной дыре новые (переданные) параметры (массу, электрический заряд, момент импульса)
     * @param nweight новая масса
     * @param nelectric_charge новый электрический заряд
     * @param nangular_moment новый момент импульса
     */
    public BlackHole(double nweight, double nelectric_charge, double nangular_moment) {
        weight = nweight;
        electric_charge = nelectric_charge;
        angular_moment = nangular_moment;
    }
    /*-------------------------------------------------------*/
    /**
     * Возвращает данные о содержимом полей класса
     * @return строку, содержащую данные из класса (массу, электрический заряд, момент импульса)
     */
    public String ToString() {
        String inf = String.format("Масса: %.4f\nЭлектрический заряд: %.4f\nМомент импульса: %.4f", weight, electric_charge, angular_moment);
        return inf;
    }
    /*-------------------------------------------------------*/
    /**
     * Возвращает данные о содержимом поля weight (масса) класса
     * @return строку, содержащую массу чёрной дыры
     */
    public String ToString_weight() {
        String inf = String.format("Масса: %.4f\n", weight);
        return inf;
    }
    /*-------------------------------------------------------*/
    /**
     * Возвращает данные о содержимом поля electric_charge (электрический заряд) класса
     * @return строку, содержащую электрический заряд чёрной дыры
     */
    public String ToString_electric_charge() {
        String inf = String.format("Электрический заряд: %.4f\n", electric_charge);
        return inf;
    }
    /*-------------------------------------------------------*/
    /**
     * Возвращает данные о содержимом поля angular_moment (момент импульса) класса
     * @return строку, содержащую момент импульса чёрной дыры
     */
    public String ToString_angular_moment() {
        String inf = String.format("Момент импульса: %.4f\n", angular_moment);
        return inf;
    }
    /*-------------------------------------------------------*/
    /**
     * Задаёт новое (переданное) значение полю weight (масса)
     * @param nweight новая масса
     * @return ничего не возвращает
     * @throws IllegalArgumentException если: <br>
     * * масса отрицательная; <br>
     * * масса равна нулю; <br>
     */
    public void set_weight(double nweight) {
        if (nweight < 0.0) {
            throw new IllegalArgumentException("Масса чёрной дыры не может быть отрицательной!");
        }
        if (nweight == 0.0) {
            throw new IllegalArgumentException("Масса чёрной дыры не может быть равной нулю!");
        }
        weight = nweight;
    }
    /*-------------------------------------------------------*/
    /**
     * Задаёт новое (переданное) значение полю electric_charge (электрический заряд)
     * @param nelectric_charge новый электрический заряд
     * @return ничего не возвращает
     */
    public void set_electric_charge(double nelectric_charge) {
        electric_charge = nelectric_charge;
    }
    /*-------------------------------------------------------*/
    /**
     * Задаёт новое (переданное) значение полю enangular_moment (момент импульса)
     * @param nenangular_moment новый момент импульса
     * @return ничего не возвращает
     */
    public void set_enangular_moment(double nangular_moment) {
        angular_moment = nangular_moment;
    }
    /*-------------------------------------------------------*/
    /**
     * Возаращает значение поля weight класса
     * @return массу чёрной дыры
     */
    public double get_weight() {
        return weight;
    }
    /*-------------------------------------------------------*/
    /**
     * Возаращает значение поля electic_charge класса
     * @return электрический заряд чёрной дыры
     */
    public double get_electric_charge() {
        return electic_charge;
    }
    /*-------------------------------------------------------*/
    /**
     * Возаращает значение поля angular_moment класса
     * @return момент импульса чёрной дыры
     */
    public double get_angular_moment() {
        return angular_moment;
    }
    /*========================================================*/
    /**
     * Определяет тип чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return название типа чёрной дыры
     */
    public String type_of_black_hole(double weight, double electric_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Вычисляет гравитационный радиус чёрной дыры
     * @param weight масса чёрной дыры
     * @return значение гравитационного радиуса
     */
    public double gravitational_radius(double weight) {

    }
    /*-------------------------------------------------------*/
    /**
     * Определяет количество горизонтов у чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return количество горизонтов у чёрной дыры
     */
    public int count_of_horizon(double weight, double electrical_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Вычисляет радиус горизонта событий (радиус Шварцшильда) чёрной дыры
     * @param weight масса чёрной дыры
     * @return значение радиуса горизонта событий
     */
    public double Schwarzschild_radius(double weight) {

    }
    /*-------------------------------------------------------*/
    /**
     * Вычисляет радиус внутреннего горизонта (горизонта Коши) чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return значение радиуса внутреннего горизонта
     */
    public double Cauchy_horizon(double weight, double electrical_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Определяет границу эргосферы чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return значение границы эргосферы
     */
    public double ergosphere_boundary(double weight, double electrical_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Вычисляет предел статичности чёрной дыры
     * @param weight масса чёрной дыры
     * @return значение предела статичности
     */
    public double limit_of_staticity(double weight) {

    }
    /*-------------------------------------------------------*/
    /**
     * Вычисляет радиус тени чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return значение радиуса тени
     */
    public double shadow_radius(double weight, double electric_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Вычисляет поверхностную гравитацию чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return значение поверхностной гравитации
     */
    public double surface_gravity(double weight, double electric_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Определяет тип сингулярности чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return название типа сингулярности
     */
    public String type_of_singularity(double weight, double electric_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Вычисляет метрику чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return метрику
     */
    public String metrics(double weight, double electric_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Определяет топологию горизонта чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return название топологии горизонта
     */
    public String topology_of_horizon(double weight, double electric_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Определяет безразмерный спин чёрной дыры
     * @param weight масса чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return значение безразмерного спина
     */
    public double dimensionless_spin(double weight, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Определяет температуру Хокинга для чёрной дыры
     * @param weight масса чёрной дыры
     * @return значение температуры Хокинга
     */
    public double Hawking_temperature(double weight) {

    }
    /*-------------------------------------------------------*/
    /**
     * Вычисляет энтропию чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return значение энтропии
     */
    public double entropy(double weight, double electric_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
    /**
     * Определяет угловую скорость горизонта чёрной дыры
     * @param weight масса чёрной дыры
     * @param electric_charge электрический заряд чёрной дыры
     * @param angular_moment момент импульса чёрной дыры
     * @return значение угловой скорости горизонта
     */
    public double angular_velocity_of_horizon(double weight, double electric_charge, double angular_moment) {

    }
    /*-------------------------------------------------------*/
}
