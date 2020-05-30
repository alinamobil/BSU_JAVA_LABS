import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Number {
    private static void FillStack(Stack stack, String string)
    {
        int i = 0;
        while(i != string.length()) {
            stack.push(string.charAt(i));
            i++;
        }
    }
    private static File CreateFile() {
        String fileName = GetString("Enter file name: ");
        File file = new File(fileName);
        try {
            file.createNewFile();
            return file;
        }
        catch (IOException ex) {
            System.out.println("Can't create file.");
            return null;
        }
    }
    private static PrintWriter CreateWriter(File file){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            return writer;
        }
        catch (IOException ex) {
            System.out.println("Can't write to file.");
            return null;
        }
    }
    private static void WriteToFile(Stack stack) {
        File file = CreateFile();
        PrintWriter writer = CreateWriter(file);
        while(!stack.empty()) {
            writer.print(stack.pop());
        }
        writer.close();
    }
    private static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
    private static String GetString(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        return string;
    }
    public static void main(String[] args) {
        String string = GetString("Enter number: ");
        if(checkString(string)){
            Stack stack = new Stack();
            FillStack(stack, string);
            try
            {
                WriteToFile(stack);
            }
            catch (EmptyStackException e)
            {
                System.out.println("Empty stack.");
            }
        }
        else{
            System.out.println("Not a number!");
        }
    }
}


