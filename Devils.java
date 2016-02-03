package castle;
import java.util.HashMap;
public class Devils {
	protected String name;
	protected int attack;
	protected boolean isFail;
	protected Game game;
	
	public boolean showBe(){ 
		return !isFail;
	}
	
	public String showName(){ 
		return name;
	}
	
	//make a devil
	public Devils(Game game) {
		isFail=false;
		this.game=game;
	}
	
	//begin matching 
	public void Match(int number){
		if(number!=1&&number!=2&&number!=3&&number!=4&&number!=5){
			System.out.println("由于你使用了一个你不会的技能，你吐血而死！");
			System.exit(-1);
		}
		if(number>=attack){
			isFail=true;
			System.out.println("啊，难道你就是传说中的....谁来着，开发者让我临死前告诉你，加qq群475927178");
		}else{
			System.out.println("开发者：哈哈哈哈，你被打死了~死了~了，重新开始把！笑死俺家了！");
			System.exit(-1);
		}
	}
	
	


}
