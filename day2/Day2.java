package day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Day2 {
    public static void main(String args[]){
        // problem 1
        int sumPowers = 0;
        int sumGames = 0;
        int id = 0;
        boolean invalid = false;
        try {
			File f = new File("./day2/input.txt");
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String data = s.nextLine();
                id=Integer.parseInt(data.substring(5,data.indexOf(':')));
                String[] turn = data.substring(data.indexOf(':')).trim().replace(",", "").replace(":", "").split(";");
                int[] min = new int[3]; // 0-> red 1-> green 2->blue
                for(int i=0; i<turn.length;i++){
                    String[] dets= turn[i].trim().split(" ");

                    //p2
                    for(int j=1;j<dets.length;j+=2){
                        if((dets[j].equals("red"))){
                            if(min[0]<Integer.parseInt(dets[j-1])) min[0]= Integer.parseInt(dets[j-1]);
                        } 
                        if((dets[j].equals("green"))){
                            if(min[1]<Integer.parseInt(dets[j-1])) min[1]= Integer.parseInt(dets[j-1]);
                        } 
                        if((dets[j].equals("blue"))){
                            if(min[2]<Integer.parseInt(dets[j-1])) min[2]= Integer.parseInt(dets[j-1]);
                        } 
                    }
                    
                    //p1
                    for(int j=1;j<dets.length;j+=2){
                        if((dets[j].equals("red")) && (Integer.parseInt(dets[j-1])>12)){
                            invalid =true;
                        } 
                        if((dets[j].equals("green")) && (Integer.parseInt(dets[j-1])>13)) invalid =true;
                        if((dets[j].equals("blue")) && (Integer.parseInt(dets[j-1])>14)) invalid =true;
                    }
                    
                }
                sumPowers += (min[0]*min[1]*min[2]);
                if(!invalid) sumGames+=id;
                invalid=false;
                
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("couldnt load file.\n");
			e.printStackTrace();
		}
        System.out.println("Sum of powers: " + sumPowers);
        System.out.println("Sum of valid games: " + sumGames);
    }
}