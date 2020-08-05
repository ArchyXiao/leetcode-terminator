package stack_queue;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/6/3 22:59
 */
public class DesignStackWithIncrementOperation {

class CustomStack {

        private int[] stack;
        private int size = 0;

        private int[] increment;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            increment = new int[maxSize + 1];
        }

        public void push(int x) {
            if (size == stack.length) {
                return;
            }

            stack[size++] = x;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }

            int val = stack[size - 1];
            if (increment[size] != 0) {
                val += increment[size];

                increment[size - 1] += increment[size];
                increment[size] = 0;
            }

            size--;

            return val;
        }

        public void increment(int k, int val) {
            int t = k > size ? size : k;
            increment[t] += val;
        }
    }

}
