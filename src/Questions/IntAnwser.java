package Questions;

public class IntAnwser extends Anwser {
    private int iAnwser;

    public IntAnwser(String sAnwserText){
        super(sAnwserText);
    }

    public int getiAnwser() {
        return iAnwser;
    }

    public void setiAnwser(int iAnwser) {
        this.iAnwser = iAnwser;
    }
}
