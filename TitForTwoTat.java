public class TitForTwoTat extends Player{	
	public boolean play(int round, boolean turn){
		if (round==1)
			return false;
		if (!turn)
			return false;
		else
			return ((int)(Math.random()*2)==1);
	}
	public Player getNewPlayerOfType(){
		return new TitForTwoTat();
	}
}