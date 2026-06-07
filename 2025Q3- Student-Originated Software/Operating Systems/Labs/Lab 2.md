Alexis Baker


Operating Systems


Lab 2


04/08/2026


**What do the code blocks do?**

**`p1.c`:** `p1.c` runs `fork()` in its most basic form. The child's and parent's PIDs are printed. The big thing to understand here is that while `fork()` is called once, it's really being returned twice, which is the fundamental building block for how the operating system can get processes running the same code to do different things through if-else statements.


**`p2.c`:** `p2.c` adds `wait()` to the mix. This is important because in `p1.c`, the order that the parent and child print in is up to the CPU scheduler. Not randomized, but not controllable, either. `wait()` forces a degree of regularity by telling the parent (in this instance) to wait until the child prints, therefore controllability. This is important for, say it with me now, decreasing variety, i.e. unpredictable states of being that we absolutely do not want in an operating system, at least for certain tasks.


**`p3.c`:** `p3.c` introduces `exec()`. The child calls `execvp()` and runs `wc` on the file. At this point the child is no longer running its own thing, `exec()` has made `wc` its function now.


**`p4.c`:** `p4.c` is about output redirection. The child closes standard output, creates a new output file, then runs the same `exec()` process as in `p3.c`. Nothing prints to the screen, but we can see that a file called `p4.output` has been created with the contents of `wc`.


**How does output redirection work?** Output redirection works by closing one output to free up that slot for another process. This way the operating system can do some behind the scenes shuffling before the program even starts.

**How does `exec` work?** `exec()` works by taking the child process, wiping its memory, and giving it a new task as dictated by the command used.


**What did you learn?** I learned how all these building blocks fit together in the nest of loops I talked about before. We are, essentially, giving the operating system the necessary tools to execute bigger and broader commands.
