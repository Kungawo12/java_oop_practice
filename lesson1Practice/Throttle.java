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
        // Create a throttle with a maximum position of 5
        Throttle throttle = new Throttle(5);

        // Check if it's on initially (should be off)
        System.out.println("Throttle is on: " + throttle.isOn());  // false

        // Increase throttle by 3
        throttle.shift(3);
        System.out.println("Flow rate: " + throttle.getFlow());    // 0.6
        System.out.println("Throttle is on: " + throttle.isOn());  // true

        // Increase throttle by more than allowed
        throttle.shift(5);  // Should cap at top
        System.out.println("Flow rate after overshift: " + throttle.getFlow());  // 1.0

        // Turn it off
        throttle.shutOff();
        System.out.println("Throttle is on after shutOff: " + throttle.isOn());  // false
        System.out.println("Flow rate after shutOff: " + throttle.getFlow());    // 0.0

        // Try shifting negatively
        throttle.shift(-2); // Should stay at 0
        System.out.println("Flow rate after negative shift: " + throttle.getFlow()); // 0.0
    }
}