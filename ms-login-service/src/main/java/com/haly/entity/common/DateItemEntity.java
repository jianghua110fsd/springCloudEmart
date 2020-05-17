package com.haly.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class DateItemEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8143418657798942658L;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_datetime")
    private Date createDatetime;

	@Temporal(TemporalType.DATE)
    @Column(name = "update_datetime")
    private Date updateDatetime;

    
	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
    
}
