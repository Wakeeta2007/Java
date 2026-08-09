import java.util.*;
public class Stack_Operation {
    public static void main (String[]args){
        
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        Object item = stack.pop();
        System.out.println(item);
        
        }

    }
    
class Stack{
    private Object arr[]=new Object[10];
    private int top=-1;
    private int max=9;

    public void push(Object item){
        if (top==max){
            System.out.println("Can't take element , Stack is full.");
            return;
        }
        else{
            arr[++top]=item;
        }
    }

    public Object pop(){
        if (top==-1){
            System.out.println("Stack is empty , Nothing to pop");
            return null;
        }
        else{
            return arr[top--];
        }
    }

    public void display(){
        
    }

}
