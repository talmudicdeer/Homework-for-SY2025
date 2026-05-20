Alexis Baker


Operating Systems


Game 4


05/20/2026


**1. What is a race condition?** A race condition is a situation where the outcome is based on timing that is uncontrollable.


**2. Explain deadlock. Give an example.** Deadlock occurs when every process is blocked from proceeding by another process that can't finish due to incorrect pair-matching. An example would be a process that can't complete because certain required files are inaccessible or missing.


**3. Define spatial locality.** Spatial locality is the principle that if a process accesses an address, its neighbors will also be accessed in the future.


**4. Is the following code race-free? Explain your answer.**

```c
pthread_mutex_t loc1 = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t loc2 = PTHREAD_MUTEX_INITIALIZER;

void function1() {
  pthread_mutex_lock(&loc1)
  global_var++
  pthread_mutex_unlock(&loc1)
}

void function2() {
  Pthread_mutex_lock(&loc2)
  global_var--
  pthread_mutex_unlock(&loc2)
}
```


No, it is not. Both functions still use different locks that don't block each other, so they can still operate concurrently and still try to write to the `global` at the same time.


**5. Write a game question to assess whether a student understands locks and mutual exclusion.** Explain mutual exclusion.
