# COMP20280 Data Structures 
#### Spring Trimester, 2020
Java programs from weekly practical sessions and assignments for the module COMP20280.   

## Getting Started
Follow these instructions to set up the project on IntelliJ or Eclipse.

#### IntelliJ IDEA
Clone the repository into your IntelliJ project, then:
* Mark the /src directory as Sources Root.
* Mark the /test directory as Test Sources Root.
* Add JUnit5.4 (org.junit.jupiter:junit-jupiter:5.4.2) under Project Structure > Libraries > + > From Maven.
* Right click on the /test directory and ‘Run All Tests’ to generate the JUnit test report.
* Run the main() method of a class to see a basic implementation test.

#### Eclipse
Clone the repository into your Eclipse project, then:
* Go to project Properties > Java Build Path > Source > set 'Contains test sources: Yes' for /test directory.
* Go to project Properties > Java Build Path > Source > set different 'Output folder' for /src and /test directories.
* If you don't have JUnit 5 set up, Eclipse will show errors for the /test directory.   
Open any test file, hover over an @Test annotation, and select 'Add JUnit 5 library to the build path'.
* Right click on the /test directory and 'Run As > JUnit Test' to generate the JUnit test report.
* Run the main() method of a class to see a basic implementation test.

## Summary
| # | Title | Solution | Test |  
|---| ----- | -------- | ---------- |
| 0 | [Interfaces](./src/projectCode20280) |-|-
| 1 | [Lists](./src/lists) | [SinglyLinkedList](./src/lists/SinglyLinkedList.java) | [SinglyLinkedListTest](./test/lists/SinglyLinkedListTest.java) 
| | | [DoublyLinkedList](./src/lists/DoublyLinkedList.java) | [DoublyLinkedListTest](./test/lists/DoublyLinkedListTest.java) 
| | | [CircularlyLinkedList](./src/lists/CircularlyLinkedList.java) | [CircularlyLinkedListTest](./test/lists/CircularlyLinkedListTest.java) 
| 2 | [Stacks](./src/stacks) | [ArrayStack](./src/stacks/ArrayStack.java) | [ArrayStackTest](./test/stacks/ArrayStackTest.java)
| | | [LinkedStack](./src/stacks/LinkedStack.java) | [LinkedStackTest](./test/stacks/LinkedStackTest.java)
| | | [BoundedStack](./src/stacks/BoundedStack.java) | [BoundedStackTest](./test/stacks/BoundedStackTest.java)
| | | [BracketChecker](./src/stacks/BracketChecker.java) | [BracketCheckerTest](./test/stacks/BracketCheckerTest.java)
| 3 | [Queues & Deques](./src/queues) | [ArrayQueue](./src/queues/ArrayQueue.java) | [ArrayQueueTest](./test/queues/ArrayQueueTest.java)
| | | [LinkedCircular](./src/queues/LinkedCircularQueue.java) | [LinkedCircularQueueTest](./test/queues/LinkedCircularQueueTest.java)
| | | [LinkedQueue](./src/queues/LinkedQueue.java) | [LinkedQueueTest](./test/queues/LinkedQueueTest.java)
| | | [TwoStackQueue](./src/queues/TwoStackQueue.java) | [TwoStackQueueTest](./test/queues/TwoStackQueueTest.java)
| | | [ArrayDeque](./src/queues/ArrayDeque.java) | [ArrayDequeTest](./test/queues/ArrayDequeTest.java)
| | | [LinkedDeque](./src/queues/LinkedDeque.java) | [LinkedDequeTest](./test/queues/LinkedDequeTest.java)
| 4 | [Complexity Analysis](./src/analysis) |  [TripleSum](./src/analysis/TripleSum.java) | -
| | | [Sort](./src/analysis/Sort.java) | [BasicSortRunner](./src/analysis/BasicSortRunner.java)
| | | [TestRunner](./src/analysis/TestRunner.java) |-|-
| | | [Timing](./src/analysis/Timing.java) |-|-
| 5 | [Recursion](./src/recursion) | [Reverse](./src/recursion/Reverse.java) | [ReverseTest](./test/recursion/ReverseTest.java)
| | | [Fibonacci](./src/recursion/Fibonacci.java) | [FibonacciTest](./test/recursion/FibonacciTest.java)
| | | [Foo](./src/recursion/Foo.java) | [FooTest](./test/recursion/FooTest.java)
| | | [Sum of Digits](./src/recursion/Digits.java) | [DigitsTest](./test/recursion/DigitsTest.java)
| | | [Collatz](./src/recursion/Collatz.java) | [CollatzTest](./test/recursion/CollatzTest.java)
| | | [Palindrome](./src/recursion/Palindrome.java) | [PalindromeTest](./test/recursion/PalindromeTest.java)
| | | [Recursive BubbleSort](./src/analysis/Sort.java) | [BubbleSortRunner](./src/analysis/BubbleSortRunner.java)
| 6 | [Tree & Priority Queue](./src/trees) | [LinkedBinaryTree](./src/trees/LinkedBinaryTree.java) | [LinkedBinaryTreeTest](./test/trees/LinkedBinaryTreeTest.java)
| | | [HeapPriorityQueue](./src/trees/HeapPriorityQueue.java) | [HeapPriorityQueueTest](./test/trees/HeapPriorityQueueTest.java)
| 7 | [Assignment 1](./src/assignment1) | [NumberList](./src/assignment1/NumberList.java) | [NumberListTest](./test/assignment1/NumberListTest.java)
| | | [MultilevelList](./src/assignment1/MultilevelList.java) | [MultilevelListTest](./test/assignment1/MultilevelListTest.java)
| | | [FlattenTree](./src/assignment1/FlattenTree.java) | [FlattenTreeTest](./test/assignment1/FlattenTreeTest.java)
| | | [UnsortedListPQ](./src/assignment1/UnsortedListPQ.java) | [UnsortedListPQTest](./test/assignment1/UnsortedListPQTest.java)
| | | [PQSort](./src/assignment1/PQSort.java) | [PQSortTest](./test/assignment1/PQSortTest.java)
| 8 | [Hash Maps & Binary Search Trees](./src/maps) | [UnsortedTableMap](./src/maps/UnsortedTableMap.java) | [UnsortedTableMapTest](./test/maps/UnsortedTableMapTest.java)
| | | [ChainHashMap](./src/maps/ChainHashMap.java) | [ChainHashMapTest](./test/maps/ChainHashMapTest.java)
| | | [WordFrequency](./src/maps/WordFrequency.java) |-|
| | | [Collisions](./src/maps/Collisions.java) |-|

## Authors
* [Rajit Banerjee](https://github.com/rajitbanerjee), 18202817
* [Dr. Aonghus Lawlor](https://github.com/aonghus), lecturer