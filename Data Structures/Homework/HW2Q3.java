public class ArrayListWithAddAll {
    private Object[] array;
    private int size;

    public ArrayListWithAddAll(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    public void add(int index, Object element) {
        if (size == array.length) {
            resize();
        }

        System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = element;
        size++;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public void addAll(int index, Object[] c) {
        if (size + c.length > array.length) {
            resize();
        }

        System.arraycopy(array, index, array, index + c.length, size - index);

        System.arraycopy(c, 0, array, index, c.length);

        size += c.length;
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayListWithAddAll list = new ArrayListWithAddAll(10);

        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");

        System.out.print("List before addAll: ");
        list.printList();

        String[] collection = {"X", "Y", "Z"};

        list.addAll(1, collection);

        System.out.print("List after addAll: ");
        list.printList();
    }
}
