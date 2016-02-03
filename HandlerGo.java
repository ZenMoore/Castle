package castle;

import java.util.Random;

public class HandlerGo  extends Handler{
	
	public HandlerGo(Game game){
		super(game);
	}
	
	@Override
	public void doCmd(String str){
		if(str.equals("Door")){
			Random random=new Random();
			int number=(int)((random.nextGaussian()+1)*13/2);
			if(number<0||number>12){
				System.out.println("任意门通向了黑洞房间，你又死了（为什么四又？？）");
				System.exit(-1);
			}
			game.goDoor(number);
		}else game.goRoom(str);
	}

	
}
