

% manipulating a knowledge base

% asserta(---). adds --- to the knowledge base
% retract(mother(X,Y)). removes first clause that matches this
% abolish(mother/2). removes all mother clauses with arity of 2
% listing.  lists contents of knowledge base



% see('filename') -- opens up filename for input
% see(user)  -- switches back to keyboard
% seen.  -- closes file(s)

% tell('filename') -- opens a file for output
% told.  -- closes file(s) for writing.


start :- reconsult('kb.pl'),
	 	 nl,
	 	 write('Use lowercase, followed by a period.'), nl,
	 	 write('Type "stop" to quit.'), nl,
	 	 nl,
	 	 process_a_query.
	 	 
process_a_query :- write('State? '),
				   read(State),
				   answer(State).
				   
answer(stop) :- write('Saving knowledge base...'), nl,
			    tell('kb.pl'),
			    listing(capital_of),
			    told,
			    write('Done.'),nl.

answer(State) :- capital_of(State,City),
				 write('The capital of '),
				 write(State),
				 write(' is '),
				 write(City), nl,
				 nl,
				 process_a_query.
				 
answer(State) :- \+ capital_of(State,_),
				 write('I have not heard of that one!'),nl,
				 write('What is the capital of '),
				 write(State),
				 write('? '),
				 read(City),
				 write('Added. '),nl,nl,
				 assertz(capital_of(State,City)),
				 process_a_query.
				 
				 
			    
