package gameXO;

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




        JButton btnStart = new JButton("Start");
        JButton btnExit = new JButton("Exit");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingGame.setVisible(true);
                map.removeMouseListener(map.ml);

            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        map = new Map();
        JPanel panelBot = new JPanel(new GridLayout(1,2));
        panelBot.add(btnStart);
        panelBot.add(btnExit);
        add(panelBot,BorderLayout.SOUTH);
        add(map,BorderLayout.CENTER);
        settingGame = new SettingGame(this);
        setVisible(true);
    }

    void startNewGame(int mod, int fieldSizeX, int fieldSizeY, int winLength){
        map.startGame( mod, fieldSizeX, fieldSizeY, winLength);
    }
}
