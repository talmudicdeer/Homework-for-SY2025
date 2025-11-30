//Alexis Baker
import java.util.ArrayList;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(String val) {
        root = new Node(val);
    }

    public BinarySearchTree() {
        root = null;
    }

    public boolean contains(String val, Node n) {
        if (n == null) return false;
        int cmp = val.compareTo(n.val);
        if (cmp == 0) return true;
        if (cmp < 0) return contains(val, n.left);
        else return contains(val, n.right);
    }

    public Node insert(String val, Node n) {
        if (n == null) return new Node(val);
        int cmp = val.compareTo(n.val);
        if (cmp == 0) return n;
        if (cmp < 0) n.left = insert(val, n.left);
        else n.right = insert(val, n.right);
        return n;
    }

    public void insert(String val) {
        root = insert(val, root);
    }

    public boolean pathToNode(String val, Node curr, ArrayList<Node> path) {
        if (curr == null) return false;
        path.add(curr);
        int cmp = val.compareTo(curr.val);
        if (cmp == 0) return true;
        if (cmp < 0 && pathToNode(val, curr.left, path)) return true;
        if (cmp > 0 && pathToNode(val, curr.right, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }

    public ArrayList<Node> findPathBetween(String v1, String v2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        if (!pathToNode(v1, root, path1)) return null;
        if (!pathToNode(v2, root, path2)) return null;
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) i++;
        int lcaIndex = i - 1;
        ArrayList<Node> fullPath = new ArrayList<>();
        for (int j = path1.size() - 1; j > lcaIndex; j--) fullPath.add(path1.get(j));
        fullPath.add(path1.get(lcaIndex));
        for (int j = lcaIndex + 1; j < path2.size(); j++) fullPath.add(path2.get(j));
        return fullPath;
    }

    public Node remove(String val, Node n) {
        if (n == null) return null;
        int cmp = val.compareTo(n.val);
        if (cmp < 0) n.left = remove(val, n.left);
        else if (cmp > 0) n.right = remove(val, n.right);
        else {
            if (n.left == null && n.right == null) return null;
            if (n.left == null) return n.right;
            if (n.right == null) return n.left;
            Node successor = findMin(n.right);
            n.val = successor.val;
            n.right = remove(successor.val, n.right);
        }
        return n;
    }

    public void remove(String val) {
        root = remove(val, root);
    }

    private Node findMin(Node n) {
        while (n.left != null) n = n.left;
        return n;
    }

    void printTree() {
        print(root);
    }

    void print(Node n) {
        if (n == null) return;
        print(n.left);
        System.out.println(n.val);
        print(n.right);
    }

    class Node {
        String val;
        Node left;
        Node right;

        Node(String val) {
            this(val, null, null);
        }

        Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert("5");
        bst.insert("2");
        bst.insert("8");
        bst.insert("1");
        bst.insert("3");
        bst.insert("7");
        System.out.println("Tree contents:");
        bst.printTree();
        System.out.println("\nPath between 1 and 7:");
        ArrayList<Node> path = bst.findPathBetween("1", "7");
        for (Node n : path) System.out.print(n.val + " ");
        System.out.println();
        System.out.println("\nRemoving 2...");
        bst.remove("2");
        System.out.println("Tree after removal:");
        bst.printTree();
    }
}
