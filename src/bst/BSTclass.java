package bst;

public class BSTclass
{
    protected Node root;
    
    public BSTclass()
    {
        root = null;
    }
    
    public boolean contains(int i, Node n)
    {
        if(n == null)
        {
            return false;
        }
        if(n.getData() == i)
        {
            return true;
        }
        else if(n.getData() > i)
        {
            return contains(i, n.getLeft());
        }
        else
        {
            return contains(i, n.getRight());
        }
    }
    public Node predecessor(int i, Node n)
    {
        if(root == null)
        {
            return null;
        }
        if(n == root.getLeftMost())
        {
            return null;
        }
        if(n.getData() == i)
        {
            if(n.getLeft() != null)
            {
                return n.getLeft().getRightMost();
            }
            else
            {
                Node temp = n.parent;
                while(temp != null && n == temp.getLeft())
                {
                    n = temp;
                    temp = temp.parent;
                }
                if(temp == null)
                {
                    return null;
                }
                else
                {
                    return temp;
                }
            }
        }
        else if(n.getData() > i)
        {
            return predecessor(i, n.getLeft());
        }
        else
        {
            return predecessor(i, n.getRight());
        }
    }
    public Node successor(int i, Node n)
    {
        if(root == null)
        {
            return null;
        }
        if(n == root.getRightMost())
        {
            return null;
        }
        if(n.getData() == i)
        {
            if(n.getRight() != null)
            {
                return n.getRight().getLeftMost();
            }
            else
            {
                Node temp = n.parent;
                while(temp != null && n == temp.getRight())
                {
                    n = temp;
                    temp = temp.parent;
                }
                if(temp == null)
                {
                    return null;
                }
                else
                {
                    return temp;
                }
            }
        }
        else if(n.getData() > i)
        {
            return successor(i, n.getLeft());
        }
        else
        {
            return successor(i, n.getRight());
        }
    }
    public Node insert(int e, Node n, Node p)
    {
        if(root == null)
        {
            root = new Node(e, null, null, null);
            return root;
        }
        if(n == null)
        {
            return new Node(e, null, null, p);
        }
        else
        {
            if(e <= n.getData())
            {
                n.setLeft(insert(e, n.getLeft(), n));
            }
            else
            {
                n.setRight(insert(e, n.getRight(), n));
            }
            return n;
        }
    }
    public boolean delete(int i, Node n)
    {
        if(n == null)
        {
            return false;
        }
        if(n.getData() == i)
        {
            if(n.getLeft() == null)
            {
                if(n == root)
                {
                    root = root.getRight();
                    return true;
                }
                if(n == n.parent.getLeft())
                {
                    n.parent.setLeft(n.getRight());
                }
                else
                {
                    n.parent.setRight(n.getRight());
                }
                return true;
            }
            else
            {
                Node temp = n;
                n.setData(n.getLeft().getRightMost().getData());
                n.setLeft(n.getLeft().removeRightMost());
                return true;
            }
        }
        else if(n.getData() > i)
        {
            return delete(i, n.getLeft());
        }
        else
        {
            return delete(i, n.getRight());
        }
    }
    public String preOrder(Node n)
    {
        String str = "";
        if(n != null)
        {
            str += n.getData() + " ";
        }
        if(n.getLeft() != null)
        {
            str += preOrder(n.getLeft());
        }
        if(n.getRight() != null)
        {
            str += preOrder(n.getRight());
        }
        return str;
    }
    public String inOrder(Node n)
    {
        String str = "";
        if(n.getLeft() != null)
        {
            str += inOrder(n.getLeft());
        }
        if(n != null)
        {
            str += n.getData() + " ";
        }
        if(n.getRight() != null)
        {
            str += inOrder(n.getRight());
        }
        return str;
    }
    public String postOrder(Node n)
    {
        String str = "";
        if(n.getLeft() != null)
        {
            str += postOrder(n.getLeft());
        }
        if(n.getRight() != null)
        {
            str += postOrder(n.getRight());
        }
        if(n != null)
        {
            str += n.getData() + " ";
        }
        return str;
    }
}