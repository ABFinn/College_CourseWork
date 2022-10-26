

in_maine(farmington).
in_maine(portland).
in_maine(augusta).

in_georgia(atlanta).
in_georgia(marietta).
in_georgia(athens).

in_southcarolina(clemson).
in_southcarolina(columbia).
in_southcarolina(edisto).

in_quebec(montreal).

in_usa(X) :- in_maine(X).
in_usa(X) :- in_georgia(X).
in_usa(X) :- in_southcarolina(X).

in_canada(X) :- in_quebec(X).

in_NA(X) :- in_usa(X).
in_NA(X) :- in_canada(X).


located_in(X,maine) :- in_maine(X),write(X),nl,fail.
located_in(X,georgia) :- in_georgia(X),write(X),nl,fail.
located_in(X,southcarolina) :- in_southcarolina(X),write(X),nl,fail.

located_in(X,na) :- in_NA(X),write(X),nl,fail.

