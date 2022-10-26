% Cannibals and missionaries!

cannibal :- 
	solve_cannibal([state(3,3,l)],Solution),
	reverse(Solution,[],OrderedSolution),
	show_states(OrderedSolution).


%
% solve_cannibal(+Sofar,-Solution)
%  searches for a Solution to the cannibals and missionaries
%  puzzle that extends the sequence of states in Sofar.
%

% Base case -- Nobody left on the left bank of the river
% This function is complete.
solve_cannibal([state(0,0,r)|PriorStates],[state(0,0,r)|PriorStates]).


% solve_cannibal where some M1 # of missionaries and C1 # of cannibals
%   exists on the left bank. It should figure out how many get on the boat and
%   call itself recursively, passing the new states as well as an r.
% THIS FUNCTION IS INCOMPLETE.

solve_cannibal([state(M1,C1,l)|PriorStates],Solution):-

	  %One or two persons crosses the river
	  %new variable for number crossing, can't be more than 2

	  %The number of persons crossing the river is limited to the number on the left bank
	  %create new variable

	  %The number of persons remaining on the left bank is decreased by the number that cross the river.

	  %The missionaries are not outnumbered on either bank after the crossing

	  %No earlier state is repeated

	  %Call solve_cannibal recursively, how many M and C's are on the right side and 
	  %left side by using state(#,#,r) and state(#,#,l)
	

% solve_cannibal where some M1 # of missionaries and C1 # of cannibals
%   exists on the right bank. It should figure out how many get on the boat and
%   call itself recursively, passing the new states as well as an r.
% THIS FUNCTION IS INCOMPLETE.

solve_cannibal([state(M1,C1,r)|PriorStates],Solution) :-

	  %One or two people cross the river

	  %The # of persons crossing is limited to the number of people on the right bank

	  %The # of people on right bank is decreased by the # that cross the river

	  %The missionaries are not outnumbered on either side.

	  %No earlier state is repeated


	  %Call solve_cannibal recursively, how many M and C's are on the left side and 
	  %right side by using state(#,#,l) and state(#,#,r)
	
	
% The remaining functions are utility functions to output the 
% solution to the screen. These are all complete.

	
show_states([]).
show_states([state(M,C,Location)|LaterStates]) :-
	write_n_times('M',M),
	write_n_times('C',C),
	N is 6 - M - C,
	write_n_times(' ', N),
	draw_boat(Location),
	MM is 3 - M,
	CC is 3 - C,
	write_n_times('M',MM),
	write_n_times('C',CC),
	nl,
	show_states(LaterStates).
	
write_n_times(_,0) :- !.
write_n_times(Item,N) :-
	write(Item),
	M is N - 1,
	write_n_times(Item,M).
	
draw_boat(l) :- write(' (___)     ').
draw_boat(r) :- write('     (___) ').


%member(X,[X|_]).
%member(X,[_|Y]) :- member(X,Y).

reverse([],List,List).
reverse([X|Tail],SoFar,List) :-
	reverse(Tail,[X|SoFar],List).