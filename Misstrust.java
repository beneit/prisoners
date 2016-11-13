public class Misstrust extends Player{
	public boolean play(int round, boolean turn){
		if (round == 1)
			return true;
		else
			return turn;
	}
	public Player getNewPlayerOfType(){
		return new Misstrust();
	}
}
		