import java.util.Scanner;

public class PScanner extends Player{
	private Scanner scan = new Scanner(System.in);
	public boolean play(int round, boolean turn){
		if (round != 1)
			System.out.println("Your enemy played: "+turn);
		else
			System.out.println("Type in your turn!");
		String nextScan;
		while (true){
			nextScan = scan.nextLine();
			if (nextScan.equals("true") || nextScan.equals("false"))
				return nextScan.equals("true");
			else 
				System.out.println("Insert 'true' or 'false'");
		}
	}
	public Player getNewPlayerOfType(){
		return new Random();
	}
}