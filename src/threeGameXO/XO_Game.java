package threeGameXO;

import java.util.Random;
import java.util.Scanner;

public class XO_Game {
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int DIAGONAL = 2;
    private static final int REVERT_DIAGONAL = 3;
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '_';
    private static final int POINT_WIN = 4;

    private static int fieldSizex = 5;
    private static int fieldSizey = 5;
    private static final char[][] field = new char[fieldSizey][fieldSizex];

    private static void fieldInit(){
        for (int y = 0; y <field.length ; y++) {
            for (int x = 0; x < field.length ; x++) {
             field[y][x] = EMPTY_DOT;
            }
        }
    }
    private static void printField(){
        System.out.println("_______");
        for (int y = 0; y <fieldSizey ; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSizex ; x++) {
                System.out.print(field[y][x]+"|");
            }
            System.out.println("");
        }
    }
    private static void turnHyman(){
        int x,y;
        do {
            System.out.println("Enter x and y : ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }while (!checkIsField(x,y) || !checkIsEmpty(x,y));
        field[y][x] = HUMAN_DOT;
    }
    private static void  turnAi(){
        int x,y;
        if(aiTryToWin())return;
        if(aiToInterrupt()) return;
        do {
            x = RANDOM.nextInt(fieldSizex);
            y = RANDOM.nextInt(fieldSizey);
        } while (!checkIsEmpty(x, y));
        field[y][x] = AI_DOT;


    }

    private static boolean checkIsField(int x, int y){
        return x >= 0 & x < fieldSizex & y >= 0 & y < fieldSizey;
    }
    private static boolean checkIsEmpty(int x, int y){
        return field[y][x] == EMPTY_DOT;
    }
    private static boolean checkFullField(){
        for (int y = 0; y < fieldSizey; y++) {
            for (int x = 0; x < fieldSizex; x++) {
                if(field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
    private static boolean direction(char c, int y, int x, int direction){
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
                b = fieldSizex;
                a = fieldSizey;
                break;
        }

        while (true) {
            if (y >= fieldSizey || x >= fieldSizex || x < 0) {
                return false;
            }
            if (field[y][x] == c) {
                y += a;
                x += b;
                count++;
                if (count == POINT_WIN) return true;
            } else break;
        }
       return false;
    }
    private static boolean checkWin(char c){
        for (int y = 0; y < fieldSizey; y++) {
            for (int x = 0; x < fieldSizex; x++) {
                if(direction(c,y,x,HORIZONTAL) || direction(c,y,x,VERTICAL) ||
                        direction(c,y,x,DIAGONAL) || direction(c,y,x,REVERT_DIAGONAL))return true;
            }
        }
        return false;
    }
    private static boolean aiTryToWin(){
        for (int y = 0; y <fieldSizey ; y++) {
            for (int x = 0; x < fieldSizex ; x++) {
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
    private static boolean aiToInterrupt(){
        for (int y = 0; y <fieldSizey ; y++) {
            for (int x = 0; x < fieldSizex ; x++) {
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
    public static void main(String[] args) {
        fieldInit();
        printField();
        while (true) {
            turnHyman();
            printField();
            if (checkWin(HUMAN_DOT)){
                System.out.println("YOU Win !!!!");
                break;
            }
            if (checkFullField()){
                System.out.println("Draw game");
                break;
            }
            turnAi();
            printField();
            if (checkWin(AI_DOT)){
                System.out.println("Compyter Win !!!!");
                break;
            }
            if (checkFullField()){
                System.out.println("Draw game");
                break;
            }
        }
    }

}
