/**
 * @author 326333398@qq.com 2017/1/29 下午10:16
 * @date 2017/01/29
 * 汉诺塔问题我的理解是要对问题先抽象，然后类比。递归无非是一个方法被不停的调用，然后到了某个临界值而被终止掉
 * 这个问题先看只有一个盘子的情况，可以直接从A柱子移动到C柱子。
 * 两个盘子的话，A1盘先移动到B柱子，A2盘子在从A柱子移动到C柱子，然后A1盘从B柱子移动到C柱子
 * 三个盘子的话，A1，A2盘子先借助C柱子移动到B柱子，A3盘子移动到C柱子，然后A1、A2盘子借助A柱子从B柱子移动到C柱子
 * n个盘子的话，A柱子上面的前N-1个盘子都借助C柱子移动到B柱子上，然后第N个盘子移动到C柱子上，然后N-1个盘子借助A柱子从B柱子移动回到C柱子上
 *
 * 从上面分析看规律以及有了，除了只有一个盘子时不需要借助其他塔外，其余情况均一样，更重要的是有了递归的停止条件，即只有一个盘子的时候
 * 这个问题不好想或者难理解的地方是我下意识的对三个柱子进行了标记，其实这三个柱子是等价的！
 */
public class HanoiTower {
    public static void movePlate(int n,String source,String dependOn,String destination){
        if (n == 1) {
            System.out.println("移动第：" + n + "号盘子从" + source + "到" + destination);
        } else {
            movePlate(n-1, source, destination, dependOn);
            System.out.println("移动第：" + n + "号盘子从" + source + "到" + destination);
            movePlate(n-1, dependOn, source, destination);
        }
    }
}
