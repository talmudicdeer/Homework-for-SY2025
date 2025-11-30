Alexis Baker


Data Structures


Lab 7


11/30/2025


**Tasks**
See Lab7.java

**In what way is a red-black tree balanced?**
Every node is either red or black; the root is always black; the leaves are always black; if a node is red, both of its children are black (this prevents chains of consecutive red nodes and ensures no path can have more than half of its nodes be red), and black-height ensures a universal ratio of black nodes in each path.

**What is the worst-case complexity of insert(val, root) for a binary search tree?**
O(h), where (h) is the height of the tree.