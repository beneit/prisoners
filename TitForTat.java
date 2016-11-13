public class TitForTat extends Player{
	public boolean play(int round, boolean turn){
		if (round == 1)
			return false;
		else
			return turn;
	}
	public Player getNewPlayerOfType(){
		return new TitForTat();
	}
}
		