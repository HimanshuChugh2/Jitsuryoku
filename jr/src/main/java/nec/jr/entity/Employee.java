package nec.jr.entity;

import java.util.List;

import com.fasterxml.jackson.core.TreeNode;

public class Employee {

	protected int id, managerId;
	protected String name;
	protected List<Employee> subordinates;
}