package redblacktree;

public class RedBlackTree<T extends Comparable<T>>
{
    /**
     * The root of the tree
     */
    private RBNode root;
    
    /**
     * Constructs a RedBlackTree
     */
    public RedBlackTree()
    {

    }

    /**
     * Hangs a new item on the tree.
     * @param object The object to be hung on the tree
     */
    public void add(T object)
    {
        //  Case 1: adding to the root-- do nothing except make it black
        if (root == null)
        {
            root = new RBNode(object);
            root.black = true;
            return;
        }
        
        //  Put the node in the tree where it belongs
        RBNode node = new RBNode(object);
        RBNode parent = root;
        do
        {
            //  Less than, so hang it on the left
            if (object.compareTo(parent.object) < 0)
            {
                if (parent.left == null)
                {
                    parent.left = node;
                    node.parent = parent;
                }
            }
            //  (Equal or) Greater than, so hang it on the right
            else
            {
                if (parent.right == null)
                {
                    parent.right = node;
                    node.parent = parent;
                }
            }
        }
        while (node.parent != parent);
        
        correctTreeAfterInserting(node);
    }
    
    
    /**
     * Hangs a new item on the tree.
     * @param object The object to removed from tree
     */
    public void remove(T object)
    {
        //  Case 1: removing from the root
        if (root.object.equals(object))
        {
            
        }
            
        throw new UnsupportedOperationException("Not yet implemented.");
    }
    
    /**
     * Hangs a new item on the tree.
     * @param object The object to be hung on the tree
     */
    public boolean find(T object)
    {
        RBNode node = root;
        while (node != null)
        {
            if (node.object.equals(object))
            {
                return true;
            }
            else if (node.object.compareTo(object)<  0)
            {
                node = node.left;
            }
            else //  compare > 0
            {
                node = node.right;
            }
        }
        return false;
    }
    
    /**
     * Prints out a depth-first-search string representation of the
     * tree's current state.
     */
    @Override
    public String toString()
    {
        if (root == null)
        {
            return "[empty tree]";
        }
        else
        {
            return root.toString();
        }
    }
    
    /**
     * Finds the uncle (parent of the parent) of a node in the tree.
     * @param node
     * @return The node's grandparent.
     * Returns null if the node has no parent or grandparent.
     */
    private RBNode grandparent(RBNode node)
    {
        //  second conditional already returns null anyway
        //  it is not necessary
        if (node.parent != null)// && node.parent.parent != null)
        {
            return node.parent.parent;
        }
        return null;
    }
    
    /**
     * Finds the uncle (sibling of the parent) of a node in the tree
     * @param node The node whose uncle to find
     * @return The node's uncle.
     * Returns null if the node has no grandparent or uncle.
     */
    private RBNode uncle(RBNode node)
    {
        RBNode grandparent = grandparent(node);
        if (grandparent == null)
        {
            return null;
        }
        if (grandparent.left == node.parent)
        {
            return grandparent.right;
        }
        return grandparent.left;
    }

    /**
     * Modifies the links in the tree to right-rotate the tree
     * @param parent The current parent
     * @param child The current child
     */
    private void rightRotation(RBNode parent, RBNode child)
    {
        parent.parent.left = child;
        parent.right = child.left;
        child.left = parent;
    }

    /**
     * Modifies the links in the tree to left-rotate the tree
     * @param parent The current parent
     * @param child The current child
     */
    private void leftRotation(RBNode parent, RBNode child)
    {
        parent.parent.right = child;
        parent.left = child.right;
        child.right = parent;
    }
    

    /**
     * Corrects the tree shape after inserting a new node
     * @param node The node, after it has been inserted into the tree.
     */
    private void correctTreeAfterInserting(RBNode node)
    {
        //  Case 1: adding to the root-- do nothing except make it black
        if (node == root)
        {
            node.black = true;
            return;
        }
        
        RBNode parent = node.parent;
        //  Case 2: adding node to black parent-- do nothing
        if (parent.black)
        {
            return;
        }
        else
        {
            //  should not be null. root is black, so if the parent is red
            //  then it must also have a parent
            RBNode grandparent = grandparent(node);
            
            //  this might be null
            RBNode uncle = uncle(node);
            
            //  Case 3: adding node with red parent and uncle
            //  -- make the parent and uncle black and grandparent red
            //  note: if uncle is null, it is a leaf, and leaves are black by definition
            if (uncle != null && !uncle.black)
            {
                parent.black = true;
                uncle.black = true;
                grandparent.black = false;
                //  Node: grandparent is now red, so it might break the rules
                //  fix this with a recursive call!
                correctTreeAfterInserting(grandparent);
                return;
            }
            else
            {
                //  Case 4: parent is red, uncle is black, inside-facing child of
                //  opposite-side parent -- rotate the parent to be the node's child
                //  Doing left rotation (case 4a)
                if (node == parent.right && parent == grandparent.left)
                {
                    leftRotation(parent, node);
                    //  Not done! Must handle Case 5 directly afterward with relinking.
                    RBNode temp = node;
                    node = parent;
                    parent = temp;
                }
                //  Doing right rotation (case 4b)
                else if (node == parent.left && parent == grandparent.right)
                {
                    rightRotation(parent, node);
                    //  Not done! Must handle Case 5 directly afterward with relinking.
                    RBNode temp = node;
                    node = parent;
                    parent = temp;
                }
                
                //  Case 5: red parent, black uncle, outside-facing child of
                //  same-side parent -- rotate the parent to be the grandparent
                if (node == parent.left)
                {
                    rightRotation(grandparent, parent);
                }
                else
                {
                    leftRotation(grandparent, parent);
                }
                parent.black = true;
                grandparent.black = false;
            }
        }
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
        boolean black = false;
        
        /**
         * The child of this node on the left (less than) side
         */
        RBNode left;
        
        /**
         * The child of this node on the right (greather than) side
         */
        RBNode right;
        
        /**
         * The parent of this node
         */
        RBNode parent;
        
        /**
         * Constructs a node for the RedBlackTree
         * @param object The object to be contained by the node.
         */
        RBNode (T object)
        {
            this.object = object;
        }
        
        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(black ? "[b:" : "[r:");
            sb.append(object.toString());
            sb.append("]\n");
            if (left != null)
            {
                sb.append(left.toString());
            }
            if (right != null)
            {
                sb.append(right.toString());
            }
            return sb.toString();
        }
    }
}
