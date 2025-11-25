/**
   ListArray.java
   implement basic methods

   not generic, just int
 */

class ListArray {
    int  capacity;
    int[] backArray;
    int size;

    /**
       ctors
     */

    public ListArray() {
	capacity = 10;
	backArray = new int[capacity];
	size = 0;
    }


    /**
       insert val at index 
     */
    public void add(int index, int val) {
	// check size < capacity
	if (size == capacity) {
	    resize();
	}
	// check index in bounds
	if (index >= 0 && index < size + 1) {
	    for (int i=size-1; i>=index; i--) {
		backArray[i+1] = backArray[i];
	    }
	    backArray[index] = val;
	}
	size++;
	
	return;
    }

    public void add(int val) {

	return;
    }


    /**
       remove element at index
     */
    public int remove(int index) {

	return backArray[index];
    }


    public int get(int index) {
	return backArray[index];
    }


    public String toString() {
	StringBuilder str = new StringBuilder();

	for (int i=0; i<size; i++) {
	    str.append(backArray[i] + "\n");
	}
	
	return str.toString();
    }


    void resize() {


	
	return;
    }
    

    /*************************

    Main
    **************************/
    public static void main(String[] args) {
	//create an instance
	ListArray myList = new ListArray();
	
	// add 1,3,5
	myList.add(0, 1);
	myList.add(0, 3);
	myList.add(0, 5);

	System.out.println(myList);
	// delete at index 1


    }
}
