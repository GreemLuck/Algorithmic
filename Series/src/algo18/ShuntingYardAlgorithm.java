// Groupe : Gremaud Lucien, Paunoiu Bruno

package algo18;

public class ShuntingYardAlgorithm implements IShuntingYardAlgorithm
{
    @Override
    public Queue<Token> convertToRPN(Queue<Token> input)
    {
        Queue<Token> output = new Queue<>();
        Stack<Token> opStack = new Stack<>();

        while(!input.isEmpty()) {
            Token token = input.dequeue();

            if(token.type == Token.TokenType.Operator) {
                while(!opStack.isEmpty() && (opStack.peek().asBracket != Token.Bracket.Open) && (token.getOperatorPrecedence() <= opStack.peek().getOperatorPrecedence())){
                    output.enqueue(opStack.pop());
                }
                opStack.push(token);

            }
            else if(token.asBracket == Token.Bracket.Open) {
                opStack.push(token);
            }
            else if(token.asBracket == Token.Bracket.Close) {
                while(!opStack.isEmpty() && (opStack.peek().asBracket != Token.Bracket.Open)){
                    output.enqueue(opStack.pop());
                }
                opStack.pop();
            }
            else {
                output.enqueue(token);
            }
        }

        while(!opStack.isEmpty())
        {
            output.enqueue(opStack.pop());
        }

        return output;
    }
}

/*
Assignement 2
Exercise 1.3.3

The sequences that cannot occur are: b, f, g
 */
