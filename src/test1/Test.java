package test1;

public class Test {

    //
    public int maxNumber(int x, int y) {
        if(x > y) {
            return x;
        }
        else {
            return y;
        }
    }

    public double maxNumber(double x, double y) {
        if(x > y) {
            return x;
        }
        else {
            return y;
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage() {
        System.out.println("HELLO");
    }

    public void printMessage(String message, String message1) {
        System.out.println(message);
    }
}
