package cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputReader {



    public static int waitForIntegerInput(){
        Integer yourNumber = 0;
        Scanner sc = new Scanner(System.in);
        while(yourNumber == 0) {
            try {
                yourNumber = sc.nextInt();


            } catch (InputMismatchException e) {
                System.out.print("Bitte gib eine richtige Zahl ein.");
            }
        }
        return yourNumber;
    }

    public static String waitForStringInput(){
        String yourString = "";
        while(yourString == "") {
            try {
                Scanner sc = new Scanner(System.in);
                yourString = sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.print("Schreib kein Scheiss.");
            }
        }

        return yourString;
    }

}
