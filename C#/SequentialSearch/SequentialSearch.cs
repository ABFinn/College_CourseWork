namespace SequentialSearch
{
    internal class SequentialSearch
    {
        /* Must make the method seqsearch static since the Main, which is static
	       is calling it. Otherwise, could have the main instantiate a class object
	       and use a gui.
	       It is illegal to use const int [] S.
	   */
        private static void seqsearch(int n, int[] S, int x, out int location)
        /* Parameter 1 is the size of the array. Parameter2 is the array.
		   Parameter3 is the value to look for in the array. Parameter 4
		   is the subscript in the array where the item is found or it is
		   0 if it is not found. Does a sequential search. */
        {
            location = 1;
            while (location <= n && S[location] != x)
                location++;
            if (location > n)
                location = 0;
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
            seqsearch(size, a, x, out place);
            if (place == 0)
                Console.WriteLine("Number " + x + " is not found.\n");
            else
                Console.WriteLine(x + " is found at position " + place + "\n");

            return;
        }
    }
}