import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_GUIDE_TEXT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_TEXT_FORMAT = "%d개를 구매했습니다.";

    private InputView() {/* prevent creating instance */}

    public static int getRottoAmounts() {
        System.out.println(PURCHASE_AMOUNT_GUIDE_TEXT);

        Scanner scanner = new Scanner(System.in);
        String stringRottoAmounts = scanner.nextLine();

        return Integer.parseInt(stringRottoAmounts);
    }

    public static void printRottoCounts(int rottoCounts) {
        String purchaseResultText = String.format(PURCHASE_RESULT_TEXT_FORMAT, rottoCounts);
        System.out.println(purchaseResultText);
    }

    public static String getLotteryNumbersString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
