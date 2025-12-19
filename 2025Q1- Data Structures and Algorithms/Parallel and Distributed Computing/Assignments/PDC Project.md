Alexis Baker


Parallel and Distributed Computing


Parallel Computing Project


12/14/2025


My intent was to implement an extremely basic program in Rust that would solve [this problem](https://projecteuler.net/problem=1?ref=dept-engineering-blog.ghost.io) from Project Euler, a site that has many different types of math problems. This proved difficult since Rust requires cargo files separately to compile something, which I wasn't to able to assemble due to limited storage space, but I was able to run the code in Rust Playground. Credit goes to Ashwin Sundar at [this page](https://engineering.deptagency.com/parallel-processing-in-rust) for the project idea and code.

The basic gist of it, though, is using a function to determine if a number in the given range is divisible by 3 or 5, and if it is, then adding it to a running total:

```rust
fn euler1_unpar(input: i32) -> i64 {
    let mut sum: i64 = 0;
    for i in 1..input {
        if i % 3 == 0 || i % 5 == 0 {
            sum += i as i64;
        }
    }
    sum
}
```

We then use the `easybench` crate to calculate a performance benchmark for comparison to the parallel code.


For the parallelization code, the `thread` module enables us to turn this process into a parallel one. We create a new thread with `thread::spawn` and dedicate the first thread to the front half of the range.

```rust
fn euler1_par(input: i32) -> i64 {
    use std::thread;

    let handle1 = thread::spawn(move || {
        let mut thread1_sum: i64 = 0;
        for i in 1..input / 2 {
            if i % 3 == 0 || i % 5 == 0 {
                thread1_sum += i as i64;
            }
        }

        thread1_sum
    });

    let handle2 = thread::spawn(move || {
        let mut thread2_sum: i64 = 0;

        for i in (input / 2)..input {
            if i % 3 == 0 || i % 5 == 0 {
                thread2_sum += i as i64;
            }
        }

        thread2_sum
    });

    handle1.join().unwrap() + handle2.join().unwrap()
}
```

`move` copies the input into the scope for later use. `join` places priority on the threads' calculations over the execution of the main function, and `unwrap` finally combines the answers from each thread into one result.

The parallelization code halves the processing time from the serial code, cutting time down from 14ms to 7ms.
