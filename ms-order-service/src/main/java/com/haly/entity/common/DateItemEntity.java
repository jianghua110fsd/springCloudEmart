package com.haly.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class DateItemEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8143418657798942658L;

	@Temporal(TemporalType.TIMESTAMP)
	//出参时间格式化  
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	//入参时，请求报文只需要传入yyyymmddhhmmss字符串进来，则自动转换为Date类型数据  
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "create_datetime")
	@CreatedDate
    private Date createDatetime;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "update_datetime")
	@LastModifiedDate 
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
