package db;

import com.opencsv.*;
import questions.Question;
import user.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataConnector {

    private static CSVReader getReader(String sFilePath){
        Path myPath = Paths.get(sFilePath);
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader reader = null;
        try {
            BufferedReader br = Files.newBufferedReader(myPath,
                    StandardCharsets.UTF_8);
            reader = new CSVReaderBuilder(br).withCSVParser(parser).build();
        }catch (FileNotFoundException e){
            System.out.print(e.getMessage());
        }catch(IOException e){
            System.out.print(e.getMessage());

        }
        return reader;
    }

    public static String[] getLine(Integer iAttributeID, String sSearchString, String sFilePath){
        CSVReader reader = getReader(sFilePath);
        String [] nextLine = null;
        try {
            while((nextLine = reader.readNext()) !=null){
                if(nextLine[iAttributeID].contains(sSearchString)){
                    break;
                }
            }
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
        return nextLine;
    }

    public static Question getQuestionByLineNumber(Integer iLineNumber){
        CSVReader reader = getReader("data/questions.csv");
        String [] nextLine = null;
        for (Integer i =0; i < iLineNumber;i++){
            try{
                nextLine = reader.readNext();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }

        }
        return new Question(Integer.parseInt(nextLine[0]),nextLine[1]);

    }

    public static int getNumberOfEntries(String sFilePath){
        CSVReader reader = getReader(sFilePath);
        Integer iNumberOfEntries =0;
        try {
            iNumberOfEntries = reader.readAll().size();
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
        return iNumberOfEntries;
    }
    public static int getMaxIndex(String sFilePath){
        Integer iComp = 0;
        CSVReader reader = getReader(sFilePath);
        try {
            String [] nextLine;
            Integer iCurrentId;
            while((nextLine = reader.readNext()) !=null){
                iCurrentId = Integer.parseInt(nextLine[0]);
                if(iCurrentId > iComp){
                    iComp = iCurrentId;
                }
                reader.close();
            }
        }catch(IOException e){
            System.out.print(e.getMessage());
        }

        return iComp;
    }

    public static user.User getUserById(Integer iUserId){
        String [] parsedUser = getLine(0,iUserId.toString(), "data/users.csv");
        return new User(Integer.parseInt(parsedUser[0]), parsedUser[1]);
    }

    public static questions.Question getQuestionById(Integer iQuestionId){
        String [] parsedQuestion = getLine(0,iQuestionId.toString(),"data/questions.csv");
        return new Question(Integer.parseInt(parsedQuestion[0]),parsedQuestion[1]);
    }

    public static void writeAnwser(Integer iAnwserValue, Integer iQuestionId, Integer iUserId){
        Integer iAnwserId = getMaxIndex("data/anwsers.csv")+1;
        String [] anwserLine = {iAnwserId.toString(),iAnwserValue.toString(), iQuestionId.toString(),iUserId.toString()};
        try{
            CSVWriter writer = new CSVWriter(new FileWriter("data/anwsers.csv"),',');
            writer.writeNext(anwserLine);

        }catch(IOException e){
            System.out.print(e.getMessage());
        }

    }
}
