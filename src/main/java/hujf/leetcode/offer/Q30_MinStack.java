package hujf.leetcode.offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *  
 *
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q30_MinStack {

    Stack<Integer> dataStack = new Stack<>();

    /**
     * 本题的关键就在于这个辅助栈，要暂存每一次入栈时的最小值，以空间换时间
     */
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public Q30_MinStack() {

    }

    public void push(int x) {
        dataStack.push(x);

        int min = !minStack.isEmpty() && minStack.peek() < x ? minStack.peek() : x;
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
