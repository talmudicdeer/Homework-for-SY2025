Alexis Baker


Parallel and Distributed Computing


Assignment: Raspberry Pi


12/14/2025


**Brief Overview of Parallel numerical integration**

Parallel numerical integration is the practice of taking advantage of multicore processing to integrate a, well, integral. Why you would want to use parallel computing in this use case is best summed up by this quote from [a document](https://homepages.math.uic.edu/~jan/mcs572f16/mcs572notes/lec13.html) by the University of Illinois-Chicago:

> The problem of numerical integeration is another illustration of an ideal parallel computation: the communication cost is constant and the amount of computational work increases as the number of function evaluations increases. The complexity of the function and the working precision is another factor which increases the computational cost.


The basic idea is to assign different function evaluations to different cores, similar to breaking up a task among different people to get it done faster. Humans can, of course, integrate just fine, as anyone who's watched the MIT Integration Bee can attest, but the human brain far exceeds any computer on Earth when it comes to speed, processing power, and capacity. We have to come up with alternative ways of integration for computers, so we use parallel processing instead.


**The issues I ran into with this assignment**

The short shrift is that I borked my Pi's SSD, and have not had the time between the schoolwork I needed to do to repair it. This has meant that since I got my Pi, I've been running it off the included microSD card, which is, shall we say, extremely not optimal, and severely hampers my Pi's processing speed. I was, however, able to run the included Python code in Colab.


**Results of running the Python script**


The code ran separate metrics for serial computation with one core, and parallel computation with two cores.

| Computation Method | Result | Time | Error | Cores Used |
| ------------------ | ------ | ---- | ----- | ---------- |
| Serial | 2.0000000000 | 0.0062 seconds | 4.11e-11 | 1 |
| Parallel | 2.0000000000 | 0.0220 seconds | 4.11e-11 | 2 |


The performance metrics were as thus:

Speedup: 0.28x

Parallel efficiency: 14.2%

Time saved: -0.0158 seconds


The script also ran a scaling test for single-core and multicore processing.

| Cores | Time | Speedup | Efficiency |
| ----- | ---- | ------- | ---------- |
| 1 | 0.0166 | 0.37 | 37.5% |
| 2 | 0.0261 | 0.24 | 11.9% |


**Conclusions**

The difference in processing speed between 1 and 2 cores is small, but that's to be expected and lines up with the tests done in the forest fire simulations from earlier this quarter; benefits in parallelization don't start reaping _obvious_ rewards until you get up to 4 or 8 cores. (But, also as we discovered in that same assignment, the returns start diminishing at a certain point.)

In terms of real-world applications, this shows that Raspberry Pis have considerable applications in automated parallel processes, especially when used as a cluster, and indeed, when I've looked into this topic online, most people who use Pis in this way use them as a cluster, rather than only one of them.

Personally, I have immense interest in using Pis as a critical part of infrastructure in building a 21st century of Cybersyn. Chile had exactly one mainframe computer in the entire country in the early 1970s; most of the process of data collection was done using Telexes. In the 21st century, we could use Pis as an extremely cheap method of data collection from within a given district, running planning algorithms, and sending that information to a larger machine covering a larger area. Our technology is exceptionally advanced, and I feel like people lose signt of that given how much of it is dedicated to inane and frivolous endeavors. The Pi's ability to execute scripts in parallel, especially when hooked up into a cluster, has immense practical application in creating a more ethically and scientifically planned economy and society at large.
