Alexis Baker


Operating Systems


Game 5


6/3/2026


**1. What is a mutex?** A property that blocks critical code from being accessed simultaneously


**2. What is a condition variable, and what is one situation where it could be used?** A type of queue that threads can put themselves into when a condition isn't preferred. They're useful when some kind of signalling between threads needs to take place.


**3. Define temporal locality.** The principle that if a specific memory address is accessed, it will likely be accessed again in the future.


**4. Consider the following code:**

```c
pthread_mutex_t loc1 = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t loc2 = PTHREAD_MUTEX_INITIALIZER;

void function1() {     
  global_var++
}
void function2() {
  global_var--
}
```

**Insert calls to mutex_lock and mutex_unlock in order to make the code thread safe.**

```c
pthread_mutex_t loc1 = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t loc2 = PTHREAD_MUTEX_INITIALIZER;

void function1() {     
    pthread_mutex_lock(&loc1);
    global_var++;
    pthread_mutex_unlock(&loc1);
}

void function2() {
    pthread_mutex_lock(&loc1); // Must use the same mutex lock as function1
    global_var--;
    pthread_mutex_unlock(&loc1);
}
```


**5. Describe the system call `lseek()` and how you might use it with a file.** It changes the position of the read/write pointer, and you can use to jump directly to a particular part of a file.


**6. What is an inode?** The generic name for a data structure that holds the metadata for a particular file.
