package cli;

import db.DataConnector;
import questions.Question;
import user.User;

public class QuestionMaster {
    User activeUser;
    Question currentQuestion;
    Integer iNumberOfQuestions = 0;
    Integer iCurrentQuestionIndex = 1;

    public  void start() {

        Integer iAnwserValue;
        initUser();
        Communicator.sayHello(activeUser.getsUserName());
        iNumberOfQuestions = DataConnector.getNumberOfEntries("data/questions.csv");
        System.out.println("Wir haben heute " + iNumberOfQuestions + " Fragen vorbereitet.");
        while(iCurrentQuestionIndex<=iNumberOfQuestions){
            nextQuestion();
            if(currentQuestion != null){
                Communicator.readQuestion(currentQuestion);
                iAnwserValue = InputReader.waitForIntegerInput(1, 10);
                DataConnector.writeAnwser(iAnwserValue,currentQuestion.getiQuestionId(),activeUser.getsUserName());
            }else{
                System.out.println("Sorry, wir konnten die Frage mit der ID: "+iCurrentQuestionIndex+" nicht laden, wir fahren mit der nächsten fort.");
            }
            iCurrentQuestionIndex++;
        }

    }

    private void initUser(){
        Communicator.askForUserId();
        activeUser = DataConnector.getUserById(InputReader.waitForStringInput());
        while(activeUser == null){
            Communicator.errorUserNotFound();
            activeUser = DataConnector.getUserById(InputReader.waitForStringInput());
        }
        Communicator.sayHello(activeUser.getsUserName());
    }

    private void nextQuestion(){
            currentQuestion = DataConnector.getQuestionByLineNumber(iCurrentQuestionIndex);

    }
}
