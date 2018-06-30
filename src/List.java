/**
 * Created by saazimi on 6/27/2018.
 */
public class List<T extends Comparable<T>> {
    Node<T> first;
    Node<T> last;

    Node recursivesearchvalue = null;

    public List() {
        first = null;
        last = null;
    }

    public List(Node<T> first) {
        this.first = first;
    }

    public List(T item) {
        Node<T> node = new Node<T>(item);
        first = node ;
         last = node ;
         node.setNext(null);
    }


    public void insertfirst(T item){
        if (isEmpty()) {
            this.first = new Node<>(item);
            first.setNext(null);
            last = first;
        }
        else {
            Node<T> node = new Node<>(item);
            node.setNext(first);
            first = node ;
        }
    }
    public void insertlast(T item){
        if (isEmpty()) {
            insertfirst(item);
        }
        else {
            Node<T> node = new Node<>(item);
            last.setNext(node);
            last = node ;
        }
    }

    public Node<T> getLastItem(){

        if (isEmpty()) {
            System.out.println("list Is Empty");
            return null;
        }
        else if (first.getNext() == null) {
            Node x = first;
            first = null;
            last = null;
            return x;
        }
        else {
            Node node = first;
            while (node.getNext() != last)
                node = node.getNext();
            node.setNext(null);
            Node z = last;
            last = node;
            return z;
        }
    }

    private boolean isEmpty() {
        if (this.first == null) return  true;
        else return false;
    }

    public void backwardPrint(){
        if (isEmpty()) {
            System.out.println("list Is Empty");
        }
        else {
            while (!isEmpty())
                System.out.println(getLastItem().getData());
        }
    }

    public void recursivesearch(T item , Node<T> firrst){
        if (firrst.getData().compareTo(item) == 0 ) recursivesearchvalue = firrst;
            else {
                if ( firrst.getNext() != null)
                    recursivesearch(item,firrst.getNext());
                else return ;
            }
    }


    public void recursivePrintlistbackward(Node listfirstitem){
        if (listfirstitem.getNext() != null) {
                recursivePrintlistbackward(listfirstitem.getNext());
        }
        else {
            System.out.println(listfirstitem.getData());
            return;
        }
        System.out.println(listfirstitem.getData());

    }


}
