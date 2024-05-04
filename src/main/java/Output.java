public class Output {
    public static void showMessage(double personalPrice) {

        if ((int) personalPrice % 100 >= 10 && (int) personalPrice % 100 <= 20) {
            System.out.printf("Каждый человек должен заплатить %.2f рублей",
                    personalPrice);
        } else {
            switch ((int) personalPrice % 10) {
                case 1 -> System.out.printf("Каждый человек должен заплатить %.2f рубль",
                        personalPrice);
                case 2, 3, 4 -> System.out.printf("Каждый человек должен заплатить %.2f рубля",
                        personalPrice);
                default -> System.out.printf("Каждый человек должен заплатить %.2f рублей",
                        personalPrice);
            }
        }
    }
}