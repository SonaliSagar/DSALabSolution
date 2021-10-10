package com.greatlearning.datastruct;

import java.util.*;

public class BracketBalance {

	private static Boolean CheckBracketBalance(String bracketExpression) {

		Stack<Character> stack = new Stack<Character>();


		for (int i = 0; i < bracketExpression.length(); i++)
		{
			char character = bracketExpression.charAt(i);
			//Check if the character is opening bracket or not?
			if (character == '(' || character == '[' || character == '{')
			{ 
				// Push the element in the stack and continue
				stack.push(character);
				continue;
			}
			// if stack is empty 
			if (stack.isEmpty())
				return false;

			char check;
			switch (character) {
			//check  = ) then check = (
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;
				
			//check  = } then check = {
			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			//check  = ] then check = [
			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		//return whether stack is empty or not
		return (stack.isEmpty());
	}

	public static void main(String[] args) {

		String bracketExpression = "([(){()}])";
		Boolean result;
		result = CheckBracketBalance(bracketExpression);

		if(result){
			System.out.println("The entered string has balanced brackets");
		}
		else
		{
			System.out.println("The entered string has not balanced brackets");
		}
	}
}
