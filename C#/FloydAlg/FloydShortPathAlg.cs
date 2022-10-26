#pragma warning disable
namespace FloydShortPathAlg
{
    internal class FloydShortPathAlg
    {
        public static int[][] adjacency;         // The matrix
        public static int n;
        public const int infinity = 10000;
        //const as infinity shouldn't ever change

        public static void createMatrix(StreamReader rdr)
        {
            string line;
            string[] s; // for split         
            int i, j;
            

            try
            {
                line = rdr.ReadLine(); // comment read
                line = rdr.ReadLine(); // reads # rows as a string
                s = line.Split(null); // pass null to use whitespace. n is in s[0], line.split turns our data into an array of characters
                Console.WriteLine("First character " + s[0]); //print test
                n = Convert.ToInt32(s[0]); // n is 5 from file
                Console.WriteLine("Number of rows " + n); //print
                Console.WriteLine();//new line

                // Dynamically allocate matrix

                adjacency = new int[n][]; //set up empty 2d array size nxn
                for (i = 0; i < n; i++)
                    adjacency[i] = new int[n];

                
                for(i=0; i < n; i++) //fill the diagonal wih 0, fill rest with infiniy
                {
                    for(j=0; j < n; j++)
                    {
                        if(j == i) // diagonal
                        {
                            adjacency[i][j] = 0;
                        }
                        else //all other spots
                        {
                            adjacency[i][j] = infinity;
                        }
                    }
                }

                line = rdr.ReadLine(); // third line - get comment
                line = rdr.ReadLine(); // fourth line - get 4 8 2 7
                s = line.Split(null); 
                i = 0;  // row 0                
                
                Console.WriteLine("Our matrix is:\n");

                //Console.WriteLine("{0,8:D}", s[2]);


                
                  

                while (Convert.ToInt32(s[0]) != -1) //will keep going until end of file
                {
                    adjacency[Convert.ToInt32(s[0])][Convert.ToInt32(s[1])] = Convert.ToInt32(s[2]);
                    line = rdr.ReadLine(); //next line
                    s = line.Split(null); //split again and start over
                }

                for (i = 0; i < n; i++) //print matrix
                {
                    for (j = 0; j < n; j++)
                        Console.Write("{0,8:D}", adjacency[i][j]);
                    Console.WriteLine();
                }
                rdr.Close(); //end reader
                return;
            } // end try

            catch (IOException e)
            {
                Console.WriteLine("Some I/O problem", e.ToString());
            }
        }

        public static void Floyd()
        {
            //variables I'll need
            //D = Will be final distance matrix
            //P = will be final path matrix
            int i,j,k;
            int[][] D = new int[n][];
            int[][] P = new int[n][];

            //setting up the size of the size part of both 2d arrays to n
            for (i = 0; i < n; i++)
            {
                P[i] = new int[n];
                D[i] = new int[n];
            }
            

            //initialize path array with -1, we will overwrite some later
            for(i = 0; i < n; i++)
            {
                {
                    for(j = 0; j < n; j++)
                    {
                        P[i][j] = -1;
                    }
                }
            }

            //copy the initial adjacency over to our Distance array
            for (i = 0; i < n; i++)
            {
                {
                    for (j = 0; j < n; j++)
                    {
                        D[i][j] = adjacency[i][j];
                    }
                }
            }

            //if the distance between I to K + K to J is less than just I to J, than set the new distance of I to J as the addition.
            //also update the path matrix
            int count = 0;
            for(k = 0; k < n; k++)
            {
                for(i = 0; i < n; i++)
                {
                    for(j = 0; j < n; j++)
                    {
                        Console.WriteLine(count);
                        count++;
                        if (D[i][k] + D[k][j] < D[i][j])
                        {
                            P[i][j] = k;
                            D[i][j] = D[i][k] + D[k][j];

                        }
                    }
                }
            }
            //Print Final Distance Matrix
            Console.WriteLine("\nFinal Distance MATRIX:\n");
            for (i = 0; i < n; i++) //print matrix D
            {
                for (j = 0; j < n; j++)
                    
                    Console.Write("{0,8:D}", D[i][j]);
                    Console.WriteLine();
            }
            //Print Path Matrix
            Console.WriteLine("\nPath MATRIX:\n");
            for (i = 0; i < n; i++) //print matrix P
            {
                for (j = 0; j < n; j++)
                    
                    Console.Write("{0,8:D}", P[i][j]);
                    Console.WriteLine();
            }

            //recursive path function to look through our path matrix and print out the intermediate vertices
            static void path(int q, int r, int[][] P)
            {
                //if a path vertex is -1, exit if
                if (P[q][r] != -1)
                {
                    path(q, P[q][r], P);
                    Console.WriteLine(q + " - v" + P[q][r] + " - " + r);
                    //Console.WriteLine("\nUse intermediate vertex " + P[q][r] + " for vertex path: " + q + " to " + r);
                    path(P[q][r], r, P);
                }
                
            }

            //call path 25 times for each index of our n x n array
            for (i = 0; i < n; i++) { 
                for(j=0;j<n; j++)
                {       
                    path(i, j, P);
                }
            }
            

        }

        
        
        static void Main(string[] args)
        {

            // args[0] is the first command line argument you supply.            
            StreamReader rdr;

            // assign filename when define or get error in catch block
            String filename = null;

            try
            {
                filename = args[0];
            }
            catch (ArgumentNullException e)
            {
                Console.WriteLine("You must enter the filename on the command line",
                    e.ToString());
            }

            try
            {
                rdr = new StreamReader(filename);

                createMatrix(rdr);
                Floyd();

            }
            catch (FileNotFoundException e)
            {
                Console.WriteLine("File {0} was not found ", filename, e.ToString());
            }

            
            return;
        }
    }
}