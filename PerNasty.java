public class PerNasty extends Player{	
	public boolean play(int round, boolean turn){
		return !(round%3==0);
	}
	public Player getNewPlayerOfType(){
		return new PerNasty();
	}
}