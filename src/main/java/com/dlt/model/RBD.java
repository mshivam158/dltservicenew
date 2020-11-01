package com.dlt.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class RBD implements Serializable {
	private static final long serialVersionUID = 1L;

	private String rbdId; //SystemName + System's Version Pkey

	private String elementType; //equipment, branch,subsystem, external,system, start, finish
	private Integer node;
	private Integer nextNode;
	private String status;//active,inactive

	@ManyToOne
	@JoinColumn(name = "systemID", nullable = false)
	private EOSystem system;
	//private Assets assets;

}
