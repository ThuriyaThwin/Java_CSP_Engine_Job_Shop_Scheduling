import java.util.ArrayList;
import java.util.Arrays;
public class JobSchedulingProblem implements CSP{
	private ArrayList<Variable> variables;
	public JobSchedulingProblem() {
		SetUp(0);
	}
	@Override
	public void SetUp(int n) {
		ArrayList<Value> varDomains = new ArrayList<>(Arrays.asList(new Value("1", 1),new Value("2", 2),new Value("3", 3),new Value("4", 4),new Value("5", 5),new Value("6", 6),new Value("7", 7),new Value("8", 8),new Value("9", 9),new Value("10", 10),
				new Value("11", 11),new Value("12", 12),new Value("13", 13),new Value("14", 14),new Value("15", 15),new Value("16", 16),new Value("17", 17),new Value("18", 18),new Value("19", 19),new Value("20", 20),
				new Value("21", 21),new Value("22", 22),new Value("23", 23),new Value("24", 24),new Value("25", 25),new Value("26", 26),new Value("27", 27)));
		variables = new ArrayList<>(Arrays.asList(new Variable("AXLE F", null, varDomains, 10),
				new Variable("AXLE B", null, varDomains, 10),
				new Variable("WHEEL RF", null, varDomains, 1),
				new Variable("WHEEL LF", null, varDomains, 1),
				new Variable("WHEEL RB", null, varDomains, 1),
				new Variable("WHEEL LB", null, varDomains, 1),
				new Variable("NUTS RF", null, varDomains, 2),
				new Variable("NUTS LF", null, varDomains, 2),
				new Variable("NUTS RB", null, varDomains, 2),
				new Variable("NUTS LB", null, varDomains, 2),
				new Variable("CAP RF", null, varDomains, 1),
				new Variable("CAP LF", null, varDomains, 1),
				new Variable("CAP RB", null, varDomains, 1),
				new Variable("CAP LB", null, varDomains, 1),
				new Variable("INSPECT", null, varDomains, 3)));
	}
	@Override
	public boolean isConsistent(Variable var, Value val) {
		if(((var.Name().split(" "))[0]).equals("AXLE")) {
			if(((var.Name().split(" "))[1]).equals("F") && variables.get(1).GetValue()==null && val.Name().equals("1") || ((var.Name().split(" "))[1]).equals("F") && variables.get(1).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(1).GetValue().Name())+(int)variables.get(1).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("B") && variables.get(0).GetValue()==null && val.Name().equals("1") || ((var.Name().split(" "))[1]).equals("B") && variables.get(0).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(0).GetValue().Name())+(int)variables.get(0).GetObject()))
				return true;
		}
		if(((var.Name().split(" "))[0]).equals("WHEEL")) {
			if(((var.Name().split(" "))[1]).equals("RF")&&variables.get(0).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(0).GetValue().Name())+(int)variables.get(0).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("LF")&&variables.get(0).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(0).GetValue().Name())+(int)variables.get(0).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("RB")&&variables.get(1).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(1).GetValue().Name())+(int)variables.get(1).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("LB")&&variables.get(1).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(1).GetValue().Name())+(int)variables.get(1).GetObject()))
				return true;
		}
		if(((var.Name().split(" "))[0]).equals("NUTS")) {
			if(((var.Name().split(" "))[1]).equals("RF")&&variables.get(2).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(2).GetValue().Name())+(int)variables.get(2).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("LF")&&variables.get(3).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(3).GetValue().Name())+(int)variables.get(3).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("RB")&&variables.get(4).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(4).GetValue().Name())+(int)variables.get(4).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("LB")&&variables.get(5).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(5).GetValue().Name())+(int)variables.get(5).GetObject()))
				return true;
		}
		if(((var.Name().split(" "))[0]).equals("CAP")) {
			if(((var.Name().split(" "))[1]).equals("RF")&&variables.get(6).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(6).GetValue().Name())+(int)variables.get(6).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("LF")&&variables.get(7).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(7).GetValue().Name())+(int)variables.get(7).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("RB")&&variables.get(8).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(8).GetValue().Name())+(int)variables.get(8).GetObject()))
				return true;
			else if(((var.Name().split(" "))[1]).equals("LB")&&variables.get(9).GetValue()!=null && Integer.parseInt(val.Name())>=(Integer.parseInt(variables.get(9).GetValue().Name())+(int)variables.get(9).GetObject()))
				return true;
		}
		if(((var.Name().split(" "))[0]).equals("INSPECT")){
			int maxTime = 0;
			for(Variable v : variables)
				if(v.GetValue() != null && Integer.parseInt(v.GetValue().Name()) > maxTime)
					maxTime = Integer.parseInt(v.GetValue().Name());
			if(Integer.parseInt(val.Name()) == (maxTime+1))
				return true;
		}
		return false;
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
		return null;
	}
}