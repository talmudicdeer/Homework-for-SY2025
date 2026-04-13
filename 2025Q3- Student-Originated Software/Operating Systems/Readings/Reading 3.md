Alexis Baker

Operating Systems

Reading 3

4/12/2026


1. **What is limited direct execution?** LDE consists of the operating system running the program directly on the CPU, but with various controls to make sure that the program operates within bounds it's supposed to operate in.


2. **What is the difference between user mode and kernel mode?** The former has limits on what operations it can do, and the latter does not. Because of this, the latter is far more dangerous for the user to be toying around in, which is why pretty much all operating systems have some level of implemented gate to keep the user from futzing around in the kernel. (In Linux distros, this is what root privileges access.)


3. **What is a MLFQ?** The multi-level feedback queue has a number of distinct queues that are assigned priorities based on observed behavior; programs that are more urgent are assigned a higher priority, and thus are processed sooner.


4. **What is starvation for processes?** One of those things that's exactly what it sounds like. If too many processes are happening at the same time and consume all of a CPU's available power, then *nobody* gets power, and processes stall out.


5. **What is decay-usage in computing priority?** Schedulers like FreeBSD use a formula to calculate priority based on CPU usage. Because usage decays as the process is undergone, this shifts priority thusly.


6. **What is turnaround time?** Turnaround time is the total time it takes for a process to complete from when it's initialized.


7. **What is time to completion?** Time-to-completion is the time remaining in a process's execution until it's completed.


8. **Explain SJF and STCF.** SJF, or Shortest Job First, is a scheduling principle that prioritizes processes with the shortest turnaround times. STCF, or Shortest Time-to-Completion First, prioritizes processes that have the least remaining amount of time to completion.


9. **What questions do you have about the reading?** What are some cybersecurity concerns with MLFQ schedulers specifically?


**Feedback from Joe Granville, 4/13/2026:** "Starvation" for a process is when it never gets the resource it needs to proceed. This isn't necessarily a system-wide condition, nor is it specific to the CPU. "Starvation" is just when a process is never unblocked/unscheduled because of a resource distribution policy neglecting it. What the book is describing is a narrowly qualified instance of how starvation might occur under a naive CPU scheduling policy. Real OSes don't fall into this trap - or at least, designers have seen past it for a long time. It's mostly a theoretical problem that safeguard against when deriving new OS strategies.

I think schedulers have two major modes of vulnerability. One is gameability/resource denial - if you know what the schedule is looking for, you can spam it and be a nuisance to the rest of the system. The other is less trivial - information leakage. By watching what queue processes are assigned to, it's possible to develop information about what the process does - if it's a frequent blocker, if it uses I/O and interactive input, etc.

A more subtle, and probably more serious, form of information leakage comes from how the scheduler can see into scheduled process' code and execution trace. A process' trace on its own can imply the presence of complex operations (like cryptographic routines) based on the memory locality and number of operations that are optimized in ways characteristic of mathematic/numeric functions (like having few or no I/O calls but a lot of arithmetic/logic). Because MLFQ schedulers aggressively analyze processes to try to squeeze out optimizations, their decisions leak and imply a lot of detailed information about what processes do (and amplify signals that are already leaked by other parts of the OS). Of course, none of that is directly exposed - but through statistical/evidence-gathering methods you can develop estimates with a high degree of accuracy.
