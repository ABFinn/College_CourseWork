sub isPrime{
	$factor = 3;
	if ($_[0] == 2){
		return true;
	}
	if ($_[0] % 2 == 0){
		return false;
	}

	while($factor <= sqrt($_[0])){
		if($_[0] % $factor == 0){
			return false;
		}
		$factor += 2;
	}
	return true;
}
sub Euler1 {
	my $sum = 0;
	my $i = 0;
	while($i<$_[0]){
		if($i % 3 == 0 or $i % 5 == 0){
			$sum += $i;
		}
		$i++;
	}
	return $sum;
}

=pod
print "What is the limit for Euler 1? ";
$ubound = int(<STDIN>);
$ans = euler2($ubound);
=cut

sub Euler2{
	my $lim = $_[0];
	my $answer = 0;
	my $fib1 = 1;
	my $fib2 = 2;

	while($fib2 <= $lim){
		if($fib2 % 2 ==0){
			$answer += $fib2;
		}
		$fib2 = $fib2 + $fib1;
		$fib1 = $fib2 - $fib1;
	}
	return $answer

}

print "Answer to Euler1 is: " . Euler1(1000) . "\n";
print "Answer to Euler2 is: " . Euler2(4000000) . "\n";
print isPrime(53) . "\n";