import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Simon {

    private static JFrame frame = new JFrame("Simon :)");
    private static GameBoardDisplay board = new GameBoardDisplay();
    private static int choice = -1;
    private static boolean hasClicked = false;
    private static final String fourColors[] = {"red", "green", "blue", "yellow"};
    private static JLabel label = new JLabel();

    public static void main(String[] args){
        createWindow();
        display();
        mouseStuff();

        Sequence sequence = new Sequence();
        label.setText("yo pay attention");
        sequence.addColor();
        paintCurrentSequence(sequence.getColors());
        label.setText("it's your turn");
        boolean wrong = false;
        while(!wrong){
            for(int i = 0;i<sequence.getColors().size();i++) {
                while(!hasClicked){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (choice == sequence.getColors().get(i)) {
                    board.setState(choice);
                    board.paintComponent(board.getGraphics());
                    label.setText("nice job keep going");
                    hasClicked = false;
                } else {
                    label.setText("you suck. it was " + fourColors[sequence.getColors().get(i)]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    wrong = true;
                    break;
                }
            }
            if (wrong) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            label.setText("yo pay attention");
            sequence.addColor();
            paintCurrentSequence(sequence.getColors());
            label.setText("it's your turn");
        }
        int score = sequence.getColors().size();
        if(score < 5){
            label.setText("smh u must have alzheimer's. your score was " + sequence.getColors().size());
        }else if(score < 10){
            label.setText("ehh u did okay. your score was " + sequence.getColors().size());
        }else if(score < 15){
            label.setText("nice job! your score was " + sequence.getColors().size());
        }else{
            label.setText("dang you're good at this. your score was " + sequence.getColors().size());
        }
    }

    private static void mouseStuff(){
        board.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int xCord = evt.getX();
                int yCord = evt.getY();
                if(xCord > 50 && xCord < 150 && yCord > 50 && yCord < 150){
                    choice = 0;
                }else if(xCord >150 && xCord < 250 && yCord > 50 && yCord <150){
                    choice = 1;
                }else if(xCord >50 && xCord < 150 && yCord > 150 && yCord <250){
                    choice = 2;
                }else if(xCord >150 && xCord < 250 && yCord > 150 && yCord <250){
                    choice = 3;
                }
                //System.out.println("you clicked " + fourColors[choice]);
                hasClicked = true;
            }
        });
    }


    private static void paintCurrentSequence(ArrayList<Integer> colors){
        for(int i = 0;i<colors.size();i++){
            board.setState(colors.get(i));
            //System.out.println("painting: " + (colors.get(i) + 1));
            board.paintComponent(board.getGraphics());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            board.setState(4);
            board.paintComponent(board.getGraphics());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createWindow(){
        frame.setSize(320,330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        label.setSize(300,20);
        label.setLocation(10,10);
    }

    private static void display(){
        board.add(label);
        frame.add(board);
    }
}
