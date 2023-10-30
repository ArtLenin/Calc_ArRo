import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int x, y;
    static char opper;
    static int answer;

    public static void main(String[] args) {
        System.out.println("Введите выражение арабскими или римскими цифрами, без пробелов и нажмите Enter ");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                opper = '+';
            }
            if (under_char[i] == '-') {
                opper = '-';
            }
            if (under_char[i] == '*') {
                opper = '*';
            }
            if (under_char[i] == '/') {
                opper = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        x = RomeToArab(stable00);
        y = RomeToArab(string03);
        if (x < 0 && y < 0) {
            answer = 0;
        } else {
            answer = calculated(x, y, opper);
            System.out.println("Результат");
            String resultRoman = convertXYtoRoman(answer);
            System.out.println(stable00 + " " + opper + " " + string03 + " = " + resultRoman);
        }
        x = Integer.parseInt(stable00);
        y = Integer.parseInt(string03);
        answer = calculated(x, y, opper);
        System.out.println("Результат");
        System.out.println(x + " " + opper + " " + y + " = " + answer);
    }

    private static String convertXYtoRoman(int xyArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
                "C", "CI", "CII", "CIII", "CIV" , "CV", "CVI", "CVII", "CVIII", "CIX", "CX"
        };
        return roman[xyArabian];
    }


    private static int RomeToArab(String roman) {

        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

    public static int calculated (int x, int y, char opper) {
        int result = 0;
        switch (opper) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                try {
                    result = x / y;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Ошибка");
        }
        return result;
    }
}