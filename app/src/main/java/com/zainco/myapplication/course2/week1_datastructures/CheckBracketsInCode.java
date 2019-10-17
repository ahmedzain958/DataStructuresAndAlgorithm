package com.zainco.myapplication.course2.week1_datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        return this.type == '(' && c == ')';
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        if (text.length() == 1) {
            System.out.println("1");
            return;
        }
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char currentCharacter = text.charAt(position);
            Bracket bracket  = new Bracket(currentCharacter, position);
            if (currentCharacter == '(' || currentCharacter == '[' || currentCharacter == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.push(bracket);
            }
            if (currentCharacter == ')' || currentCharacter == ']' || currentCharacter == '}') {
                // Process closing bracket, write your code here
                if (!opening_brackets_stack.isEmpty()) {
                    if (opening_brackets_stack.lastElement().Match(currentCharacter))
                        opening_brackets_stack.pop();
                    else {
                        System.out.println(position + 1);
                        return;
                    }
                } else if (opening_brackets_stack.isEmpty()) {  // input = { or Input: []](
                    System.out.println(position + 1);
                    return;
                }
            }
            // Printing answer, write your code here
        }
        if (opening_brackets_stack.isEmpty()) {
            System.out.println("Success");
        } else {
            System.out.println(opening_brackets_stack.lastElement().position+1);

        }
    }
}
