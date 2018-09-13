package cli;

import com.inamik.text.tables.GridTable;
import com.inamik.text.tables.SimpleTable;
import com.inamik.text.tables.grid.Border;
import com.inamik.text.tables.grid.Util;
import questions.Question;

import static com.inamik.text.tables.Cell.Functions.HORIZONTAL_CENTER;
import static com.inamik.text.tables.Cell.Functions.TOP_ALIGN;

public class Communicator {

    public static void showMenu(){
        Integer height = 2;
        Integer width = 30;
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

    }

    public static void sayBye(String sUsername){

    }

    public static void errorUserNotFound(){
        System.out.println("Sorry, wir konnten mit der eingegeben ID niemanden finden.");
    }

}
