% all of our facts

in_maine(farmington). %fact
in_maine(westbrook).
in_maine(portland).
in_maine(rangeley).
in_maine(wilton).

in_newhampshire(conway).
in_newhampshire(nashua).
in_newhampshire(manchester).

in_georgia(atlanta).
in_georgia(marietta).
in_georgia(athens).




%all of our rules


in_united_states(X) :- in_southeast(X). %rule, x is in united states if x is in maine
in_united_states(X) :- in_northeast(X). 

in_southeast(X) :- in_georgia(X).
%in_southeast(X) :- in_southcarolina(X).

in_northeast(X) :- in_maine(X).
in_northeast(X) :- in_newhampshire(X).