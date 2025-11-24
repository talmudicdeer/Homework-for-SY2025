// Alexis and Neremia //
public static void main(String[] args);
public class DLList<T> {
    private class Node {
        T x;
        Node prev, next;
    }

    private Node dummy;
    private int n;

    public DLList() {
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
        n = 0;
    }

    private Node getNode(int i) {
        if (i < 0 || i >= n) throw new IndexOutOfBoundsException();
        Node p;
        if (i < n / 2) {
            p = dummy.next;
            for (int j = 0; j < i; j++)
                p = p.next;
        } else {
            p = dummy.prev;
            for (int j = n - 1; j > i; j--)
                p = p.prev;
        }
        return p;
    }

    public T get(int i) {
        return getNode(i).x;
    }

    public T set(int i, T x) {
        Node u = getNode(i);
        T y = u.x;
        u.x = x;
        return y;
    }

    private Node addBefore(Node w, T x) {
        Node u = new Node();
        u.x = x;
        u.prev = w.prev;
        u.next = w;
        w.prev.next = u;
        w.prev = u;
        n++;
        return u;
    }

    public void add(int i, T x) {
        if (i < 0 || i > n) throw new IndexOutOfBoundsException();
        addBefore(i == n ? dummy : getNode(i), x);
    }

    private void remove(Node w) {
        w.prev.next = w.next;
        w.next.prev = w.prev;
        n--;
    }

    public T remove(int i) {
        Node w = getNode(i);
        remove(w);
        return w.x;
    }

    public int size() {
        return n;
    }
}

//Review comment by Joe Granville, 11/4/25: Interesting approach. Good job breaking the operations down into smaller,
// shared parts. It would help to follow your reasoning if your names were more expressive -
// especially your us and ws - but as someone who loves mathematical notation I can say you're doing it right here.
// If you're going to use sparse names, be consistent and lean into it hard. But be prepared to bend to the conventions
// of your team - most people nowadays struggle to follow code with cryptic or terse symbols.
