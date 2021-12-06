package DataStructrue;

public class sparseArr {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];// 原数组
        int num = 0;//记录棋子个数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }//为原数组赋初值
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[3][4] = 1;//设置棋子
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    num++;
                }
            }
        }//记录棋盘中棋子个数

        int[][] sparseArr = new int[num + 1][3];//定义稀疏数组，行为棋子个数加一，列为3列
        sparseArr[0][0] = arr.length;//记录原数组的行
        sparseArr[0][1] = arr[0].length;//记录原数组的列数
        sparseArr[0][2] = num;//记录棋子的个数

        int count = 1;//行数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                    count++;
                }
            }
        }//为稀疏数组赋值

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.print(sparseArr[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 1; i < sparseArr.length; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
