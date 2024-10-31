import interpreter.*;
import memento.*;
import observer.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        testExpression();
        testMemento();
//        testObserver();
    }

    public static void testExpression() {
        System.out.println(Interpreter.parse("1+2+3").interpret()); // 6
        System.out.println(Interpreter.parse("1+2+3-4").interpret()); // 2
        System.out.println(Interpreter.parse("10+2+3-4-5").interpret()); // 6
        System.out.println(Interpreter.parse("1 + 2 + 3 + 4").interpret()); // 10
    }

    public static void testMemento() {
        TextEditorMemento editor = new TextEditorMemento();

        editor.addText("Hello");
        editor.save();
        System.out.println(editor.getText()); // Hello

        editor.addText(" World");
        editor.save();
        System.out.println(editor.getText()); // Hello World

        editor.addText("!");
        editor.save();
        System.out.println(editor.getText()); // Hello World!

        editor.restore();
        System.out.println(editor.getText()); // Hello World!

        editor.restore();
        System.out.println(editor.getText()); // Hello World

        editor.restore();
        System.out.println(editor.getText()); // Hello

        editor.restore();
        System.out.println(editor.getText()); //


    }

    public static void testObserver() {
        NewsAgency observable = new NewsAgency();
        Observer observer1 = new FirstNewsChannel();
        Observer observer2 = new SecondNewsChannel();

        observable.addObserver(observer1);
        observable.addObserver(observer2);

        observable.addNews("first news");
        System.out.println("----");

        observable.addNews("second news");
        System.out.println("----");

        observable.addNews("third news");
        System.out.println("----");

        observable.removeObserver(observer1);

        observable.addNews("fourth news");
        System.out.println("----");

        observable.removeObserver(observer2);
        observable.addObserver(observer1);

        observable.addNews("fifth news");
        System.out.println("----");
    }
}