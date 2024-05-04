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

        while (true) {      //in separate static too

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

        InputLoopFunctions.addingItem(sc, calculator);

        //sc.close();

        System.out.println("Добавленные товары: ");

        for (String item : calculator.getItems()) {
            System.out.println(" ╰┈➤ " + item + " ** ");
        }

        Output finalOutput = new Output();
        finalOutput.showMessage(calculator.getPriceForPerson());
    }
}