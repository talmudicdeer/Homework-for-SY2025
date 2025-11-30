//Alexis Baker
public class MinHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(T val) {
        if (size == capacity) throw new IllegalStateException("Heap is full");
        heap[size] = val;
        int current = size;
        size++;

        while (current > 0 && heap[current].compareTo(heap[parent(current)]) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public T peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    public T extractMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        T min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return min;
    }

    private void heapify(int i) {
        int smallest = i;
        int left = left(i);
        int right = right(i);

        if (left < size && heap[left].compareTo(heap[smallest]) < 0) smallest = left;
        if (right < size && heap[right].compareTo(heap[smallest]) < 0) smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public int getSize() {
        return size;
    }
}
