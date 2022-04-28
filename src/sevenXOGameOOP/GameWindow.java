package sevenXOGameOOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIDTH_WINDOW = 600;
    private static final int HEIGHT_WINDOW = 700;
    private Map map;
    private SettingGame settingGame;



    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH_WINDOW,HEIGHT_WINDOW);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Game X / O");
        setVisible(true);

        map = new Map();
        SettingGame settingGame = new SettingGame(this);
        JPanel botPanel = new JPanel(new GridLayout(1,2));
        Button btnStart = new Button("Start");
        Button btnExit = new Button("Exit");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingGame.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botPanel.add(btnStart);
        botPanel.add(btnExit);
        add(botPanel,BorderLayout.SOUTH);
        add(map,BorderLayout.CENTER);

    }

    void startNewGame(int mod, int fieldSizeX, int fieldSizeY, int winLength){
        map.startGame( mod, fieldSizeX, fieldSizeY, winLength);
    }
}
