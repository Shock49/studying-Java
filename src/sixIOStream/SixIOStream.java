package sixIOStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class SixIOStream {
    private static final Random random = new Random();
    private static String createWord(int len){
        String string = "";
        for (int i = 0; i < len; i++) {
            string += (char)(random.nextInt(91-65)+65);
        }
        return string;
    }
    private static void fillWordFile(File fileName) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new FileOutputStream(fileName,true));
        int count = random.nextInt(10);
        for (int i = 0; i < 10; i++) {
            if(i != count) {
                ps.print(createWord(random.nextInt(10-6)+6) + " ");
            }else {ps.print("KEY ");}
        }
        ps.println();
        ps.flush();
        ps.close();
    }
    private static void mergFile(File file1, File file2, File fileFinish) throws FileNotFoundException{
       PrintStream ps = new PrintStream(new FileOutputStream(fileFinish,true));
        Scanner sc = new Scanner(new FileInputStream(file1));
        while (sc.hasNext()){
            ps.println(sc.nextLine());
        }
        ps.flush();
        sc.close();
        sc = new Scanner(new FileInputStream(file2));
        while (sc.hasNext()){
            ps.println(sc.nextLine());
        }
        sc.close();
        ps.flush();
        ps.close();
    }
    private static boolean searchWord(File file, String word) throws FileNotFoundException{
        Scanner sc = new Scanner(new FileInputStream(file));
        byte[] v1 = word.getBytes();
        while (sc.hasNext()){
            byte[] v2 = sc.next().getBytes();
            if (v1.length == v2.length) {
                for (int i = 0; i < word.length(); i++) {
                    if (v1[i] != v2[i]) {
                        break;
                    }
                }
                sc.close();
                return true;
            }
        }
        sc.close();
        return false;
    }
    private static boolean searchWordInFolder(File folder, String word) throws FileNotFoundException{
        File[] folderFile = folder.listFiles();
        for (int i = 0; i < folderFile.length; i++) {
            Scanner sc = new Scanner(new FileInputStream(folderFile[i].getAbsolutePath()));
            byte[] v1 = word.getBytes();
            while (sc.hasNext()){
                byte[] v2 = sc.next().getBytes();
                if (v1.length == v2.length) {
                    for (int j = 0; j < word.length(); j++) {
                        if (v1[j] != v2[j]) {
                            break;
                        }
                    }
                    sc.close();
                    return true;
                }
            }
            sc.close();
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            File f1 = new File("F://JavaHomeWork//Java_lvl_1//src//SixIOStream//fileTxt//file_1.txt");
            File f2 = new File("F://JavaHomeWork//Java_lvl_1//src//SixIOStream//fileTxt//file_2.txt");
            File f3 = new File("F://JavaHomeWork//Java_lvl_1//src//SixIOStream//fileTxt//file_3.txt");
            fillWordFile(f1);
            fillWordFile(f2);
            mergFile(f1,f2,f3);
            System.out.println("Search word file1 : " + searchWord(f1,"KEY"));
            System.out.println("Search word file2 : " + searchWord(f2,"KEY"));
            System.out.println("Search word folder SixIOStream : " + searchWordInFolder(new File("F://JavaHomeWork//Java_lvl_1//src//SixIOStream//fileTxt"),"false"));

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
