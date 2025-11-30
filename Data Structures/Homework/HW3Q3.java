public class BinaryTreeNode<T> {
    T value;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> rotateRight() {
        if (this.left == null) {
            return this;
        }

        BinaryTreeNode<T> newRoot = this.left;
        this.left = newRoot.right;
        newRoot.right = this;

        return newRoot;
    }
}