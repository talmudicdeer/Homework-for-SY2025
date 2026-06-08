Alexis Baker


Operating Systems


Workshop 1


04/29/2026


Goal: to understand virtual memory and how virtual addresses are translated to physical addresses.

Task: answer the questions, It may be helpful to draw pictures, but you don’t need to submit your pictures.

Given:
- virtual memory is 256 Bytes
- physical memory is 128 Bytes
- page size: 32 Bytes


Questions:
- How many pages in virtual memory? 8
- How many bits is a virtual address? 8 bits
- How many pages are there in virtual memory? 8
- How many bits is the VPN? 3 bits
- How many frames in physical memory? 4
- How many bits is the PFN? 2 bits


Translation of addresses:

Suppose a process allocates 2 arrays of int:
- a[4] starts at address at virtual address 4 and holds 4 ints.
  - What is the size of a[] in bytes? 16
- b[4] starts at address 240
  - suppose virtual page  0 is mapped to frame 0, and suppose virtual page 7 is mapped to frame 2
    - What are the virtual addresses for a[1] and b[1]? for a[1], 8; for b[1], 244
    - What are their physical addresses? 8
