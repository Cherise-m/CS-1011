package lab07;

public class DieDriver {
    public static void main(String[] args) {
        Die die1 = new Die(8);
        die1.roll();

        System.out.println("die landed on the number:" + die1.getCurrentValue());
    }
}
