package math.fastexpo;

public class Fastexpo {
	int pow(int a, int n, int m) {
		if (n == 1)
			return a;
		if ((n & 1) != 0) {
			return (a * pow((a * a) % m, (n - 1) >> 1, m)) % m;
		} else {
			return (pow((a * a) % m, n >> 1, m)) % m;
		}
	}

	public static void main(String[] args) {
		
	}
}
