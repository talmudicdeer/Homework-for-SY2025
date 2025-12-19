//Alexis Baker//
//Running time complexity of O(n)//

class ListArray {
    int capacity;
    int[] backArray;
    int size;

    public ListArray() {
        capacity = 10;
        backArray = new int[capacity];
        size = 0;
    }

    public void add(int index, int val) {

        if (size == capacity) {
            resize();
        }

        if (index >= 0 && index <= size) {
            for (int i = size - 1; i >= index; i--) {
                backArray[i + 1] = backArray[i];
            }
            backArray[index] = val;
            size++;
        }
    }

    public void add(int val) {
        add(size, val);
    }

    public int remove(int index) {

        if (index >= 0 && index < size) {
            int removedValue = backArray[index];

            for (int i = index; i < size - 1; i++) {
                backArray[i] = backArray[i + 1];
            }

            size--;
            return removedValue;
        }
        return -1;
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
            return backArray[index];
        }
        return -1;
    }

    public void Reverse() {
        int left = 0;
        int right = size - 1;

        while (left < right) {

            int temp = backArray[left];
            backArray[left] = backArray[right];
            backArray[right] = temp;

            left++;
            right--;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(backArray[i]).append("\n");
        }
        return str.toString();
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        System.arraycopy(backArray, 0, newArray, 0, size);
        backArray = newArray;
    }

    public static void main(String[] args) {
        ListArray myList = new ListArray();

        myList.add(0, 1);
        myList.add(0, 3);
        myList.add(0, 5);

        System.out.println("Original list:");
        System.out.println(myList);

        myList.Reverse();

        System.out.println("Reversed list:");
        System.out.println(myList);
    }
}
