package cli;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputReader {



    public static int waitForIntegerInput(Integer minInt, Integer maxInt){
        Integer yourNumber=0;
        Scanner sc = new Scanner(System.in);
        while(yourNumber < minInt || yourNumber > maxInt) {
            System.out.print("Bitte gib eine Zahl zwischen " +minInt + " und "+ maxInt+" ein: ");
            try {
                yourNumber = sc.nextInt();

            } catch (InputMismatchException e) {
                sc.reset();
            }

        }
        return yourNumber;
    }

    public static String waitForStringInput(){
        String yourString = "";
        Scanner sc = new Scanner(System.in);
        while(yourString == "") {
            try {

                yourString = sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.print("Schreib kein Scheiss.");
                sc.reset();
            }
        }

        return yourString;
    }

}
