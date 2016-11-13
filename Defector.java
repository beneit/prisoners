public class Defector extends Player{
	public boolean play(int round, boolean turn){
		return true;
	}
	public Player getNewPlayerOfType(){
		return new Defector();
	}
}