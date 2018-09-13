import db.DataConnector;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{
    /**
     * Application Entry Point
     */
    public static void main(String[] args)
    {
        while(true) {
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            Integer yourNumber = 0;
            try {
                yourNumber = sc.nextInt();

            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Your Number is: " + yourNumber.toString());
            System.out.println(DataConnector.getUserById(yourNumber).getsUserName());
        }



    }
}
