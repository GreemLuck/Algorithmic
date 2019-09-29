package algo18.Tests;

import org.junit.Test;
import algo18.Queue;
import algo18.ShuntingYardAlgorithm;
import algo18.Token;

public class ShuntingYardAlgorithmTest {

    @Test
    public void convertToRPN() {
        Queue<Token> inQ = new Queue<>();
        Token three = new Token(3), plus = new Token(Token.OperatorType.Plus), four = new Token(4)
                , divided = new Token(Token.OperatorType.Divide), seven = new Token(7), six = new Token(6)
                , open = new Token(Token.Bracket.Open), close = new Token(Token.Bracket.Close);

        inQ.enqueue(open);
        inQ.enqueue(three);
        inQ.enqueue(plus);
        inQ.enqueue(four);
        inQ.enqueue(close);
        
        Queue<Token> outQ = new ShuntingYardAlgorithm().convertToRPN(inQ);

        assert outQ.dequeue() == three;
        assert outQ.dequeue() == four;
        assert outQ.dequeue() == plus;
    }
}