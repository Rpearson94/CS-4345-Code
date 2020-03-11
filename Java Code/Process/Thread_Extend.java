
public class Thread_Extend {
	public static void main(String[] args) {
		ShowChar s = new ShowChar('A', 150);
		ShowNum i = new ShowNum(7, 200);
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(i);
		t1.start();
		t2.start();
		s.start();
		i.start();
	}
}

class ShowChar extends Thread {
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

class ShowNum extends Thread {
	int num;
	int times;

	public ShowNum(int n, int t) {
		num = n;
		times = t;
	}

	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.print("\tTh2:" + num);
		}

	}
}