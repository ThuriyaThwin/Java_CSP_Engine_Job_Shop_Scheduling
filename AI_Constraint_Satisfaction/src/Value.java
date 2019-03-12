public class Value {
	private String Name;
	private Object Ob;
	public Value(String Name, Object Ob){
		this.Name = Name;
		this.Ob = Ob;
	}
	public String Name(){
		return Name;
	}
	public Object Object(){
		return Ob;
	}
}