package cli;

import db.DataConnector;
import questions.Question;
import user.User;

public class QuestionMaster {
    User activeUser;
    Question currentQuestion;
    Integer iNumberOfQuestions = 0;
    Integer iCurrentQuestionId = 0;

    public  void start() {
        Integer iAnwserValue;
        initUser();
        Communicator.sayHello(activeUser.getsUserName());
        iNumberOfQuestions = DataConnector.getNumberOfEntries("data/questions.csv");
        while(iCurrentQuestionId<iNumberOfQuestions){
            nextQuestion();
            Communicator.readQuestion(currentQuestion);
            iAnwserValue = InputReader.waitForIntegerInput();
            DataConnector.writeAnwser(iAnwserValue,currentQuestion.getiQuestionId(),activeUser.getiUserID());

        }

    }

    private void initUser(){
        Communicator.askForUserId();
        activeUser = DataConnector.getUserById(InputReader.waitForIntegerInput());
        while(activeUser == null){
            Communicator.errorUserNotFound();
            activeUser = DataConnector.getUserById(InputReader.waitForIntegerInput());
        }
    }

    private void nextQuestion(){
            currentQuestion = DataConnector.getQuestionById(iCurrentQuestionId);

    }
}
