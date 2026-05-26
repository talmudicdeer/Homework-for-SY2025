Alexis Baker


Operating Systems


Reading 8


**1. What is the difference between using interrupts and polling?** The difference between interrupts and polling comes down to who is doing the checking. In interrupts, the device lets the CPU know, and in polling, the CPU is constantly checking to see if the process is complete.


**2. What is the difference between PCI and the memory bus?** The memory bus is very, very fast, but only handles RAM and talks directly to the CPU, whereas PCI allows modular interfacing with the CPU at the expense of speed.


**3. What 3 registers are part of a canonical device interface?** Status, control, and data.


**4. What is DMA and why is it efficient?** DMA allows interfacing between external devices and the RAM without involving the CPU at all. This is highly efficient because it completely frees up the CPU.


**5. What is a device driver?** A driver is a piece of software that communicates between a device and the operating system.


**6. What is RAID?** RAID is a configuration system for storage disks that treats connected disks as one big pool of memory rather than individual drives.


**7. What questions do you have about the reading?** So does DMA interface with the memory bus? How does that work?


  **Feedback from Joe Granville, 05/24:** DMA is provided as a special service or control process that is somewhat independent of the CPU. It may be a feature of the memory controller, or it may be a device that is capable of talking to the memory controller on behalf of the CPU without the CPU supervising closely.

The DMA controller manages the retrieval and copying of data out of memory while the CPU does other things. The CPU requests a DMA read of some memory/disk resource over the bus, and the DMA controller carries out a little program to iterate through all the affected addresses and copy around the data requested, telling RAM, disks or hardware registers who to talk to. Once all the necessary hardware sub-steps are done, the DMA controller signals the CPU via interrupt that its big data operation is complete and a result is ready somewhere.
