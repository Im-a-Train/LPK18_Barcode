import cli.*;
import snake.Game;

import java.io.IOException;

public class Main

{

    /**
     * Application Entry Point
     */
    public static void main(String[] args){
        Boolean run = true;
        while(run){
            Integer iCommandId = 0;
            Communicator.showMenu();
            iCommandId = InputReader.waitForIntegerInput(1,6);
            switch (iCommandId){
                case 1:
                    QuestionMaster qm = new QuestionMaster();
                    qm.start();
                    break;
                case 2:
                    BlackholeCalc.calculateBlackHole();
                    break;
                case 3:
                    Game game = new Game();
                    game.start();
                    break;
                case 4:
                    System.exit(1);
                    break;
            case 5:
                try{
                    Process call= new ProcessBuilder("\"C:\\Program Files (x86)\\Microsoft\\Skype for Desktop\\Skype.exe\"").start();
                }catch(IOException e){
                    System.out.println("Hm, es konnte keine Verbindung aufgebaut werden.");
                }
                break;
            case 6:
                EnterSubject.readUser();
                break;
                    default:
                        System.out.println("Die Zahl " + iCommandId +" steht nicht zur Disskusion, wähle eine zwischen 1 und 4");

            }
            }
        }

    }
