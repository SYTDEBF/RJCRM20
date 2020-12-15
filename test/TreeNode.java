public class TreeNode<T>
{
    public  T data;
    public  TreeNode child,parent,sibling;

    public TreeNode(T data, TreeNode child, TreeNode parent, TreeNode sibling) {
        this.data = data;
        this.child = child;
        this.parent = parent;
        this.sibling = sibling;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", child=" + child +
                ", parent=" + parent +
                ", sibling=" + sibling +
                '}';
    }
}
