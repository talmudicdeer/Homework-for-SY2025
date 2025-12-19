Alexis Baker


Parallel and Distributed Computing


Assignment: Matrix Multiplication


12/14/2025


**Serial version**

Plugged the serial code into GDB. It hit me with two errors of the same type: `undefined reference to 'omp_get_wtime'`. I added the -fopenmp flag when running it in the terminal, and this time it gave `undefined reference to fmaxf`. To fix this, I added the -lm flag to the end of the command, so my final GCC command was `gcc -fopenmp mm-serial.c -o mm-serial -lm`. That made the file compile.


**Parallel version**

Came across the same errors as in the serial version, using the same final command as before (but with the file name changed out) fixed the problem.


**Time comparison**

Serial version: 123.442360 milliseconds

Parallel version: 91.106307 milliseconds
