public class HelloWorld {
     public static void main(String[] args) {
        System.out.println("Hello world!");
         // HW0 1a
		int row = 0;
		int SIZE = 5;
		while (row < SIZE) {
			int col = 0;
			while (col <= row) {
				System.out.print('*');
				col = col + 1;
			}
			System.out.println();
			row = row + 1;
		}


		drawTriangle(10);


		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));


        int[] a = {1, 2, -3, 4, 5, 4};
    	int n = 3;
    	windowPosSum(a, n);
    	// Should print 4, 8, -3, 13, 9, 4
    	System.out.println(java.util.Arrays.toString(a));
     }

     // HW0 1b
     public static void drawTriangle(int N) {
		int row = 0;
		int SIZE = N;
		while (row < SIZE) {
			int col = 0;
			while (col <= row) {
				System.out.print('*');
				col = col + 1;
			}
			System.out.println();
			row = row + 1;
		}
	}

	// HW0 2
	public static int max(int[] m) {
        int len = m.length;
        int count = 0;
        int currMax = 0;
        while (count < len) {
			if (m[count] > currMax) {
            currMax = m[count];
			}
		count = count + 1;
        }
        return currMax;
    }

    // HW0 3
    public static int max2(int[] m) {
        int currMax = 0;
        for (int count = 0; count < m.length; count += 1) {
          if (m[count] > currMax) {
            currMax = m[count];
			}
        }
        return currMax;
    }

    // HW0 4
    public static void windowPosSum(int[] a, int n) {
    /** your code here */ 
    for (int i = 0; i < a.length; i++) {
      if (a[i] < 0) {
        continue;
      }
      for (int j = 1; j <= n; j++) {
        if (i + j < a.length) {
          a[i] += a[i + j];
        }
        else {
          break;
        } 
      }
    }
  }
}

