

class CPU 
  #create CPU with four registers, instruction type variable, 
  #and array representing "memory" (of size 100) 
  def initialize
    @CPU = Array.new(4)
    @InstructionType = 0
    @Memory = Array.new(20)
    @lineArray = Array.new(4)
  end
  
  
  def fetch
	#get next instruction
  @line = @instructions.gets
  #puts @line
	#if not nil 
	if @line	
		#process instruction
    @lineArray = @line.split

		return true
	else
		#since instruction was nil, no more lines to process
		#so return false
		return false
	end	
  end
  
  def decode
  	if @lineArray[0] == "MEM"
      @InstructionType = "MEM"
    elsif @lineArray[0] == "LOAD"
      @InstructionType = "LOAD"
    elsif @lineArray[0] == "STO"
      @InstructionType = "STO"
    elsif @lineArray[0] == "ADD"
      @InstructionType = "ADD"
    elsif @lineArray[0] == "SUB"
      @InstructionType = "SUB"
    elsif @lineArray[0] == "MUL"
      @InstructionType = "MUL"
    elsif @lineArray[0] == "DIV"
      @InstructionType = "DIV"  
    elsif @lineArray[0] == "OUT"
      @InstructionType = "OUT"
    else 
      @InstructionType = "IN"
    end

    #figure out what type of instruction it is
  	#and set instructionType variable

  	return false
  end
  
=begin

	INSTRUCTION TYPES
==============================================================================================================================
	MEM A B     :  Load value of A at memory location B. There are only 100 'slots' of memory. A is a hard-coded "constant"
	LOAD A B    :  Load into register A the value at memory address B. There are only four registers.
	STO A B     :  Store value of register A to memory location B
	ADD A B C   :  Add contents of register A and register B, storing output to register C
	SUB A B C   :  Subtract contents of register B from contents of register A, storing output to register C
	MUL A B C   :  Multiply contents of register A and register B, storing output to register C
	DIV A B C   :  Divide contents of register A by contents of register B, storing output to register C
	OUT A       :  Output content of register A to standard out (screen)
	IN A        :  Read input from standard in (keyboard) and store contents 

=end
  
  def execute
  	#depending on instruction type, execute appropriate behavior
    if @InstructionType == "MEM"
      location = @lineArray[2].to_i
      @Memory[location] = @lineArray[1].to_i
    elsif @InstructionType == "LOAD"
      location = @lineArray[1].to_i
      location1 = @lineArray[2].to_i
      @CPU[location] = @Memory[location1]
    elsif @InstructionType == "STO"
      location = @lineArray[1].to_i
      location1 = @lineArray[2].to_i
      @Memory[location1] = @CPU[location]
    elsif @InstructionType == "ADD"
      value1 = @lineArray[1].to_i
      value2 = @lineArray[2].to_i
      output = @lineArray[3].to_i
      @CPU[output] = @CPU[value1].to_i + @CPU[value2].to_i    
    elsif @InstructionType == "SUB"
      value1 = @lineArray[1].to_i
      value2 = @lineArray[2].to_i
      output = @lineArray[3].to_i
      @CPU[output] = @CPU[value1].to_i - @CPU[value2].to_i
    elsif @InstructionType == "MUL"
      value1 = @lineArray[1].to_i
      value2 = @lineArray[2].to_i
      output = @lineArray[3].to_i
      @CPU[output] = @CPU[value1].to_i * @CPU[value2].to_i
    elsif @InstructionType == "DIV"
      value1 = @lineArray[1].to_i
      value2 = @lineArray[2].to_i
      output = @lineArray[3].to_i
      @CPU[output] = @CPU[value1].to_i / @CPU[value2].to_i
    elsif @InstructionType == "OUT"
      print "OUT:", @lineArray[1], "\n"
    elsif @InstructionType == "IN"
      puts "gimme a number"
      value = @lineArray[1].to_i
      @CPU[value] = gets.to_i


    end

  end
  


  def output
    pp @CPU
    pp @Memory
    puts input
  end


  
  def input

  end
  
  
  def runProgram
	#get file name
  puts "gimme a file name"

  fname = gets.chomp
	#create @instructions instance variable as a file pointer (already done)
	#note that you can use the same gets method on a file 
  	@instructions = File.new(fname,"r")
  	
	#while fetch returns true
	puts "==Program begin=="
	
  	while fetch
  		#decode instruction
  		decode
  		#execute instruction
      execute

  	end
    output
  	
  	puts "==Program complete=="
  end
  
end

computer = CPU.new
computer.runProgram


