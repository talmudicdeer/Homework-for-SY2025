Node tmp = new Node("tmp", null);

tmp.next = n2.next;
tmp.prev = n2;

n2.next.prev = tmp;
n2.next = tmp;