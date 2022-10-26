using System.ComponentModel.Design;
using System.Security.Cryptography;

namespace BinarySearch
{
    internal class BinarySearch
    {
        private static void binsearch(int n, int[] S, int x, out int location)
        {
            int high = n;
            int low = 1;
            location = 0;
            int mid;

            while (low <= high && location == 0)
            {
                mid = (int)(Math.Floor((double)(low + high) / 2));
                if (x == S[mid])
                    location = mid;
                else if (x < S[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }



        }
        static void Main(string[] args)
        {
            const int size = 9;  // size = #elements in array
            int[] a;
            int x = 18, i;   // x = value to search for
            int place;       // subscript in array where x is or 0

            a = new int[size + 1];

            for (i = 1; i <= size; i++)  // 9 elements, I use subscripts
                a[i] = i + 3;              // starting at 1, not 0.
            Console.WriteLine("Array is:\n");
            for (i = 1; i <= size; i++)
            {
                //Console.WriteLine( setw( 6 )  a[i]);
                // {argnumber,field_width}
                Console.Write("{0,6}", a[i]);
                if ((i + 1) % 5 == 0)
                    Console.WriteLine("\n");
            }
            Console.WriteLine("\n\nDoing sequential search:\n");
            binsearch(size, a, x, out place);
            if (place == 0)
                Console.WriteLine("Number " + x + " is not found.\n");
            else
                Console.WriteLine(x + " is found at position " + place + "\n");

            return;
        }
    }
}