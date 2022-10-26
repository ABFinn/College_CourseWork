male(aidan).
male(bailey).
male(cash).
male(alan1).
male(alan2).
male(michael).
male(david).
male(david2).
male(nolan).
male(jack).


female(dacey).
female(beth).
female(mary).
female(katie).
female(jenny).
female(jackie).


parent(katie,aidan).
parent(katie,bailey).
parent(katie,cash).
parent(katie,dacey).
parent(alan,aidan).
parent(alan,bailey).
parent(alan,cash).
parent(alan,dacey).

parent(david, nolan).
parent(jackie, nolan).

married(jackie, david).
married(jack, jenny).










male(joe).
male(chris).
male(carter).
male(jackson).
male(kin).
male(joejr).
male(joey).
male(wesley).
male(kelly).

female(shannon).
female(vickie).
female(cathy).
female(andrea).
female(leanna).
female(aerin).
female(cass).
female(isla).
female(jacob).
female(marjorie).
female(cecilia).
female(abigail).

parent(joe,chris).
parent(vickie,chris).
parent(joe,kelly).
parent(vickie,kelly).
parent(joe,joejr).
parent(vickie,joejr).
parent(chris,carter).
parent(chris,jackson).
parent(shannon,carter).
parent(shannon,jackson).
parent(kin,shannon).
parent(kin,cass).
parent(cathy,shannon).
parent(cathy,cass).
parent(marjorie,cathy).
parent(cass,isla).
parent(cass,aerin).
parent(jacob,isla).
parent(jacob,aerin).
parent(joejr,joey).
parent(joejr,wesley).
parent(joejr,cecilia).
parent(joejr,abigail).
parent(andrea,joey).
parent(andrea,wesley).
parent(andrea,cecilia).
parent(andrea,abigail).

married(chris,shannon).
married(shannon,chris).
married(kin,cathy).
married(cathy,kin).
married(jacob,cass).
married(cass,jacob).
married(joe,vickie).
married(vickie,joe).
married(kelly,leanna).
married(leanna,kelly).
married(joejr,andrea).
married(andrea,joejr).



sibling(X,Y) :- parent(Z, X), parent(Z, Y), X \== Y.
father(X,Y) :- male(X), parent(X,Y).
mother(X,Y) :- female(X), parent(X,Y).

brother(X,Y) :- male(X), sibling(X,Y).
sister(X,Y) :- female(X), sibling(X,Y).

uncle(X,Y) :- brother(X, Z), parent(Z, Y).
uncle(X,Y) :- sister(X, Z), parent(Z, Y).

niece(X,Y) :- uncle(Y, X), female(X).
niece(X,Y) :- aunt(Y, X), female(X).
nephew(X,Y) :- uncle(Y, X), male(X).
nephew(X,Y) :- aunt(Y, X), male(X).

ancestor(X, Y) :- parent(X,Y).
ancestor(X, Y) :- parent(X,Z), ancestor(Z, Y).


