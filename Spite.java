public class Spite extends Player{
	private boolean mem = false;
	public boolean play(int round, boolean turn){
		if (mem)
			return mem;
		else if (turn && round!=1)
			mem = true;
		return mem;
	}
	public Player getNewPlayerOfType(){
		return new Spite();
	}
}
		