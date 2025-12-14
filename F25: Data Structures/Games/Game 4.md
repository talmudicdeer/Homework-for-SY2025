Alexis Baker


Data Structures


Game 4


12/14/2025


**1. Consider the following binary tree:**

Root: S1

Left child: S2

Left grandchildren: S4 + ( )

Right child: S3

Right grandchildren: S5 + ( )

**a. List the nodes in pre-order traversal.**

S1, S2, S4, S3, S5


**a. List the nodes in in-order traversal.**

S4, S2, S1, S5, S3


**2. What is a final variable in Java?**

A variable whose value is immutable once assigned.


**3. Consider the min heap below.**

Root: 1

Left child: 25

Left grandchildren: 26 + 30

Right child: 20

Right grandchildren: 28 + ( )


**Describe the process of adding a node with a value of 15.**

In a min heap, the tree is sorted by the largest value at the root, regardless of when in the array it was added, and every subsequent child being smaller than its parent. First, we'd add it to the end of the array, in this case, the empty spot at the bottom of the right branch. Then, we'd compare its value, 15, to that of its parent, 20. If it's larger, it will swap places with its parent so that the lesser value is at the bottom of the branch. In this case, it's not, so 15 stays in the right grandchild spot in which we placed it.


**4. Consider the following graph.**

North vertex: 1

West vertex: 2

Central vertex: 3

East vertex: 4

South vertex: 5

**Write the adjacency list representation.**

Vertex 1: 2, 3, 4, null

Vertex 2: 1, 3, 5, null

Vertex 3: 1, 2, 4, 5, null

Vertex 4: 1, 3, 5, null

Vertex 5: 2, 3, 4, null


**5. Fill in the code below for `contains()`. Note that every time you see `...`, you should replace it with an expression or method call.**

```java
public class BST3 {
  Integer val;
  BST3 left, right;
  int height;

  public boolean contains(Integer val) {
    if (val == null) {
      return false;
    }
    if (... && ...) { // found it
      return true;
    }
    if ( ... && ...) { //val is less than the node
      return ... //recursive call
    }
    else if (...) {
      return ... //recursive call
    }
  }
}

public static void main(String[] args) {
// create new BST
BST3 bstTree = new BST3(2);
bstTree.left = new BST3(1);
bstTree.right = new BST3(3);

bstTree.printTree();

  if (bstTree.contains(1)) {
    System.out.println("contains 1");
  }
}
```


See Game4Q5.java.
