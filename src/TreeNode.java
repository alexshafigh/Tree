/**
 * Created by saazimi on 6/24/2018.
 */
public class TreeNode<T extends Comparable<T>> implements Comparable {
    T data;
    TreeNode<T> leftNode;
    TreeNode<T> rightNode;

    public TreeNode() {
        data = null;
        leftNode = null;
        rightNode = null;
    }

    public TreeNode(T vlue) {
        data = vlue;
        leftNode = null;
        rightNode = null;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode!=null?leftNode:null;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() { return rightNode!=null?rightNode:null; }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public void insert(T value){
        if (value.compareTo(data) < 0){
            if ( leftNode == null)
                leftNode =  new TreeNode<>(value);
            else leftNode.insert(value);
        }
        else if (value.compareTo(data) > 0 ){
            if ( rightNode == null)
                rightNode = new TreeNode<>(value);
            else rightNode.insert(value);
        } //node.compareto(data)==0
    }

    public boolean isEmpty() {
        return data == null;
    }

    @Override
    public int compareTo(Object o) {
         int value  = 10;
        if (this.data instanceof  Integer){
            if (this.data == ((TreeNode)o).data) value =  0;
            else if ((Integer)this.data <(Integer) ((TreeNode)o).data) value =  -1;
            else if ((Integer)this.data <(Integer) ((TreeNode)o).data) value =  1;
        }
        return value;
    }
}
