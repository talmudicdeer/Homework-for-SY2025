Alexis Baker


Data Structures


Reading 7


11/30/2025


**Define the min heap property.**
For every node `n`, the value of `n` is less than or equal to the values of its children.

**How do you find the minimum in a min heap?**
Look at the root.

**Define a 2-4 tree.**
> Another type of binary search tree where each node can have between two and four children.

**What questions do you have about the reading?**
How does a meldable heap accomplish the same time complexity as a binary heap despite being less organized?

**Feedback from Joe Granville, 12/01/2025:**
I think meldable heaps are less compact, but not necessarily less organized. They are able to provide equivalent complexity because of the distribution of the empty spots introduced by the randomness of the heap operations.


If you're looking at individual operations the randomness mostly adds uncertainty to your expected time. But if you amortize the analysis over many operations, you can algebraically replace the random terms with their expected/average values.


The randomness also supposedly makes it less likely to encounter worst-case scenarios (like completely skewed trees) that arise in other heaps where the structure is deterministic and based on insertion order, but that one I have trouble explaining off the cuff. I had to dig for someone else's interpretation, and I'm not totally satisfied by it.


Apparently the idea is that it reduces the impact of any one particular pathological case. The premise seems to be that a given user of this heap implementation might always enter data in a certain order, and for deterministic heaps that order might always result in a skewed heap. Because the randomized meldable heap makes placement choices arbitrarily, it becomes highly unlikely that the random elements will come out the same even if the input is a pathological case. So you might still get somewhat suboptimal trees, but they're likely to be not quite as bad, and unlikely to be an absolute worst case.


Hopefully this will come up in lecture, I think this is an interesting and deep question. Good job.
