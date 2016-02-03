package castle;
import java.util.HashMap;
public class Room {
	private String description;
	private HashMap<String,Room> exits=new HashMap<String,Room>();
	private HashMap<String,Devils> devils=new HashMap<String,Devils>();
	public static HashMap<Integer,Room> doors=new HashMap<Integer,Room>();
	private String sign;
	private boolean haveDoor=false;
	
	public Room(String description,String sign,int n) {
		this.description = description;
		this.sign = sign;
		doors.put(n,this);
	}
	
	public void setExit(String desc,Room room){
		exits.put(desc,room);
	}
	
	public  HashMap<Integer,Room> getdoors(){
		return Room.doors;
	}

	public HashMap<String,Room> getExits(){
		return exits;
	}
	
	public void setDevil(String name,Devils devil){
		devils.put(name,devil);
	}
	
	public void setDoor(){
		haveDoor=true;
	}
	
	public String getExitDesc(){
		StringBuilder sb=new StringBuilder();
		for(String dir: exits.keySet()){
			sb.append(dir);
			sb.append("  ");
		}
		if(this.haveDoor){
			sb.append("Door");
		}
		return sb.toString();
	}

	public String getDevilDesc(){
		StringBuilder sbr=new StringBuilder();
		for(String der: devils.keySet()){
			if(devils.get(der).showBe()){
				sbr.append(der+" <---(怪物名)   ");
				sbr.append(devils.get(der).showName());
				sbr.append("\n");
			}
		}
		return sbr.toString();
	}
	
	public Room getExit(String direction){
		return exits.get(direction);
	}

	public Devils getDevils(String ob){ 
		return devils.get(ob);
	}
	
	public boolean showDevils(){
		boolean ar=false;
		if(!devils.isEmpty()){
			for(String der: devils.keySet()){
				if(devils.get(der).showBe()){
					ar=true;
				}
			}
		}
		return ar;
	}

	public boolean haveSign(){ 
		boolean have=true;
		if(sign==null){
			have=false;
		}
		return have;
	}
	
	public String getSign(){ 
		return sign;
	}
	
	public String showDesc(){
		return description;
	}
	
	public int showDevilNum(){
		return devils.size();
	}
	

}
