%draw a maze
%create connect statements for it where start and finish are entry/exit

%connect(start,#).

%connect(start,1).
%connect(1,54).
%connect(5,9).
%connect(9,10).
%connect(10,11).
%connect(10,14).
%connect(11,7).
%connect(7,6).
%connect(6,2).
%connect(2,3).
%connect(3,4).
%connect(4,8).
%connect(8,12).
%connect(12,16).
%connect(14,13).
%connect(14,15).
%connect(15,16).
%connect(16,finish).
% connect(#,finish).

connect(start,1).
connect(1,2).
connect(2,6).
connect(6,5).
connect(5,9).
connect(9,13).
connect(13,14).
connect(14,10).
connect(14,15).
connect(10,11).
connect(11,7).
connect(7,8).
connect(8,4).
connect(4,1).
connect(8,12).
connect(12,16).
connect(16,finish).
connect(14,15).
connect(15,16).
connect(4,3).

% Maze solver
solve_maze :- path([start],Solution), reverse(Solution, RevSol), write(RevSol).
solve_maze(X) :- path([X],Solution), reverse(Solution, RevSol), write(Solution).

path([finish|RestOfPath],[finish|RestOfPath]).
path([CurrentLocation|RestOfPath],Solution) :-
	connected_to(CurrentLocation, NextLocation),
	\+ member(NextLocation,RestOfPath),
	path([NextLocation,CurrentLocation|RestOfPath],Solution).
	
connected_to(Location1,Location2) :- connect(Location1,Location2).
connected_to(Location1,Location2) :- connect(Location2,Location1).

member(X,[X|_]).
member(X,[_|Y]) :- member(X,Y).

reverse([],[]).
reverse([Head|Tail] , Result) :-
	reverse(Tail, ReversedTail),
	append(ReversedTail, [Head] , Result).

