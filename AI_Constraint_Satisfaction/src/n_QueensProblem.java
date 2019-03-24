import java.util.ArrayList;
import java.util.Arrays;
public class n_QueensProblem implements CSPInterface{
	private ArrayList<Variable> variables = new ArrayList<>();
	public n_QueensProblem(int n) {
		ArrayList<Value> varDomains = new ArrayList<>();
		for(int j = 0; j < n; j++)
			varDomains.add(new Value(("row "+(j+1)), j));
		for(int i = 0; i < n; i++)
			variables.add(new Variable(""+i, null, varDomains, new Value[n]));
	}
	@Override
	public boolean isConsistent(Variable var, Value val) {
		int m = Integer.parseInt(var.Name());
		int n = (int) val.Object();
        for (int i=0; i<m; i++)
            if (((Value[]) variables.get(i).GetObject())[n] != null) 
                return false;
        for (int i=m, j=n; i>=0 && j>=0; i--, j--) 
            if (((Value[]) variables.get(i).GetObject())[j]  != null) 
                return false;
        for (int i=m, j=n; i>=0 && j<variables.size(); i--, j++) 
            if (((Value[]) variables.get(i).GetObject())[j]  != null)
            	return false;
        ((Value[]) variables.get(m).GetObject())[n] = val;
        return true;
	}
	@Override
	public boolean assignmentIsComplete() {
		for(Variable v : variables)
			if(v.GetValue() == null)
				return false;
		return true;
	}
	@Override
	public Variable SelectUnassignedVariable() {
		for(Variable v : variables)
			if(v.GetValue() == null)
				return v;
		return null;
	}
	@Override
	public Value Clear(Variable var) {
		Arrays.fill(((Value[])variables.get(Integer.parseInt(var.Name())).GetObject()), null);
		return null;
	}
}