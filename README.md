# Kotlin Data Structures & Algorithms #

This repo is my way of practicing the skills needed to build solutions and solve problems with the Kotlin language and programming at large. I implemented various data structures, generally utilizing generics and often exploring multiple solutions to the same problem. 

### Data Structures: ###
* Stack
  * [Interface](src/main/kotlin/stack/StackInterface.kt)
  * [Implementation](src/main/kotlin/stack/Stack.kt)
* Queue
  * [Interface](src/main/kotlin/queue/Queue.kt)
  * [ArrayList Queue](src/main/kotlin/queue/ArrayListQueue.kt)
  * See also * [Priority Queue](src/main/kotlin/heaps/priorityqueue/PriorityQueue.kt)
* Linked Lists
  * Singly Linked List
    * [Node](src/main/kotlin/linkedlist/singlylinkedlist/Node.kt)
    * [Linked List](src/main/kotlin/linkedlist/singlylinkedlist/LinkedList.kt)
    * [Linked List Iterator](src/main/kotlin/linkedlist/singlylinkedlist/LinkedListIterator.kt)
    * [Test](src/main/kotlin/linkedlist/singlylinkedlist/Test.kt)
  * Doubly Linked List
    * [Node](src/main/kotlin/linkedlist/doublylinkedlist/Node.kt)
    * [Doubly Linked List](src/main/kotlin/linkedlist/doublylinkedlist/DoublyLinkedList.kt)
* Trees
  * Basic
    * [Tree Node](src/main/kotlin/tree/basic/generic/TreeNode.kt)
    * [Basic Tree](src/main/kotlin/tree/basic/BasicTree.kt)
  * Binary Search
    * [Binary Search attempt 1](src/main/kotlin/tree/binarysearch/BinarySearchTree.kt)
    * [Binary Search Tree](src/main/kotlin/tree/binarysearchtree/BinarySearchTree.kt)
    * [Binary Node](src/main/kotlin/tree/binarysearchtree/BinaryNode.kt)
  * AVL
    * [AVL Node](src/main/kotlin/tree/avl/AVLNode.kt)
    * [AVL Tree](src/main/kotlin/tree/avl/AVLTree.kt)
    * [AVL Test](src/main/kotlin/tree/avl/Test.kt)
* Tries
  * [Trie Node](src/main/kotlin/tries/TrieNode.kt)
  * [Trie](src/main/kotlin/tries/Trie.kt)
  * [Extensions](src/main/kotlin/tries/Extensions.kt)
  * [Test](src/main/kotlin/tries/Test.kt)
* Heaps
  * [Collection Interface](src/main/kotlin/heaps/Collection.kt)
  * [Heap](src/main/kotlin/heaps/Heap.kt)
  * [Priority Queue](src/main/kotlin/heaps/priorityqueue/PriorityQueue.kt)
* Graphs
  * [Interface](src/main/kotlin/graph/graph/Graph.kt)
  * [Adjacency List](src/main/kotlin/graph/graph/AdjacencyList.kt)
  * [Adjacency Matrix](src/main/kotlin/graph/graph/matrix/AdjacencyMatrix.kt)
  * [Dijkstra](src/main/kotlin/graph/Dijkstra.kt)


* [Extensions](src/main/kotlin/extensions/extensions.kt)
* [High Order Functions](src/main/kotlin/extensions/highorderfunctions/Functions.kt)

### Algorithms ###
* Sorting
  * [Bubble Sort](src/main/kotlin/sorts/bubblesort/BubbleSort.kt)
  * [Insertion Sort](src/main/kotlin/sorts/insertionsort/InsertionSort.kt)
  * [Merge Sort](src/main/kotlin/sorts/mergesort/MergeSort.kt)
  * [Radix Sort](src/main/kotlin/sorts/radixsort/RadixSort.kt)
  * [Selection Sort](src/main/kotlin/sorts/selectionsort/SelectionSort.kt)
  * Quick Sort
    * [Naive Quick Sort](src/main/kotlin/sorts/quicksort/QuicksortNaive.kt)
    * [Lomuto Quick Sort](src/main/kotlin/sorts/quicksort/QuicksortLomuto.kt)
    * [Hoare Quick Sort](src/main/kotlin/sorts/quicksort/QuicksortHoare.kt)
* [Utils](src/main/kotlin/sorts/Utils.kt)
* [Test](src/main/kotlin/sorts/Test.kt)

### Problem + Solutions ###
* Dynamic Programming
  * Memoization
    * [Fibonacci](src/main/kotlin/problems/dynamic/memoization/fib.kt)
    * [How Sum](src/main/kotlin/problems/dynamic/memoization/howSum.kt)
    * [Can Sum](src/main/kotlin/problems/dynamic/memoization/canSum.kt)
    * [Best Sum](src/main/kotlin/problems/dynamic/memoization/bestSum.kt)
    * [Count Construct](src/main/kotlin/problems/dynamic/memoization/countConstruct.kt)
    * [Can Construct](src/main/kotlin/problems/dynamic/memoization/canConstruct.kt)
    * [All Construct](src/main/kotlin/problems/dynamic/memoization/allConstruct.kt)
    * [Grid Travelers](src/main/kotlin/problems/dynamic/memoization/gridTravelers.kt)
