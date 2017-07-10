import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

import javax.print.DocFlavor.STRING;

import java.util.regex.*;

import javafx.scene.effect.ImageInput;
import java.io.IOException;

class hello100 {
    public static void main(String[] args) {
        int i = 1;
        int f = 0;
        int ii = 101;
        boolean k = true;
        Pattern p = Pattern.compile("^hello$|^Hello$|^HELLO$");
        System.out.println("100回挨拶するまで終了できません");
        try {
            while (i < ii) {
                System.out.println("\n" + i + "人目「Hello」");
                String str = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                str = br.readLine();
                Matcher m = p.matcher(str);
                if (m.find()) {
                    System.out.println(i + "人目「Hello World!!」");
                    f++;
                    k = false;
                } else {
                    System.out.println(i + "人目「は？？？？？？？」");
                    f--;
                    k = true;
                }
                i++;
                if (f < 100 && k){
                    System.out.println("得点: " + f);
                    ii++;
                    System.out.println("残り人数" + (ii - i));
                }else{
                    System.out.println("得点: " + f);
                    System.out.println("残り人数" + (ii - i));
                }
            }
        } catch (IOException e) {
            System.out.println("\nGoodbye");
        }
    }
}