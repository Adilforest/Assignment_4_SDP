package observer;

public class FirstNewsChannel implements Observer {
    @Override
    public void update(String message) {
        System.out.println("First news channel received the message: " + message);
    }
}