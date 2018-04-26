package countsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CountSort {
	
	// am main-ul aici

			 
			  public static int[] sort(int[] array) {
	 
			    int[] aux = new int[array.length];
			    int min = array[0];
			    int max = array[0];
			    for (int i = 1; i < array.length; i++) {
			      if (array[i] < min) {
			        min = array[i];
			      } else if (array[i] > max) {
			        max = array[i];
			      }
			    }

			    int[] counts = new int[max - min + 1];
			    for (int i = 0;  i < array.length; i++) {
			      counts[array[i] - min]++;
			    }
			    counts[0]--;
			    for (int i = 1; i < counts.length; i++) {
			      counts[i] = counts[i] + counts[i-1];
			    }

			    for (int i = array.length - 1; i >= 0; i--) {
			        aux[counts[array[i] - min]--] = array[i];
			    }
			 
			    return aux;
			  }
			 
			  public static void main(String[] args) {
			 
				  Scanner sc=new Scanner(System.in);
				  System.out.println("n= ");
				int n=sc.nextInt();
			    int [] unsorted=new int[n]; 
			    for(int i=0;i<unsorted.length;i++)
			    {
			    	unsorted[i]=new Random().nextInt(n);
			    }
			  //  System.out.println("Before: " + Arrays.toString(unsorted));
			    long start=System.currentTimeMillis();
			    int [] sorted = sort(unsorted);
			    long fin=System.currentTimeMillis();
			    
			   // System.out.println("After: " + Arrays.toString(sorted));
			    System.out.println("Aici este diferenta: " + (fin-start));
			 
			  }
			  
			  public int[] returnVector(int n)
				{
					int[] myVector = new int[n];
					for (int i = 0; i < myVector.length; i++) {
						myVector[i] = randomFill();
					}
					return myVector;
				}
				
				public int randomFill()
				{
					Random random = new Random();
					int randomNum = random.nextInt(60000000);
					return randomNum;
				}
				
				public void runAplication(int n)
				{
					
					int[] array=returnVector(n);
					long startTime = System.currentTimeMillis();
					sort(array);
					
				long stopTime = System.currentTimeMillis();
					
					long dif = 0;
					dif = (stopTime - startTime) ;
					System.out.println("Aici este diferenta " + dif);
					
				}
			}
