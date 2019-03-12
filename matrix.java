class matrix{
    public static void main(String args[]){
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            // {13,14,15,16}      
        };
        print(matrix,3,4);
        transpose(matrix,3,4);
        rotateClockwise(matrix,3,4);
        rotateAntiClockwise(matrix,3,4);
        
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

    static void transpose(int m[][],int rows,int cols){
        int[][] newMatrix = new int[cols][rows];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                newMatrix[j][i] = m[i][j];
            }
        }
        print(newMatrix,cols,rows);
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
}