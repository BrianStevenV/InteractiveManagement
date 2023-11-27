package com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.repositories;

import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
