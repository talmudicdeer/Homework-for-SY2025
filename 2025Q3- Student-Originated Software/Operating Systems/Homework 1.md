Alexis Baker


Operating Systems


Homework 1


**1. Write a program that calls `fork()`. Before calling `fork()`, have the main process access a variable (e.g., `x`) and set its value to something (e.g., `100`).**

```c
#include <stdio.h>
#include <unistd.h>

int main() {
    int x = 267;

    if (fork() == 0) {
        x = 200;
        printf("Child x = %d\n", x);
    } else {
        sleep(1);
        printf("Parent x = %d\n", x);
    }

    return 0;
}
```

**What value is the variable in the child process?** 267, but immediately it is changed to 200.


**What happens to the variable when both the parent and child change the value of `x`?** It will produce two different values, since the parent and child processes cannot see or change each other's results.


**2. Write a program that opens a file (with the `open()` system call) and then calls `fork()` to create a new process.**

```c
#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int fd = open("test.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);
    
    if (fd < 0) {
        perror("Error opening file");
        return 1;
    }

    // 2. Fork the process
    pid_t pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        return 1;
    } 
    else if (pid == 0) {
        write(fd, "Hello from Child!\n", 18);
    } 
    else {
        wait(NULL); // Wait for child to finish writing first
        write(fd, "Hello from Parent!\n", 19);
        close(fd);
    }

    return 0;
}
```

**Can both the child and parent access the file descriptor returned by `open()`?** Yes.


**What happens when they are writing to the file concurrently, i.e., at the same time?** If done without a file lock system or a `wait()` call, it can spark a race condition.


**3. Write another program using `fork()`. The child process should print “hello”; the parent process should print “goodbye”. You should try to ensure that the child process always prints first.**

```c
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    if (fork() == 0) {
        printf("hello\n");
    } else {
        wait(NULL);
        printf("goodbye\n");
    }
    return 0;
}
```

**Can you do this without calling `wait()` in the parent?** Yes, using pipes.


**5. Now write a program that uses `wait()` to wait for the child process to finish in the parent.**

```c
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();

    if (pid == 0) {

        printf("Child: I am running...\n");
        sleep(2);
        printf("Child: I am done!\n");
    } else {
        printf("Parent: Waiting for child to finish...\n");
        wait(NULL);
        printf("Parent: Child has finished. Goodbye!\n");
    }

    return 0;
}
```

**What does `wait()` return?** A direct return value, which is the function's output, and an indirect status value, which is passed to us as a pointer.


**What happens if you use `wait()` in the child?** If the child has no child processes of its own, the call will immediately fail. If it does, then it will work just as normal.


**6. Write a slight modification of the previous program, this time using `waitpid()` instead of `wait()`.**

```c
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();

    if (pid == 0) {
        printf("Child: I am running...\n");
        sleep(2);
        printf("Child: I am done!\n");
    } else {
        printf("Parent: Waiting specifically for child PID %d...\n", pid);
        
        waitpid(pid, NULL, 0); 
        
        printf("Parent: Specified child has finished. Goodbye!\n");
    }

    return 0;
}
```

**When would `waitpid()` be useful?** When you are dealing with multiple child processes and want to control how those processes are, well, processed.


**7. Write a program that creates a child process, and then in the child closes standard output (`STDOUT_FILENO`).**

```c
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();

    if (pid == 0) {
        close(STDOUT_FILENO); 
        
        printf("This will not be visible.\n"); 
    } else if (pid > 0) {
        printf("Parent process: Child PID is %d\n", pid);
    }

    return 0;
}
```

**What happens if the child calls `printf()` to print some output after closing the descriptor?** Nothing will display on the screen and the data will be lost.


**8. Write a program that creates two children, and connects the standard output of one to the standard input of the other, using the `pipe()` system call.**

```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int fd[2];
    
    if (pipe(fd) == -1) {
        perror("pipe failed");
        return 1;
    }

    if (fork() == 0) {
        dup2(fd[1], STDOUT_FILENO);
        close(fd[0]);
        close(fd[1]);
        
        execlp("echo", "echo", "Hello from Child 1!", NULL);
        exit(1); 
    }

    if (fork() == 0) {
        dup2(fd[0], STDIN_FILENO);
        close(fd[0]);
        close(fd[1]);
        
        execlp("grep", "grep", "Hello", NULL);
        exit(1);
    }

    close(fd[0]);
    close(fd[1]);

    wait(NULL);
    wait(NULL);

    return 0;
}
```
