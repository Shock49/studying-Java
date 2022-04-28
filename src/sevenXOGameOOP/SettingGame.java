package sevenXOGameOOP;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingGame extends JFrame {
    private static final int WIDTH_SETTING_WINDOW = 400;
    private static final int HEIGHT_SETTING_WINDOW = 500;
    private static final int FIELD_SIZE_MIN = 3;
    private static final int FIELD_SIZE_MAX = 10;
    private static final int WIN_LENGTH = 3;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";
    private final Font font =  new Font("Century Gothic", Font.BOLD, 15);

    private GameWindow gameWindow;
    private JRadioButton btnHumVSHum ;
    private JRadioButton btnAiVSHum;
    private JSlider sliderField;
    private JSlider sliderWinLength;
    Button buttonOK;

    SettingGame(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setTitle("Setting");
        setSize(WIDTH_SETTING_WINDOW,HEIGHT_SETTING_WINDOW);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10,1));
        addModeGame();
        addFieldControl();
        buttonOK = new Button("OK");
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickBtnStart();
            }
        });
        add(buttonOK);
    }

    void addModeGame(){
        JLabel lb = new JLabel("Mod Game");
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setFont(font);
        add(lb);
        btnHumVSHum = new JRadioButton("Human vs Human");
        btnAiVSHum = new JRadioButton("Computer vs Human");
        ButtonGroup gameMod = new ButtonGroup();
        gameMod.add(btnHumVSHum);
        gameMod.add(btnAiVSHum);
        btnHumVSHum.setSelected(true);
        add(btnHumVSHum);
        add(btnAiVSHum);
    }

    void addFieldControl(){
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + FIELD_SIZE_MIN);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + WIN_LENGTH);
        sliderField = new JSlider(FIELD_SIZE_MIN,FIELD_SIZE_MAX);
        sliderWinLength = new JSlider(WIN_LENGTH,FIELD_SIZE_MIN);
        sliderField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderField.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue());
            }
        });
        JLabel lb = new JLabel("Setting fiel size");
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setFont(font);
        add(lb);
        add(lbFieldSize);
        add(sliderField);
        JLabel lb2 = new JLabel("Setting win length");
        lb2.setHorizontalAlignment(JLabel.CENTER);
        lb2.setFont(font);
        add(lb2);
        add(lbWinLength);
        add(sliderWinLength);
    }

    void onClickBtnStart(){
     int gameMod;
     if(btnHumVSHum.isSelected())
         gameMod = Map.MODE_HVH;
     else if(btnAiVSHum.isSelected())
         gameMod = Map.MODE_HVA;
     else
         throw new RuntimeException("Unexpected game mode!");
     int fieldSize = sliderField.getValue();
     int winLength = sliderWinLength.getValue();
     gameWindow.startNewGame(gameMod,fieldSize,fieldSize,winLength);
     setVisible(false);
    }
}
