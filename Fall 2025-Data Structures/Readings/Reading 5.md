Alexis Baker


Data Structures


Reading 5


11/30/2025


**Define binary tree both recursively and informally in English.**
A binary tree consists of a root and at most two children, which are themselves binary trees.

**Define the depth of a node.**
The depth of a node is the distance from a node to the root.

**Define the height of a binary tree.**
The height of a tree is the same as the height of the root.

**How many nodes are in a binary tree of height 0?**
One.

**What is the maximum nodes in a binary tree of height 2?**
Seven.

**What is depth-first traversal?**
Depth-first traversal goes down the left branch, then the root, and then the right branch.

**What is breadth-first traversal?**
Breadth-first traversal goes through what one might consider the layers of a tree: from the root, to its children, then the grandchildren, and so on.

**What is the key property of a binary search tree?**
The value of the left-side child is less than the value of the parent, and the value of the right-side child is more than the value of the parent.

**What is a partial order (you can look this up online)?**
A type of binary relation that allows elements of a set to be compared.

**What questions do you have about the reading?**
Not a question, but [this lecture](https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/resources/lecture-6-binary-trees-part-1/) helped visualize and clarify a lot of the basic points about binary trees for me.


**Feedback from Joe Granville, 12/01/2025:**
I think the partial orderings referred to here represent a system of ordered relationships where some but not all items can be meaningfully compared.


Consider a set of tasks or transformations where some have prerequisite relationships and some are independent. If the items are "put on shoes" and "put on socks", socks come before shoes. But if you also consider "put on hat", it doesn't matter what order the hat is relative to the other items - it can come before, after, or in between.


Now think about how you'd represent this in completely ignorant, symbolic, mechanical programming rules. If you say that hat has the same "order" value as shoes or socks, then it implies that the hat must come in the same order as either the shoes or the socks. Essentially, you have to put shoes and socks on their own sort of ordered list of values, and for items like hats that don't have ordered relationships to the socks and shoes, you have to have values from a different list.


It turns out that you can connect the lists so that they form a lattice or graph of dependencies. However you represent the partial ordering, in addition to the symbolic ordering value, you need to keep a structure to tell you which values have meaningful comparisons. The "greater than/less than" relationships end up being structurally equivalent to edges in a graph.
