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
                System.out.println("ERROR! Введите положительное число больше '1' ");
                sc.nextLine();
            }
            System.out.println("!!! Число должно быть больше '1'! ");
        }

        while (true) {

            System.out.println("Введите название товара (либо -> 'завершить' ): ");
            itemName = sc.next();

            if (itemName.equalsIgnoreCase("завершить")) break;

            System.out.println("Введите стоимость товара в формате ХХ.ХХ (рубли.копейки): ");
            Double itemPrice = sc.nextDouble();

            calculator.addDish(itemName, itemPrice);

            System.out.println("Добавленные товары: ");

            for (String item : calculator.getItems()) {
                System.out.println(" ╰┈➤ " + item + " ** ");
            }

            DataOutput finalOutput = new DataOutput();
            finalOutput.showMessage(calculator.getPriceForPerson());


        }

    }
}