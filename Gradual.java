public class Gradual extends Player{
	private int i=0;
	private int det=0;
	public boolean play(int round, boolean turn){
		if (round==1)
			return false;
		if (turn && det==0){
			det=i+3;
			i++;
			}
		if (det==0)
			return false;
		det=det-1;
		if (det > 1)			
			return true;
		return false;
	}
	public Player getNewPlayerOfType(){
		return new Gradual();
	}
}
			
		