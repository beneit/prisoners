public class PerKind extends Player{	
	public boolean play(int round, boolean turn){
		return (round%3==0);
	}
	public Player PerKind(){
		return new Defector();
	}
}