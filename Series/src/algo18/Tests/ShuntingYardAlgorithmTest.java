package algo18.Tests;

import org.junit.Test;
import algo18.Queue;
import algo18.ShuntingYardAlgorithm;
import algo18.Token;

public class ShuntingYardAlgorithmTest {

    @Test
    public void convertToRPN() {
        Queue<Token> inQ = new Queue<>();
        Token three = new Token(3), plus = new Token(Token.OperatorType.Plus), four = new Token(4);

        inQ.enqueue(three);
        inQ.enqueue(plus);
        inQ.enqueue(four);

        Queue<Token> outQ = new ShuntingYardAlgorithm().convertToRPN(inQ);

        assert outQ.dequeue() == three;
        assert outQ.dequeue() == four;
        assert outQ.dequeue() == plus;
    }
}