//Alexis Baker//
//Running time complexity of O(n^3^)//

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

        if (index >= 0 && index < size + 1) {

            for (int i = size - 1; i >= index; i--) {
                backArray[i + 1] = backArray[i];
            }

            backArray[index] = val;
            size++;
        }
    }

    public void add(int val) {

        if (size == capacity) {
            resize();
        }

        backArray[size] = val;
        size++;
    }

    public int remove(int index) {
        int removed = backArray[index];

        for (int i = index; i < size - 1; i++) {
            backArray[i] = backArray[i + 1];
        }

        size--;
        return removed;
    }

    public int get(int index) {
        return backArray[index];
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < size; i++) {
            str.append(backArray[i]).append("\n");
        }

        return str.toString();
    }

    void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = backArray[i];
        }
        backArray = newArray;
    }

    public void removeDuplicate() {

        for (int i = 0; i < size; i++) {
            int current = backArray[i];

            for (int j = i + 1; j < size; j++) {

                if (backArray[j] == current) {
                    remove(j);
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListArray myList = new ListArray();

        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(3);
        myList.add(1);

        System.out.println("Original List: ");
        System.out.println(myList);

        myList.removeDuplicate();

        System.out.println("After duplicate removal: ");
        System.out.println(myList);
    }

}