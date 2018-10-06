package cli;

import db.DataConnector;

public class EnterSubject {

    public static void readUser(){
        System.out.println("Bitte lesen sie den nächsten Benutzer ein:");
        String sUserId = InputReader.waitForStringInput();
        System.out.println("Bitte geben sie dem Benutzer einen Namen");
        String sUserName = InputReader.waitForStringInput();
        DataConnector.insertUserById(sUserId, sUserName);
        System.out.println("Subjekt erfolgreich erfasse");
    }



}
