import java.util.InputMismatchException;
import java.util.Scanner;

public class InputLoopFunctions {
    public static void addingItem(Scanner sc, Calculator calculator){

        String itemName;

        while (true) {

            System.out.println("Введите название товара (либо -> 'завершить' ): ");
            itemName = sc.next();

            if (itemName.equalsIgnoreCase("завершить")) break;
            else {
                while (true) {
                    System.out.println("Введите стоимость товара в формате ХХ,ХХ (рубли,коп.): ");
                    try {
                        double itemPrice = sc.nextDouble();
                        if (itemPrice <= 0) {
                            System.out.println("Цена должна быть положительным числом!");
                        } else {
                            calculator.addDish(itemName, itemPrice);
                            break;
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("Формат ввода неверный!" +
                                " Введите дробное число через запятую!");
                        sc.nextLine();
                    }
                }
            }
        }
        sc.close();
    }
}
