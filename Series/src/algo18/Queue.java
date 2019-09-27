package algo18;


public class Queue<T> {

    private final Object[] queue;
    private final int SIZE = 100;
    private int head, end;

    public Queue() {
        queue = new Object[SIZE];
        head = 0;
        end = 0;
    }

    public void enqueue(T element) {
        queue[end++] = element;
    }

    public T dequeue() {
        return (T)queue[head++];
    }

    public boolean isEmpty() {
        if(head == end){
            return true;
        } else {
            return false;
        }
    }
}