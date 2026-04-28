import java.util.*;

class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> stacks;
    private TreeSet<Integer> availableIndices;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.availableIndices = new TreeSet<>();
    }

    public void push(int val) {
       
        if (availableIndices.isEmpty()) {
            stacks.add(new Stack<>());
            availableIndices.add(stacks.size() - 1);
        }
        
        int firstAvailable = availableIndices.first();
        Stack<Integer> stack = stacks.get(firstAvailable);
        stack.push(val);
        
      
        if (stack.size() == capacity) {
            availableIndices.remove(firstAvailable);
        }
    }

    public int pop() {
        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }

        Stack<Integer> stack = stacks.get(index);
        int val = stack.pop();
        
        
        availableIndices.add(index);
        
        
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            availableIndices.remove(stacks.size() - 1);
            stacks.remove(stacks.size() - 1);
        }
        
        return val;
    }
}
