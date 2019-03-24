public interface CSP {
	public abstract boolean isConsistent(Variable var, Value val);
	public abstract boolean assignmentIsComplete();
	public abstract Variable SelectUnassignedVariable();
	public abstract Value Clear(Variable var);
}