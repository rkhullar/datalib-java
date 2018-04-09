package list.linked;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest
{

    private <T> Node<T>[] build_node_array(final T[] items)
    {
        final Node[] nodes = new Node[items.length];
        for(int i=0; i<items.length; i++)
            nodes[i] = new Node<>(items[i]);
        return nodes;
    }

    private <T> LinkedList<T> build_list(final T[] items)
    {
        final LinkedList<T> list = new LinkedList<>();
        final Node<T>[] nodes = build_node_array(items);

        for(int i=0; i<items.length-1; i++)
            nodes[i].next = nodes[i+1];

        for(int i=1; i<items.length; i++)
            nodes[i].prev = nodes[i-1];

        list.head = nodes[0];
        list.tail = nodes[nodes.length-1];
        list.size = nodes.length;

        return list;
    }

    @Test
    public void test_empty_to_string()
    {
        LinkedList list = new LinkedList();
        assertEquals("[]", list.toString());
    }

    @Test
    public void test_node_to_string()
    {
        Character[] items = {'a', 'b', 'c', 'd'};
        LinkedList list = build_list(items);
        assertEquals("[a, b, c, d]", list.toString());
    }

    @Test
    public void test_node_index_of_1()
    {
        Character[] items = {'a', 'b', 'c', 'd'};
        LinkedList<Character> list = build_list(items);
        assertEquals(1, list.indexof('b'));
    }

    @Test
    public void test_node_index_()
    {
        Character[] items = {'a', 'b', 'c', 'd'};
        LinkedList<Character> list = build_list(items);
        assertEquals(-1, list.indexof('e'));
    }

    @Test
    public void test_seek_to_head()
    {
        Character[] items = {'a', 'b', 'c', 'd'};
        LinkedList<Character> list = build_list(items);
        list.curr = list.tail; list.pos = 3;
        list.seek(0);
        assertEquals(0, list.pos);
        assertEquals("a", list.curr.toString());
    }

    @Test
    public void test_seek_to_tail()
    {
        Character[] items = {'a', 'b', 'c', 'd'};
        LinkedList<Character> list = build_list(items);
        list.curr = list.head; list.pos = 0;
        list.seek(3);
        assertEquals(3, list.pos);
        assertEquals("d", list.curr.toString());
    }

    @Test
    public void test_seek_to_middle()
    {
        Character[] items = {'a', 'b', 'c', 'd'};
        LinkedList<Character> list = build_list(items);
        list.curr = list.head.next; list.pos = 1;
        list.seek(2);
        assertEquals(2, list.pos);
        assertEquals("c", list.curr.toString());
    }
}