import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.print.DocFlavor.STRING;

import javafx.scene.effect.ImageInput;

import java.io.IOException;

class hello100 {
    public static void main(String[] args) {
        int i = 1;
        try {
            while (i < 101) {
                System.out.println("\n" + i +"人目「Hello」");
                String str = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                str = br.readLine();
                if(str.equals("hello")){
                    System.out.println(i + "人目「Hello World!!」");
                }else{
                    System.out.println(i + "人目「は？？？？？？？」");
                }
                i++;
                }
        } catch (IOException e) {
                 System.out.println("\nGoodbye");
            }
    }
}