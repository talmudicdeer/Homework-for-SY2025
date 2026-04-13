Alexis Baker


Operating Systems


Game 1


4/13/2026


1. **[3] Describe what `fork()` and `exec()` do. Explain how they work together.** `fork()` produces a nearly identical copy of the program, practically indistinguishable to the operating system; the process doing the calling is the parent, the created process the child. `exec()` is the function to execute a program. When preparing to call `exec()`, the `fork()` processes are using the parent/child process as a template; the child can then carry out the setup steps to calling `exec()`.


2. **[2] Which code is executed by the child after the fork?**

```c
rc = fork();
if (rc < 0) {
  fprintf(stderr, "case a\n");
  exit(1);

}
else if (rc > 0) {
  printf("case b\n");
} else {
  printf ("case c\n");
}
```

The child would run the code in the `else{}` block.


3. **[1] What does the `wc` command do in Linux?** `wc` is the command line utility to count the number of newlines, words, characters, etc.


4. **[1] What is the purpose for creating a pipe?** To save time and resources by not needing to write information to an intermediary.
