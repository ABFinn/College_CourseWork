using System.Drawing;
using System.IO;
#pragma warning disable
namespace SimQuickSort
{
    internal class SimQuickSort
    {
        //size of array S
        static long n;
        //array for elements
        static long[] S;
        //counts # exchanges per run, array fills up one for each run, do 50 times for each size n
        static long[] C = new long[50];
        //An array for keeping track of the average exchanges for each 50 runs for each size n. 
        static double[] Averages = new double[15];
        //Each element of Averages divided by the n it originally ran on
        static double[] Scale = new double[15];
        //counter for exhanges
        static long count;
        //Random r for filling up array
        static Random r = new Random();

        private static void partition(long low, long high, out long pivotpoint)
        {
            long i, j, pivotitem;
            pivotitem = S[low];
            long temp;

            j = low;
            for(i = low + 1;i <= high; i++)
            {
                if (S[i] < pivotitem)
                {
                    j++;
                    temp = S[i];
                    S[i] = S[j];
                    S[j] = temp;
                    count++;

                }
            }
            pivotpoint = j;
            temp = S[low];
            S[low] = S[pivotpoint];
            S[pivotpoint] = temp;
        }

        private static void quicksort(long low, long high)
        {
            long pivotpoint;
            if(high > low)
            {
                partition(low, high, out pivotpoint);
                quicksort(low, pivotpoint - 1);
                quicksort(pivotpoint + 1, high);

            }
        }

        static void Main(string[] args)
        {
            //lim array for various size "n"
            int[] lim = { 10, 50, 100, 500, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000 };
            //int[] lim = { 10, 50 };
            int l = 0;
            n = lim[l];
            S = new long[n];
            double avgNum = 0;
            double scaleNum = 0;
            

            for (l = 0; l < lim.Length; l++)
            {
                //set n to next part of lim array
                n = lim[l];
                //set S to the correct size
                S = new long[n];
                for (int k = 0; k < 50; k++)
                {               
                    for (int i = 0; i < n; i++)
                    {
                        S[i] = r.Next(0, (int)n*10);
                    }
                    quicksort(0, n - 1);
                    C[k] = count;                   
                    count = 0;
                    
                    //test output array
                    /*for (int j = 0; j <= n - 1; j++)
                    {
                        //Console.Write("{0,10}", S[j]);
                        if ((j + 1) % 10 == 0)
                        {
                            //Console.WriteLine("\nLine # is: " + n);
                            //Console.WriteLine("\nK # is: " + k);
                        }
                    }
                    */

                }
                //iterates over our exchange numbers and adds them to avgNum so we can find an average
                for (int h = 0; h < C.LongLength; h++)
                {

                    avgNum = C[h] + avgNum;

                }
                
                avgNum = avgNum /  50;
                scaleNum = avgNum / lim[l];


                //Output and rounding to two decimals
                Averages[l] = Math.Round(avgNum,2);
                Scale[l] = Math.Round(scaleNum, 2);

                Console.WriteLine("\n\nAvg Num for " + n + " is: " + Averages[l]);
                Console.WriteLine("\nScale Num for " + n + " is: " + Scale[l]);







            }


            //avgNum = avgNum / 50;
            //scaleNum = avgNum / lim[limCount];




            /*for (int k = 0; k <= 49; k++)
            {
                //Console.WriteLine( setw( 6 )  a[i]);
                // {argnumber,field_width}
                Console.Write("{0,10}", C[k]);
                if ((k + 1) % 1 == 0)
                {
                    Console.WriteLine("\n");
                }
            }
            */

            //Console.WriteLine("\n");
            //Console.WriteLine("Avg value: " + avgNum);
            //Console.WriteLine("Scale Value: " + scaleNum);
            //Console.WriteLine("{o:F8}", 6);


        }   
    }
}