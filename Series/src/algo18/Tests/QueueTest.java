package algo18.Tests;

import org.junit.Test;
import algo18.Queue;

public class QueueTest
{
    @Test
    public void dequeue()
    {
        Queue<Integer> integerQueue = new Queue<>();
        integerQueue.enqueue(1);

        assert !integerQueue.isEmpty();

        integerQueue.enqueue(2);
        integerQueue.enqueue(3);

        assert integerQueue.dequeue() == 1;
        assert integerQueue.dequeue() == 2;
        assert integerQueue.dequeue() == 3;
        assert integerQueue.isEmpty();

        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        integerQueue.enqueue(4);

        assert integerQueue.dequeue() == 1;
        assert integerQueue.dequeue() == 2;
        assert integerQueue.dequeue() == 3;
        assert integerQueue.dequeue() == 4;
        assert integerQueue.isEmpty();
    }
}