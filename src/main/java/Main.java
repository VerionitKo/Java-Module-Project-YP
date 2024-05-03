import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String itemName;
        int humanCount;
        Calculator calculator;

        System.out.println("Приветствую!\n Введите количество человек" +
                " на сколько будем делить счет. Введите значение (больше '1'): ");

        while (true) {

            try {
                humanCount = sc.nextInt();
                if (humanCount > 1) {
                    calculator = new Calculator(humanCount);
                    break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("ERROR! Введите число! ");
                sc.nextLine();
            }
            System.out.println("!!! Число должно быть больше '1'! ");
        }

        while (true) {

            System.out.println("Введите название товара (либо -> 'завершить' ): ");
            itemName = sc.next();

            if (itemName.equalsIgnoreCase("завершить")) break; else {
                while (true) {
                    System.out.println("Введите стоимость товара в формате ХХ,ХХ (рубли,коп.): ");
                    try {
                        double itemPrice = sc.nextDouble();
                        if (itemPrice <= 0) {
                            System.out.println("Цена должна быть положительным числом!");
                        } else {
                            calculator.addDish(itemName, itemPrice);
                            System.out.println("Товар " + itemName + " успешно добавлен!");
                            System.out.println("Сейчас общая сумма: " + calculator.getTotalPrice());
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

        System.out.println("Добавленные товары: ");

        for (String item : calculator.getItems()) {
            System.out.println(" ╰┈➤ " + item + " ** ");
        }

        Output finalOutput = new Output();
        finalOutput.showMessage(calculator.getPriceForPerson());
    }
}