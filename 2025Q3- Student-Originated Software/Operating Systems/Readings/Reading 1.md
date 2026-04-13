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
