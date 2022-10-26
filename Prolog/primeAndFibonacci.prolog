divisible(X,Y):- N is Y*Y,
				 N =< X,
				 X mod Y =:= 0.

divisible(X,Y):- Y < X,
				 Y1 is Y+1,
				 divisible(X,Y1).

isprime(X):- Y is 2, X > 1, \+divisible(X,Y).



summation(0,0).
summation(X, Sum) :- X1 is X-1,
					 summation(X1,SubSum),
					 Sum is SubSum + X.

factorial(0,1).
factorial(X,Y):- X1 is X-1,
		    factorial(X1,Z),
			Y is X*Z.



			
fib(0,R) :- R is 0.			
fib(1,R) :- R is 1.
fib(2,R) :- R is 1.
fib(X,R) :- X1 is X-1,
          X2 is X-2,
		  fib(X1,X3),
          fib(X2,X4),
          R is X3 + X4.

