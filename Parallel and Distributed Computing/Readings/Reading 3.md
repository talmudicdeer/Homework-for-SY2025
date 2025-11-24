Alexis Baker


Parallel and Distributed Computing


Reading 3


10/26/2025


Deadlock occurs when every process is blocked from proceeding by another process that can't finish due to incorrect pair-matching. To fix this, you have to make sure that the processes line up with their partners correctly and are sending and receiving in the proper order.

**Comment from Prof. Bergman, 10/30/25:**
Here are the main approaches to solving deadlock.


### Prevention (Design to make deadlock impossible)
Eliminate one of the four necessary conditions:
* Mutual exclusion: Make resources shareable when possible (e.g., read-only data)
* Hold and wait: Require processes to request all resources at once, or release all held resources before requesting new ones 
* No preemption: Allow the system to forcibly take resources from processes 
* Circular wait: Impose a total ordering on resource types and require processes to request resources in increasing order

### Avoidance (Allow deadlock conditions but avoid unsafe states)
* Banker's Algorithm: Before granting a resource request, check if it leaves the system in a "safe state" where there's at least one execution sequence that allows all processes to complete. Conservative but can reduce concurrency.
* Detection and Recovery (Let deadlock happen, then fix it)
* Detection: Periodically check for cycles in the resource allocation graph Recovery options:
  * Abort one or more processes in the cycle
  * Preempt resources from some processes
  * Rollback processes to a safe checkpoint

### Practical Strategies
**Lock ordering:** Always acquire locks in a consistent global order (most common in practice)
**Timeouts:** Use try-lock with timeouts - if you can't acquire all needed locks within a time limit, release everything and retry
**Lock hierarchies:** Assign levels to locks and only allow acquiring locks at higher levels than currently held
**Deadlock-free data structures:** Use lock-free algorithms (compare-and-swap, atomic operations) when possible

Most real systems use a combination of prevention through lock ordering plus timeouts as a backup.
The pure theoretical approaches (like Banker's Algorithm) are often too conservative or complex for practical use.
