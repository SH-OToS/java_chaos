import java.io.*;
import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.util.regex.*;

import javafx.scene.effect.ImageInput;

class hello100 {
    public static void main(String[] args) {
        int i = 1;
        int f = 0;
        int ii = 101;
        boolean k = true;
        Pattern p = Pattern.compile("^hello$|^Hello$|^HELLO$");
        Pattern pExit = Pattern.compile("^exit$|^EXIT$|^Exit$");
        Pattern pHelp = Pattern.compile("^help$|^HELP$|^Help$");
        System.out.println("説明: HELPと入力");
        try {
            while (i < ii) {
                System.out.println("\n" + i + "人目「Hello」");
                String str = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                str = br.readLine();
                Matcher m = p.matcher(str);
                Matcher mExit = pExit.matcher(str);
                Matcher mHelp = pHelp.matcher(str);
                if(mExit.find()){
                    System.exit(0);
                    break;
                }
                if(mHelp.find()){
                    System.out.println("\n--HELP--\n100回挨拶するかExitと打つまで終了できません\nExit: 終了\n※入力は大文字小文字関係なく認識されます\n--HELP--\n");
                    continue;
                }
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
                if (f < 100 && k) {
                    System.out.println("得点: " + f);
                    ii++;
                    System.out.println("残り人数" + (ii - i));
                } else {
                    System.out.println("得点: " + f);
                    System.out.println("残り人数" + (ii - i));
                }
            }
        } catch (IOException e) {
            System.out.println("\nGoodbye");
        }
    }
}