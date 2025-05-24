

public class Throttle{
    private int top;
    private int position;

    public Throttle(int size){
        if(size <= 0){
            throw new IllegalArgumentException("Size <= 0: "+size);
        }
        top = size;
    }
    public double getFlow(){
        return (double) position/ (double) top;
    }
    public boolean isOn(){
        return  (getFlow() > 0);
    }
    public void shift(int amount){
        if(amount > top - position){
            position = top;
        }
        else if(position + amount < 0){
            position = 0;
        }
        else{
            position += amount;
        }
        
    }
    public void shutOff(){
        position =0;
    }

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
    }
}