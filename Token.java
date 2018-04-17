import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Token {

    enum Toktype {
        NUMBER, OP, PAREN
    }

    // Pensa a implementar els "getters" d'aquests atributs
    private Toktype ttype;
    private int value;
    private char tk;

    public int getValue() {
        return value;
    }

    public char getTk() {
        return tk;
    }

    public Toktype getTtype() {
        return ttype;
    }

    // Constructor privat. Evita que es puguin construir objectes Token externament
    private Token() {
    }

    // Torna un token de tipus "NUMBER"
    static Token tokNumber(int value) {
        Token num = new Token();
        num.ttype = Toktype.NUMBER;
        num.tk = (char) value;
        return num;
    }

    // Torna un token de tipus "OP"
    static Token tokOp(char c) {
        Token op = new Token();
        op.ttype = Toktype.OP;
        op.tk = c;
        return op;
    }

    // Torna un token de tipus "PAREN"
    static Token tokParen(char c) {
        Token par = new Token();
        par.ttype = Toktype.PAREN;
        par.tk = c;
        return par;
    }

    // Mostra un token (conversió a String)
    public String toString() {
        Token t = new Token();
        return t.toString();
    }

    // Mètode equals. Comprova si dos objectes Token són iguals
    public boolean equals(Object o) {
        Token t = (Token)o;
        return this.ttype == t.ttype;
    }

    // A partir d'un String, torna una llista de tokens
    public static Token[] getTokens(String expr) {
        // Inicializamos la String expr vacía, y creamos una Lista
        expr = "";
        List<Token> t = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            // Si hay un espacio, continua
            if (expr.charAt(i) == ' '){
                continue;
            }
            // Si el carácter no es un operador, es decir un número, creamos una StringBuilder
            if (!comprobar(expr.charAt(i))){
                StringBuilder sb = new StringBuilder();
                sb.charAt(expr.charAt(i));
                // Recorremos la String en busca de los valores
                for (int j = i+1; j < expr.length(); j++) {
                    if (comprobar(expr.charAt(j))){
                        break;
                    } sb.append(j);
                    i = j;
                }
                t.add(Token.tokNumber(Integer.parseInt(sb.toString())));
            } else if (EsParentesis(expr.charAt(i))) {
                t.add(Token.tokParen(expr.charAt(i)));
                if (expr.charAt(i) == '+' || expr.charAt(i) == '-' || expr.charAt(i) == '*' || expr.charAt(i) == '/') {
                    t.add(Token.tokOp(expr.charAt(i)));
                }
            }
        }
        return t.toArray(Token.getTokens(expr));
    }

    static boolean EsParentesis(char c){
        return (c == '(' || c == ')');
    }

    static boolean comprobar(char c){
        return (c == ' ' || c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')');
    }
}

//            else if (comprobar(expr.charAt(i)) && expr.charAt(i) != '(' && expr.charAt(i) != ')') {
//                if (expr.charAt(i) == '-') {
//                } else if (expr.charAt(i) == '+') {
//                    if (i == 0 || i + 1 < expr.length() - 1 && expr.charAt(i + 1) == '-' ||
//                            t.size() > 0 && t.get(t.size() - 1).getTk() == '-') {
//                        continue;
//                    }
//                }
//                t.add(tokOp(expr.charAt(i)));
//            } else if (comprobar(expr.charAt(i))){
//                t.add(tokParen(expr.charAt(i)));
//            }