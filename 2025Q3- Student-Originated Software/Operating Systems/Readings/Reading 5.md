Alexis Baker


Operating Systems


Reading 5


**1. How does the OS keep track of the size when you allocate memory?** It uses a memory allocator for micromanagement.


**2. What is the internal fragmentation problem?** Infrag happens when a process is allocated more memory than it needs.


**3. What are best fit and worst fit? What is a disadvantage of both of these?** best-fit searches free memory blocks for the smallest possible allotment for the process while still being big enough to execute it, and worst-fit searches free memory blocks and allots the largest possible memory space. Best-fit risks severe exfrag, and worst-fit risks starvation of other processes.


**4. What are first fit and next fit? What are advantages of those?** first-fit allots the first free memory address (that is of a suitable size) to a process starting from address 0, and next-fit does so starting from the spot of the previous allocation. The biggest benefit of first-fit is that it is very, very fast, and next-fit allows for more even memory allocation.


**5. What is a page table?** A page table is a data structure that catalogues virtual addresses to physical addresses in the RAM.


**6. What are 4 of the bits stored in an x86 page table entry?** The P bit, the read/write bit, the user/supervisor bit, and the dirty bit.


**7. What is the TLB, and why is it important?** The translation lookaside buffer (TLB) is a cache built directly into the MMu, and it's important because without it paging memory would be an exponentially slower process.


**8. What questions do you have about the reading?** Wouldn't worst-fit also risk infrag?

**Feedback from Joe Granville, 05/24:** Yes and no. Below a certain memory occupancy threshold, worst-fit can actually work quite well for amortized performance, because it leaves you with maximally large fragments instead of creating tiny snips the way best-fit tends to.
