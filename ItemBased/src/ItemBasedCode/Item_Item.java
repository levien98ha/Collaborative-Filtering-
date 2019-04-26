package ItemBasedCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class Item_Item {
	public static int n;
	public static int m;

	public static void main(String[] args) {
		// du lieu test ma tran [n,m]= [4, 8]
		/*
		  2 3 0 0 1 5 2 2 
		  0 3 5 0 0 5 2 2 
		  1 5 0 0 1 5 2 2
		  2 3 1 3 0 5 0 2
		 */
		int i, j, k;
		double sim;
		float p = 0, q = 0;
		float d = 0;
		// nhap index
		System.out.println("Nhap so User va so Item:");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		double A[][] = new double[m][n]; // ma tran data chuyen vi
		double B[][] = new double[m][n]; // kq
		double E[][] = new double[n][m]; // ma tran data ban dau
		double C[][] = new double[m][n]; // he so ma tran (da dien=1, chua dien=0)
		double D[][] = new double[m][m]; // ma tran khoang cach Euclide
		double S[][] = new double[m][m]; // ma tran Sim
		System.out.println("Nhap rating:");
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				E[i][j] = s.nextInt();
			}
		}

		// xuat index ban dau
		System.out.println("Data:");
		System.out.print("\t");
		for (j = 0; j < m; j++) {
			System.out.print("Item" + j + "  \t");
		}
		System.out.println();
		for (i = 0; i < n; i++) {
			System.out.print("User" + i);
			for (j = 0; j < m; j++) {
				System.out.print("\t" + E[i][j]);
			}
			System.out.println();
		}

		// chuyen vi ma tran
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				A[j][i] = E[i][j];
			}
		}

		// tinh khoang cach giua cac item
		for (i = 0; i < m; i++) {
			for (k = 0; k < m; k++) {
				for (j = 0; j < n; j++) {
					d += Math.pow(A[i][j] - A[k][j], 2);
					// D[i][i]=(float) Math.sqrt(4);
				}
				D[i][k] = (float) Math.sqrt(d);
				d = 0;
			}
		}
		
		// xuat khoang cach euclide
		System.out.println("\n Khoang cach Euclide");
		System.out.print("\t");
		for (i = 0; i < m; i++) {
			System.out.print("Item" + i + "  \t");
		}
		System.out.println();
		for (i = 0; i < m; i++) {
			System.out.print("Item" + i);
			for (j = 0; j < m; j++) {
				System.out.print("\t" + (double) (Math.round(D[i][j] * 100.00) / 100.00));
			}
			System.out.println();
		}

		// do do tuong tu
		System.out.println("\n Do do tuong tu giua cac Item");
		System.out.print("\t");
		for (i = 0; i < m; i++) {
			System.out.print("Item" + i + "  \t");
		}
		System.out.println();
		for (i = 0; i < m; i++) {
			System.out.print("Item" + i);
			for (j = 0; j < m; j++) {
				sim = 1 / (1 + ((double) (Math.round(D[i][j] * 100.00) / 100.00)));
				S[i][j] = (double) (Math.round(sim * 100.00) / 100.00);
				System.out.print("\t" + S[i][j]);
			}
			System.out.println();
		}
		// he so ma tran A (cho dien =1; chua dien =0)
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (A[i][j] != 0)
					C[i][j] = 1;
				else
					C[i][j] = 0;
			}
		}
		/*
		 * System.out.print("\t"); for (j=0;j<m;j++) {
		 * System.out.print("Item"+j+"  \t"); } System.out.println(); for(i=0; i<n;i++)
		 * { System.out.print("User"+i); for (j=0;j<m;j++) {
		 * System.out.print("\t"+C[i][j]); } System.out.println(); }
		 */

		
		// Bang rating complete
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				for (k = 0; k < m; k++) {
					p += A[k][j] * S[k][i];
					q += C[k][j] * S[k][i];
				}
				if (A[i][j] == 0)
					B[i][j] = (double) (Math.round((p / q) * 100.00) / 100.00);
				if (A[i][j] != 0)
					B[i][j] = A[i][j];
				/*
				 * System.out.println(); System.out.println("p="+p); System.out.println("q="+q);
				 */
				p = 0;
				q = 0;
			}
		}

		// ket qua
		System.out.println();
		System.out.println("Ket Qua:");
		System.out.print("\t");
		for (j = 0; j < n; j++) {
			System.out.print("User" + j + "  \t");
		}
		System.out.println();
		for (i = 0; i < m; i++) {
			System.out.print("Item" + i);
			for (j = 0; j < n; j++) {
				System.out.print("\t" + B[i][j]);
			}
			System.out.println();
		}

	}
}
