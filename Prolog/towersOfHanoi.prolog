% Move 1 Disk from Start to Destination. 
% Don't care about the empty so it's anonymous. 

move(1,Start,Dest,_) :-  
    write('Move top disk from '), 
    write(Start), 
    write(' to '), 
    write(Dest), 
    nl.

% N is the number of disks to move
% Start is where the disks are
% Dest is where you want to move the disks
% Empty is the 'working' slot (where you can move something temporarily)
% Remember, these are the values for each instance/call to this predicate

move(N,Start,Dest,Empty) :- 
    N>1, 
    M is N-1, 
    move(M,Start,Empty,Dest), 
    move(1,Start,Dest,_), 
    move(M,Empty,Dest,Start).  