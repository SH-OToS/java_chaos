import java.io.*;
import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.util.regex.*;
import java.util.Random;

// 名前の由来: Something that was just a greeting program
// 改造しすぎて趣旨が変わってきたので名前を変えたけど実質hello100.javaです
class STWJAGP {
    public static void main(String[] args) {
        int i = 1;
        int f = 0;
        int ii = 101;
        int tmp;
        boolean k = true;
        boolean name_boolean = false;
        String name = null;
        Pattern pCheat = Pattern.compile("^cheat [0-9]{0,3} [a-z]{4}$");
        Pattern pEcho = Pattern.compile("^echo |^echo$");
        Pattern pName = Pattern.compile("^name |^name$");
        Pattern pRand = Pattern.compile("^rand [0-9]{0,9}$|^rand$");
        Pattern pReve = Pattern.compile("^reve |^reve$");
        Random Rnd = new Random();
        System.out.println("説明: HELPと入力");
        try {
            while (i < ii) {
                if (name_boolean){
                    System.out.println("\n" + i + "人目の" + name + "「Hello」");
                }else{
                    System.out.println("\n" + i + "人目「Hello」");
                }
                String str = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                str = br.readLine();
                String str_cat = str.toLowerCase();
                Matcher mCheat = pCheat.matcher(str_cat);
                Matcher mEcho = pEcho.matcher(str_cat);
                Matcher mName = pName.matcher(str_cat);
                Matcher mRand = pRand.matcher(str_cat);
                Matcher mReve = pReve.matcher(str_cat);
                if (str_cat.equals("exit")) {
                    System.out.println("\nGoodBye");
                    System.exit(0);
                    break;
                }
                if (str_cat.equals("help")) {
                    System.out.println(
                            "\n--HELP--\n100回挨拶するかExitと打つまで終了できません\nExit: 終了\necho: 名前の通りエコー命令です\n  echo [テキスト]と打つとテキストの部分が帰ってきます\nName: Helloって言ってくるやつに名前をつけられます\n  name [名前]でnameの部分が名前として設定されます\n  nameのみ打つと名前機能が解除されます\nRand: 乱数です。以上\n  Rand [数値]で0から数値の値までの乱数を生成します\n  Rand空打ちで0から2147483647までの乱数を生成します\nReve: 文字列反転です\n  Reve [文字列]で文字列の部分を反転させます\nCheat: チートできます\n  Cheatの命令: \n     kill 全体の人数を指定された人数消せる\n     fcon 得点を追加できる\n  Cheatの書式: Cheat [-99~999](三桁で入力してください) [命令]\n※入力は大文字小文字関係なく認識されます。\n--HELP--\n");
                    continue;
                }
                if (mReve.find()){
                    if(str_cat.length() > 5){
                        String str_reve_cat = str.substring(5, str.length());
                        StringBuffer str_reve = new StringBuffer(str_reve_cat);
                        String rev = str_reve.reverse().toString();
                        System.out.println("\n--Reverse--\n" + rev + "\n--Reverse--\n");
                    }else{
                        System.out.println("\n--Reverse--\nError: 内容がありません\n--Reverse--\n");
                    }
                    continue;
                }
                if (mRand.find()){
                    if(str_cat.length() > 5){
                        String str_rand = str.substring(5, str.length());
                        int num_rand = Integer.parseInt(str_rand);
                        if(num_rand < 1){
                            System.out.println("\n--Random--\n" + (Rnd.nextInt(2147483647)) + "\n--Random--\n");
                        }else{
                            System.out.println("\n--Random--\n" + (Rnd.nextInt(num_rand)) + "\n--Random--\n");
                        }
                    }else{
                        System.out.println("\n--Random--\n" + (Rnd.nextInt(2147483647)) + "\n--Random--\n");
                    }
                    continue;
                }
                if (mEcho.find()){
                    if(str_cat.length() > 5){
                        String str_echo = str.substring(5, str.length());
                        System.out.println("\n--echo--\n" + str_echo + "\n--echo--\n");
                    }else{
                        System.out.println("\n--echo--\n(null)\n--echo--\n");
                    }
                    continue;
                }
                if (mName.find()){
                    if(str_cat.length() > 5){
                        name = str.substring(5, str.length());
                        name_boolean = true;
                        System.out.println("\n--Name--\nName機能を有効にしました\n現在の名前は" + name + "です\n--Name--");
                    }else{
                        name_boolean = false;
                        System.out.println("\n--Name--\nName機能を無効にしました\n--Name--\n");
                    }
                    continue;
                }
                if (mCheat.find()) {
                    int num_len = str_cat.length();
                    String num_str = str_cat.substring(num_len - 8, num_len - 5);
                    int num = Integer.parseInt(num_str);
                    String num_command = str_cat.substring(num_len - 4, num_len);
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
                if (name_boolean){
                    if (str_cat.equals("hello")) {
                        System.out.println(i + "人目の" + name + "「Hello!!!」");
                        f++;
                        k = false;
                    } else {
                        System.out.println(i + "人目の" + name + "「は？？？？？？？」");
                        f--;
                        k = true;
                    }
                }else{
                    if (str_cat.equals("hello")) {
                        System.out.println(i + "人目「Hello World!!」");
                        f++;
                        k = false;
                    } else {
                        System.out.println(i + "人目「は？？？？？？？」");
                        f--;
                        k = true;
                    }
                }
                i++;
                if (f < 100 && k) {
                    System.out.println("得点: " + f);
                    ii++;
                } else {
                    System.out.println("得点: " + f);
                }
                System.out.println("残り人数: " + (ii - i));
            }
            System.out.println("\nお疲れ様でした");
        } catch (IOException e) {
            System.out.println("\nBREAK");
        }
        
    }
}