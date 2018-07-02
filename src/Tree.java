/**
 * Created by saazimi on 6/24/2018.
 */
public class Tree<T extends Comparable<T>> {
    protected TreeNode pparent = null;
    TreeNode returny = null;
    private TreeNode<T> root;


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

    public void BinaryTreeDelete(T item, TreeNode treeroot) {
        TreeNode node = searchfornode(item, treeroot);
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            //Leaf
            searchforparent(item, treeroot);
            if (pparent.leftNode == node)
                pparent.leftNode = null;
            else pparent.rightNode = null;
        } else if ((node.getLeftNode() == null && node.getRightNode() != null) || (node.getLeftNode() != null && node.getRightNode() == null)) {
            searchforparent(item, treeroot);
            if (pparent.getLeftNode() == node)
                pparent.setLeftNode(node.getLeftNode() == null ? node.getRightNode() : node.getLeftNode());
            else pparent.setRightNode(node.getLeftNode() == null ? node.getRightNode() : node.getLeftNode());
//            if (node.getLeftNode() == null)
//                node = node.getRightNode();
//            else node = node.getLeftNode();
        } else {
            TreeNode z = LittlesBiggerThan(item);
            TreeNode w = BiggestLittlerThan(item);
            if (z.data.compareTo(w.data) < 0) {
                TreeNode candid = z;
                searchforparent((T) candid.data, this.getRoot());
                pparent.setRightNode(null);
                searchforparent(item, this.getRoot());
                if (pparent != null) {
                    if (pparent.getRightNode() == node) {
                        pparent.setRightNode(candid);
                    } else pparent.setLeftNode(candid);
                    candid.setLeftNode(node.getLeftNode());
                } else {
                    candid.setLeftNode(node.getLeftNode());
                    candid.setRightNode(node.getRightNode());
                }
            } else {
                TreeNode candid = z;
                searchforparent((T) candid.data, this.getRoot());
                TreeNode parentLiitestBigger = pparent;

                if (parentLiitestBigger.leftNode == candid) parentLiitestBigger.leftNode = null;
                else parentLiitestBigger.rightNode = null;
                searchforparent(item, this.getRoot());
                TreeNode itemparent = pparent;

                if (itemparent != null) {
                    if (itemparent.getRightNode() == node) {
                        itemparent.setRightNode(candid);
                    } else itemparent.setLeftNode(candid);

                    candid.setRightNode(node.getRightNode());
                    candid.setLeftNode(node.getLeftNode());
                    node.setRightNode(null);
                    node.setLeftNode(null);
                } else {
                    candid.setLeftNode(node.getLeftNode());
                    candid.setRightNode(node.getRightNode());
                    node.setRightNode(null);
                    node.setLeftNode(null);

                }
            }

        }

    }

    private TreeNode LittlesBiggerThan(T item) {
        TreeNode pointer = searchfornode(item, this.getRoot());
        pointer = pointer.rightNode;
        while (pointer.getLeftNode() != null) pointer = pointer.getLeftNode();
        return pointer;
    }

    private TreeNode BiggestLittlerThan(T item) {
        TreeNode pointer = searchfornode(item, this.getRoot());
        pointer = pointer.leftNode;
        while (pointer.getRightNode() != null) pointer = pointer.rightNode;
        return pointer;
    }


    public void searchforparent(T item, TreeNode treenode) {
        if (searchfornode(item, treenode) == treenode) pparent = null;
        else {
            if (treenode.getLeftNode() != null) {
            if (treenode.getLeftNode().data == item) pparent = treenode;
            else searchforparent(item, treenode.getLeftNode());
        }
            if (treenode.getRightNode() != null) {
            if (treenode.getRightNode().data == item) pparent = treenode;
            else searchforparent(item, treenode.getRightNode());
        }
        }
    }

    public TreeNode getPparent(){
        return pparent;
    }

}
