import cli.Communicator;
import cli.InputReader;
import cli.QuestionMaster;
import db.DataConnector;
import snake.Game;

public class Main

{

    /**
     * Application Entry Point
     */
    public static void main(String[] args){
        Boolean run = true;
        System.out.println(DataConnector.getUserById(1).getsUserName());
        while(run){
            Integer iCommandId =0;
            Communicator.showMenu();
            iCommandId = InputReader.waitForIntegerInput();
            switch (iCommandId){
                case 1:
                    QuestionMaster qm = new QuestionMaster();
                    qm.start();
                    break;
                case 2:
                    break;
                case 3:
                    Game game = new Game();
                    game.start();
                    break;
                case 4:
                    System.exit(1);
                    default:
                        System.out.println("Die Zahl " + iCommandId +" steht nicht zur Disskusion, wähle eine zwischen 1 und 4");

            }
            }
        }

    }
