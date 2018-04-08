package list.linked;

public class LinkedList<T>
{
    protected Node<T> head, tail, curr;
    protected int size, pos;

    void reset()
    {
        head = null;
        tail = null;
        curr = null;
        size = 0;
        pos = -1;
    }

    void reset(T data)
    {
        Node<T> node = new Node<>(data);
        head = node;
        tail = node;
        curr = node;
        size = 1;
        pos = 0;
    }

    public LinkedList()
    {
        reset();
    }

    public LinkedList(T data)
    {
        reset(data);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node node = head;
        for(int i=0; i<size; i++)
        {
            if(node != null)
            {
                sb.append(node.data);
                if(node.hasNext())
                    sb.append(", ");
                node = node.next;
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
