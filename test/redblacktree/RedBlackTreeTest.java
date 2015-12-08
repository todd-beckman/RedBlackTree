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

    @Test
    public void testConstruct()
    {
        assert("[empty tree]".equals(new RedBlackTree<Integer>().toString()));
    }
    
    @Test
    public void testAddCase1()
    {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.add(1);
        assert("[b:1]\n".equals(tree.toString()));
    }
    
    @Test
    public void testRemove()
    {
        fail("Not yet implemented");
    }
    
    @Test
    public void testFind()
    {
        fail("Not yet implemented");
    }

}
