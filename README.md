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
Open any test file, hover over any @Test annotation, and select 'Add JUnit 5 library to the build path'.
* Right click on the /test directory and 'Run As > JUnit Test' to generate the JUnit test report.
* Run the main() method of a class to see a basic implementation test.

## Summary
Classes implemented in the repository are summarised below. Refer to the individual class descriptions for more
 information.  
*Note:* The starred (*) solutions are the required data structures for the repository. The others were included
 either as helper classes, or as solutions to practicals and assignments for the module.

| # | Title | Solution | Test |  
|---| ----- | -------- | ---------- |
| 0 | [Interfaces](src/interfaces) |-|-
| 1 | [Lists](./src/lists) | [SinglyLinkedList *](./src/lists/SinglyLinkedList.java)  | [SinglyLinkedListTest](./test/lists/SinglyLinkedListTest.java), [SinglyLinkedListTest2](./test/lists/SinglyLinkedListTest2.java) 
| | | [DoublyLinkedList *](./src/lists/DoublyLinkedList.java) | [DoublyLinkedListTest](./test/lists/DoublyLinkedListTest.java), [DoublyLinkedListTest2](./test/lists/DoublyLinkedListTest2.java) 
| | | [CircularlyLinkedList *](./src/lists/CircularlyLinkedList.java) | [CircularlyLinkedListTest](./test/lists/CircularlyLinkedListTest.java) 
| 2 | [Stacks](./src/stacks) | [ArrayStack *](./src/stacks/ArrayStack.java) | [ArrayStackTest](./test/stacks/ArrayStackTest.java)
| | | [LinkedStack *](./src/stacks/LinkedStack.java) | [LinkedStackTest](./test/stacks/LinkedStackTest.java), [LinkedStackTest2](./test/stacks/LinkedStackTest2.java)
| | | [BoundedStack](./src/stacks/BoundedStack.java) | [BoundedStackTest](./test/stacks/BoundedStackTest.java)
| | | [BracketChecker](./src/stacks/BracketChecker.java) | [BracketCheckerTest](./test/stacks/BracketCheckerTest.java)
| 3 | [Queues & Deques](./src/queues) | [ArrayQueue *](./src/queues/ArrayQueue.java) | [ArrayQueueTest](./test/queues/ArrayQueueTest.java)
| | | [LinkedCircularQueue *](./src/queues/LinkedCircularQueue.java) | [LinkedCircularQueueTest](./test/queues/LinkedCircularQueueTest.java)
| | | [LinkedQueue *](./src/queues/LinkedQueue.java) | [LinkedQueueTest](./test/queues/LinkedQueueTest.java), [LinkedQueueTest2](./test/queues/LinkedQueueTest2.java)
| | | [TwoStackQueue](./src/queues/TwoStackQueue.java) | [TwoStackQueueTest](./test/queues/TwoStackQueueTest.java)
| | | [ArrayDeque](./src/queues/ArrayDeque.java) | [ArrayDequeTest](./test/queues/ArrayDequeTest.java)
| | | [LinkedDeque *](./src/queues/LinkedDeque.java) | [LinkedDequeTest](./test/queues/LinkedDequeTest.java)
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
| 6 | [Trees & Priority Queue](./src/trees) | [LinkedBinaryTree *](./src/trees/LinkedBinaryTree.java) | [LinkedBinaryTreeTest](./test/trees/LinkedBinaryTreeTest.java), [LinkedBinaryTreeTest2](./test/trees/LinkedBinaryTreeTest2.java)
| | | [HeapPriorityQueue *](./src/trees/HeapPriorityQueue.java) | [HeapPriorityQueueTest](./test/trees/HeapPriorityQueueTest.java), [HeapPriorityQueueTest2](./test/trees/HeapPriorityQueueTest2.java)
| | | [BalanceableBinaryTree](./src/trees/BalanceableBinaryTree.java) | - |
| | | [BinaryTreePrinter](./src/trees/BinaryTreePrinter.java) | - |
| 7 | [Assignment 1](./src/assignment1) | [NumberList](./src/assignment1/NumberList.java) | [NumberListTest](./test/assignment1/NumberListTest.java)
| | | [MultilevelList](./src/assignment1/MultilevelList.java) | [MultilevelListTest](./test/assignment1/MultilevelListTest.java)
| | | [FlattenTree](./src/assignment1/FlattenTree.java) | [FlattenTreeTest](./test/assignment1/FlattenTreeTest.java)
| | | [UnsortedListPQ](./src/assignment1/UnsortedListPQ.java) | [UnsortedListPQTest](./test/assignment1/UnsortedListPQTest.java)
| | | [PQSort](./src/assignment1/PQSort.java) | [PQSortTest](./test/assignment1/PQSortTest.java)
| 8 | [Hash Map & Tree Maps](./src/maps) | [UnsortedTableMap *](./src/maps/UnsortedTableMap.java) | [UnsortedTableMapTest](./test/maps/UnsortedTableMapTest.java)
| | | [ChainHashMap *](./src/maps/ChainHashMap.java) | [ChainHashMapTest](./test/maps/ChainHashMapTest.java), [ChainHashMapTest2](./test/maps/ChainHashMapTest2.java)
| | | [WordFrequency](./src/maps/WordFrequency.java) | [WordsFrequencyTest](./test/maps/WordFrequencyTest.java)
| | | [Collisions](./src/maps/Collisions.java) | [CollisionsTest](./test/maps/CollisionsTest.java)
| | | [TreeMap *](./src/maps/TreeMap.java) | [TreeMapTest](./test/maps/TreeMapTest.java), [TreeMapTest2](./test/maps/TreeMapTest2.java)
| | | [AVLTreeMap *](./src/maps/AVLTreeMap.java) | [AVLTreeMapTest](./test/maps/AVLTreeMapTest.java)
| | | [SplayTreeMap *](./src/maps/SplayTreeMap.java) | [SplayTreeMapTest](./test/maps/SplayTreeMapTest.java)

## Authors
* [Rajit Banerjee](https://github.com/rajitbanerjee), 18202817
* [Dr. Aonghus Lawlor](https://github.com/aonghus), lecturer