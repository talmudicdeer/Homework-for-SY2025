public class BST3 {
    Integer val;
    BST3 left, right;
    int height;

    public boolean contains(Integer val) {
        if (val == null) {
            return false;
        }
        if (this.val != null && this.val.equals(val)) {
            return true;
        }
        if (val < this.val && left != null) {
            return left.contains(val);
        }
    else if (val > this.val && right != null) {
            return right.contains(val);
        }
    }
    return false;
}

public static void main(String[] args) {

    BST3 bstTree = new BST3(2);
    bstTree.left = new BST3(1);
    bstTree.right = new BST3(3);

    bstTree.printTree();

    if (bstTree.contains(1)) {
        System.out.println("contains 1");
    }
}