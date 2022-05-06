package sevenXOGameOOP;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;

public class Map extends JPanel {

    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;

    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int DIAGONAL = 2;
    private static final int REVERT_DIAGONAL = 3;

    private static final int EMPTY_DOT = 0;
    private static final int HUMAN_DOT = 1;
    private static final int AI_DOT = 2;
    private static final int HUMAN_2_DOT = 3;

    private static final int DOT_PADDING = 15;

    private static final int STATUS_HUMAN_WIN = 0;
    private static final int STATUS_AI_WIN = 1;
    private static final int STATUS_DRAW = 2;
    private static final int STATUS_PLAYER_1_WIN = 3;
    private static final int STATUS_PLAYER_2_WIN = 4;


    private static final Random RANDOM = new Random();
    MouseListener ml;

    private int[][] field;
    private int cellWidth;
    private int cellHeight;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int modGame;
    private boolean isGameOver;
    private int statusGameOver;
    private int moveNow;
    int howMoveNext;

    private Image circle;
    private Image cross;
    private Image ln_h;
    private Image ln_v;
    private Image draw;
    private Image win;
    private Image lose;
    private Image player1;
    private Image player2;

    Map(){
        setBackground(Color.BLACK);
    }
    void startGame(int mod, int fieldSizeX, int fieldSizeY, int winLength){

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.modGame = mod;
        this.winLength = winLength;
        cellWidth = getWidth() / fieldSizeX;
        cellHeight = getHeight() / fieldSizeY;
        this.field = new int[fieldSizeY][fieldSizeX];
        fieldInit();
        isGameOver = false;
        this.moveNow = HUMAN_DOT;
        this.howMoveNext = -1;
        try {
            circle = ImageIO.read(Map.class.getResourceAsStream("image\\circle.png"));
            cross = ImageIO.read(Map.class.getResourceAsStream("image\\cross.png"));
            ln_h = ImageIO.read(Map.class.getResourceAsStream("image\\ln_h.png"));
            ln_v = ImageIO.read(Map.class.getResourceAsStream("image\\ln_v.png"));
            draw = ImageIO.read(Map.class.getResourceAsStream("image\\draw.png"));
            lose = ImageIO.read(Map.class.getResourceAsStream("image\\lose.png"));
            win = ImageIO.read(Map.class.getResourceAsStream("image\\win.png"));
            player1 = ImageIO.read(Map.class.getResourceAsStream("image\\player1.png"));
            player2 = ImageIO.read(Map.class.getResourceAsStream("image\\player2.png"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

         ml = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(modGame == MODE_HVA) {
                    update(e);
                    repaint();
                }else if(modGame == MODE_HVH){
                    update(e, moveNow);
                    repaint();

                }else {
                    throw new RuntimeException("Strange mod : " + modGame);
                }
                if(isGameOver) removeMouseListener(ml);
            }
        };
        addMouseListener(ml);
        repaint();
    }

    void update(MouseEvent e){
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if(!checkIsField(cellX,cellY) || !checkIsEmpty(cellX,cellY))return;
            field[cellY][cellX] = HUMAN_DOT;
        if (checkWin(HUMAN_DOT)){
            isGameOver = true;
            statusGameOver  = STATUS_HUMAN_WIN;
            System.out.println("YOU Win !!!!");
            return;
        }
        if (checkFullField()){
            isGameOver = true;
            statusGameOver = STATUS_DRAW;
            System.out.println("Draw game");
            return;
        }
            turnAi();
            if (checkWin(AI_DOT)) {
                isGameOver = true;
                statusGameOver = STATUS_AI_WIN;
                System.out.println("Compyter Win !!!!");
                return;
            }
            if (checkFullField()) {
                isGameOver = true;
                statusGameOver = STATUS_DRAW;
                System.out.println("Draw game");
                return;
            }
    }
    private void update(MouseEvent e, int moveNow){
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if(!checkIsField(cellX,cellY) || !checkIsEmpty(cellX,cellY))return;
            if(moveNow == HUMAN_DOT){
                howMoveNext = HUMAN_DOT;
                this.moveNow = HUMAN_2_DOT;
            }else {
                howMoveNext = HUMAN_2_DOT;
                this.moveNow = HUMAN_DOT;
            }
            field[cellY][cellX] = howMoveNext;
            if (checkWin(howMoveNext)){
                isGameOver = true;
                if(howMoveNext == HUMAN_DOT) statusGameOver  = STATUS_PLAYER_1_WIN;
                else if(howMoveNext == HUMAN_2_DOT) statusGameOver = STATUS_PLAYER_2_WIN;
                else throw new RuntimeException("Can't know plauer : " + howMoveNext);
                return;
            }
            if (checkFullField()){
                isGameOver = true;
                statusGameOver = STATUS_DRAW;
                System.out.println("Draw game");
                return;
            }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
    void render(Graphics g){
        printField(g);
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(checkIsEmpty(x,y))continue;
                if(field[y][x] == HUMAN_DOT){
                    g.drawImage(cross,x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2, null);
                }
                else if(field[y][x] == AI_DOT){
                    g.drawImage(circle, x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2, null);
                }
                else if(field[y][x] == HUMAN_2_DOT) {
                    g.drawImage(circle, x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2, null);
                }
                else {
                    throw new RuntimeException("Can't recognize cell: " + field[y][x]);
                }
            }
        }
        if(isGameOver)showMesgGameOver(g);
    }

    private void printField(Graphics g) {
        for (int i = 0; i <= fieldSizeY; i++) {
            g.drawImage(ln_v, i * cellWidth, 0 ,6, getHeight(),null);
        }
        for (int i = 0; i <= fieldSizeX; i++) {
            g.drawImage(ln_h,0, i * cellHeight, getWidth(), 6, null);
        }
    }
    private void showMesgGameOver (Graphics g){
        int x = getWidth() ;
        int y = getHeight() / 3;

        switch (statusGameOver){
            case STATUS_HUMAN_WIN:
                g.drawImage(win,0,y,x,y,null);
                break;
            case STATUS_AI_WIN:
                g.drawImage(lose,0,y,x,y,null);
                break;
            case STATUS_DRAW:
                g.drawImage(draw,0,y,x,y,null);
                break;
            case STATUS_PLAYER_1_WIN:
                g.drawImage(player1,0,y,x,y,null);
                break;
            case STATUS_PLAYER_2_WIN:
                g.drawImage(player2,0,y,x,y,null);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + statusGameOver);
        }
    }
    private boolean checkIsField(int x, int y){
        return x >= 0 & x < fieldSizeX & y >= 0 & y < fieldSizeY;
    }
    private  boolean checkIsEmpty(int x, int y){
        return field[y][x] == EMPTY_DOT;
    }
    private  void fieldInit(){
        for (int y = 0; y <field.length ; y++) {
            for (int x = 0; x < field.length ; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }
    private  boolean checkFullField(){
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
    private  boolean direction(int c, int y, int x, int direction){
        int a,b;
        int count = 0;
        switch (direction){
            case 0:
                a = 0; b = 1;
                break;
            case 1:
                a = 1; b = 0;
                break;
            case 2:
                a = 1; b = 1;
                break;
            case 3:
                a = 1; b = -1;
                break;
            default:
                b = fieldSizeX;
                a = fieldSizeY;
                break;
        }

        while (true) {
            if (y >= fieldSizeY || x >= fieldSizeX || x < 0) {
                return false;
            }
            if (field[y][x] == c) {
                y += a;
                x += b;
                count++;
                if (count == winLength) return true;
            } else break;
        }
        return false;
    }
    private  boolean checkWin(int c){
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(direction(c,y,x,HORIZONTAL)) return true;
                if(direction(c,y,x,VERTICAL)) return true;
                if( direction(c,y,x,DIAGONAL)) return true;
                if( direction(c,y,x,REVERT_DIAGONAL))return true;
            }
        }
        return false;
    }
    private  boolean aiTryToWin(){
        for (int y = 0; y <fieldSizeY ; y++) {
            for (int x = 0; x < fieldSizeX ; x++) {
                if(checkIsEmpty(x,y)){
                    field[y][x] = AI_DOT;
                    if(checkWin(AI_DOT)){
                        return true;
                    }
                    field[y][x] = EMPTY_DOT;
                }
            }
        }
        return false;
    }
    private  boolean aiToInterrupt(){
        for (int y = 0; y <fieldSizeY ; y++) {
            for (int x = 0; x < fieldSizeX ; x++) {
                if(checkIsEmpty(x,y)){
                    field[y][x] = HUMAN_DOT;
                    if(checkWin(HUMAN_DOT)){
                        field[y][x] = AI_DOT;
                        return true;
                    }
                    field[y][x] = EMPTY_DOT;
                }
            }
        }
        return false;
    }
    private  void  turnAi(){
        int x,y;
        if(aiTryToWin())return;
        if(aiToInterrupt()) return;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!checkIsEmpty(x, y));
        field[y][x] = AI_DOT;


    }
}
