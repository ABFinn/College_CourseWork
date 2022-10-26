puts "gimme a file name"

fname = gets.chomp

@instructions = File.new(fname,"r")