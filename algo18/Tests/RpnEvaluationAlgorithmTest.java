package unifr.algo18.Tests;

import org.junit.Test;
import unifr.algo18.Queue;
import unifr.algo18.RpnEvaluationAlgorithm;
import unifr.algo18.Token;

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