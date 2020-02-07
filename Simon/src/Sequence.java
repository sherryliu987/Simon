import java.util.ArrayList;

public class Sequence {

    private ArrayList<Integer> colors;

    public Sequence(){
        colors = new ArrayList<Integer>();
    }

    public void addColor(){
        int random = (int)(Math.random() * 4);
        colors.add(random);
    }

    public ArrayList<Integer> getColors(){
        return colors;
    }
}
