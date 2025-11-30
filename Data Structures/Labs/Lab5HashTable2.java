/**
HashTable2.java

create a chained hash table of int

 */

public class HashTable2 {
    int backArray[];
    int length = 16;  // initial size of the backing array
    int size;

    /**
       ctors
     */
    HashTable2() {
	backArray = new int[length];
	size = 0;
    }


    static int hash2(int x) {
	int z = 113;
	int w = 10;  // largest value of key is 1023
	int result = (z * x) % 1024 / 64 ;

	return result;
    }


    
    
    public static void main(String[] args) {


	
	int y = hash2(1);
	System.out.println(y);
	
	return;
    }
}
