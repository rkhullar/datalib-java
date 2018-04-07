package list.linked;

class Node<T>
{
    protected T data;
    protected Node<T> prev, next;

    Node(){}

    Node(T data)
    {
        this.data = data;
    }

    boolean hasData()
    {
        return this.data != null;
    }

    boolean hasPrev()
    {
        return this.prev != null;
    }

    boolean hasNext()
    {
        return this.next != null;
    }

    public String toString()
    {
        return hasData() ? data.toString() : "null";
    }
}
