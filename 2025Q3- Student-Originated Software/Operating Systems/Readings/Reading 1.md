Alexis Baker

Operating Systems

Reading 1

04/01/2026


1. **What is a system call?**  A system call is the interfacing operating between user-level actions and the kernel, like opening a file, saving a file to a directory, or opening an application. The operating system can't do those things directly; it needs to be instructed, or called, to do them.


2. **What are the three main themes of OSTEP?** In the introductory dialogue, the Professor says that the three key ideas that are going to be expounded upon a la Feynman are virtualization, concurrency, and persistence.


3. **What does it mean to say that the operating system virtualizes the CPU?** This means that the operating system gives programs the illusion that they are running off their own private processing power, when in reality they're all sharing slices of a portion of the real CPU.


4. **What does it mean to say that the operating system virtualizes memory?** Similar idea as above; the programs think that they're each getting their own block of memory, when the operating system is actually allocating small portions to each program; otherwise, the memory would be overrun with simultaneous operations.


5. **Why does the program in figure 2.5 give the wrong answer for large iterations of the loop but not small ones?** The problem is the crux of the issue of concurrency. The programs requires three instructions to run, but because they do not happen at the same time, they exhibit strange properties when iterated for long periods of time (to a computer, at least). This is the problem of running complex programs that is at the heart of software development and operating system functionality.


6. **What questions do you have about the reading?** At what point do abstractions start being more of a hindrance than a help? This is something I've been thinking about for a while as I've been using Linux as my daily driver since about November. It's also something I've been thinking about in non-computer science-related topics, like education, or the functioning of a state as an organism.


**Feedback from Joe Granville, 4/13/2026:** I'd say it's not a question of when abstractions become a hindrance, but when they become a necessity. You can only deal with so many concrete details at once. The history of human knowledge is abstraction - the search for symmetries in the face of overwhelming detail.


**Feedback from Joe Granville, 4/13/2026:** Thinking more about your question, I should qualify my response better. You can't totally get away from abstractions, practically speaking - software is an abstraction over the machine architecture, which is an abstraction over the behavior of the constituent electronic components, which are usually themselves reasoned about in terms of abstractions over their physical/electrical properties.

But abstraction can get in the way of specific responsibilities. An example is trying to use a high-level file writer utility - like Python's `csvwriter`, or a database ORM ("object relational mapper") to write really large volumes of data. These utilities are meant for general use, and they hide the way that reads and writes happen with the data backing those forms of storage.

For the general use case, this works fine. But because the operations are opaque, you can't see why or how the implementation strains when you throw really big writes at it. Those abstractions can become silent, and seemingly arbitrary, bottlenecks. But the problem is usually less abstraction in and of itself, but choosing an "abstraction" instance that behaves inappropriately or obfuscates details of the problem you're trying to solve.
