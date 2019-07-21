public class Counter {
    public static int wonX = 0;
    public static int wonO = 0;
    public static int draws = 0;

    public static void getStatistics(){
        System.out.println("x won: "+wonX);
        System.out.println("o won: "+ wonO);
        System.out.println("number of draws: "+draws);
    }

    public static void getSumm(){
        System.out.println(wonX+wonO+draws);
    }
}
