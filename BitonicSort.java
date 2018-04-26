package bitonic;

import java.util.Random;

public class BitonicSort {
	
	/*   Parametrul dir indica directia de sortare
	 ascendent sau descendent, daca(a[i] > a[j]) 
	 accepta directia, apoi a[i] si a[j] se interschimba */
 void compAndSwap(int a[], int i, Integer j, Integer dir)
 {
     if ( (a[i] > a[j] && dir == 1) ||
          (a[i] < a[j] && dir == 0))
     {
         // Swapping elements
         int temp = a[i];
         a[i] = a[j];
         a[j] = temp;
      //   System.out.println(a[i]);
      //   System.out.println(a[j]);
     }
 }

 /* Secventa recursiva pentru o secventa bitonica in mod
    ascendent, daca dir=1 si in ordine descendenta altfel
    (dir=0). Secventa pentru a fi sortata incepe cupozitia
    indexului low , parametrul cnt este numarul elementelor 
    ce vor fi sortate */
 void bitonicMerge(int a[], Integer low, Integer cnt, Integer dir)
 {
     if (cnt>1)
     {
    	
         int k = cnt/2;
         for (int i=low; i<low+k; i++)
             compAndSwap(a,i, i+k, dir);
         bitonicMerge(a,low, k, dir);
         bitonicMerge(a,low+k, cnt-k, dir);
     }
 }

 /* Aceasta functie in primul rand produce o secventa bitonica
    recursiva sortand-si cele doua jumatati in oridne inversa a sortarii 
    si apoi apleleaza bitonicMarge sa faca acelas lucru in aceiasi ordine
      */
 void bitonicSort(int a[], Integer low, Integer cnt, Integer dir)
 {
     if (cnt>1)
     {
         int k = cnt/2;
       //  System.out.println("am intrat1");
         //sortare in ordine ascendenta , dir este 1
         bitonicSort(a, low, k, 1);
       //  System.out.println("am intrat2");
         // sortare in ordine descendenta , dir este 0
         bitonicSort(a,low+k,cnt-k, 0);

         // Vom merge-ui ambele secvente in ordine crescatoare
         // dir=1.
         bitonicMerge(a, low, cnt, dir);
     }
 }

 /* Apelam functia bitonicSort pentru a sorta intregul 
  * vector de lungime N in ordine crescatoare */
 void sort(int a[], int N, int up)
 {
	 long startTime=System.currentTimeMillis();
     bitonicSort(a, 0, N, up);
     long stopTime=System.currentTimeMillis();
     
     long dif=0;
     dif=stopTime-startTime;
     System.out.println(" Aici este diferenta: "+dif);
 }

 
 static void printArray(int arr[])
 {
//     int n = arr.length;
//     for (int i=0; i<n; ++i)
//         System.out.print(arr[i] + " ");
//     System.out.println();
 }
 
 public int[] returnVctor(int n) {
		int[] myVector = new int[n];
		for (int i = 0; i < myVector.length; i++) {
			myVector[i] = randomFill();
		}
		return myVector;
	}

	public static Integer randomFill() {
		Random random = new Random();
		int randomNum = random.nextInt();
		return randomNum;
	}
	
	public void runAplication(int n)
	{
		int[] vector=returnVctor(n);
		sort(vector, vector.length, 1);
//		for(int i=0;i<vector.length;i++)
//		{
//			System.out.print(vector[i]+" ");
//		}
		
	}

}
