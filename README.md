# Software Design Patterns — Assignment 4 (AITU)

![Java](https://img.shields.io/badge/Java-21-007396?logo=openjdk&logoColor=white)

## Overview

Assignment 4 for the Software Design Patterns course at Astana IT University.
The project demonstrates three classic **behavioral** design patterns from the
Gang of Four catalogue, each implemented as a self-contained package with a
driver in `Main.java`.

## Patterns / Concepts Implemented

- **Interpreter** — `src/interpreter/` — parses and evaluates simple
  arithmetic expressions (integer addition and subtraction) by building a
  composite tree of `Expression` nodes: `NumberExpression` for terminals and
  `OperatorExpression` for binary operations. An `Interpreter` utility class
  handles tokenisation and tree construction from a string like `"1 + 2 - 3"`.
  *(Note: the `Interpreter` parser class and `TextEditorMemento` wrapper are
  referenced in `Main.java` but not present in the repository — only the
  expression-tree classes are committed.)*

- **Memento** — `src/memento/` — implements undo functionality for a text
  editor. `TextEditor` produces `TextEditor.Memento` snapshots (inner class
  with private access). A separate standalone `Memento` value class and a
  `History` stack-based caretaker are also present, reflecting two variants
  explored during development.

- **Observer** — `src/observer/` — models a news-broadcast system.
  `Observable` is the subject interface; `ObservableBase` is an abstract class
  that manages the subscriber list and implements notify logic, reducing
  boilerplate in concrete subjects. `NewsAgency` extends `ObservableBase` and
  publishes headlines. `FirstNewsChannel` and `SecondNewsChannel` implement the
  `Observer` interface and print received messages.

**OOP concepts exercised:** interfaces, abstract classes, inheritance,
encapsulation (private inner class for Memento state), composition.

## Project Structure

```
src/
├── Main.java                      # Driver — calls testExpression / testMemento / testObserver
├── interpreter/
│   ├── Expression.java            # interface: interpret() → int
│   ├── NumberExpression.java      # terminal: wraps a literal int
│   └── OperatorExpression.java    # composite: +/- on two sub-expressions
├── memento/
│   ├── TextEditor.java            # originator with nested Memento inner class
│   ├── Memento.java               # standalone memento value object
│   └── History.java               # caretaker — Stack<Memento>
└── observer/
    ├── Observable.java            # subject interface
    ├── ObservableBase.java        # abstract base — manages observer list
    ├── Observer.java              # observer interface
    ├── NewsAgency.java            # concrete subject
    ├── FirstNewsChannel.java      # concrete observer 1
    └── SecondNewsChannel.java     # concrete observer 2
```

## How to Run

The project is a plain Java project (no build tool). You can run it from the
command line or from IntelliJ IDEA.

**From the command line (JDK 21+):**

```bash
# Compile from the src/ directory
javac -d out \
  src/interpreter/*.java \
  src/memento/*.java \
  src/observer/*.java \
  src/Main.java

# Run
java -cp out Main
```

**From IntelliJ IDEA:** open the project root, let IDEA index it, then run the
`Main` class. The active demo can be switched by un-commenting the relevant
method call in `main()`.

---

Adil Ormanov — [GitHub](https://github.com/Adilforest)
