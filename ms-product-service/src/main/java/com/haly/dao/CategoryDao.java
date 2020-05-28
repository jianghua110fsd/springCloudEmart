package com.haly.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haly.entity.CategoryEntity;
import com.haly.entity.SubcategoryEntity;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {

	@Query("select new com.haly.entity.SubcategoryEntity ("
			+ "sub.scPk.categoryId, sub.scPk.subcategoryId, sub.subcategoryName, sub.briefIntro ) "
			+ "from SubcategoryEntity sub "
			+ "where sub.scPk.categoryId = ?1")
	List<SubcategoryEntity> querySubsByCategoryId(@Param("categoryId") String categoryId, Sort sort);
    
}
