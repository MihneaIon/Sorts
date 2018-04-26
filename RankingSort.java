package rank;

import java.util.Random;

public class RankingSort {
	
	 public Integer[] returnVctor(int n) {
			Integer[] myVector = new Integer[n];
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
			Integer[] vector=returnVctor(n);
			sort(n);
			
		}
		
		public void sort(int n)
		{
			long start=System.currentTimeMillis();
			Integer[] vector=new Integer[n];
			Integer[] rank=new Integer[n];
			Integer[] array=new Integer[n];
			array=returnVctor(n);
			for(int i=0;i<n;i++)
				rank[i]=0;
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<i;j++)
				{
					if(array[j]>array[i])
						rank[j]++;
					else {
						rank[i]++;
					}	
				}
			}
			for(int i=0;i<n;i++)
			{
				vector[rank[i]]=array[i];
			}
			for(int i=0;i<n;i++)
			{
				array[i]=vector[i];
			}
			long stop=System.currentTimeMillis();
			
			long dif=(stop-start)/1000;
			for(int i=0;i<vector.length;i++)
			{
				System.out.println(vector[i]);
			}
			System.out.println("Aici diferenta este: "+dif);
		}
}
