import java.util.Scanner;
import java.io.*;

public class Memory{
    private static Scanner input_file;
    private static Scanner check;
    private static Scanner instr = new Scanner(System.in);
    private static String current;
    private static String input;
    private static int[] entries = new int[2000];
    private static int addr = 0;
    private static int counter = 0;
    private static Memory memory1 = new Memory();

    public static int read(int id){                                                                              //sends values in the address to the pipe
        return entries[id];
    }

    public static void write(int id, String val){                                                               //write the value sent from pipe into the address
        entries[id] = Integer.parseInt(val.replaceFirst(".*?(\\d+).*", "$1"));                 //$1 is first captured group for REGEX
    }

    public void loop(String[] args){                                                                           //finds program within argument
        while(instr.hasNextLine()){                                                                             //looks for requests
            current = instr.nextLine();
            if(current.matches("exit")){                                                                  //exits and closes scanner if "exit"
                instr.close();
                System.exit(-1);
            }
            if(current.isEmpty()){
                continue;
            }
            if(current.matches("(\\d+) (\\d+).*")){                                                        //checks to use either read or write with REGEX
                check = new Scanner(current);
                addr = Integer.parseInt(check.next());
                write(addr, check.next());
                check.close();
            }
            else{
                addr = Integer.parseInt(current);
                System.out.println(read(addr));
            }
        }
    }

    public static void main(String[] args) {                                                                        //main method
        try{
            counter = 0;
            input_file = new Scanner(new File(args[0]));
            while(counter <= 1999){
                write(counter++, "0");
            }
            counter = 0;
            while(input_file.hasNextLine()){                                                                      //finds every input within program
                input = input_file.nextLine();
                if(input.matches("(\\.)(\\d+).*")){                                                         //looks for addresses .1000 and .500
                    counter = Integer.parseInt(input.replaceFirst(".*?(\\d+).*", "$1"));         //$1 is first captured group for REGEX
                }
                else if(input.matches(".*?(\\d+).*")) {                                                    //finds instructions and values
                    write(counter++, input);
                }
            }
        }catch (Exception e){
            System.out.println(e + "File does not exist...");                                                   //for if file isn't found
            System.exit(0);
        }
        memory1.loop(args);
        instr.close();
    }
}