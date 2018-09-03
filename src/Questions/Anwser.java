package Questions;

public abstract class Anwser {

    private String sAnwserText;

    public Anwser(String sAnwserText){
        this.setsAnwserText(sAnwserText);
    }
    public void setsAnwserText(String sAnwserText) {
        this.sAnwserText = sAnwserText;
    }

    public String getsAnwserText() {
        return sAnwserText;
    }
}
