package com.company;

import java.io.*;
public class Main
{
    /**
     * Application Entry Point
     */
    public static void main(String[] args)
    {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String yourNumber = "";
            try {
                yourNumber = br.readLine();
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("Your Number is: " + yourNumber);
        }



    }
}
