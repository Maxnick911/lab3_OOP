package ad211.vetokhin;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner msg = new Scanner(System.in);

        System.out.println("1.Print your line and the program will print true if the string ends with 'ed'");
        String message1 = msg.nextLine();
        System.out.println(checkEd(message1));

        System.out.println("2. Print your line and the program will print sum of all digits in the line");
        String message2 = msg.nextLine();
        System.out.println("Sum of digits: " + isDigit(message2));

        System.out.println("3. Print your line and the program will print length of longest block of symbols in the line ");
        String message3 = msg.nextLine();
        System.out.println("Length of longest block is: " + findLongestBlock(message3));

        System.out.println("4. Print your line and the program will find and print all the words in the line");
        String message4 = msg.nextLine();
        findWords(message4);

        System.out.println("5. Print 2 lines and the program will print 1 line with alternately entered characters of each line");
        System.out.print("Print first line: ");
        String message5 = msg.nextLine();
        System.out.print("And second: ");
        String message6 = msg.nextLine();
        System.out.print("Result line: " + mixWords(message5, message6));

        System.out.println("\nEnd of the program...");
    }

    private static boolean checkEd (String message) {
        return message.endsWith("ed");
    }

    private static int isDigit (String message) {
        int sum = 0;
        for(int i = 0; i < message.length(); i++){
            char c = message.charAt(i);
            if(Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }

    private static int findLongestBlock (String message) {
        char c = message.charAt(0);
        int max = 0;
        for (int i = 1, j = 0; i < message.length(); i++) {
            if (message.charAt(i) == c) {
                j++;
            }
            else {
                c = message.charAt(i);
                j = 1;
            }
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    private static void findWords (String message) {
        String[] words = message.split("\\s+");
        System.out.println("Words found: " +  Arrays.toString(words));
    }

    private static String mixWords (String message1, String message2) {
        String resultString = "";
        int l = Math.min(message1.length(), message2.length());
        for(int i = 0; i < l; i++) {
           resultString = resultString + message1.charAt(i) + message2.charAt(i);
        }
        resultString = resultString + message1.substring(l) + message2.substring(l);
        return resultString;
    }


}