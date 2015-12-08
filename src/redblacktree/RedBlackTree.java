package redblacktree;

public class RedBlackTree<T extends Comparable<T>>
{
    private final RBLeaf leaf = new RBLeaf();
    
    /**
     * The root of the tree
     */
    private RBNode root;
    
    /**
     * Constructs a RedBlackTree
     */
    public RedBlackTree()
    {
        root = leaf;
    }

    /**
     * Hangs a new item on the tree.
     * @param object The object to be hung on the tree
     */
    public void add(T object)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
    
    /**
     * Hangs a new item on the tree.
     * @param object The object to be hung on the tree
     */
    public void remove(T object)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
    
    /**
     * Hangs a new item on the tree.
     * @param object The object to be hung on the tree
     */
    public boolean find(T object)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
    
    /**
     * A node in the RedBlackTree, which in addition to the standard binary tree
     * structure also has a flag that tells if the current node is black or red.
     * @author Todd Beckman
     *
     */
    class RBNode 
    {
        /**
         * The data which is encapsulated by the node
         */
        T object;
        
        /**
         * A flag to see if this node is black or red
         */
        boolean black;
        
        /**
         * The child of this node on the left (less than) side
         */
        RBNode left;
        
        /**
         * The child of this node on the right (greather than) side
         */
        RBNode right;
        
        /**
         * Constructs a node for the RedBlackTree
         * @param object The object to be contained by the node.
         */
        RBNode (T object)
        {
            this.object = object;
            black = true;
        }
    }
    
    /**
     * A node which is a leaf. It is always black and contains no data.
     * @author Todd Beckman
     *
     */
    class RBLeaf extends RBNode
    {
        
        /**
         * Constructs a leaf.
         */
        RBLeaf()
        {
            super(null);
            black = true;
        }
    }
}
