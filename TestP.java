public class TestP{
	public static void main(String[] args){
		int temptation = 1;
		int reward = 2;
		int punishment = 4;
		int suckers = 6;
		int playequals = 10000;
		int[][] player={{playequals,0},		//0.Coop
						{playequals,1},		//1.Defector
						{playequals,2},		//2.TitForTat
						{playequals,3},		//3.Misstrust
						{playequals,4},		//4.Spite
						{playequals,5},		//5.Punisher
						{playequals,6},		//6.Pavlov
						{playequals,7},		//7.Gradual
						{playequals,8},		//8.Prober
						{playequals,9},		//9.MasterAndServant
						{playequals,10},		//10.Random
						{playequals,11},		//11.PerKind
						{playequals,12},		//12.PerNasty
						{playequals,13},		//13.GoByMajority
						{playequals,14},		//14.TitForTwoTat
						{playequals,15},		//15.MasterAndServantTFT
						};	//PScanner
		//1. share,  2. multiplicator    -> sum(share)=1, sum(share*multiplicator)=1
		double[][] genInfo={{0.1,4},
						{0.2,2},
						{0.2,1},
						{0.5,0}
						};
		Court court = new Court(player, genInfo, temptation, reward, punishment, suckers);
		court.playGens(40,120); //generations / rounds
		court.printGens(0,40);  //print gens from () till ()
	}
}