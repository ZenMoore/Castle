package castle;

public class HandlerDefense  extends Handler{
	
	public HandlerDefense(Game game){
		super(game);
	}

	@Override
	public void doCmd(String over){
		System.out.println("风吹枯草，你躺在血泊中，嘴里不断念叨着：为什么我的防御技能特么是抱头蹲起！");
		System.out.println("可是一切已经晚了，你死了，但是你抱着头的样子将永远留在人们的心里！");
		System.exit(-1);
	}

}
