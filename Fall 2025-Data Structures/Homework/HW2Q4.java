public class ArrayRotation {

    public static void rotate(int[] a, int r) {
        if (a == null || a.length <= 1) return;

        int n = a.length;
        r = ((r % n) + n) % n;

        reverse(a, 0, n - 1);
        reverse(a, 0, r - 1);
        reverse(a, r, n - 1);
    }

    private static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};

        System.out.print("Original array: ");
        printArray(a);

        rotate(a, 3);

        System.out.print("Array after rotation by 3: ");
        printArray(a);
    }
}
