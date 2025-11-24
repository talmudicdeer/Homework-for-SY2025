public void insertTmp (SLList headA, Node tmp) {
    Node curr = headA.first;
    curr = curr.next;

    tmp.next = curr.next;
    curr.next = tmp;

}