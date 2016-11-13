public class Prober extends Player{
	private boolean mem1;
	private boolean mem2;
	public boolean play(int round, boolean turn){
		if (round == 1)
			return false;
		else if (round == 2)
			return true;
		else if (round == 3){
			mem1 = turn;
			return true;
		}
		else if (round == 4)
			mem2 = turn;
		if (!mem1 && !mem2)
			return true;
		return turn;
	}
	public Player getNewPlayerOfType(){
		return new Prober();
	}
}
		