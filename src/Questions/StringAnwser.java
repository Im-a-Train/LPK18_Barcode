package Questions;

public class StringAnwser extends Anwser {

    public StringAnwser(String sAnwserText){
        super(sAnwserText);

    }
    private String sAnwser;

    public String getsAnwser() {
        return sAnwser;
    }

    public void setsAnwser(String sAnwser) {
        this.sAnwser = sAnwser;
    }
}
