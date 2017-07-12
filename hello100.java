import java.io.*;
import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.util.regex.*;
class hello100 {
    public static void main(String[] args) {
        int i = 1;
        int f = 0;
        int ii = 101;
        int tmp;
        boolean k = true;
        Pattern pCheat = Pattern.compile("^Cheat [0-9]{0,3} [a-zA-Z]{4}$|^cheat [0-9]{0,3} [a-zA-Z]{4}$|CHEAT [0-9]{0,3} [a-zA-Z]{4}$");
        System.out.println("説明: HELPと入力");
        try {
            while (i < ii) {
                System.out.println("\n" + i + "人目「Hello」");
                String str = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                str = br.readLine();
                String str_cat = str.toLowerCase();
                Matcher mCheat = pCheat.matcher(str);
                if (str_cat.equals("exit")) {
                    System.out.println("\nGoodBye");
                    System.exit(0);
                    break;
                }
                if (str_cat.equals("help")) {
                    System.out.println(
                            "\n--HELP--\n100回挨拶するかExitと打つまで終了できません\nExit: 終了\nCheat: チートできます\n  Cheatの命令: \n           kill 全体の人数を指定された人数消せる\n           fcon 得点を追加できる\n  Cheatの書式: Cheat [-99~999](三桁で入力してください) [命令]\n※入力は大文字小文字関係なく認識されます。ただし命令は小文字のみ認識されます\n--HELP--\n");
                    continue;
                }
                if (mCheat.find()) {
                    int num_len = str.length();
                    String num_str = str.substring(num_len - 8, num_len - 5);
                    int num = Integer.parseInt(num_str);
                    String num_command = str.substring(num_len - 4, num_len);
                    Pattern command_Pattern = Pattern.compile("kill|fcon");
                    Matcher command_Matcher = command_Pattern.matcher(num_command);
                    if (num_len < 14) {
                        System.out.println("Cheat Error: 書式が間違っています.詳しくはHelpで確認してください");
                        continue;
                    }
                    if (num_command.equals("kill")) {
                        i = i - num;
                        ii = ii - num;
                        System.out.println("\n--Cheat--\n" + num + "人消しました\n--Cheat--\n");
                    }
                    if (num_command.equals("fcon")) {
                        tmp = f;
                        f = num;
                        System.out.println("\n--Cheat--\n" + tmp + "点を" + num + "点に書き換えました\n--Cheat--\n");
                    }
                    if (!command_Matcher.find()){
                        System.out.println("Cheat Error: 指定された命令は存在しません");
                    }
                    continue;
                }
                if (str_cat.equals("hello")) {
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
                    System.out.println("残り人数: " + (ii - i));
                } else {
                    System.out.println("得点: " + f);
                    System.out.println("残り人数: " + (ii - i));
                }
            }
        } catch (IOException e) {
            System.out.println("\nGoodbye");
        }
    }
}