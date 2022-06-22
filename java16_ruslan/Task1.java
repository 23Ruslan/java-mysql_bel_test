class Task1 {

  private static String p;

  static boolean reg(String S) { // just input control
    java.util.regex.Pattern p = java.util.regex.Pattern.compile("[0-9]+");
    java.util.regex.Matcher m = p.matcher(S);
    return m.matches();
  }

  public static String method1(int n) { //via Sieve of Eratosthenes algorithm, O(N*log(log(N)))
    boolean[] prime = new boolean[n + 1];
    java.util.Arrays.fill(prime, true);
    prime[1] = false;
    int sum = 1;
    for (int i = 2; i * i <= n; i++)
      if (prime[i])
        for (int j = i * i; j <= n; j += i) // before sqrt
          if (prime[j]) {
            sum += 1;
            prime[j] = false;
          }; //subtract the number of non-primes from the total number of numbers:
    return (n - sum) + ", i. e. " + java.lang.Math.round(100.0 * (n - sum) / n) + "%";
  }

  public static String method2(int n) { //via direct calculation, O(N^2). Just to compare and test the results
    int temporary = 0, sum = 0;
    for (int j = 2; j <= n; j++) {
      for (int i = 2; i <= java.lang.Math.ceil(j / 2.0); i++)
        if ((temporary = j % i) == 0) break;
      sum += (temporary == 0) ? (0) : (1);
    }
    return ((n > 2) ? (sum + 1) : 1) + ", i. e. " + java.lang.Math.round(100.0 * (sum + 1) / n) + "%";
  }

  public static void main(String[] args) {
    System.out.println("Input natural number N and press Enter:");
    while (true) {
      p = (new java.util.Scanner(System.in)).next();
      if (reg(p)) {
        break;
      } else {
        System.out.println("Input only digits:");
      }
    }
    int n = Integer.valueOf(p);
    System.out.println("The number of primes in the interval (0,N]:");
    System.out.print((n <= 1) ? "0, 0%" : method1(n));
  }
}