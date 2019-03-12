import java.util.ArrayList;
import java.util.Arrays;
public class AustraliaProblem implements CSP{	
	private ArrayList<Variable> variables;
	public AustraliaProblem(){
		SetUp(0);
	}
	@Override
	public void SetUp(int y){
		ArrayList<Value> varDomains = new ArrayList<>(Arrays.asList(new Value("RED","RED"),new Value("BLUE","BLUE"),new Value("GREEN","GREEN")));
		Variable WA = new Variable("WA", null, varDomains, new Object());
		Variable NT = new Variable("NT", null, varDomains, new Object());
		Variable SA = new Variable("SA", null, varDomains, new Object());
		Variable Q  = new Variable("Q", null, varDomains, new Object());
		Variable NSW= new Variable("NSW", null, varDomains, new Object());
		Variable V  = new Variable("V", null, varDomains, new Object());
		Variable T  = new Variable("T", null, varDomains, new Object());
		WA.SetObject(new Variable[]{NT,SA});
		NT.SetObject(new Variable[]{WA,Q,SA});
		SA.SetObject(new Variable[]{WA,NT,Q,NSW,V});
		Q.SetObject(new Variable[]{NT,SA,NSW});
		NSW.SetObject(new Variable[]{Q,SA,V});
		V.SetObject(new Variable[]{SA,NSW});
		T.SetObject(new Variable[0]);
		variables = new ArrayList<>(Arrays.asList(WA,NT,SA,Q,NSW,V,T));
	}
	@Override
	public boolean isConsistent(Variable var, Value val){
		Variable[] neigh = (Variable[]) var.GetObject();
		for(int i = 0; i < neigh.length; i++)
			if(neigh[i].GetValue() != null)
				if (val.Object() == neigh[i].GetValue().Object())
					return false;
		return true;
	}
	@Override
	public boolean assignmentIsComplete(){
		for(Variable v : variables)
			if(v.GetValue() == null)
				return false;
		return true;
	}
	@Override
	public Variable SelectUnassignedVariable(){
		for(Variable v : variables)
			if(v.GetValue() == null)
				return v;
		return null;
	}
	@Override
	public Value Clear(Variable var) {
		return null;
	}
}