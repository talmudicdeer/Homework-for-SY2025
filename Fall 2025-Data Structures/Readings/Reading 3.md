Alexis Baker


Data Structures


Reading 3


10/27/2025


**What is a singly linked list (SLL)?**
An SLList is a sequence of nodes that are linked singularly and linearly; that is, one node is linked to the next node, that node is linked to the next node, and so on.

**What is an inner class?**
An inner class is defined entirely within the body of another class, differing from a subclass in that a subclass derives its properties from another class through inheritance.

**What is the complexity of inserting an element at the head of a SLL?**
`push()` creates a new node, sets it at the head, and increases the size of the list, and then `pop()` removes the head by setting head to `next` and decrementing.

**Why is having a variable for length in a SLL efficient?**
It allows the programmer to directly address the length without needing to traverse the entire list.

**Why is having a variable for tail in a SLL efficient?**
It allows changing the tail directly in constant time, without the traversal problem mentioned above.

**What is an advantage of a DLL over a SLL?**
With the use of the dummy node, deleting nodes is trivial since DLL nodes account for both the previous and next nodes.

**What questions do you have about the reading?**
What are some of the advantages of an SLL over a DLL?
