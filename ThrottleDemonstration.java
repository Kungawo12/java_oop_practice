import edu.colorado.simulations.Throttle;

public class ThrottleDemonstration {
    public static void main(String[] args) {
        Throttle control = new Throttle(100);
        control.shift(3);
        
        final int SIZE = 8;
        final int SPOT = 3;

        Throttle small = new Throttle(SIZE);
        small.shift(SPOT);
        System.out.println("My small throttle is now at position ");
        System.out.println(SPOT + " out of "+ SIZE+".");
        System.out.println("The flow is now: "+small.getFlow());

        Throttle tiny = new Throttle(4);
        Throttle huge = new Throttle(10000);

        tiny.shift(5);
        huge.shift(20500);


        Throttle t1;
        Throttle t2;

        t1 = new Throttle(100);
        t1.shift(25);
        t2 = t1;
        t2.shift(-5);
        System.out.println("Flow of t1 is: "+t1.getFlow());
    }
}
