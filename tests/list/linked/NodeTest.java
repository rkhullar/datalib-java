package list.linked;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest
{

    @Test
    public void test_empty_build()
    {
        Node node = new Node();
        assertNotNull(node);
        assertNull(node.data);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void test_non_empty_build()
    {
        Node node = new Node<>("test");
        assertEquals("test", node.data);
        assertNotNull(node.data);
        assertNull(node.prev);
        assertNull(node.next);
    }

    @Test
    public void test_has_prev_and_next()
    {
        Node a = new Node(), b = new Node();
        a.next = b; b.prev = a;
        assertFalse(a.hasPrev());
        assertFalse(b.hasNext());
        assertTrue(a.hasNext());
        assertTrue(b.hasPrev());
    }

    @Test
    public void test_empty_to_string()
    {
        Node node = new Node();
        assertEquals("null", node.toString());
    }

    @Test
    public void test_non_empty_to_string()
    {
        Node<Integer> node = new Node<>(5);
        assertEquals("5", node.toString());
    }
}