/*
Q7. Write java program for the following matrix operations:
    a. Addition of two matrices
    b. Summation of two matrices
    c. Transpose of a matrix -- Take input of elements of matrices from user
 */
package javapractical;

import java.util.Scanner;

/**
 *
 * @author SH
 */
public class Q7 {
    static Scanner sc;
    public static void main(String args[]){
        sc=new Scanner(System.in);
        int dim[]=EnterDim();
        int [][]Matrix1=EnterMatrix(dim);
        printMatrix(dim,Matrix1);
        System.out.print("Enter 1 for Addition\nEnter 2 for Subtraction\nEnter anything else for Transpose");
        int res=sc.nextInt();
        if(res==1 || res==2){
            int sign=1;
            int [][]Matrix2=EnterMatrix(dim);
            printMatrix(dim,Matrix2);
            if(res==2)sign=-1;
            printMatrix(dim,Add(Matrix1,Matrix2,dim,sign));
        }
        else{
            int ndim[]={dim[1],dim[0]};
            printMatrix(ndim,Transpose(Matrix1,dim));
        }
    }
    public static void printMatrix(int []dim,int[][] Matrix){
        System.out.print("{");
        for(int i=0;i<dim[0];i++){
            System.out.print("{");
            for(int j=0;j<dim[1];j++){
                System.out.print(Matrix[i][j]);
                if(j!=dim[1]-1)System.out.print(",");
            }
            System.out.print("}");
            if(i!=dim[0]-1)System.out.println("");
        }
        System.out.println("}");
    }
    public static  int[] EnterDim(){
        System.out.print("Please Enter number of rows :- ");
        int m=sc.nextInt();
        System.out.print("Please Enter number of colls :- ");
        int n=sc.nextInt();
        int arr[]={m,n};
        return arr;
    }
    public static int[][] EnterMatrix(int[] dim){
        int m=dim[0];
        int n=dim[1];
        int [][] Matrix=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print("mxn = "+i+"x"+j+"--> ");
                Matrix[i][j]=sc.nextInt();
            }
        }
        return Matrix;
    }
    public static int[][] Add(int[][]Matrix1,int[][]Matrix2,int []dim,int sign){
        int m=dim[0];
        int n=dim[1];
        int[][] Matrix=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Matrix[i][j]=Matrix1[i][j]+(Matrix2[i][j]*sign);
            }
        }
        return Matrix;
    }
    public static int[][] Transpose(int [][] Matrix,int [] dim){
        int m=dim[0];
        int n=dim[1];
        int [][] AMatrix=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                AMatrix[j][i]=Matrix[i][j];
            }
        }
        return AMatrix;
    }
}
