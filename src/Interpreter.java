import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class Token{
    enum Type{
        INTEGER,
        PLUS,
        MINUS,
        VARIABLE,
        INVALID_VARIABLE
    }
    public Type type;
    public String text;

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return "'"+text+"'";
    }
}
class ExpressionProcessor
{
    public Map<Character, Integer> variables = new HashMap<>();

    ArrayList<Token> lex(String expression){
        ArrayList<Token> tokens = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)){
                case '+':
                    tokens.add(new Token(Token.Type.PLUS,"+"));
                    break;
                case '-':
                    tokens.add(new Token(Token.Type.MINUS,"-"));
                    break;
                default:
                    StringBuilder digit = new StringBuilder();
                    StringBuilder letters = new StringBuilder();
                    for (int j = i; j < expression.length(); j++) {
                        char c = expression.charAt(j);
                        if(Character.isLetter(c) && c!='+'&& c!='-'){
                            if (j+1 < expression.length() && Character.isLetter(expression.charAt(j+1)) && expression.charAt(j+1)!='+'&& expression.charAt(j+1)!='-'){
                                tokens.add(new Token(Token.Type.INVALID_VARIABLE,letters.append(expression.charAt(j+1)).toString()));
                            }else {
                                tokens.add(new Token(Token.Type.VARIABLE,letters.append(""+c).toString()));
                            }
                            break;
                        }else if (Character.isDigit(c)){
                            digit.append(c);
                            ++i;
                        }else {
                            tokens.add(new Token(Token.Type.INTEGER,digit.toString()));
                            break;
                        }
                    }
                    break;


            }
        }

        return tokens;
}
    public int calculate(String expression)
    {
        // todo
        ArrayList<Token> tokens = lex(expression);

        boolean isInvalid = tokens.stream().anyMatch(token -> token.type.equals(Token.Type.INVALID_VARIABLE));
        boolean isInvalid1 = tokens.stream().noneMatch(token -> token.type.equals(Token.Type.VARIABLE));
        return isInvalid || isInvalid1 ? 0 : 1;
    }
}