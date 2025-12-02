Alexis Baker


Data Structures


Reading 2


10/26/2025


**What is a list?**
A list is a sequence of values, from 0, 1, 2… _n_. Using the `get()` function on value 2, for example, would call whatever is contained in value 2.

**What is a backing array?**
A backing array is the underlying array that holds all of the data used by a list, stack, etc.

**What is `ArrayStack`?**
`ArrayStack` uses the backing array to implement the list interface. The backing array is dubbed `a` here. The list element with index `i` is kept in `a[i]`.  Because the backing array will always be larger than the list itself, variable `n` is used to keep things grounded in reality (read: track the number of elements _actually_ in `a`). The list elements are then kept in indices `a[0]. . . a[n-1]`, while the length of the backing array is always greater than `n`.

**What is `ArrayQueue`?**
A first-in-first-out queue is a particularly bad fit for `ArrayStack` since it would get extraordinarily cumbersome once `n` gets too large; this is because the removal and addition process of FIFO is proportional to `n`. `ArrayQueue` gets around this problem by using modulus to simulate an infinite array and insert elements at different parts of the array. Adding an element using `ArrayQueue` involves resizing the array if necessary, then calling `% length`.

**When resize is called on an array with 128 elements in order to double the size of the array, how many elements 
are copied?**
128 elements, since it’s being doubled.

**For a circular array described in 2.3, what is the meaning of `j`, what is the meaning of `n`, and what is the index 
of the last element in the queue?**
`j` denotes the next element to remove, `n` denotes the number of elements in the queue, and the index of the last element in the queue is `a.length-1`.

**What is big-O for the following code?**
O(n^2^), since `n` is being reiterated on in the while loop.

**What questions do you have about the reading?**
At what point does using ArrayStack become inefficient and using ArrayQueue advantageous?

**Feedback from Joe Granville, 10/27/25:**
Queues and stacks have different fundamental operations, so it'd be an apples-to-oranges comparison. You use a stack when you need LIFO access and a queue when the application calls for iterating in FIFO order. Both can have different types of memory structures behind them. Generally scale or other performance factors would motivate you to change representation and storage strategies, not operational characteristics like push and pop versus enqueue and dequeue.

Good try on Big O. You're properly identifying that the varying values are the ones to watch for, but you're being too literal in your application. n % 10 and n /= 10 are actually **O(1) operations** in most contexts. It's the while loop that has impact on Big O here. This is actually a slightly devious example IMO. If we were just counting from 0 to n (or n to 0) it would be O(n). But the condition in the while loop interacts with the n /= 10 statement. If you keep dividing a number by another(positive) number until it gets close to zero, that's a logarithm. All the other statements are O(1).

**Reponse from Alexis Baker, 10/28/25:**
Ahhhhhh, okay, thanks for that. That one took me a lot of thinking.
