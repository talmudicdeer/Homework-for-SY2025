Alexis Baker


Operating Systems


Game 5


6/3/2026


**1. What is a mutex?** A mutex is a property that prevents critical sections of code from being accessed concurrently.


**2. What is a condition variable, and what is one situation where it could be used?**


**3. Define temporal locality.**


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


**5. Describe the system call `lseek()` and how you might use it with a file.**


**6. What is an inode?**


**7. Write a game question to assess whether a student understands files and inodes.**
