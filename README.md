# Software Design Patterns — Assignment 4 (AITU)

![Java](https://img.shields.io/badge/Java-21-007396?logo=openjdk&logoColor=white)

## Overview

Assignment 4 for the Software Design Patterns course at Astana IT University.
The project demonstrates three classic **behavioral** design patterns from the
Gang of Four catalogue, each implemented as a self-contained package with a
driver in `Main.java`.

## Patterns Implemented

### Interpreter — `src/interpreter/`

Parses and evaluates simple arithmetic expressions (integer addition and
subtraction) by building a composite tree of `Expression` nodes.

| Class | Role |
|---|---|
| `Expression` | Terminal/non-terminal interface — declares `interpret() → int` |
| `NumberExpression` | Terminal node — wraps a literal integer |
| `OperatorExpression` | Non-terminal/composite node — applies `+` or `-` to two sub-expressions |
| `Interpreter` | Utility class — tokenises an arithmetic string (e.g. `"1 + 2 - 3"`) and builds the expression tree left-to-right; ignores whitespace |

```java
System.out.println(Interpreter.parse("1+2+3").interpret());      // 6
System.out.println(Interpreter.parse("1+2+3-4").interpret());    // 2
System.out.println(Interpreter.parse("10+2+3-4-5").interpret()); // 6
System.out.println(Interpreter.parse("1 + 2 + 3 + 4").interpret()); // 10
```

### Memento — `src/memento/`

Implements undo functionality for a simple text editor.

| Class | Role |
|---|---|
| `Memento` | Value object — holds a single immutable state snapshot (`String`) |
| `History` | Caretaker — `Stack<Memento>` with `push`/`pop` |
| `TextEditor` | Originator (alternate variant) — produces `TextEditor.Memento` inner-class snapshots |
| `TextEditorMemento` | Originator + integrated caretaker — `addText`, `save`, `restore`, `getText`; used by `Main` |

```java
TextEditorMemento editor = new TextEditorMemento();
editor.addText("Hello");    editor.save();
editor.addText(" World");   editor.save();
editor.addText("!");        editor.save();
editor.restore(); // "Hello World!"
editor.restore(); // "Hello World"
editor.restore(); // "Hello"
editor.restore(); // ""
```

### Observer — `src/observer/`

Models a news-broadcast system where a news agency publishes headlines and
registered channels receive them.

| Class | Role |
|---|---|
| `Observer` | Listener interface — `update(String message)` |
| `Observable` | Subject interface — `addObserver`, `removeObserver`, `notifyObservers` |
| `ObservableBase` | Abstract base — manages the subscriber `List` and dispatches notifications |
| `NewsAgency` | Concrete subject — extends `ObservableBase`; publishes via `addNews(String)` |
| `FirstNewsChannel` | Concrete observer — prints received headline |
| `SecondNewsChannel` | Concrete observer — prints received headline |

**OOP concepts exercised:** interfaces, abstract classes, inheritance,
encapsulation, composition.

## Project Structure

```
src/
├── Main.java                          # Driver — calls testExpression / testMemento / testObserver
├── interpreter/
│   ├── Expression.java                # interface: interpret() → int
│   ├── NumberExpression.java          # terminal: wraps a literal int
│   ├── OperatorExpression.java        # composite: +/- on two sub-expressions
│   └── Interpreter.java               # parser: tokenises string → Expression tree
├── memento/
│   ├── Memento.java                   # value object: immutable state snapshot
│   ├── History.java                   # caretaker: Stack<Memento>
│   ├── TextEditor.java                # originator (inner-class Memento variant)
│   └── TextEditorMemento.java         # originator + caretaker used by Main
└── observer/
    ├── Observable.java                # subject interface
    ├── ObservableBase.java            # abstract base — manages observer list
    ├── Observer.java                  # observer interface
    ├── NewsAgency.java                # concrete subject
    ├── FirstNewsChannel.java          # concrete observer 1
    └── SecondNewsChannel.java         # concrete observer 2
```

## How to Run

The project is a plain Java project (no build tool). You can run it from the
command line or from IntelliJ IDEA.

**From the command line (JDK 21+):**

```bash
# Compile from the project root
javac -d out \
  src/interpreter/*.java \
  src/memento/*.java \
  src/observer/*.java \
  src/Main.java

# Run
java -cp out Main
```

**From IntelliJ IDEA:** open the project root, let IDEA index it, then run the
`Main` class. All three demos run sequentially; individual sections can be
toggled by commenting/uncommenting the method calls in `main()`.

---

Adil Ormanov — [GitHub](https://github.com/Adilforest)
