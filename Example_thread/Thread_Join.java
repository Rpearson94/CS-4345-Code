
public class Thread_Join {
	public static void main(String[] args) {
		ShowChar s = new ShowChar('A', 15);

		Thread t1 = new Thread(s);

		t1.start();

	}
}

class ShowChar implements Runnable {
	char c;
	int times;

	public ShowChar(char c, int t) {
		this.c = c;
		times = t;
	}

	public void run() {
		ShowNum n = new ShowNum(7, 20);
		Thread t2 = new Thread(n);

		t2.start();

		try {
			for (int i = 0; i < times; i++) {
				System.out.print("\t i1 = " + i + " Th1:" + c);
				if (i == 8)
					t2.join(); // this will make the thread 1 (printing character) to wait, after printing 8
											// times, for thread 2 to finish
			}
		} catch (Exception e) {
		}
	}
}

class ShowNum implements Runnable {
	int num;
	int times;

	public ShowNum(int n, int t) {
		num = n;
		times = t;
	}

	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.print("\t i2 = " + i + " Th2:" + num);
		}

	}
}

// =================== Sample outputs ===================

/*
 * Run 1 output: ---jGRASP exec: java Thread_Join
 * 
 * i2 = 0 Th2:7 i1 = 0 Th1:A i2 = 1 Th2:7 i1 = 1 Th1:A i2 = 2 Th2:7 i1 = 2 Th1:A
 * i2 = 3 Th2:7 i1 = 3 Th1:A i2 = 4 Th2:7 i1 = 4 Th1:A i2 = 5 Th2:7 i1 = 5 Th1:A
 * i2 = 6 Th2:7 i1 = 6 Th1:A i2 = 7 Th2:7 i1 = 7 Th1:A i2 = 8 Th2:7 i1 = 8 Th1:A
 * i2 = 9 Th2:7 i2 = 10 Th2:7 i2 = 11 Th2:7 i2 = 12 Th2:7 i2 = 13 Th2:7 i2 = 14
 * Th2:7 i2 = 15 Th2:7 i2 = 16 Th2:7 i2 = 17 Th2:7 i2 = 18 Th2:7 i2 = 19 Th2:7
 * i1 = 9 Th1:A i1 = 10 Th1:A i1 = 11 Th1:A i1 = 12 Th1:A i1 = 13 Th1:A i1 = 14
 * Th1:A ----jGRASP: operation complete.
 */

/*
 * Run 2 output: ----jGRASP exec: java Thread_Join
 * 
 * i1 = 0 Th1:A i2 = 0 Th2:7 i1 = 1 Th1:A i2 = 1 Th2:7 i1 = 2 Th1:A i2 = 2 Th2:7
 * i1 = 3 Th1:A i2 = 3 Th2:7 i1 = 4 Th1:A i2 = 4 Th2:7 i1 = 5 Th1:A i2 = 5 Th2:7
 * i1 = 6 Th1:A i2 = 6 Th2:7 i1 = 7 Th1:A i2 = 7 Th2:7 i1 = 8 Th1:A i2 = 8 Th2:7
 * i2 = 9 Th2:7 i2 = 10 Th2:7 i2 = 11 Th2:7 i2 = 12 Th2:7 i2 = 13 Th2:7 i2 = 14
 * Th2:7 i2 = 15 Th2:7 i2 = 16 Th2:7 i2 = 17 Th2:7 i2 = 18 Th2:7 i2 = 19 Th2:7
 * i1 = 9 Th1:A i1 = 10 Th1:A i1 = 11 Th1:A i1 = 12 Th1:A i1 = 13 Th1:A i1 = 14
 * Th1:A ----jGRASP: operation complete.
 * 
 */