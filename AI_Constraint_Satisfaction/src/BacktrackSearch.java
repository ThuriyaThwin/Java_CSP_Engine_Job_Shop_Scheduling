import java.util.ArrayList;
public class BacktrackSearch{
	private ArrayList<Variable> assignments = new ArrayList<>();
	public ArrayList<Variable> Backtracking_Search(CSPInterface csp){
		if(Backtrack(assignments, csp))
			return assignments;
		return new ArrayList<>();
	}
	public boolean Backtrack(ArrayList<Variable> assignments, CSPInterface csp){	
		if(csp.assignmentIsComplete())
			return true;
		Variable var = csp.SelectUnassignedVariable();
		for(Value value: var.VarDomains())
			if(csp.isConsistent(var, value)){
				var.SetValue(value);
				assignments.add(var);
				if(Backtrack(assignments, csp))
					return true;
				else{
					var.SetValue(csp.Clear(var));
					assignments.remove(assignments.size()-1);	
				}
			}
		return false;
	}
}