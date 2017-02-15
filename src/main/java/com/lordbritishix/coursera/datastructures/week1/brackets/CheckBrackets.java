package com.lordbritishix.coursera.datastructures.week1.brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
    private final char type;
    private final int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    public int getPosition() {
        return position;
    }
}

class BracketChecker {
    public static final int SUCCESS = 0;

    public int check(String text) {
        Stack<Bracket> openingBracketsStack = new Stack<>();

        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                openingBracketsStack.push(new Bracket(next, position));
            }

            if (next == ')' || next == ']' || next == '}') {
                if (openingBracketsStack.isEmpty()) {
                    return position + 1;
                }

                Bracket bracket = openingBracketsStack.peek();
                if (!bracket.match(next)) {
                    return position + 1;
                }

                openingBracketsStack.pop();
            }
        }

      if (!openingBracketsStack.isEmpty()) {
            return openingBracketsStack.peek().getPosition() + 1;
        }

        return 0;
    }
}

class checkBrackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        BracketChecker bracketChecker = new BracketChecker();
        int ret = bracketChecker.check(text);

        if (ret == BracketChecker.SUCCESS) {
            System.out.println("Success");
        } else {
            System.out.println(ret);
        }
    }
}
