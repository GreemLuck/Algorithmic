package algo18;

public class RpnEvaluationAlgorithm implements IRpnEvaluationAlgorithm
{

    @Override
    public double evaluateExpression(Queue<Token> inputQueue)
    {
        Stack<Double> stack = new Stack();
        while(!inputQueue.isEmpty()) {
            Token token = inputQueue.dequeue();

            if (token.type == Token.TokenType.Numeric)
            {
                stack.push(token.asNumber);
            }
            else if (token.type == Token.TokenType.Operator)
            {
                double op2 = stack.pop();
                double op1 = stack.pop();

                switch(token.asOperator){
                    case Plus:
                        stack.push(op1 + op2);
                        break;
                    case  Minus:
                        stack.push(op1 - op2);
                        break;
                    case Multiply:
                        stack.push(op1 * op2);
                        break;
                    case Divide:
                        stack.push(op1/op2);
                        break;
                    case Power:
                        stack.push(Math.pow(op1, op2));
                        break;
                }
            }
            else if (token.type == Token.TokenType.Function)
            {
                double op = stack.pop();
                switch (token.asFunction){
                    case Sin:
                        stack.push(Math.sin(op));
                        break;
                    case Cos:
                        stack.push(Math.cos(op));
                        break;
                    case Exp:
                        stack.push(Math.exp(op));
                        break;
                }
            }
        }
        return stack.peek();
    }

}
