import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day1 {
    public static void main(String args[]){
        // problem 1
        int total = 0;
        try {
			File f = new File("./day1/input.txt");
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String data = s.nextLine();
                for(int i =0;i<data.length();i++){
                    data.charAt(i);
                }
                // problem 2 onel iner
                data = data.replaceAll(("(one)"), "one1one");
                data = data.replaceAll(("(two)"), "two2two");
                data = data.replaceAll(("(three)"), "three3three");
                data = data.replaceAll(("(four)"), "four4four");
                data = data.replaceAll(("(five)"), "five5five");
                data = data.replaceAll(("(six)"), "six6six");
                data = data.replaceAll(("(seven)"), "seven7seven");
                data = data.replaceAll(("(eight)"), "eight8eight");
                data = data.replaceAll(("(nine)"), "nine9nine");
                data = data.replaceAll(("[a-z]"), "");
                int next = (data.charAt(0)-48)*10 + (data.charAt(data.length()-1)-48);
                System.out.println(data);
                System.out.println(next);
                total += next;
                
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("couldnt load file.\n");
			e.printStackTrace();
		}
        System.out.println(total);
    }
}