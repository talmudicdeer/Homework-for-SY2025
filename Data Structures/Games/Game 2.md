Alexis Baker


Data Structures


Game 2


11/25/2025


**When implementing a deque using a linked list, what are the advantages of using a doubly linked list over a singly linked list?**
You can modify the DLL from both ends with the use and manipulation of a dummy node, rather than having to iterate through the list to remove a specific value with an SLL.

**When implementing a queue with a linked list, what are the advantages of having a reference to the tail?**
When enqueuing, which requires adding to the end, a reference to the tail similarly abrogates the need to traverse the entire list, allowing for simple addition.

**What is a static variable in Java?**
Variable that belongs to the class and all instances within it, not just an object.

**What is the average case time complexity of searching for a value in a linked list of size *N*?**
O(n) for an unsorted list, could vary wildly for a sorted list due to list structure and searching algorithm used.

**What is the time complexity of retrieving an element using its index from a linked list of size N? Explain your answer.**
Also O(n), because you might have to traverse up to N values in the worst case.