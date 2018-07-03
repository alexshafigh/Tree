/**
 * Created by saazimi on 7/2/2018.
 */
public class queue<T>  {
    Node head;
    Node tail;
    public queue(){
        head = null;
        tail = null;
    }

    public queue(Node node) {
        head = node;
        tail = head;
    }
    public void insert(Node node){
        if (isEmpty()) {
            head = node;
            tail  = head;
        }
        else {
            tail.setNext(node);
            tail = node;
        }
    }
    public Node getFirst(){
        if (isEmpty()) return null;
        else {
            Node pointer = head;
            head = head.getNext();
            pointer.setNext(null);
            return pointer;
        }
    }
    public boolean isEmpty(){
        return head==null;
    }
}
