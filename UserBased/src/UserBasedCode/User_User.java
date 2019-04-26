package UserBasedCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class User_User {
	public static int n;
	public static int m;

	public static void main(String[] args) {
		// du lieu 4 8
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
		double A[][] = new double[n][m]; // ma tran data
		double B[][] = new double[n][m]; // kq
		double E[][] = new double[n][m];
		double C[][] = new double[n][m]; // he so ma tran (da dien=1, chua dien=0)
		double D[][] = new double[n][n]; // ma tran khoang cach Euclide
		double S[][] = new double[n][n]; // ma tran Sim
		System.out.println("Nhap rating:");
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				A[i][j] = s.nextInt();
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
				System.out.print("\t" + A[i][j]);
			}
			System.out.println();
		}

		// tinh khoang cach giua cac user
		for (i = 0; i < n; i++) {
			for (k = 0; k < n; k++) {
				for (j = 0; j < m; j++) {
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
		for (i = 0; i < n; i++) {
			System.out.print("User" + i + "  \t");
		}
		System.out.println();
		for (i = 0; i < n; i++) {
			System.out.print("User" + i);
			for (j = 0; j < n; j++) {
				System.out.print("\t" + (double) (Math.round(D[i][j] * 100.00) / 100.00));
			}
			System.out.println();
		}

		// do do tuong tu
		System.out.println("\n Do do tuong tu giua cac user");
		System.out.print("\t");
		for (i = 0; i < n; i++) {
			System.out.print("User" + i + "  \t");
		}
		System.out.println();
		for (i = 0; i < n; i++) {
			System.out.print("User" + i);
			for (j = 0; j < n; j++) {
				sim = 1 / (1 + ((double) (Math.round(D[i][j] * 100.00) / 100.00)));
				S[i][j] = (double) (Math.round(sim * 100.00) / 100.00);
				System.out.print("\t" + S[i][j]);
			}
			System.out.println();
		}
		// he so ma tran A (cho dien =1; chua dien =0)
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
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
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				for (k = 0; k < n; k++) {
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
		for (j = 0; j < m; j++) {
			System.out.print("Item" + j + "  \t");
		}
		System.out.println();
		for (i = 0; i < n; i++) {
			System.out.print("User" + i);
			for (j = 0; j < m; j++) {
				System.out.print("\t" + B[i][j]);
			}
			System.out.println();
		}

	}
}
