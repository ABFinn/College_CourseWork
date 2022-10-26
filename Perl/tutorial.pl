use warnings;
use strict;


sub functionName {
	#arguments stored in @_
	return $_[0] + $_[1];
}

print functionName(1,2);