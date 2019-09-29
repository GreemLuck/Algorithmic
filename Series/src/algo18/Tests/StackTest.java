package algo18.Tests;

import algo18.Stack;
import org.junit.Test;

public class StackTest {
    @Test
    public void pop() {
        Stack<Integer> integerStack = new Stack<>();

        assert integerStack.isEmpty();
        integerStack.push(1);

        assert !integerStack.isEmpty();

        integerStack.push(2);
        integerStack.push(3);

        assert integerStack.pop() == 3;
        assert integerStack.peek() == 2;
        assert  integerStack.pop() == 2;
        assert integerStack.pop() == 1;
        assert integerStack.isEmpty();
    }
}
