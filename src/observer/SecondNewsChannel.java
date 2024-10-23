package observer;

public class SecondNewsChannel implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Second news channel received the message: " + message);
    }
}