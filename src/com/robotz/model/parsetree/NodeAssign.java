package com.robotz.model.parsetree;

import com.robotz.model.Token;

public class NodeAssign extends Node {
	
	private final String nodeType = "assn";
	private String variableName;
	private Token value;
	
	@Override
	public String getNodeType() {
		
		return nodeType;
		
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public Token getValue() {
		return value;
	}

	public void setValue(Token value) {
		this.value = value;
	}
	
}
