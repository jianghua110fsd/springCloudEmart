package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.haly.entity.common.DateItemEntity;

@Entity
@Table(name = "subcategory_tbl")
@EntityListeners(AuditingEntityListener.class)
public class SubcategoryEntity extends DateItemEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2786088494444553144L;
	

	@EmbeddedId
	private SubcategoryEntityPk scPk;
    
    @Column(name = "subcategory_name")
    private String subcategoryName;
    
    @Column(name = "brief_intro")
    private String briefIntro;

    
    SubcategoryEntity () {}
    		
    public SubcategoryEntity (String categoryId, String subcategoryId, 
    							String subcategoryName, String briefIntro) {
    	
    	this.setScPk(new SubcategoryEntityPk(categoryId, subcategoryId));
    	this.subcategoryName = subcategoryName;
    	this.briefIntro = briefIntro;
    }
    
	public SubcategoryEntityPk getScPk() {
		return scPk;
	}

	public void setScPk(SubcategoryEntityPk scPk) {
		this.scPk = scPk;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getBriefIntro() {
		return briefIntro;
	}

	public void setBriefIntro(String briefIntro) {
		this.briefIntro = briefIntro;
	}

}
