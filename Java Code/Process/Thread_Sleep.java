
public class Thread_Sleep {
	public static void main(String[] args) {
		ShowChar s = new ShowChar('A', 150);
		ShowNum i = new ShowNum(7, 200);

		Thread t1 = new Thread(s);
		Thread t2 = new Thread(i);
		t1.start();
		t2.start();

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
		for (int i = 0; i < times; i++)
			System.out.print("\tTh1:" + c);
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
		try {
			for (int i = 0; i < times; i++) {
				System.out.print("\t i = " + i + " Th2:" + num);
				if (i >= 30)
					Thread.sleep(2); // This thread will sleep for 2 millisec after printing 30 times
			}
		} catch (InterruptedException e) {
		}

	}
}