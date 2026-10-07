# Doubly Linked Deque

A Java project demonstrating a deque (double-ended queue) built on a doubly linked
chain of nodes. Items can be added, removed, and inspected at either end in
constant time.

## Overview

| Type | Kind | Description |
|------|------|-------------|
| `DequeInterface<T>` | Interface | Defines addToFront, addToBack, removeFront, removeBack, getFront, getBack, isEmpty, clear |
| `DLinkedDeque<T>` | Abstract class | Provides the `firstNode`, `lastNode`, and `size` fields, `size()`, and the nested `DLNode` class |
| `Lab07Deque<T>` | Class | Concrete deque: implements all operations plus `toString()` |
| `EmptyQueueException` | Runtime exception | Thrown when removing from or reading an empty deque |
| `Lab07DequeTest` | Test class | JUnit tests for every method, on empty and non-empty deques |

## How It Works

Each `DLNode` holds `previous`, `data`, and `next` references. The deque tracks both
the first and last node, so operations at either end never traverse the chain.

```java
addToFront("B") on [A] -> [B, A]
addToBack("C") on [B, A] -> [B, A, C]
removeFront() -> "B" // deque is now [A, C]
removeBack() -> "C" // deque is now [A]
```


## Exceptions

| Scenario | Exception |
|----------|-----------|
| `removeFront()` on an empty deque | `EmptyQueueException` |
| `removeBack()` on an empty deque | `EmptyQueueException` |
| `getFront()` on an empty deque | `EmptyQueueException` |
| `getBack()` on an empty deque | `EmptyQueueException` |

## Concepts Demonstrated

- **Doubly linked lists**: maintaining `previous` and `next` links on every insert and
  removal
- **Edge cases**: first insert into an empty deque, and removing the last remaining
  node from either end (both `firstNode` and `lastNode` must reset to null)
- **Abstract classes and generics**: `Lab07Deque<T>` extends the abstract
  `DLinkedDeque<T>`
- **Nested classes**: the protected static `DLNode<T>` used to build the chain
- **Custom runtime exceptions**: `EmptyQueueException` with default and message
  constructors
- **Unit testing**: exception paths, null elements, and mixed front/back sequences

## Project Structure

deque/

├── DequeInterface.java

├── DLinkedDeque.java

├── EmptyQueueException.java

├── Lab07Deque.java

└── Lab07DequeTest.java


## Running the Tests

The tests extend `student.TestCase`, so `student.jar` must be on your classpath.

1. Create a Java project and a package named `deque`
2. Place all five `.java` files in that package
3. Add `student.jar` to the project's build path
4. Run `Lab07DequeTest` as a JUnit test

## Example Usage

```java
Lab07Deque<String> deque = new Lab07Deque<>();
deque.addToBack("A");
deque.addToBack("B");
deque.addToFront("C");

deque.toString();    // "[C, A, B]"
deque.getFront();    // "C"
deque.getBack();     // "B"
deque.removeBack();  // "B"
deque.size();        // 2
```
