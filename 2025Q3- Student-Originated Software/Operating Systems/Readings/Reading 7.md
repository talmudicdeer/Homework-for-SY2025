Alexis Baker


Operating Systems


Reading 7


**1. What is a race condition?** Put simply, a race condition is when two processes executing concurrently try to write to the same program at the same time.


**2. What is a critical section of code?** A critical section of code is something that cannot be accessed concurrently, usually some kind of resource.


**3. Define atomic operation.** An atomic operation is a process that is executed completely and indivisibly on its own.


**4. What is a mutual exclusion?** A mutex is a property that prevents critical sections of code from being accessed concurrently.


**5. What is the first parameter of `Pthread_create()`?** The first parameter of `Pthread_create()` is a pointer to a `pthread_t` variable.


**6. Why is `void *` used in `Pthread_create`?** For type flexibility.


**7. What is spin-wait?** A technique where a thread checks a loop condition over and over until it's true.


**8. What questions do you have about the reading?** Doesn't spin-wait bring up heightened risks for deadlock?


**Feedback from Joe Granville, 05/24:** I don't think so. Deadlocks are really more dependent on the logical relationships of the waiting conditions than they are determined by how waiting is implemented. You're really just changing where the code would be while stuck, not the odds of writing code that will become stuck.
