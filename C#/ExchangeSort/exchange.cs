namespace ExchangeSort
{
    internal class exchange
    {
        private static void exchangesort(int n, int[] S)
        {
            int i, j;
            int temp;
            for(i = 0; i < n - 1; i++)
            {
                for(j = i + 1; j < n; j++)
                {
                    if (S[j] < S[i])
                    {
                        temp = S[i];
                        S[i] = S[j];
                        S[j] = temp;
                    }
                        
                   
                }
            }
        }
        static void Main(string[] args)
        {
            int i;
            const int size = 6;
            int[] a;

            a = new int[size];
            a[0] = 200;
            a[1] = 100;
            a[2] = 5;
            a[3] = 75;
            a[4] = 1;
            a[5] = 6;

            Console.WriteLine("Array is:\n");
            for (i = 0; i <= size - 1; i++)
            {
                //Console.WriteLine( setw( 6 )  a[i]);
                // {argnumber,field_width}
                Console.Write("{0,6}", a[i]);
            }

            exchangesort(size, a);

            Console.WriteLine("\nArray is:\n");
            for (i = 0; i <= size - 1; i++)
            {
                //Console.WriteLine( setw( 6 )  a[i]);
                // {argnumber,field_width}
                Console.Write("{0,6}", a[i]);              
            }

            return;

        }
    }
}