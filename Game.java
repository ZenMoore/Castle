package castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
	private String admin;
	private Room currentRoom;
	private HashMap<String,Handler> handlers=new HashMap<String,Handler>();

	public void setAdmin(){ 
		Scanner in=new Scanner(System.in);
		System.out.println("游戏开始前，请输入你的名字：");
		admin=in.nextLine();
	}
	
	public String getAdmin(){
		return admin;
	}
	
	//make a game with the control handler
	public Game() {
		handlers.put("Go", new HandlerGo(this));
		handlers.put("Attack",new HandlerAttack(this));
		handlers.put("Defense",new HandlerDefense(this));
		handlers.put("See",new HandlerSee(this));
		setAdmin();
		createRooms();
	}
	
	//print welcome and comment.
	public  void welcome(){
		System.out.println("欢迎来到城堡！");
		System.out.println("这是一个超级变态的游戏。");
		System.out.println("输入 Go(空格)(房间名) 进入。");
		System.out.println("输入 Attack(空格)(怪物名) 进攻。");
		System.out.println("输入 Defense(空格)(怪物名) 防守。");
		System.out.println("输入 See 查看标语。");
		System.out.println("如果你不按格式写得话，会一各种理由死掉，就是结束程序，不要问我为什额。");
		System.out.println("对了，为了方便你的输入，怪物名是这样的:(小写英文字母)(数字)(小写英文字母)");
		System.out.println("还有就是，Door就是有点儿奇怪的任意门。");
		System.out.println("祝你好孕！");
	}
	
	//create rooms of this game.
	
public void createRooms(){
		Room outside,yiA,yiB,yiC,yiD,erE,erF,erG,dadianI,sanH,sanJ,sanK,out;
		outside=new Room("外面",admin+",这是个灭绝的时代，黄沙满天，你的师傅翁恺告诉你，要想获得性福，必须到达城堡的另一边",5);
		yiA=new Room("1A",null,0);	yiB=new Room("1B",admin+",这里有通关秘籍qq群475927178",1);yiC=new Room("1C",null,2);yiD=new Room("1D",null,3);
		erE=new Room("2E",null,4);erF=new Room("2F","To Die",12);erG=new Room("2G",null,10);
		sanH=new Room("3H",null,11);sanJ=new Room("3J",null,8);sanK=new Room("3K",admin+",这里有通关秘籍qq群475927178",9);
		dadianI=new Room("Palace I","To Die",6);
		out=new Room("城堡外","你发现，这里仍然是个灭绝的时代，黄沙满天，您的师傅翁恺告诉你，我逗你玩的！ps.这万恶的讨论区竟然不能传附件！",7);
		outside.setExit("1A",yiA);outside.setExit("1B",yiB);outside.setExit("1C",yiC);outside.setExit("1D",yiD);
		yiA.setExit("up",erE);yiA.setExit("down",outside);
		yiB.setExit("right",yiC);yiB.setExit("down",outside );
		yiC.setExit("up", erG);yiC.setExit("right",yiD);yiC.setExit("down",outside);yiC.setExit("left",yiB);
		yiD.setExit("left",yiC);yiD.setExit("down",outside);
		erE.setExit("down",yiA);erE.setExit("right",erF);
		erF.setExit("right",erG);erF.setExit("left",erE);
		erG.setExit("left",erF);erG.setExit("up",sanK);
		sanH.setExit("right",sanJ);
		sanJ.setExit("right",sanK);sanJ.setExit("left",sanH);
		sanK.setExit("left",sanJ);sanK.setExit("down",erG);sanK.setExit("right",dadianI);
		dadianI.setExit("out",out);
		yiA.setDevil("a1a",new Devila(this));
		yiB.setDevil("a1b",new Devila(this));yiB.setDevil("a2b",new Devila(this));
		yiC.setDevil("a1c",new Devila(this));
		erE.setDevil("b1e",new Devilb(this));
		erF.setDevil("a1f",new Devila(this));erF.setDevil("b1f",new Devilb(this));
		erG.setDevil("b1g",new Devilb(this));
		sanH.setDevil("b1h",new Devilb(this));sanH.setDevil("b2h",new Devilb(this));
		sanJ.setDevil("b1j",new Devilb(this));sanJ.setDevil("c1j",new Devilc(this));
		sanK.setDevil("c1k",new Devilc(this));
		dadianI.setDevil("a1i", new Devila(this));dadianI.setDevil("b1i", new Devilb(this));dadianI.setDevil("b2i", new Devilb(this));
		dadianI.setDevil("b3i", new Devilb(this));dadianI.setDevil("c1i",new Devilc(this));dadianI.setDevil("e1i", new Devilc(this));
		yiD.setDoor();yiB.setDoor();erE.setDoor();sanH.setDoor();dadianI.setDoor();
		currentRoom=outside;
//		doors.put(0,outside);doors.put(1,yiA);doors.put(2,yiB);doors.put(3,yiC);doors.put(4,yiD);doors.put(5,erE);doors.put(6,erF);doors.put(7,erG);
//		doors.put(8,sanH);doors.put(9,sanJ);doors.put(10,sanK);doors.put(11,dadianI);doors.put(12,out);
		}

	//show the exits that you can go to.
	public void showExit(){
		if(currentRoom.getExits().isEmpty()){
			System.out.println("加qq群475927178");
			System.out.println("再见了，你终于成功了！");
			System.exit(-1);
		}
		System.out.print("你可以去....");
		System.out.println(currentRoom.getExitDesc());
	}
	
	public void showDevil(){
		int n=(int)(Math.random()*5);
		switch(n){
		case 0:System.out.println("突然刮起一阵狂风，跳出来一只妖精！");break;
		case 1:System.out.println("忽然刮起一阵黑风，蹦出来一只妖精！");break;
		case 2:System.out.println("猛然刮起一阵乱风，竟出来一只妖精！");break;
		case 3:System.out.println("悄然间 在你的身后，一只妖精向你微笑~~^v^");break;
		case 4:System.out.println("由于开发者今天心情不怎么好，你碰见一只膀大腰粗、腿毛爆长的女妖精！");break;
		}
		System.out.println(currentRoom.getDevilDesc());
	}
	//enter in a room
	public void goRoom(String word){
		Room nextRoom=currentRoom.getExit(word);
		if(nextRoom==null){
			System.out.println("你撞墙而死！");
			System.exit(-1);
		}else{
			currentRoom=nextRoom;
		}
	}
	
	public void goDoor(int number){
		Room nextRoom=currentRoom.getdoors().get(number);
		currentRoom=nextRoom;
	}
	
	public void against(String ob){
		Scanner in=new Scanner(System.in);
		System.out.println("输入你的攻击技能吧(数字啊)!  1->直拳 2->摆拳 3->勾拳 4->鞭腿 5->广场舞");
		int number=in.nextInt();
		Devils currentDevil=currentRoom.getDevils(ob);
		currentDevil.Match(number);
	}
	//begin playing 
	public void play(){
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.println("你在......好像是在"+currentRoom.showDesc());
			if(currentRoom.haveSign()){
				System.out.println("这里有一块标志牌，你确定要看吗？要看的话在下面写：“See ”，不看的话在下面写“不要~~”");
				String yes=in.nextLine();
				yes=yes.trim();
				if(yes.equals("See")){
					Handler handler=handlers.get("See");
					handler.doCmd(currentRoom.getSign());
				}else if(yes.equals("不要~~")){
					System.out.println("这个标语提示的信息好像还很重要呢？就这么不看了，好吧，走就走了，不看也就不看了。");
				}else{
					System.out.println("呔！谁允许你不按格式回答了，谁允许你在标语上乱涂乱画了，剥夺你的政治权利，你，死了！");
					System.exit(-1);
				}
			}
			for(int i=0;currentRoom.showDevils();i++){
					showDevil();
					String line=in.nextLine();
					String[] words=	line.split("\\s+");
					if(words[0].equals("Attack")||words[0].equals("Defense")){
						Handler handler=handlers.get(words[0]);
						if(words.length==2)
							handler.doCmd(words[1]);
						else{
							System.out.println("你自攻而死，亦自受而死！");
							System.exit(-1);
						}			
						if(i==currentRoom.showDevilNum()||i==currentRoom.showDevilNum()-1) break;
					}else{
						System.out.println("其实，开发者可能告诉过你这里应该输入什么了...你这样输入的意思是：我是奥特曼！");
						System.out.println("你死了！");
						System.exit(-1);
					}
			}
			showExit();
			String line=in.nextLine();
			String[] words=	line.split("\\s+");
			if(words[0].equals("Go")){
				Handler handler=handlers.get(words[0]);
				if(handler!=null){
					if(words.length==2)
						handler.doCmd(words[1]);
					else{
						System.out.println("你撞墙而死！");
						System.exit(-1);
					}
				}else{
					System.out.println("由于你的不正常行为，你死了！");
					System.exit(-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Game game=new Game();
		game.welcome();
		game.play();
		in.close();
	
	}

}
