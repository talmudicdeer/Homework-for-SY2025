Alexis Baker


Operating Systems


Reading 4


**1. Why are isolation and protection important for processes?** They keep processes from crashing into each other and causing a system catastrophe.


**2. What does virtualizing memory mean?** It means the CPU is creating a mass of fake memory to give processes the illusion of boundless memory access, so you can run test processes without it crashing your machine.


**3. When would a program reference physical addresses?** Very rarely, but most frequently upon starting up the computer. Device drivers also reference physical addresses.


**4. What is the difference between the stack and the heap?** The stack is managed by the CPU and has a definite order set by said CPU, the heap is a mass of unallocated memory that must be managed directly.


**5. What is a memory leak?** Memory leaks happen when a process fails to release allocated memory back to the operating system when it's no longer needed.


**6. List some of the other problems that can occur with dynamic allocation of memory.** Memory fragmentation, wild pointers, double-freeing, and buffer overflows.


**7. What is an anonymous memory region, and what does `mmap` do?** `mmap` is a call that directly links a process to a chunk of virtual memory, cutting out a lot of in-between processes that normally come with `read()`. One of the two mapping functions `mmap` can do is anonymous mapping, where `mmap` generates a block of blank memory with no device or hardware backing.


**8. What is the external fragmentation problem?** Exfrag happens when there's more than enough memory to fulfill the needs of the process queue, but those processes are allocated small, non-contiguous blocks that aren't able to fulfill the needs of other processes in the queue.


**9. What questions do you have about the reading?** What are the use cases for file-back mapping with `mmap`? What's the difference between buffer overflow and exfrag?
