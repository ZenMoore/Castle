package castle;

public class HandlerAttack  extends Handler{
	
	public HandlerAttack(Game game){
		super(game);
	}
	
	@Override
	public void doCmd(String str){
		game.against(str);
	}


}
