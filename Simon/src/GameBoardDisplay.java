import javax.swing.*;
import java.awt.*;

public class GameBoardDisplay extends JComponent {

    private Graphics2D g2;
    private int state;
    private Color lightRed = new Color(255,105,97);
    private Color darkRed = new Color(255,20,20);
    private Color lightGreen = new Color(144,238,144);
    private Color darkGreen = new Color(11,150,11);
    private Color lightBlue = new Color(150,223,255);
    private Color darkBlue = new Color(20,20,255);
    private Color lightYellow = new Color(250,250,190);
    private Color darkYellow = new Color(255,255,20);

    public void paintComponent(Graphics g){
        g2 = (Graphics2D) g;
        if(state == 0) {
            paintRed();
        }else if(state == 1){
            paintGreen();
        }else if(state == 2){
            paintBlue();
        }else if(state == 3){
            paintYellow();
        }else{
            paintBlank();
        }
    }

    public void setState(int s){
        state = s;
    }

    public void paintBlank(){
        g2.setColor(lightRed);
        Rectangle topLeft = new Rectangle(50,50,100,100);
        g2.fill(topLeft);
        g2.setColor(lightGreen);
        Rectangle topRight = new Rectangle(150,50,100,100);
        g2.fill(topRight);
        g2.setColor(lightBlue);
        Rectangle bottomLeft = new Rectangle(50,150,100,100);
        g2.fill(bottomLeft);
        g2.setColor(lightYellow);
        Rectangle bottomRight = new Rectangle(150,150,100,100);
        g2.fill(bottomRight);
    }
    public void paintRed(){
        g2.setColor(darkRed);
        Rectangle topLeft = new Rectangle(50,50,100,100);
        g2.fill(topLeft);
        g2.setColor(lightGreen);
        Rectangle topRight = new Rectangle(150,50,100,100);
        g2.fill(topRight);
        g2.setColor(lightBlue);
        Rectangle bottomLeft = new Rectangle(50,150,100,100);
        g2.fill(bottomLeft);
        g2.setColor(lightYellow);
        Rectangle bottomRight = new Rectangle(150,150,100,100);
        g2.fill(bottomRight);
    }

    public void paintGreen(){
        g2.setColor(lightRed);
        Rectangle topLeft = new Rectangle(50,50,100,100);
        g2.fill(topLeft);
        g2.setColor(darkGreen);
        Rectangle topRight = new Rectangle(150,50,100,100);
        g2.fill(topRight);
        g2.setColor(lightBlue);
        Rectangle bottomLeft = new Rectangle(50,150,100,100);
        g2.fill(bottomLeft);
        g2.setColor(lightYellow);
        Rectangle bottomRight = new Rectangle(150,150,100,100);
        g2.fill(bottomRight);
    }

    public void paintBlue(){
        g2.setColor(lightRed);
        Rectangle topLeft = new Rectangle(50,50,100,100);
        g2.fill(topLeft);
        g2.setColor(lightGreen);
        Rectangle topRight = new Rectangle(150,50,100,100);
        g2.fill(topRight);
        g2.setColor(darkBlue);
        Rectangle bottomLeft = new Rectangle(50,150,100,100);
        g2.fill(bottomLeft);
        g2.setColor(lightYellow);
        Rectangle bottomRight = new Rectangle(150,150,100,100);
        g2.fill(bottomRight);
    }

    public void paintYellow(){
        g2.setColor(lightRed);
        Rectangle topLeft = new Rectangle(50,50,100,100);
        g2.fill(topLeft);
        g2.setColor(lightGreen);
        Rectangle topRight = new Rectangle(150,50,100,100);
        g2.fill(topRight);
        g2.setColor(lightBlue);
        Rectangle bottomLeft = new Rectangle(50,150,100,100);
        g2.fill(bottomLeft);
        g2.setColor(darkYellow);
        Rectangle bottomRight = new Rectangle(150,150,100,100);
        g2.fill(bottomRight);
    }
}
