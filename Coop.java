public class Coop extends Player{
	public boolean play(int round, boolean turn){
		return false;
	}
	public Player getNewPlayerOfType(){
		return new Coop();
	}
}
		