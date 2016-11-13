public class Player implements Comparable{
	private int penalty = 0;

	public void resetPenalty(){
		penalty = 0;
	}
	public void setPenalty(int npenalty){
		int altep = penalty;
		penalty+=npenalty;
//		System.out.println(altep +"+"+npenalty+"="+penalty);
	}
	public int getPenalty(){
		return penalty;
	}
	
	public boolean play(int round, boolean turn){
		return true;
	}
	
	public void printClass() {
		System.out.println(this.getClass().getName());
	}
	
	public String getaClass() {
		return this.getClass().getName();
	}
	
	public Player getNewPlayerOfType(){
		return this;
	}
	
	public int compareTo(Object player) throws ClassCastException{
		return (this.penalty - ((Player)player).getPenalty());
	}
//	public int compareTo(Player player) throws ClassCastException{
//		return (this.penalty - player.getPenalty());
//	}
}