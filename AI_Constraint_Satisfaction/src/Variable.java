import java.util.ArrayList;
public class Variable {	
	private String Name;
	private Object Ob;
	private Value value;
	private ArrayList<Value> varDomains = new ArrayList<>();
	public Variable(String Name, Value value, ArrayList<Value> varDomains, Object Ob){
		this.Name = Name;
		this.value = value;
		this.varDomains = varDomains;
		this.Ob = Ob;
	}
	public String Name(){
		return Name;
	}
	public Object GetObject(){
		return Ob;
	}
	public void SetObject(Object Ob) {
		this.Ob = Ob; 
	}
	public void SetValue(Value value) {
		this.value = value;
	}
	public Value GetValue(){
		return value;
	}
	public ArrayList<Value> VarDomains(){
		return varDomains;
	}
}
