package bai01;
import java.util.Random;
public class Ramdom {
	private static final String digits = "0123456789";

    private static Random generator = new Random();

    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, digits.length() - 1);
            char ch = digits.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

}
