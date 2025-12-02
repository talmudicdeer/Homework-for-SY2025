//Alexis Baker//

import java.io.IOException;

//lab3 is an Singly linked list.
public class lab3 {
    
    Node dummy;
    int size;

    lab3(){
        dummy = new Node(null);
        size = 0;
    }

    public lab3 removeduplicate(){

        lab3 temp = new lab3();
        int num = 1;
        Node head = locate(1);
        System.out.println(locate(size).element);
        for (int i = 0; i <  size; i++ ){
            if(!temp.contains (head.element)){
                temp.add(num-1, head.element);
                num++; 
            }
            head=head.next;
        }
        return temp;
}

    public void addAll (int index, lab3 list){

        list.locate(list.size).next = locate(index+1);
        locate(index).next = list.locate(1);
        size = size + list.size;


    }

    public boolean contains (String element){

        Node head = locate(0);
        for (int i = 0; i <= size; i++){
            if (head.element==element) {
                return true;
            }
            else {
                head= head.next;
            }
            
        }
            return false;
    }


        public boolean containsNode (Node element, int max){

        Node head = locate(0);
        for (int i = 0; i <= max; i++){
            if (head==element) {
                return true;
            }
            else {
                head= head.next;
            }
            
        }
            return false;
    }





    public Node locate(int index){
        //loop through list until ptr points to node at index
        //if empty return null

        Node ptr = dummy;

        for (int i=0; i<index; i++){
            ptr = ptr.next;
        }
        return ptr;
    }

    public void add(int index, String str){
        Node temp = new Node(str);
        if (index <= size){
            Node prev = locate(index);
            temp.next = prev.next;
            prev.next = temp;
            size++;
            //System.out.println(temp.next);
        }
        else{
            throw new IndexOutOfBoundsException("Whoopsies!");
        }
    }

    public String toString(){

        String str = "";
        Node temp = dummy.next;


        System.out.println(size);
        //Iterate through and add to string
        for (int i=0; i<size-1; i++){
            //System.out.println(temp.element);
            str = str + temp.element + ", ";
            temp = temp.next;
            
        }
        str = str + temp.element;

        return str;
    }


    public void deleteLoops(){

        for (int i = 0; i <= size; i++){
            System.out.print(i);
            System.out.println(locate(i).element);
            if (containsNode(locate(i), i-1)){
                System.out.println(locate(i).element);
                locate(i).next = null;
                size = i-1;
                break;
            }
        }

    }

    public void MAKELOOPDONTRUN(int first, int last){
        locate(last).next=locate(first);
    }

    class Node{
        String element;
        Node next;

        Node(String newElt){
            element = newElt;
            next = null;
        }
    }

    public static void main(String[] args){
        lab3 mylist = new lab3();
        lab3 daList = new lab3();
        mylist.add(0, "test");
        mylist.add(0, "test");
        mylist.add(0, "test 2");
        mylist.add(2, "test 3");
        mylist.add(0, "test 3");
        daList.add(0,"testING");
        daList.add(0,"testING 2");
        System.out.println(mylist.contains("test"));
        System.out.println(mylist.toString());
        mylist = mylist.removeduplicate(); //running time complexity: O(m^2^)
        System.out.println(mylist.toString());
        mylist.addAll(1,daList); //running time complexity: O(k+n)
        System.out.println(mylist.toString());
        mylist.MAKELOOPDONTRUN(2, 3);
        mylist.deleteLoops(); //running time complexity: O(m^2^)
        System.out.println(mylist.toString());
        return;
    }
}
