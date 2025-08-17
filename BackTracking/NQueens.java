package BackTracking;

import java.util.*;

class NQueens {
    boolean check(char mat[][], int n, int row,int col){
        for(int i=row;i>=0;i--){
            if(mat[i][col]=='Q') return false;
        }
        for(int i=row, j=col;j>=0&&i>=0;j--,i--){
            if(mat[i][j]=='Q') return false;
        }
        for(int i=row, j=col;j<n&&i>=0;j++,i--){
            if(mat[i][j]=='Q') return false;
        }
        return true;
    }
    void fun(char mat[][], int n, int row, int cnt[]){
        if(row==n){
            cnt[0]++;
        }
        else{
            for(int col = 0;col<n;col++){
                if(check(mat,n,row,col)){
                    mat[row][col] = 'Q';
                    fun(mat,n,row+1,cnt);
                    mat[row][col] = '-';
                }
            }
        }
    }
    public List<List<String>> totalNQueens(int n) {
        char [][]mat=new char[n][n];
        List<List<String>> lst =new ArrayList<>();
        int cnt[] = {0};
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++)
            {
                mat[row][col]='-';
            }
        }
        fun(mat,n,0,cnt);
        return lst;
    }
}