import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 326333398@qq.com 2017/2/7 下午10:16
 *         求一排数列中窗口里面的最大值，这里最容易想到的办法是M*N的复杂度,M为窗口大小，N为数列长度。暴力解决问题
 *         本题目的巧妙是弄了一个双端队列，用来记录当前窗口的最大值
 */
public class MaximumWindowNumber {

    public static void main(String[] args) {
        List<Integer> exampleList = Arrays.asList(4, 3, 5, 4, 3, 3, 6, 7);
        System.out.println(getMaxWindowNumber(exampleList, 3));
    }

    private static List<Integer> getMaxWindowNumber(List<Integer> exampleList, int windowSize) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < exampleList.size(); i++) {
            recursiveWindow(exampleList, windowSize, linkedList, resultList, i);

        }
        return resultList;
    }

    private static void recursiveWindow(List<Integer> exampleList, int windowSize, LinkedList<Integer> linkedList,
        List<Integer> resultList, int i) {
        if (linkedList.isEmpty()) {
            linkedList.add(i);
            if (i >= windowSize - 1) {
                resultList.add(exampleList.get(linkedList.getFirst()));
            }
            return;
        }
        if (exampleList.get(linkedList.getLast()) > exampleList.get(i)) {
            linkedList.add(i);
            if (i - windowSize + 1 > linkedList.getFirst()) {
                linkedList.removeFirst();
            }
            if (i >= windowSize - 1) {
                resultList.add(exampleList.get(linkedList.getFirst()));
            }
        } else {
            linkedList.removeLast();
            recursiveWindow(exampleList, windowSize, linkedList, resultList, i);
        }
    }
}
