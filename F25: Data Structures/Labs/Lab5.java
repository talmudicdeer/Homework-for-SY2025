//Alexis Baker
//Time complexity of add(): O(1) best case, O(n) worst case
//Time complexity of remove(): O(1) best case, O(n) worst case
public class HashTable2 {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node[] backArray;
    private int length = 16;
    private int size;

    private final int w = 32;
    private final int d = 4;        // log2(16)
    private final int z = 0x9E3779B9;

    public HashTable2() {
        backArray = new Node[length];
        size = 0;
    }

    // ----------------------------
    // Hash functions (both present)
    // ----------------------------

    /** Original simple hash */
    static int hash1(int x) {
        return x % 16;
    }

    /** Multiplicative hash */
    int hash2(Object x) {
        int h = x.hashCode();
        return (z * h) >>> (w - d);
    }


    // ----------------------------
    // ADD using hash1 or hash2
    // ----------------------------

    public void addUsingHash1(int value) {
        addInternal(value, hash1(value));
    }

    public void addUsingHash2(int value) {
        addInternal(value, hash2(value));
    }

    private void addInternal(int value, int index) {
        Node newNode = new Node(value);
        newNode.next = backArray[index];
        backArray[index] = newNode;
        size++;
    }


    // ----------------------------
    // REMOVE using hash1 or hash2
    // ----------------------------

    public void removeUsingHash1(int value) {
        removeInternal(value, hash1(value));
    }

    public void removeUsingHash2(int value) {
        removeInternal(value, hash2(value));
    }

    private void removeInternal(int value, int index) {
        Node current = backArray[index];
        Node previous = null;

        while (current != null) {
            if (current.data == value) {
                if (previous == null) {
                    backArray[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }


    // ----------------------------
    // Support methods
    // ----------------------------

    public void printTable() {
        for (int i = 0; i < length; i++) {
            System.out.print("Index " + i + ": ");
            Node current = backArray[i];
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    /** Longest chain length */
    public int longestChain() {
        int longest = 0;
        for (int i = 0; i < length; i++) {
            int count = 0;
            Node current = backArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }


    // ----------------------------
    // Test / comparison
    // ----------------------------
    public static void main(String[] args) {

        int[] dataset = {10, 26, 42, 58, 74, 90};

        HashTable2 t1 = new HashTable2();
        for (int x : dataset) t1.addUsingHash1(x);
        System.out.println("Longest chain with hash1: " + t1.longestChain());

        HashTable2 t2 = new HashTable2();
        for (int x : dataset) t2.addUsingHash2(x);
        System.out.println("Longest chain with hash2: " + t2.longestChain());
    }
}
