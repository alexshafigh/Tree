/**
 * Created by saazimi on 6/17/2018.
 */
public class Node<T>  {
    private T data;
    private Node next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(TreeNode treeroot) {
        data = (T) treeroot;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
