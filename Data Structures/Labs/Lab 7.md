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

**Feedback from Joe Granville, 11/30/2025:**
You're doing great on this back work. Feel free to reach out if I can help in any way.


Good job on findPathBetween(), not many got this one. You can make it faster by searching for the node where the paths connect first. If you'researching from the root and v1 and v2 are both on the same side, you know the root won't be on the shortest path between them.


This reasoning applies to all nodes until you find one that has v1 on one side and v2 on the other - that's the point where the paths must connect. If we assume that v1 is less and v2 is greater, you can search just the left child for v1 and just the right side for v2, which might be significantly shorter searches than considering the tree from the root twice.


Which isn't to say that you need to be able to reproduce that solution off the cuff. Despite all the talk about optimality, in an interview (and on the job) a correct and complete solution is probably better than having heard of the "best" answer but only being able to kind of implement it. Understanding that the optimized solution is out there, and why it might be better, is the most critical part.


Kudos.
