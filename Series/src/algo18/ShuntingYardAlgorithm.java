package algo18;

public class ShuntingYardAlgorithm implements IShuntingYardAlgorithm
{
    @Override
    public Queue<Token> convertToRPN(Queue<Token> input)
    {
        Queue<Token> output = new Queue<>();
        Stack<Token> operatorStack = new Stack<>();

        while(!input.isEmpty()){
            Token read = input.dequeue();

            if(read.type == Token.TokenType.Numeric){
                output.enqueue(read);
            } else if(read.type == Token.TokenType.Function){
                operatorStack.push(read);
            } else if(read.type == Token.TokenType.Operator){

                Token topOperator = operatorStack.peek();
                while((topOperator.type == Token.TokenType.Function)
                    || (topOperator.getOperatorPrecedence() >= read.getOperatorPrecedence())
                    && (topOperator.toString() != "("))
                {

                }
            }
        }
    }
}
