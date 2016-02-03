package castle;

public class HandlerSee  extends Handler{
	
	public HandlerSee(Game game){
		super(game);
	}

	@Override
	public void doCmd(String str){
		if(str.equals("To Die")){
			System.out.println("只见标语这个东东突然放出一道激光！你死了！");
			System.exit(-1);
		}else{
			System.out.println("比"+game.getAdmin()+"聪明一万倍的标语君："+str);
		}
	}

}
