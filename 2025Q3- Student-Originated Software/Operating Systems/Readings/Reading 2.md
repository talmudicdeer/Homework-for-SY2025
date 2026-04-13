Alexis Baker

Operating Systems

Reading 2


1. **Give a definition of the term 'process'?** The process is the program specifically while it runs. By itself, a program is an inert thing; it's the operating system that infuses life into it and conversely, can take it away, a bit like a homunculus, or a golem. It's this inscribing of the *shem*, and removal of it, that is the process.


2. **What are the three main process states?** Running, ready, and blocked. In the running state, the program is, well, running. That's pretty self-explanatory. In the ready state, the program is prepared to run, but the OS is not running it, for whatever reason. In the blocked state, the program has executed some kind of function that requires another program to respond in order to proceed. This is a bit like how you need to commit and push files to GitHub for them to be viewable on the website. Committing them is only the first step of the process, and you need to push them in order for them to be publically available, and not just on the local repository.


3. **What is the register context of a process?** The register context is the waystation for a blocked process. The operating system loads it into an allocated memory space, and holds it there until the secondary process is completed.


4. **What does `fork()` do?** Creates life, essentially. It produces a nearly identical copy of the process that in practice is indistinguishable from the parent process to the operating system; which program does what when is a matter up to the OS scheduler, which, according to the book, will be covered later.


5. **What value does `fork()` return to the parent process?** It returns the process identifier of its child.


6. **What value does `fork()` return to the child?** It returns a value of zero.


7. **What questions do you have about the reading?** Where does exec() come into play in all of this?