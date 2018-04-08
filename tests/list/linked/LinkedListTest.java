package list.linked;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest
{

    @Test
    public void test_empty_to_string()
    {
        LinkedList list = new LinkedList();
        assertEquals("[]", list.toString());
    }

    @Test
    public void test_node_to_string()
    {
        char[] items = {'a', 'b', 'c', 'd'};
        Node[] nodes = new Node[items.length];

        for(int i=0; i<items.length; i++)
            nodes[i] = new Node<>(items[i]);

        LinkedList list = new LinkedList();

        for(int i=0; i<items.length-1; i++)
            nodes[i].next = nodes[i+1];

        for(int i=1; i<items.length; i++)
            nodes[i].prev = nodes[i-1];

        list.head = nodes[0];
        list.tail = nodes[nodes.length-1];
        list.size = nodes.length;

        assertEquals("[a, b, c, d]", list.toString());
    }
}