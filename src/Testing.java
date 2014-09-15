/**
 * Created by Яна on 13.09.2014.
 */
public class Testing {
    // Вспомогательный метод для вывода коэффициентов
    public static void derive(Polynom c) {
        for (int element : c.getArray()) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
    // Проверка правильности нахождения суммы, разности, произведения.
        Polynom one = new Polynom(new int[]{0, 1, -3, 5, 7});
        Polynom two = new Polynom(new int[]{1, 2, 3, -4, 5});
        Polynom summa1 = one.sum(two);
        derive(summa1);

        Polynom subtract1 = one.subtract(two);
        derive(subtract1);

        Polynom multiply1 = one.multiply(two);
        derive(multiply1);

    // Проверка на эквивалент
        System.out.println(summa1.equals(subtract1));

    // От перестановки множителей ничего не должно измениться
        Polynom multiply2 = two.multiply(one);
        System.out.println(multiply2.equals(multiply1));

        System.out.println(multiply1.hashCode());

    // Вычисление значения в заданной точке
        Polynom three = new Polynom ( new int[] {1, 2, 1, 5});
        System.out.println(three.value(9.1));

    // Еще два массива для тестов.
        Polynom four = new Polynom(new int [] {3, -6, 1, 4, 2 , -1, 1});
        Polynom five = new Polynom(new int[] {1, 1, -3, 5, 7});

    // Проверим, как добавляет степени при разных длинах массивов
        Polynom summa2 = four.sum(two);
        derive(summa2);

    // Проверим, как обрезаются нулевые коэфициенты.
        Polynom subtract2 = five.subtract(one);
        derive(subtract2);
    }
}