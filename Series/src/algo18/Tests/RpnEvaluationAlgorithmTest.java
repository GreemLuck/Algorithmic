package algo18.Tests;

import algo18.Queue;
import algo18.RpnEvaluationAlgorithm;
import algo18.Token;
import org.junit.Test;

public class RpnEvaluationAlgorithmTest
{

    @Test
    public void evaluateExpression()
    {
        Queue<Token> tokenQueue = new Queue<>();

        tokenQueue.enqueue(new Token(5));
        tokenQueue.enqueue(new Token(4));
        tokenQueue.enqueue(new Token(Token.OperatorType.Plus));

        assert new RpnEvaluationAlgorithm().evaluateExpression(tokenQueue) == 9;
    }
}