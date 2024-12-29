public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();

        Queue queue = new Queue(10);
        queue.enqueue(20);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();

    }
}