package algo18;

public class Stack<T>
{
    private Node head;
    private Node end;
    private int size;

    public Stack(){
        head = new Node(null, null);
        end = new Node(null,null);
        head.next = end;
        end.next = end;
        size = 0;
    }

    private class Node{
        T item;
        Node next;

        Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public void push(T element)
    {
        Node newItem = new Node(element, head.next);
        head.next = newItem;
        size++;
    }

    public T peek()
    {
        return head.next.item;
    }

    public T pop()
    {
        T result = head.next.item;
        head.next = head.next.next;
        size--;
        return result;
    }

    public boolean isEmpty()
    {
        if(head.next == end){
            return true;
        } else {
            return false;
        }
    }
}
