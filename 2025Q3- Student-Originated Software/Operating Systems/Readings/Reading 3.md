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