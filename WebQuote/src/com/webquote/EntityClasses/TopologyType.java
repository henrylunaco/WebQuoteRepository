package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the topology_types database table.
 * 
 */
@Entity
@Table(name="topology_types")
public class TopologyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TOPOLOGY_ID")
	private int topologyId;

	private String name;

	//bi-directional many-to-one association to Tblwebquote
	@OneToMany(mappedBy="topologyType")
	private Set<Tblwebquote> tblwebquotes;

    public TopologyType() {
    }

	public int getTopologyId() {
		return this.topologyId;
	}

	public void setTopologyId(int topologyId) {
		this.topologyId = topologyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Tblwebquote> getTblwebquotes() {
		return this.tblwebquotes;
	}

	public void setTblwebquotes(Set<Tblwebquote> tblwebquotes) {
		this.tblwebquotes = tblwebquotes;
	}
	
}