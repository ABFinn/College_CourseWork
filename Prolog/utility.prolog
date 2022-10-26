
/* Lists
[Head | Tail]

swap_first_two([A,B|C], Result) :- Result is [B,A | C].


swap_first_two([1,2,3,4], Result). %should return 2,1,3,4


*/



list_length([],0).
list_length([_|Tail],Len) :- list_length(Tail,X),
						   Len is X + 1.
						  		
member(X,[X|_]).
member(X,[_|Rest]) :- member(X,Rest).


append([], X, X).
append([X1|X2],Y, [X1|Z]) :- append(X2,Y,Z).

reverse([],[]).
reverse([Head|Tail] , Result) :-
	reverse(Tail, ReversedTail),
	append(ReversedTail, [Head] , Result).

