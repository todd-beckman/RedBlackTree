package redblacktree;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * RedBlackTreeTest is a JUnit test file which tests the functionality of the
 * RedBlackTree data structure.
 * 
 * @author Todd Beckman
 *
 */
public class RedBlackTreeTest
{
    //  construction
    @Test
    public void testConstruct()
    {
        assert("[empty tree]".equals(new RedBlackTree<Integer>().toString()));
    }
    
    //  adding the root
    @Test
    public void testAddCase1()
    {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.add(1);
        assert("[b:1]\n".equals(tree.toString()));
    }

    //  adding to the left side
    @Test
    public void testAddCase2a()
    {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.add(1);
        tree.add(0);
        assert("[b:1]\n[r:0]\n".equals(tree.toString()));
    }

    //  adding to the right side
    @Test
    public void testAddCase2b()
    {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.add(1);
        tree.add(2);
        assert("[b:1]\n[r:2]\n".equals(tree.toString()));
    }

    //  case 3 on the left side with the root as the grandparent
    @Test
    public void testAddCase3a()
    {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(1);
        assert("[b:3]\n[b:2]\n[r:1]\n[b:4]\n".equals(tree.toString()));
    }

    //  case 3 on the left side with non-root grandparent
    @Test
    public void testAddCase3b()
    {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.add(0);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(1);
        assert("[b:0]\n[r:3]\n[b:2]\n[r:1]\n[b:4]\n".equals(tree.toString()));
    }
    
    @Test
    public void testRemove()
    {
    }
    
    @Test
    public void testFind()
    {
    }

}
