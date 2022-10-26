using System.IO;
namespace Fibonacci
{
    internal class Fibonacci
    {
        public static int fib(int n)
        {
            if (n <= 1)
                return n;
            else
                return fib(n - 1) + fib(n - 2);
        }

        public static int fib2(int n)
        {
            int i;
            int[] f = new int[n + 1];
            f[0] = f[0];
            if (n > 0)
            {
                f[1] = 1;
                for (i = 2; i <= n; i++)
                    f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }
        static void Main(string[] args)
        {
            int number = 1;
            while(number != -1)
            {
                Console.WriteLine("\nEnter the term number that you want\n");
                Console.WriteLine("in the Fibonacci sequence (<= 40).\n");
                Console.WriteLine("Enter -1 to stop.\n\n");
                number = Convert.ToInt32(Console.ReadLine());
                if (number != -1)
                {
                    Console.WriteLine("Using a recursive version, we get:\n");
                    Console.WriteLine("" + fib(number));
                    Console.WriteLine();
                    Console.WriteLine("Using a nonrecursive version, we get:\n");
                    Console.WriteLine("" + fib2(number));
                    Console.WriteLine();
                }

            }
        }
    }
}
