package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the event_types database table.
 * 
 */
@Entity
@Table(name="event_types")
public class EventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EVENT_TYPE_ID")
	private int eventTypeId;

	private String description;

	@Column(name="EVENT_NAME")
	private String eventName;

	//bi-directional many-to-one association to WebquoteDetailProgress
	@OneToMany(mappedBy="eventType")
	private Set<WebquoteDetailProgress> webquoteDetailProgresses;

    public EventType() {
    }

	public int getEventTypeId() {
		return this.eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Set<WebquoteDetailProgress> getWebquoteDetailProgresses() {
		return this.webquoteDetailProgresses;
	}

	public void setWebquoteDetailProgresses(Set<WebquoteDetailProgress> webquoteDetailProgresses) {
		this.webquoteDetailProgresses = webquoteDetailProgresses;
	}
	
}