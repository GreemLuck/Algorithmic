package unifr.algo18;

public interface IShuntingYardAlgorithm
{
    Queue<Token> convertToRPN(Queue<Token> input);
}
