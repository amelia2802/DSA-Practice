# Trees Notes

## Table of Contents
1. [Abstract Data Types](#abstract-data-types)
2. [Trees](#trees)

## Abstract Data Types
An abstract data type (ADT) is a mathematical model for data structures that defines a data type by its behavior from the point of view of a user. This means it focuses on what operations are allowed and what kind of results are expected, without specifying how these operations are implemented.

For example, a stack is an abstract data type that supports two main operations:
1. **Push**: Add an element to the top of the stack.
2. **Pop**: Remove the element from the top of the stack.

The key here is that, as a user, you don't need to know how these operations are implemented (whether the stack is implemented using an array or a linked list). You just need to know that you can push and pop elements.

Similarly, other common abstract data types include:
- **Queue**: Supports enqueue (adding to the end) and dequeue (removing from the front) operations.
- **List**: Allows operations like adding, removing, and accessing elements at specific positions.
- **Set**: Supports operations like adding, removing, and checking for the presence of elements without duplicates.

ADTs provide a way to focus on the high-level behavior of data structures, making it easier to design and reason about algorithms and systems.

## Trees

A tree is an **abstract data** type that stores elements hierarchically.

### Some facts about trees:
- Tree is a nonlinear data structure.That referres to the intricate and interconnected way trees grow and organize. A tree's structure includes branches that split and intertwine in various directions, forming a network rather than a single, direct line. This "nonlinear" organization is richer and more complex than the simple "before" and "after" relationships found in a straight line or sequence.

- Trees are faster than linear data structures i.e. arrays & linked lists.

- Uses in file systems, GUIs, databases, websites

<hr>
A tree can be empty, meaning there are no nodes or people in our family tree. 
If the tree is not empty, it has a root (the grandparent).
The root can have children (branches), and these children can also have their own children (more branches).
This process can continue, creating a structure where each node (person) can have its own set of subtrees (descendants).
So, a tree is either:

 - Empty (no nodes)
 - Or it has a root (main person) with branches (children), and each branch can have more branches (grandchildren), and so on.
<hr>

### Tree Terminology
- Two nodes that are children of the same parent are ***siblings***. A node v is external
 if v has no children. A node v is internal if it has one or more children. External
 nodes are also known as ***leaves***.

- An ***edge*** of tree T is a pair of nodes (u,v) such that u is the parent of v, or vice
 versa. A ***path*** of T is a sequence of nodes such that any two consecutive nodes in
 the sequence form an edge.

###  Ordered Trees
 A tree is ordered if there is a meaningful linear order among the children of each
 node; that is, we purposefully identify the children of a node as being the first,
 second, third, and so on. Such an order is usually visualized by arranging siblings
 left to right, according to their order.