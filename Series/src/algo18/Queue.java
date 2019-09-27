package algo18;


public class Queue<T> {

    private Node head, end;
    private int size;

    public Queue() {
        head = new Node(null,null,null);
        end = new Node(null,null,null);

        head.previous = head;
        head.next = end;
        end.previous = head;
        end.next = end;

        size = 0;
    }

    private class Node {
        T item;
        Node previous;
        Node next;

        private Node(T item, Node previous, Node next){
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    public void enqueue(T element) {
        Node newItem = new Node(element,head,head.next);
        head.next.previous = newItem;
        head.next = newItem;
        size++;
    }

    public T dequeue() {
        T result = end.previous.item;
        end.previous.previous.next = end;
        end.previous = end.previous.previous;
        size--;
        return result;
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }
}