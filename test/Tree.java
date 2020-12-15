public class Tree<T> {
    public TreeNode<T> root;
    public Tree()
    {
        this.root=null;
    }
    public void preorder()
    {
        for (TreeNode<T> p=this.root;p!=null;p=p.sibling)
        {
            preorder(p);
        }
        System.out.println();
    }
    public void preorder(TreeNode p){
        if (p!=null)
        {
            System.out.println(p.data+" ");
            for (TreeNode<T> q=p.child;q!=null;q=q.sibling)
            {
                preorder(q);
            }

        }
    }
//    public String toString()
//    {
//        return "树" +
//                "的横向"
//    }
}
