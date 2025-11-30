/**
Binary Search Tree of Strings

 */


public class BinarySearchTree {
    Node root;
    int height;
    
    /*******************
          constructors
     *******************/
    public BinarySearchTree(String val) {
	root = new Node(val);
    }

      /***********
         methods
      ************/
    public boolean contains(String val, Node n) {
	if (n == null) {
	    return false;
	}
	if (val.compareTo(n.val) > 0) {  // this.val is greater than n.val
	    return contains(val, root.left);
	}
	else {
	    return contains(val, root.right);
	}
    }

    
    /**
       insert: if value is already in the tree
       do not modify the tree and return the tree node
       @return the new node that is inserted
     */
    public Node insert(String val, Node n) {
	if (n == null) {
	    return new Node(val, null, null);
	}
	
	
	return null;

    }


    void printTree() {
	System.out.println(root.val);

	return;
    }

    void pprintTree(int height) {
	for (int i=0; i<height; i++) {
	    System.out.print("\n");
	}
	System.out.println(root.val);
    }

      /*************
      inner classes
      **************/
    class Node {
	String val;
	Node left;
	Node right;

	/*******************
          constructors
	*******************/
	Node(String val) {
	    this(val, null, null);
	}

	Node(String val, Node left, Node right) {
	    this.val = val;
	    this.left = left;
	    this.right = right;
	}
    }

    
      /**************
           main
      ***************/
    public static void main(String[] args) {
	// create new BST
	BinarySearchTree bstRoot = new BinarySearchTree("2");
	bstRoot.printTree();

	BinarySearchTree bstLeft = new BinarySearchTree("1");
	bstLeft.printTree();

	BinarySearchTree bstRight = new BinarySearchTree("3");
	bstRight.printTree();

	bstRoot.root.left = bstLeft.root;
	
	return;
    }


					    
      

    
    
}
