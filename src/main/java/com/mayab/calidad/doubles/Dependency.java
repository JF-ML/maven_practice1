package com.mayab.calidad.doubles;

public class Dependency {
	private final Subdependency subDependency;
	
	public Dependency(Subdependency subDependency) {
		super();
		this.subDependency = subDependency;
	}
	
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	public String getSubdependencyClassName() {
		return subDependency.getClassName();
	}
	public int addTwo(int i) {
		return i+2;
	}
	public int multiply(int i,int j) {
		return 0;
	}
	public String getClassNameUpperCase() {
		return getClassName().toUpperCase();
	}
}
