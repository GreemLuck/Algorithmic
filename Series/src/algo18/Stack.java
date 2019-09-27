package algo18;

public class Stack<T>
{
    private final Object[] stack;
    private final int SIZE = 100;
    private int head;

    public Stack(){
        stack = new Object[SIZE];
        head = -1;
    }

    public void push(T element)
    {
        stack[++head] = element;
    }

    public T peek()
    {
        return (T)stack[head];
    }

    public T pop()
    {
        return (T)stack[head--];
    }

    public boolean isEmpty()
    {
        if(head == -1){
            return true;
        } else {
            return false;
        }
    }
}
