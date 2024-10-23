package memento;

import java.util.Stack;

public class History {
    private final Stack<Memento> history;

    public History() {
        history = new Stack<>();
    }

    public void push(Memento memento) {
        history.push(memento);
    }

    public Memento pop() {
        if (history.isEmpty())
            return null;
        return history.pop();
    }
}