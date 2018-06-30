/**
 * Created by saazimi on 6/24/2018.
 */
public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    TreeNode returny = null;
    protected TreeNode pparent = null;


    public Tree() {
        root = null;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public Tree(T data) {
        TreeNode rout = new TreeNode(data);
        this.root = rout;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void insertNode(T insetvalue){
        if (root == null )
            root = new TreeNode<T>(insetvalue);
        else root.insert(insetvalue);
    }

    public void preOrderTraversal(TreeNode treeNode){
        if (treeNode == null) return;
        else {
            System.out.printf("%s " ,treeNode.data);
            preOrderTraversal(treeNode.getLeftNode());
            preOrderTraversal(treeNode.getRightNode());
        }
    }

    public void postOrdertraversal(TreeNode treeNode){
        if (treeNode == null) return;
        else {
            postOrdertraversal(treeNode.getRightNode());
            postOrdertraversal(treeNode.getLeftNode());
            System.out.printf("%s ",treeNode.data);
        }
    }

    public int getDepth(TreeNode root){
        int depth = 1;
        if ( root.getLeftNode() == null && root.getRightNode() == null ) {
        } //LEAF
        else
            {
                if (root.getLeftNode() == null && root.getRightNode() != null)  {depth += getDepth(root.getRightNode());}
                else {
                    if ( root.getLeftNode() != null && root.getRightNode() == null )  {depth += getDepth(root.getLeftNode());}
                    else
                        {
                          if( root.getLeftNode() != null && root.getRightNode() != null )  {depth += maximum(getDepth(root.leftNode),getDepth(root.rightNode));}
                    }
                }
            }
            return depth;
    }

    public int maximum(int a , int b){
        return a>=b?a:b;

    }

//    public void NodeDelete(T item,Node tree){
//        Node pointer = searchfornode(item);
//    }

    public TreeNode searchfornode(T item,TreeNode treeroot) {
        if (treeroot != null) {
            if (treeroot.data == item)
            {
                returny = treeroot;
            }
            else {
                searchfornode(item, treeroot.getLeftNode());
            }
            searchfornode(item, treeroot.getRightNode());
        }
        return returny;
    }

//    public void BinaryTreeDelete(T item , TreeNode treeroot ){
//        if (treeroot.getLeftNode() == null && treeroot.getRightNode() == null)
//        {//this node is leaf
//
//        }
//        if (treeroot.getLeftNode() != null){
//
//        }
//        else if (treeroot.getRightNode() != null){
//
//        }
//        else
//    }


    public void searchforparent(T item , TreeNode treenode){
        if (treenode.getLeftNode() != null){
            if (treenode.getLeftNode().data == item) pparent = treenode;
            else searchforparent(item,treenode.getLeftNode());
        }
         if (treenode.getRightNode() != null){
            if (treenode.getRightNode().data == item) pparent = treenode;
            else searchforparent(item,treenode.getRightNode());
        }
        return;
    }

    public TreeNode getPparent(){
        return pparent;
    }

}
