package sevenXOGameOOP;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

    Map(){
        setBackground(Color.BLACK);
    }
    void startGame(int mod, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.println("mod : " + mod);
        System.out.println("fieldSizeX : " + fieldSizeX);
        System.out.println("fieldSizeY : " + fieldSizeY);
        System.out.println("winLength : " + winLength);
    }
}
