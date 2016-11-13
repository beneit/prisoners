public class Court{
	private Player[] player;
	private double[][] genInfo;
	private int[][] allGens;
	private String[] playerInfo;
	private int totalPlayer = 0;
	private int temptation = 1;
	private int reward = 2;
	private int punishment = 4;
	private int suckers = 6;
	
	public Court(int[][] playernew, double[][] genInfo){
		//PlayerArray check and init
		for (int i=0;i<playernew.length;i++)
			totalPlayer += playernew[i][0];
		player = new Player[totalPlayer];
		playerInfo = new String[playernew.length];
		int total = 0;
		for (int i = 0; i<playernew.length;i++){
			addPlayer(playernew[i][1],playernew[i][0],total);
			total+=playernew[i][0];
			playerInfo[i]=player[total-1].getaClass();
		}
		if (total%2==1){
			System.out.println("Choose even Number of player!");
			System.exit(0);
		}
		
		//genInfo check and init
		this.genInfo=genInfo;
		double gen0=0;
		double gen1=0;
		for (int i=0;i<genInfo.length;i++){
			gen0 += genInfo[i][0];
			gen1 += genInfo[i][0]*genInfo[i][1];
			if (!((int)(totalPlayer*genInfo[i][0])==(totalPlayer*genInfo[i][0]))){
				System.out.println("Bad Generation. Could not generate integer for next Generation");
				System.exit(0);
			}
		}
		if (gen0!=1 || gen1!=1){
			System.out.println("Bad Generation. Insert 1/1 in sum/sum of product!");
			System.exit(0);
		}
		
		
		// Construktor Info
		System.out.println("Spieler insgesamt: "+totalPlayer);
	}
	public Court(int[][] playernew, double[][] genInfo, int temptation, int reward, int punishment, int suckers){
		this(playernew,genInfo);
		this.temptation = temptation;
		this.reward = reward;
		this.punishment = punishment;
		this.suckers = suckers;
	}
	public int getTemptation(){
		return temptation;}
	public int getReward(){
		return reward;}
	public int getPunishment(){
		return punishment;}
	public int getSuckers(){
		return suckers;}
	public void addPlayer(int strat,int n, int total){
		for (int i = 0; i<n ; i++)
			switch(strat){
				case 0:
					player[total+i] = new Coop(); break;
				case 1:
					player[total+i] = new Defector(); break;
				case 2:
					player[total+i] = new TitForTat(); break;
				case 3:
					player[total+i] = new Misstrust(); break;
				case 4:
					player[total+i] = new Spite(); break;
				case 5:
					player[total+i] = new Punisher(); break;
				case 6:
					player[total+i] = new Pavlov(); break;
				case 7:
					player[total+i] = new Gradual(); break;
				case 8:
					player[total+i] = new Prober(); break;
				case 9:
					player[total+i] = new MasterAndServant(); break;
				case 10:
					player[total+i] = new Random(); break;
				case 11:
					player[total+i] = new PerKind(); break;
				case 12:
					player[total+i] = new PerNasty(); break;
				case 13:
					player[total+i] = new GoByMajority(); break;
				case 14:
					player[total+i] = new TitForTwoTat(); break;
				case 15:
					player[total+i] = new MasterAndServantTFT(); break;
				case 16:
					player[total+i] = new PScanner(); break;
					
				default:
					System.out.println("bad strategy argument...");
					System.exit(0);
			}
	}	
	public void shufflePlayer(){
		Player tmp;
		int rand;
	//	Random r = new Random();
		for(int i =0; i < player.length; i++){
	//		rand = r.nextInt(player.length);
			rand = (int)(Math.random()*player.length);
			tmp = player[i]; 
			player[i] = player[rand]; 
			player[rand] =tmp;
		}
	}
	
	
	
	public void playRounds(int G){
		boolean turn1=true;
		boolean turn2=false;
		boolean turntemp;
		for (int j = 0; j<totalPlayer/2;j++)
			for (int i = 1;i<=G;i++){
				turntemp=turn1;
				turn1 = player[j].play(i,turn2);
				turn2 = player[totalPlayer-j-1].play(i,turntemp);
				if (turn1)
					if (turn2){
						player[j].setPenalty(punishment);
						player[totalPlayer-j-1].setPenalty(punishment);
					}
					else{
						player[j].setPenalty(temptation);
						player[totalPlayer-j-1].setPenalty(suckers);
					}
				else
					if (turn2){
						player[j].setPenalty(suckers);
						player[totalPlayer-j-1].setPenalty(temptation);
					}
					else{
						player[j].setPenalty(reward);
						player[totalPlayer-j-1].setPenalty(reward);
					}
			}
	}
	
	public void arrangePlayer(){
		quicksort(0,player.length-1);
	}
	public void quicksort(int left, int right){
		int div;
		if (left<right){
			div = divide(left,right);
			quicksort(left, div);
			quicksort(div+1,right);
		}
	}
	public int divide(int left, int right){
		int i = left;
		int j = right-1;
		Player pivot = player[right];
		Player temp;
		while (i < j){
			while ((player[i].getPenalty()<=pivot.getPenalty()) && (i < right))
				i++;
			while ((player[j].getPenalty()>=pivot.getPenalty()) && (j > left))
				j--;
			if (i<j){
				temp=player[i];
				player[i]=player[j];
				player[j]=temp;
			}
		}
		if (player[i].getPenalty() > pivot.getPenalty()){
			temp=player[i];
			player[i]=player[right];
			player[right]=temp;
		}
		return j;
	}
	
	public void resetPlayersPen(){
		for (Player tplayer: player)
			tplayer.resetPenalty();
	}
	
	public void sortNextGen(){
		int total = 0;
		int genAdder = 0;
		Player[] tempPlayer = new Player[totalPlayer];
		for (int i = 0;i<genInfo.length;i++){
			for (int j = genAdder;j<genAdder+(int)(genInfo[i][0]*totalPlayer);j++){
				for (int k = 0;k<(int)(genInfo[i][1]);k++)
					tempPlayer[total+k]= player[j].getNewPlayerOfType();
				total+=genInfo[i][1];
			}
			genAdder += (int)(genInfo[i][0]*totalPlayer);
		}
		player = tempPlayer;
		
	}
	public void playGens(int gens, int rounds){
		allGens = new int[playerInfo.length][gens];
		for (int i = 0;i<gens;i++){
			countPlayer(i);
			shufflePlayer();
			//resetPlayersPen();
			playRounds(rounds);
			//arrangePlayer();
			java.util.Arrays.sort(player);
			if (i < gens-1)sortNextGen();
		}
		//arrangePlayer();
	}
	public void countPlayer(int played){
		boolean b;
		int n;
		for (Player playerCh : player){
			b=true;
			n=-1;
			while (b){
				n++;
				if (playerCh.getaClass().equals(playerInfo[n]))
					b=false;
			}
			allGens[n][played]+=1;
		}
	/*
		java.util.HashMap zuordnung = new java.util.HashMap();
		int genAdder = 0;
		int total = 0;
		for(int i = 0;i<;i++)
			zuordnung.put(playerInfo[i], i);
        for (int i = 0;i<genInfo.length;i++){
			for (int j = genAdder;j<genAdder+(int)(genInfo[i][0]*totalPlayer);j++){
				for (int k = 0;k<(int)(genInfo[i][1]);k++)
					switch(player.getClassAsInt)
				total+=genInfo[i][1];
			}
			genAdder += (int)(genInfo[i][0]*totalPlayer);
		}
		if (zuordnung.containsKey(meineZahl)) {
		System.out.println(zuordnung.get(meineZahl).toString());
		} else {
		System.out.println("-1");
		}*/
	}
	public void printPlayer(){
		for (int i=0;i<totalPlayer;i++)
			System.out.println("Spieler "+i+" "+player[i].getaClass()+": "+player[i].getPenalty());
	}
	public void printGens(int n,int m){
		for (int j=n;j<m;j++){
			for (int i=0;i<playerInfo.length;i++)
				System.out.println(j+". Gen, "+playerInfo[i]+": "+allGens[i][j]);
			System.out.println("");
		}
	}		
}