package memento;

public class TextEditor {
    private StringBuilder builder;

    public TextEditor() {
        this.builder = new StringBuilder();
    }

    public void addText(String text) {
        builder.append(text);
    }

    public String getText() {
        return builder.toString();
    }

    public Memento save() {
        return new Memento(builder.toString());
    }

    public void restore(Memento memento) {
        builder = new StringBuilder(memento.getState());
    }
}