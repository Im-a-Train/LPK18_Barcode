package db;

import com.opencsv.*;
import questions.Question;
import user.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataConnector {

    public static String[] getLine(Integer iAttributeID, String sSearchString, String sFilePath){
        Path myPath = Paths.get(sFilePath);
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        try {
            BufferedReader br = Files.newBufferedReader(myPath,
                    StandardCharsets.UTF_8);
            CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).build();
            String [] nextLine;
            while((nextLine = reader.readNext()) !=null){
                if(nextLine[iAttributeID].contains(sSearchString)){
                    return nextLine;
                }

            }
        }catch(FileNotFoundException e){
            System.out.print(e.getMessage());

        }catch(IOException e){
            System.out.print(e.getMessage());

        }
        return null;

    }
    public static int getMaxIndex(String sFilePath){
        Integer iComp = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader(sFilePath));
            String [] nextLine;
            Integer iCurrentId;
            while((nextLine = reader.readNext()) !=null){
                iCurrentId = Integer.parseInt(nextLine[0]);
                if(iCurrentId > iComp){
                    iComp = iCurrentId;
                }
            }
        }catch(FileNotFoundException e){
            System.out.print(e.getMessage());

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
