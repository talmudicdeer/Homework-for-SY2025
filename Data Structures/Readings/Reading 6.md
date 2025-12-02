Alexis Baker


Data Structures


Reading 6


11/30/2025


**Define a red-black binary tree.**
It's a type of binary search tree that is self-balancing through designating nodes as red or black in an ordered way.

**What is a balanced tree?**
A type of tree where the height between the left and right subtrees is kept uniform, ensuring processes can be carried out in O(log n) time.

**Define a 2-4 tree.**
Another type of binary search tree where each node can have between two and four children.

**Define black height in a red-black tree.**
Black-height is a ratio of black leaves to red to ensure the same proportion throughout the tree.

**What is a left-leaning red-black tree?**
A type of tree that's supposed to be easier to implement while having similar time complexity as a regular red-black tree. All red nodes link left, which simplifies implementation by enforcing only a singular type of rotation.

**What questions do you have about the reading?**
So is a 2-4 tree necessarily a red-black tree?

**Feedback from Joe Granville, 12/01/2025:**
There's a correspondence between 2-4 trees and red-black trees, yes. I'm not sure that one is entirely the same as the other, but it does seem to have a mathematical property called isomorphism that implies equivalency between two mathematical structures.


An isomorphism (or bijection) is a function that maps each input value to a unique output value, and covers every possible input and output value. Because every output value is covered and there is exactly one input value it's associated with, you can reverse the mapping too. (Imagine the absolute value function - there are no negative values in its range of outputs, so you can't reverse it for all numbers.)


There's clearly a way to take a given red-black tree and rewrite it as a 2-4 tree, and the other way around. So the structures seem to be equivalent. I think there could be an argument that the operations implementing those trees might not be the same, though. There's more than one way of implementing a red-black tree, after all. If you look at not just the tree structures but also how they change under certain operations, I think it might be that one tree might change differently as a 2-4 tree than it would as a red-black tree under the same operation. But just maybe - I think it's plausible that they're totally equivalent, I'm just not sure how I would prove it so I don't want to commit to that interpretation.
