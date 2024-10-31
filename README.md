# Assignment 4: Behavioral Design Patterns

This project implements three behavioral design patterns as part of Assignment 4 for the Software Design Patterns course. The patterns are:

1. **Interpreter Pattern**: Evaluates simple arithmetic expressions.
2. **Memento Pattern**: Implements a simple text editor with undo functionality.
3. **Observer Pattern**: Simulates a news system where multiple observers (news channels) receive updates from an observable (news agency).

## Table of Contents

- [Design Patterns](#design-patterns)
  - [Interpreter Pattern](#interpreter-pattern)
  - [Memento Pattern](#memento-pattern)
  - [Observer Pattern](#observer-pattern)

## Design Patterns

### 1. Interpreter Pattern

The **Interpreter** pattern is used to evaluate arithmetic expressions consisting of integers, addition (`+`), and subtraction (`-`). It uses the following classes:

- `Expression` interface: Defines the `interpret()` method.
- `NumberExpression`: Handles integer values.
- `OperationExpression`: Handles the addition and subtraction operations.
- `Interpreter`: Parses a string expression like `"5 + 2 - 3"` and evaluates the result.

### 2. Memento Pattern

The **Memento** pattern is implemented in the context of a simple text editor. The text editor allows users to type text, save the current state, and undo changes. The pattern includes:

- `Memento`: Stores the state of the text.
- `TextEditor`: Manages text input and stores the state using the Memento.
- `History`: A stack-based history manager for saving and restoring `Memento` objects.

### 3. Observer Pattern

The **Observer** pattern is used in a news system where multiple observers (news channels) get notified whenever the observable (news agency) publishes new headlines. The pattern consists of:

- `Observable` interface: Defines methods to add, remove, and notify observers.
- `Observer` interface: Defines the `update()` method.
- `NewsAgency`: The observable that holds the latest headline and notifies observers.
- `NewsChannel`: The observer that receives updates from the news agency.
