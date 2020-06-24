package bst;

public class Node
{
    protected int data;
    protected Node left, right, parent;
    
    public Node(int data, Node left, Node right, Node parent)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    
    public void setData(int data)
    {
        this.data = data;
    }
    public void setLeft(Node left)
    {
        this.left = left;
    }
    public void setRight(Node right)
    {
        this.right = right;
    }
    public int getData()
    {
        return data;
    }
    public Node getLeft()
    {
        return left;
    }
    public Node getRight()
    {
        return right;
    }
    public boolean isLeaf()
    {
        if(left == null && right == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Node getLeftMost()
    {
        if(left != null)
        {
            return left.getLeftMost();
        }
        else
        {
            return this;
        }
    }
    public Node getRightMost()
    {
        if(right != null)
        {
            return right.getRightMost();
        }
        else
        {
            return this;
        }
    }
    public Node removeLeftMost()
    {
        if(left == null)
        {
            return right;
        }
        else
        {
            left = left.removeLeftMost();
            return this;
        }
    }
    public Node removeRightMost()
    {
        if(right == null)
        {
            return left;
        }
        else
        {
            right = right.removeRightMost();
            return this;
        }
    }
}