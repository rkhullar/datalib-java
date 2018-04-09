package list.linked;

public class LinkedList<T>
{
    protected Node<T> head, tail, curr;
    protected int size, pos;

    private void reset()
    {
        head = null;
        tail = null;
        curr = null;
        size = 0;
        pos = -1;
    }

    private void reset(T data)
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

    protected void seek(int pos)
    {
        int distance_from_head = pos,
            distance_from_tail = size-pos-1,
            distance_from_curr = Math.abs(this.pos-pos);

        Strategy strategy = Strategy.head;
        int min_distance = distance_from_head;

        if(distance_from_tail < min_distance)
        {
            strategy = Strategy.tail;
            min_distance = distance_from_tail;
        }

        if(distance_from_curr < min_distance)
        {
            strategy = Strategy.curr;
            min_distance = distance_from_curr;
        }

        switch (strategy)
        {
            case head:
                for(curr=head, this.pos=0; curr != null && this.pos < pos; this.pos++, curr=curr.next);
                break;
            case tail:
                for(curr=tail, this.pos=size-1; curr != null && this.pos > pos; this.pos--, curr=curr.prev);
                break;
            case curr:
                if(pos > this.pos)
                    for(; curr != null && this.pos < pos; this.pos++, curr=curr.next);
                else if(pos < this.pos)
                    for(; curr != null && this.pos > pos; this.pos--, curr=curr.prev);
        }

    }

    public void insert(int pos, int data)
    {

    }

    public T delete(int pos)
    {
        return null;
    }

    public int indexof(T data)
    {
        int i = 0;
        Node node = head;
        while(node != null)
        {
            if(node.data.equals(data))
                return i;
            node = node.next;
            i += 1;
        }
        return -1;
    }

    public boolean exists(T data)
    {
        return indexof(data) > -1;
    }

}
