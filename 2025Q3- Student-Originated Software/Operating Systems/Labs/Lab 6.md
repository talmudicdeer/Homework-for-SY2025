Alexis Baker


Operating Systems


Lab 6


For this lab I wrote Hello World:

```c
#include <stdio.h>

int main() {
        printf("Hello, World!\n");
        return 0;
}
```

I had to download `strace`, but once I did everything went as normal. A rare but welcome occurrence. Here are the system calls that cropped up:


**`execve`:** Executes the designated filename.

**`brk`:** designates the program break, aka its memory allocation.

**`mmap`:** creates new virtual memory address.

**`openat`:** Opens the file relative to its path descriptor.

**`read`:** reads from a file descriptor. Identical in basic function to `pread64`, which also showed up here.

**`write`:** writes bytes from a buffer to a file descriptor. This is what the `printf` line is doing.

**`exit_group`:** exits all threads. This is what `return 0` is doing.