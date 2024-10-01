public class MazeSolverStack extends MazeSolver {

    private MyStack stack;
    public MazeSolverStack(Maze maze)
    {
        super(maze);
    }


    @Override
    void makeEmpty() {
        stack = new MyStack();
    }

    @Override
    boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    void add(Square s) {
        stack.push(s);
    }

    @Override
    void remove() {
        stack.pop();
    }

    @Override
    Square next() {
        return stack.peek();
    }
}