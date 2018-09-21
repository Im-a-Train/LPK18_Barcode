package db;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import questions.Question;
import user.User;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class DataConnector {

    private static Iterable<CSVRecord> getRecords(String sFilePath){
        Iterable<CSVRecord> records = null;
        try{
            Reader in = new FileReader(sFilePath);
            records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .parse(in);
        }catch(IOException e){
            System.out.println("Error while reading Data.");
        }

        return records;
    }

    public static Question getQuestionByLineNumber(Integer iLineNumber){
        Iterable<CSVRecord> records = getRecords("data/questions.csv");
        Question question = null;
        for(CSVRecord record : records) {
            if (record.getRecordNumber() == iLineNumber) {
                question = new Question(Integer.parseInt(record.get("ID_Question")), record.get("QuestionText"));
                break;
            }
        }
        return question;

    }

    public static int getNumberOfEntries(String sFilePath){
        Iterable<CSVRecord> records = getRecords(sFilePath);
        Integer iNumberOfEntries = 0;
        for (CSVRecord record : records) {
            iNumberOfEntries++;
        }
        return iNumberOfEntries;
    }

    public static int getMaxIndex(String sFilePath){
        Integer imaxIndex=0;
        Iterable<CSVRecord> records = getRecords(sFilePath);
        for(CSVRecord record : records){
            if(Integer.getInteger(record.get(0))>imaxIndex){
                imaxIndex = Integer.getInteger(record.get(0));
            }
        }
        return imaxIndex;
    }


    public static user.User getUserById(Integer iUserId){
        Iterable<CSVRecord> records = getRecords("data/users.csv");
        User user = null;
        for (CSVRecord record : records) {
            if (Integer.parseInt(record.get("ID_User")) == iUserId) {
                user = new User(Integer.parseInt(record.get("ID_User")), record.get("Username"));
                break;
            }
        }
        return user;

    }

    public static questions.Question getQuestionById(Integer iQuestionId){
        Iterable<CSVRecord> records = getRecords("data/questions.csv");
        Question question = null;
        for(CSVRecord record : records){
            if(Integer.parseInt(record.get("ID_Question"))==iQuestionId){
                question = new Question(Integer.parseInt(record.get("ID_Question")), record.get("QuestionText"));
            }
        }

        return question;
    }

    public static void writeAnwser(Integer iAnwserValue, Integer iQuestionId, String sUsername){
        Integer iAnwserId = getMaxIndex("data/anwsers.csv")+1;
        String [] AnwserLine = {iAnwserId.toString(),iAnwserValue.toString(), iQuestionId.toString(), sUsername};
        try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("data/anwsers.csv"), StandardOpenOption.APPEND);
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            printer.printRecord(Arrays.asList(AnwserLine));
            printer.flush();

        }catch(IOException e){
            System.out.print(e.getMessage());
        }

    }
}
