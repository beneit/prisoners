public class Pavlov extends Player{
	private boolean tempturn=false;
	public boolean play(int round, boolean turn){
		if (round == 1)
			return false;
		boolean oturn = tempturn;
		tempturn = !(oturn==turn);
		return tempturn;
	}
	public Player getNewPlayerOfType(){
		return new Pavlov();
	}
}
		