package memento;

/**
 * Originator + integrated Caretaker for a simple text editor.
 *
 * <p>Demonstrates the <strong>Memento</strong> pattern: the current text content
 * is the mutable originator state; each call to {@link #save()} pushes a
 * {@link Memento} snapshot onto the {@link History} stack; {@link #restore()}
 * pops the most-recently-saved snapshot and resets the editor to that state,
 * or clears the content when the history stack is exhausted.</p>
 */
public class TextEditorMemento {

    private String text;
    private final History history;

    public TextEditorMemento() {
        this.text = "";
        this.history = new History();
    }

    /**
     * Appends {@code newText} to the current content.
     */
    public void addText(String newText) {
        text = text + newText;
    }

    /**
     * Returns the current content of the editor.
     */
    public String getText() {
        return text;
    }

    /**
     * Saves a snapshot of the current state onto the history stack.
     */
    public void save() {
        history.push(new Memento(text));
    }

    /**
     * Restores the most-recently-saved state from the history stack.
     * If the stack is empty, the content is reset to an empty string.
     */
    public void restore() {
        Memento memento = history.pop();
        text = (memento != null) ? memento.getState() : "";
    }
}
