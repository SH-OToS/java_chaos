import java.util.Random;

class dice {
  public static void main(String[] args) {
    Random rand = new Random();
    if (args.length >= 2) {
      int rand_int = Integer.parseInt(args[0]);
      int rand_count = Integer.parseInt(args[1]);
      int i = 0;
      System.out.println("\n" + 1 + "から" + rand_int + "までの乱数" + rand_count + "回");
      while (rand_count > i) {
        System.out.println("rand" + (i + 1) + "回目: " + (rand.nextInt(rand_int) + 1));
        i++;
      }
    } else {
      if (args.length >= 1) {
        int rand_int = Integer.parseInt(args[0]);
        System.out.println("\n" + 1 + "から" + rand_int + "までの乱数");
        System.out.println("\nrand: " + (rand.nextInt(rand_int) + 1) + "\n");
      } else {
        System.out.println("\n引数が存在しないので６面ダイスを使用します");
        System.out.println("\nrand: " + (rand.nextInt(6) + 1) + "\n");
      }
    }
  }
}