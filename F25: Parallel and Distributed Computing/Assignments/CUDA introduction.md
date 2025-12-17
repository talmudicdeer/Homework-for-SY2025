Alexis Baker


Parallel and Distributed Computing


Assignment: CUDA Introduction


12/14/2025



**1. Experiment with `printf()` inside the kernel. Try printing out the values of `threadIdx.x` and `blockIdx.x` for some or all of the threads. Do they print in sequential order? Why or why not?** They don't necessarily print in sequential order, since the process is being executed in parallel.


**2. Print the value of `threadIdx.y` or `threadIdx.z` (or `blockIdx.y`) in the kernel. (Likewise for `blockDim` and `gridDim`). Why do these exist? How do you get them to take on values other than 0 (1 for the dims)?** They exist so that each thread has a reference point for where they are placed in the grid and the block. They start at 0 by default, but can take on a range of values depending on how the grid and block dimensions are set up in the kernel.
