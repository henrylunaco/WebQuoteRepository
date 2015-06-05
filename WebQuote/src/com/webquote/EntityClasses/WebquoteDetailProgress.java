package com.webquote.EntityClasses;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the webquote_detail_progress database table.
 * 
 */
@Entity
@Table(name="webquote_detail_progress")
public class WebquoteDetailProgress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROGRESS_ID")
	private int progressId;

    @Temporal( TemporalType.DATE)
	@Column(name="DATE_CREATE")
	private Date dateCreate;

	private String description;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to Tblwebquote
    @ManyToOne
	@JoinColumn(name="WEBQUOTE_ID")
	private Tblwebquote tblwebquote;

	//bi-directional many-to-one association to EventType
    @ManyToOne
	@JoinColumn(name="EVENT_TYPE_ID")
	private EventType eventType;
    
    //bi-directional many-to-one association to EventType
    @ManyToOne
	@JoinColumn(name="STATUS_TYPE_ID")
	private StatusType statusType;

    public WebquoteDetailProgress() {
    }

	public int getProgressId() {
		return this.progressId;
	}

	public void setProgressId(int progressId) {
		this.progressId = progressId;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Tblwebquote getTblwebquote() {
		return this.tblwebquote;
	}

	public void setTblwebquote(Tblwebquote tblwebquote) {
		this.tblwebquote = tblwebquote;
	}
	
	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}
	
}