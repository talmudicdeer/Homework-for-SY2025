Alexis Baker


Operating Systems


Lab 7


05/13/2026


So here we have the program using only `pthread_create`, no `pthread_join` yet. I called it `threads_only`.

```c
#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

void* thread_func(void* arg) {
printf("Hello. I am inside your walls.\n");
return NULL;
}

int main() {
pthread_t thread_id;

    pthread_create(&thread_id, NULL, thread_func, NULL);
    
    printf("Hello, Big World.\n");
    return 0;
}
```

I then ran this through my terminal:

```bash
gcc -pthread threads_only.c -o threads_only
strace -f -o threads_only.txt ./threads_only
```

Now we have the program with `pthread_join`, appropriately called `threads_with_join`:

```c
#include <stdio.h>
#include <pthread.h>
#include <unistd.h>

void* thread_func(void* arg) {
    printf("Hello. I am inside your walls.\n");
    return NULL;
}

int main() {
    pthread_t thread_id;

    pthread_create(&thread_id, NULL, thread_func, NULL);
    
    pthread_join(thread_id, NULL);
    
    printf("Hello, Big World.\n");
    return 0;
}
```

Going to be honest, I wonder if I did something wrong here. When I look at the trace files for both, `threads_only` has characteristics that shouldn't be there; it uses `futex` like `threads_with_join` does and also prints the child process, which it shouldn't do. The differences between the two trace files mostly come down to memory addresses.