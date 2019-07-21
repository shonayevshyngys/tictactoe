public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        Tree tree = new Tree();
        tree.recure(b, true, 0);
        Counter.getStatistics();
        Counter.getSumm();
    }
}
