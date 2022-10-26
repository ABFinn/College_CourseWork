
borders(maine,newhampshire).
borders(newhampshire,massachusetts).
borders(newhampshire,vermont).
borders(vermont,newyork).
borders(vermont,massachusetts).

borders(A,B) :- borders(B,A).

capitalOf(augusta,maine).
capitalOf(concord,newhampshire).
capitalOf(montpelier,vermont).
capitalOf(boston,massachusetts).
capitalOf(albany,newyork).

navigate(A,B,Solution) :- borders(A,B), Solution is [A|B].
navigate(A,B) :- borders(A,Z), navigate(Z,B).

