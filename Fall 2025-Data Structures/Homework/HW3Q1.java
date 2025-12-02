import java.util.*;

class Node {
    String value;
    Node left, right;

    Node(String value) {
        this.value = value;
        left = right = null;
    }
}

public class ExpressionTree {

    private static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    private static int precedence(String op) {
        switch (op) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
        }
        return -1;
    }

    private static List<String> infixToPostfix(String expr) {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(expr, "+-*/() ", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken().trim();
            if (token.isEmpty()) continue;

            if (token.matches("\\d+")) {
                output.add(token);

            } else if (token.equals("(")) {
                stack.push(token);

            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                stack.pop();

            } else if (isOperator(token)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) &&
                        precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    public static Node buildTree(String infixExpr) {
        List<String> postfix = infixToPostfix(infixExpr);
        Stack<Node> stack = new Stack<>();

        for (String token : postfix) {
            if (!isOperator(token)) {
                stack.push(new Node(token));   // operand
            } else {
                Node right = stack.pop();
                Node left = stack.pop();
                Node opNode = new Node(token);
                opNode.left = left;
                opNode.right = right;
                stack.push(opNode);
            }
        }

        return stack.pop();
    }

    public static void printPreorder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter arithmetic expression: ");
        String expr = sc.nextLine();

        Node root = buildTree(expr);

        System.out.print("Prefix expression: ");
        printPreorder(root);
        System.out.println();
    }
}