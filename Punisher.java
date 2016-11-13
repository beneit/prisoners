public class Punisher extends Player{
	private boolean oturn = false;
	private int dif = 0;
	public boolean play(int round, boolean turn){
		if (round==1)
			return false;
		if (turn && !oturn)
			dif = dif+6-1;
		if (dif <= 0){
			oturn = false;
			return false;
		}
		else if (!turn)
			dif = dif-6+1;
		if (dif <= 0){
			oturn = false;
			return false;
		}
		oturn = true;
		return true;
	}
	public Player getNewPlayerOfType(){
		return new Punisher();
	}
}
		