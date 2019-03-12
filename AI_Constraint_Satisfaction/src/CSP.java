public interface CSP {
	public abstract void SetUp(int n);
	public abstract boolean isConsistent(Variable var, Value val);
	public abstract boolean assignmentIsComplete();
	public abstract Variable SelectUnassignedVariable();
	public abstract Value Clear(Variable var);
}