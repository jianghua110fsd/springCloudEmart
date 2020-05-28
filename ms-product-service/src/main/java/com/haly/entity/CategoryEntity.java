package com.haly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.haly.entity.common.DateItemEntity;

@Entity
@Table(name = "category_tbl")
@EntityListeners(AuditingEntityListener.class)
public class CategoryEntity extends DateItemEntity implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1053956958924223041L;

	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "category_id")
    private String categoryId;
    
    @Column(name = "category_name")
    private String categoryName;
    
    @Column(name = "brief_intro")
    private String briefIntro;

    
    CategoryEntity () {}
    		
    public CategoryEntity (String categoryId, String categoryName, String briefIntro) {
    	this.categoryId = categoryId;
    	this.categoryName = categoryName;
    	this.briefIntro = briefIntro;
    }
    

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBriefIntro() {
		return briefIntro;
	}

	public void setBriefIntro(String briefIntro) {
		this.briefIntro = briefIntro;
	}

}
