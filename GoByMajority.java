public class GoByMajority extends Player{
	private int NTrue=0;
	public boolean play(int round, boolean turn){
		if (round==1)
			return false;
		if (turn)
			NTrue++;
		return (2*NTrue>round);
	}
	public Player getNewPlayerOfType(){
		return new GoByMajority();
	}
}