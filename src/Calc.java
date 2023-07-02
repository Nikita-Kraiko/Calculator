import java.util.Scanner;

public class Calc {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        String phrase = scanner.nextLine();
        System.out.println(count(phrase));
    }

    public static String count(String phrase) throws Exception {
        int num1;
        int num2;
        String operation;
        String result;
        boolean isRoman;
        String[] operands = phrase.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception();

        if (phrase.contains("+")) operation = "+";
        else if (phrase.contains("-")) operation = "-";
        else if (phrase.contains("*")) operation = "*";
        else operation = "/";


        if (Converting.isRoman(operands[0]) && Converting.isRoman(operands[1])) {
            num1 = Converting.convertToArabian(operands[0]);
            num2 = Converting.convertToArabian(operands[1]);
            isRoman = true;
        }
        else if (!Converting.isRoman(operands[0]) && !Converting.isRoman(operands[1])){
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else { throw new Exception();}
        if (num1>10 ||num1 <1 || num2 >10 || num2 <1){
            throw new Exception();
        }

        int arab = calculate(num1,num2,operation);
        if (isRoman){
            if (arab <= 0){
                throw new Exception();
            }
            result = Converting.convertToRomain(arab);
        }
        else {
            result = String.valueOf(arab);
        }
        return result;
    }

    static int calculate(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };

    }


}
class Converting {
    static String[] numArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXIV", "XXV", "XXVII",
                "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX", "L", "LIV", "LVI",
                "LX", "LXIII", "LXIV", "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C"};


    public static boolean isRoman(String val) {
        for (int i = 0; i < numArray.length; i++) {
            if (val.equals(numArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static String convertToRomain(int arab) {
        return numArray[arab];
    }

    public static int convertToArabian(String romain) {
        for (int i = 0; i < numArray.length; i++) {
            if (romain.equals(numArray[i])) {
                return i;
            }
        }
        return -1;
    }



}
