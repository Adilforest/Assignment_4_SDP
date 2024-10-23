package memento;

public class TextEditorMemento {
    private final TextEditor editor;
    private final History history;

    public TextEditorMemento() {
        this.editor = new TextEditor();
        this.history = new History();
    }

    public void addText(String text) {
        editor.addText(text);
    }

    public String getText() {
        return editor.getText();
    }

    public void save() {
        Memento memento = editor.save();
        history.push(memento);
    }

    public void restore() {
        Memento memento = history.pop();
        if (memento != null)
            editor.restore(memento);
        else
            editor.restore(new Memento(""));
    }
}