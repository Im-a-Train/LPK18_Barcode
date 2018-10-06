package cli;

import com.inamik.text.tables.GridTable;
import com.inamik.text.tables.SimpleTable;
import com.inamik.text.tables.grid.Border;
import com.inamik.text.tables.grid.Util;
import questions.Question;

import java.io.*;

import static com.inamik.text.tables.Cell.Functions.HORIZONTAL_CENTER;
import static com.inamik.text.tables.Cell.Functions.TOP_ALIGN;

public class Communicator {

    public static void showMenu(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Integer height = 2;
        Integer width = 30;
printAscii("ascii/Rocket_Logo");
        SimpleTable s = SimpleTable.of()
                .nextRow()
                .nextCell()
                .addLine("1")
                .addLine("Befragung starten")
                .applyToCell(TOP_ALIGN        .withHeight(height))
                .applyToCell(HORIZONTAL_CENTER.withWidth (width ))
                .nextCell()
                .addLine("2")
                .addLine("Blackhole berechnen")
                .applyToCell(TOP_ALIGN        .withHeight(height))
                .applyToCell(HORIZONTAL_CENTER.withWidth (width ))
                .nextRow()
                .nextCell()
                .addLine("3")
                .addLine("Langweilig")
                .applyToCell(TOP_ALIGN        .withHeight(height))
                .applyToCell(HORIZONTAL_CENTER.withWidth (width ))
                .nextCell()
                .addLine("4")
                .addLine("Fertig mit Schluss")
                .applyToCell(TOP_ALIGN        .withHeight(height))
                .applyToCell(HORIZONTAL_CENTER.withWidth (width ))
            .nextRow()
            .nextCell()
            .addLine("5")
            .addLine("Erde anrufen")
            .applyToCell(TOP_ALIGN        .withHeight(height))
            .applyToCell(HORIZONTAL_CENTER.withWidth (width ))
            .nextCell()
            .addLines("6")
            .addLines("Benutzer erfassen")
            .applyToCell(TOP_ALIGN        .withHeight(height))
            .applyToCell(HORIZONTAL_CENTER.withWidth (width ))
                ;

//
// NOTE: SimpleTable makes creating the table easy, but you will need to convert it
// into a GridTable in order to perform further operations
// (like adding a border or printing)
//

// Convert to grid
//
        GridTable g = s.toGrid();

// Add simple border
//
        g = Border.of(Border.Chars.of('+', '-', '|')).apply(g);


// Print the table to System.out
//
        Util.print(g);

    }
    public static void readQuestion(Question qCurrentQuestion){

        System.out.println();
        System.out.println(qCurrentQuestion.getsQuestionText());
    }
    public static void askForUserId(){
        System.out.println("Nächstes Subjekt scannen: ");
    }

    public static void sayHello(String sUsername){
        System.out.println("Hallo " + sUsername + " ");

    }

    public static void sayBye(String sUsername){
        System.out.println("Vielen Dank für das Angenehme gespräch. Ich habe ihre Anworten gespeichert und sie können wieder ihren anderen Aufgaben nachgehen.");

    }

    public static void errorUserNotFound(){
        System.out.println("Sorry, wir konnten kein Subjekt mit der eingegeben ID finden.");
    }

    public static void printAscii(String sFilePath){
        try{
            FileReader fr = new FileReader(new File(sFilePath));
            BufferedReader bf = new BufferedReader(fr);
            String line = bf.readLine();
            while(line != null){
                System.out.println(line);
                line = bf.readLine();
            }
            fr.close();

        }catch ( IOException e){
            System.out.println("The Graphic could not be loaded");
            System.out.println(e.getMessage());
        }



    }
}
