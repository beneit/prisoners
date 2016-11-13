public class Random extends Player{	
	public boolean play(int round, boolean turn){
		return ((int)(Math.random()*2)==1);
	}
	public Player getNewPlayerOfType(){
		return new Random();
	}
}