public class MasterAndServantTFT extends Player{
	private boolean whoswho;
	private boolean imwithme=true;
	public boolean play(int round, boolean turn){
		if (!imwithme)
			return turn;
		switch(round){
			case 1: whoswho = turn; return true;
			case 2: imwithme = turn; return false;
			case 3: imwithme = !turn; return false;
			case 4: imwithme = !turn; return true;
			case 5: imwithme = turn; return false;
			case 6: imwithme = !turn; return true;
			case 7: imwithme = turn; return true;
			case 8: imwithme = turn; break;
			
			default:
				return whoswho;
		}
		return whoswho;
	}
	public Player getNewPlayerOfType(){
		if (Math.random()>0.99)
			return new MasterAndServant();
		else
			return new MasterAndServantTFT();
	}
}