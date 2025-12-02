Alexis Baker


Data Structures


Reading 4


11/25/2025


**What is a hash table?**
Hash table is a term used to describe a variety of data structures that are capable of storing *n* number of integers from a range of *U* = {0,..., 2<sup>w</sup>-1}.

**What is a multiplicative hash function?**
It uses modular arithmetic and integer division to generate hash values.

**What is hashing with chaining?**
Each array value corresponds to a bucket, typically a linked list, that contains a mutable set of values; in practice, array values correspond to a head pointer to a linked list.

**What is hashing with linear probing?**
Linear probing searches for an empty value in an array by a fixed stride, which can be and frequently is 1, leading to extremely slow results and bad performance.

**What questions do you have about the reading?**
This one lecture I found from Cornell on the subject of multiplicative hashing talks about the importance of (*ka/2<sup>q</sup>*) % *a*, but I didn't see it talked about in the book, and was wondering if our book *does* talk about it, but in different ways.


Specifically, the lecture in question says:


> A faster but often misused alternative is multiplicative hashing, in which the hash index is computed as ⌊*m* * frac(*ka*)⌋. Here *k* is again an integer hash code, *a* is a real number and frac is the function that returns the fractional part of a real number. Multiplicative hashing sets the hash index from the fractional part of multiplying *k* by a large real number. It's faster if this computation is done using fixed point rather than floating point, which is accomplished by computing (*ka/2<sup>q</sup>*) % *m* for appropriately chosen integer values of *a*, *m*, and *q*. So *q* determines the number of bits of precision in the fractional part of *a*....
> In the fixed-point version, The division by *2<sup>q</sup>* is crucial. The common mistake when doing multiplicative hashing is to forget to do it, and in fact you can find web pages highly ranked by Google that explain multiplicative hashing without this step. Without this division, there is little point to multiplying by *a*, because *ka % m* = (*k % m*) * (*a % m*) % *m*. This is no better than modular hashing with a modulus of *m*, and quite possibly worse.


**Feedback from Prof. Weiss, 11/29/25:**
Could you give me a ref to the article you read?


Usually fixed point computation is done by multiplying by a power of 2 and then truncating. 


In general, integer mult can be slower than float mult.


**Response from Alexis Baker, 11/30/25:**
[https://www.cs.cornell.edu/courses/cs3110/2015sp/lectures/14/lec14.html]
