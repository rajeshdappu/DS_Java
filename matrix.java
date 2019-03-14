class matrix{
    public static void main(String args[]){
        int[][] matrix = {
            {1,2,3,4,},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}   
        };
        print(matrix,4,4);
        // transpose(matrix,3,4);
        // rotateClockwise(matrix,3,4);
        // rotateAntiClockwise(matrix,3,4);
        // rotateClockwise90(matrix,4,4);
        // rotateAntiClockwise90(matrix,4,4);

        // int[][] m1 = {
        //     {1,2,3},
        //     {4,5,6},
        //     {7,8,9}
        // };
        // matrixMultplication(m1,3,3,m1,3,3);

        sphericarOrder(matrix,4,4);
        
    }

    static void print(int a[][],int rows,int cols){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }  

    static int[][] transpose(int m[][],int rows,int cols){
        int[][] newMatrix = new int[cols][rows];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                newMatrix[j][i] = m[i][j];
            }
        }
                System.out.println("Transpose ,");
        print(newMatrix,cols,rows);
        return newMatrix;
    } 

    static void rotateClockwise(int mt[][],int r,int c){
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = r-1;
        int colEnd = c-1;

        while(rowStart<rowEnd && colStart<colEnd){

            int prevElement = mt[rowStart+1][colStart];

            for(int i=colStart;i<=colEnd;i++){ //rotating first row
                int currentElement = mt[rowStart][i];
                mt[rowStart][i] = prevElement;
                prevElement = currentElement;
            }
            rowStart++;

            for(int i=rowStart;i<=rowEnd;i++){//rotating last column
                int currentElement = mt[i][colEnd];
                mt[i][colEnd] = prevElement;
                prevElement = currentElement;
            }
            colEnd --;

            for(int i=colEnd;i>=colStart;i--){ //rotating last row
                int currentElement = mt[rowEnd][i];
                mt[rowEnd][i] = prevElement;
                prevElement = currentElement;
            }
            rowEnd--;

            for(int i=rowEnd;i>=rowStart;i--){//rotating first column
                int currentElement = mt[i][colStart];
                mt[i][colStart] = prevElement;
                prevElement = currentElement;
            }
            colStart++;
        }

        print(mt,r,c);
    }

    static void rotateAntiClockwise(int mt[][],int r,int c){
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = r-1;
        int colEnd = c-1;


        while(rowStart<rowEnd && colStart<colEnd){

            int nextElement = mt[rowStart+1][colEnd];

            for(int i=colEnd;i>=colStart;i--){
                int currentElement = mt[rowStart][i];
                mt[rowStart][i] = nextElement;
                nextElement = currentElement;
            }
            rowStart++;
            for(int i=rowStart;i<=rowEnd ; i++){
                int currentElement = mt[i][colStart];
                mt[i][colStart] = nextElement;
                nextElement = currentElement;
            }
            colStart++;

            for(int i=colStart;i<=colEnd;i++){
                int currentElement = mt[rowEnd][i];
                mt[rowEnd][i] = nextElement;
                nextElement = currentElement;
            }
            rowEnd--;
            for(int i=rowEnd;i>=rowStart;i--){
                int currentElement = mt[i][colEnd];
                mt[i][colEnd] = nextElement;
                nextElement = currentElement;
            }
            colEnd--;
        }
        print(mt,r,c);
    }

    static void rotateClockwise90(int mt[][],int r, int c){
        mt = transpose(mt,r,c); // because rotation in clockwise means tranpose + reversing columns
        for(int i=0;i<r;i++){
            for(int j=0,k=c-1;j<k;j++,k--){
                int temp = mt[i][j];
                mt[i][j] = mt[i][k];
                mt[i][k] = temp;
            }
        }
        print(mt,r,c);
    }

    static void rotateAntiClockwise90(int mt[][],int r, int c){
        mt = transpose(mt,r,c); // because rotation in anti-clockwise means tranpose + reversing rows
        for(int i=0,j=r-1;i<j;i++,j--){
            int temp[] = mt[i];
            mt[i] = mt[j];
            mt[j] = temp;
        }
        print(mt,r,c);
    }

    static void matrixMultplication(int m1[][],int r1,int c1,int m2[][],int r2,int c2){
        int result[][] = new int [r1][c2];
        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                result[i][j] = 0;
                for(int k=0;k<c1;k++){
                    result[i][j] =  result[i][j] + (m1[i][k] * m2[k][j]);
                }
            }
        }
        print(result,r1,c2);
    }

    static void sphericarOrder(int m[][],int r,int c){
        int rowStart = 0;
        int rowEnd = r-1;
        int colStart = 0;
        int colEnd = c-1;

        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                System.out.println(m[rowStart][i]);
            }
            rowStart++;
            for(int i=rowStart;i<=rowEnd;i++){
                System.out.println(m[i][colEnd]);
            }
            colEnd--;
            for(int i=colEnd;i>=colStart;i--){
                System.out.println(m[rowEnd][i]);
            }
            rowEnd--;
            for(int i=rowEnd;i>=rowStart;i--){
                System.out.println(m[i][colStart]);
            }
            colStart++;
        }
    }
}