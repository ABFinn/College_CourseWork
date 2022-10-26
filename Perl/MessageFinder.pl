use warnings;
use strict;

#get values from cmd line (file name and message)
#store message as array of single-char strings (using split())
#open file, reading in each line and storing it in one big string
#for each periodicity
	#for each letter in message
		#build up regular expression using concat

	#match regex against file contents
	#if a match, output the period you found the match
	#else output no match at that period

my $fName = $ARGV[0];
my $stringToFind = $ARGV[1];
my $content = "";
my @stringArray = split('',$stringToFind);
my $regex = "";

open(BOOK,'<', $fName);


while(<BOOK>) {
   $content.=$_
}

$content =~ s/\W//g;

print $content."\n";
#print $stringToFind."\n";


foreach (@stringArray) {
	print "$_\n";
}
for(my $i=2;$i<25;$i++){
	$regex = "";
	foreach (@stringArray){
		$regex.=$_."."."{$i}";
	}
	print "Current Regex is:".$regex."\n";
	if($content =~ m/($regex\s*)/){
		print "$1"."\n";
	}
	else{
		print "false\n";
	}
	

}



#f.{2}e.{2}.s{2}.h{2}

