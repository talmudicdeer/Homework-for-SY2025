Alexis Baker


Operating Systems


Game 2


04/22/2026


**[6]**


**1. [2] Describe what fork() and exec() do. Explain how they work together.** `fork()` produces a nearly identical copy of the program, practically indistinguishable to the operating system; the process doing the calling is the parent, the created process the child. `exec()` is the function to execute a program. When preparing to call `exec()`, the `fork()` processes are using the parent/child process as a template; the child can then carry out the setup steps to calling `exec()`.


**2. [2] When fork() is called, what is the value that is returned to the child process?** Zero (0).


**What is the value returned to the parent process?** The process ID of the child process.


**3. [2] What does ‘limited’ mean in limited direct execution?** That the execution is happening within constraints/limits.


**4. [2] What is the command line text to compute the word count of the concatenation of all of the files with the
extension .txt in your current directory?** `wc`
