public class linked_List {
    Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    // add first
    public void addFirst(String data){
        Node newnode= new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void addlast(String data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node currentNode=head;
        while(currentNode.next !=null){
            currentNode=currentNode.next;

        }
        currentNode.next=newnode;
    }
    public void printList(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node currentNode=head;
        while(currentNode !=null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.next;


        }
        System.out.println("NULL");
    }
    public void reverseIterator(){
        if(head==null || head.next==null){
            return;
        }
        Node prevnode=head;
        Node currnode=head.next;
        while(currnode !=null){
            Node nexthode=currnode.next;
            currnode.next=prevnode;
            //update
            prevnode=currnode;
            currnode=nexthode;

        }
        head.next=null;
        head=prevnode;
    }
    public static void main(String[] args) {
        linked_List ls=new linked_List();
        ls.addlast("S");
        ls.addlast("H");
        ls.addlast("I");
        ls.addlast("V");
        ls.addlast("A");
        ls.addlast("M");
        ls.addFirst("Mr.");
        ls.printList();


    }
}
