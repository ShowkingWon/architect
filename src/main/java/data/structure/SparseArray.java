package data.structure;

/**
 * 稀疏数组.
 * 常用于数据压缩，比如五子棋、围棋等棋局保存。
 * 稀疏数组可以看做是普通数组的压缩，但是这里说的普通数组是值无效数据量远大于有效数据量的数组。
 * <p>
 * 压缩原因
 * 1.原数组中存在大量的无效数据，占据了大量的存储空间，真正有用的数据却少之又少
 * 2.压缩存储可以节省存储空间以避免资源的不必要的浪费，在数据序列化到磁盘时，压缩存储可以提高IO效率
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2020-02-19  19:48
 */
public class SparseArray {

    public static void main(String[] args) {
        //1 初始化二维数组

        /**
         * 初始化二位数组
         *  以11*11为例
         *  0 0 0 0 0 0 0 0 0 0 0
         *  0 0 1 0 0 0 0 0 0 0 0
         *  0 0 0 0 2 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0 0
         *  0 0 0 0 0 0 0 0 0 0 0
         */

        //1 初始化二维数组
        int rowCount = 11;
        int colCount = 11;
        int[][] array = new int[rowCount][colCount];

        //2 赋值
        array[1][2] = 1;
        array[2][3] = 2;

        //3 打印数组
        System.out.println("------------> 原始的二维数组");
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("------------> 二维数组转稀疏数组");
        /**
         * 稀疏数组
         * 11 11 2
         * 1  2  1
         * 2  3  2
         */

        //第一步: 先遍历二维数组，得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }

        //第二步：创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = rowCount;
        sparseArray[0][1] = colCount;
        sparseArray[0][2] = sum;
        //遍历二维数组，将非零的数值存入sparseArray
        int count = 0;//用于记录是第几个非零数值
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        // 打印稀疏数组
        System.out.println("------------> 稀疏数组");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        /**
         * 将稀疏数组恢复成原始二维数组
         * 1.先读取稀疏数组第一行，根据第一行的数据，创建原始的二维数组
         * 2.读取稀疏数组的第二行及往后的数据，并赋值给原始的二维数组
         */

        int[][] oldArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        //从稀疏数组的第二行开始
        for (int i = 1; i < sparseArray.length; i++) {
            oldArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //打印恢复后的二维数组
        System.out.println("------------> 恢复后的二维数组");
        for(int[] row : oldArray){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
