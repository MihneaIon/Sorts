package bublesort;

import java.util.Random;

public class Buble {

	public void sort(Integer[] myVector) {
		long startTime = System.currentTimeMillis();
		int ok;
		do {
			ok = 1;
			for (int i = 0; i < myVector.length - 1; i++) {
				if (myVector[i] > myVector[i + 1]) {
					int aux=myVector[i];
					myVector[i]= myVector[i+1];
					myVector[i+1]=aux;
					ok = 0;
				}
			}

		} while (ok == 0);
		
		long stopTime = System.currentTimeMillis();

		long dif = 0;
		dif = (stopTime - startTime) / 1000;
		System.out.println("Aici este diferenta " + dif);
	}

	public Integer[] vctor(int n) {
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

}
