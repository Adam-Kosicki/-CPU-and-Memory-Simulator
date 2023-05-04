import java.util.Scanner;
import java.io.*;

public class Memory {
    private static Scanner input_file;
    private static Scanner check;
    private static Scanner instr = new Scanner(System.in);
    private static String current;
    private static String input;
    private static int[] entries = new int[2000];      // Array to hold program instructions
    private static int addr = 0;                       // Address to be read/written
    private static int counter = 0;                    // Counter to keep track of the current instruction
    private static Memory memory1 = new Memory();      // Memory object created


    public static int read(int id){                    // Method to read a value from a memory address
        return entries[id];
    }

    public static void write(int id, String val){      // Method to write a value to a memory address
        entries[id] = Integer.parseInt(val.replaceFirst(".*?(\\d+).*", "$1")); // Parses integer value from string using regex
    }

    public void loop(String[] args){                   // Main loop for reading instructions
        while(instr.hasNextLine()){                     // Continues to read input until user types "exit"
            current = instr.nextLine();
            if(current.matches("exit")){
                instr.close();                          // Closes scanner before exiting
                System.exit(-1);
            }
            if(current.isEmpty()){                     // If input is empty, continue
                continue;
            }
            if(current.matches("(\\d+) (\\d+).*")){     // If input is in format "address value", writes value to memory
                check = new Scanner(current);
                addr = Integer.parseInt(check.next());
                write(addr, check.next());
                check.close();
            }
            else{                                       // If input is just an address, reads value from memory and prints it
                addr = Integer.parseInt(current);
                System.out.println(read(addr));
            }
        }
    }

    public static void main(String[] args) {
        try{
            counter = 0;
            input_file = new Scanner(new File(args[0]));  // Reads input file specified in command line argument
            while(counter <= 1999){                       // Initializes all memory addresses to 0
                write(counter++, "0");
            }
            counter = 0;
            while(input_file.hasNextLine()){              // Reads every input within program
                input = input_file.nextLine();
                if(input.matches("(\\.)(\\d+).*")){       // If input is in format ".address", sets the counter to the value of the address
                    counter = Integer.parseInt(input.replaceFirst(".*?(\\d+).*", "$1"));
                }
                else if(input.matches(".*?(\\d+).*")) {   // If input is an instruction or a value, writes it to the current memory address and increments counter
                    write(counter++, input);
                }
            }
        }catch (Exception e){
            System.out.println(e + "File does not exist...");   // Catches exception if file is not found
            System.exit(0);
        }
        memory1.loop(args);                                 // Enters main loop for reading instructions
        instr.close();
    }
}
