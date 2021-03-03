package algorithm.sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序.
 *      类似于抓扑克牌
 * 增量法.
 * 少量元素的排序,插入排序是个有效的算法.
 *
 * 1.时间复杂度: O(n^2)
 *      平均情况: O(n^2)
 *      最佳情况: O(n)
 *      最坏情况: O(n^2)
 *
 *      当数据正序时，执行效率最好，每次插入都不用移动前面的元素，时间复杂度为O(n)。
 *      当数据反序时，执行效率最差，每次插入都要前面的元素后移，时间复杂度为O(n^2)。
 *      所以，数据越接近正序，直接插入排序的算法性能越好。
 * 2.空间复杂度: O(1)
 * 3.稳定性: 稳定
 *      直接插入排序的过程中，不需要改变相等数值元素的位置，所以它是稳定的算法。
 * 4.复杂性: 简单
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-03-03  20:51
 */
public class InsertionSort {

    public static void main(String[] args) {

        //测试n个数据的排序
        int n = 100;
        int[] arr = new int[n];
        for (int index = 0; index < n; index++) {
            arr[index] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(arr));
        SimpleDateFormat startTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序开始时间：" + startTime.format(new Date()));

        insertionSort2(arr);
        System.out.println(Arrays.toString(arr));


        SimpleDateFormat endTime = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        System.out.println("排序结束时间：" + endTime.format(new Date()));
    }


    /**
     * 插入排序. 又称为直接插入排序.
     * <p>
     * 插入排序，一般也被称为直接插入排序。对于少量元素的排序，它是一个有效的算法 [1]  。
     * 插入排序是一种最简单的排序方法，它的基本思想是将一个记录插入到已经排好序的有序表中，
     * 从而一个新的、记录数增1的有序表。在其实现过程使用双层循环，外层循环对除了第一个元素之外的所有元素，
     * 内层循环对当前元素前面有序表进行待插入位置查找，并进行移动.
     *
     * @creator wx
     * @date 2021/3/3 21:08
     * @description
     */
    public static int[] insertionSort(int[] array) {
        int j;
        //对除了第一个元素之外的所有元素
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            // 左侧是已经排序好的数组, 需要从右到左挨个比较,寻找
            // insert array[i] into the sorted sequence array[0,1... i-1 ]
            j = i - 1;
            // 当前元素前面有序表进行待插入位置查找，并进行移动
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        return array;

    }


    /**
     * 插入排序.
     *  用双重for循环实现.
     *
     * @creator wx
     * @date 2021/3/3 21:37
     * @description
     */
    public static int[] insertionSort2(int[] array) {
        //对除了第一个元素之外的所有元素
        //第1个数肯定是有序的，从第2个数开始遍历，依次插入有序序列
        for (int i = 1; i < array.length; i++) {
            // 取出第i个数，和前i-1个数比较后，插入合适位置
            int value = array[i];
            int j = i-1;
            // 因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数(array[j])比temp大，就把这个数后移一位
            // 当前元素前面有序表进行待插入位置查找，并进行移动
            for (; j >= 0; j--) {
                if(array[j] > value){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            // 插入数据
            array[j+1] = value;
        }

        return array;

    }


}
