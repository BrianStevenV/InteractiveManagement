package com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.repositories;

import com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<PostEntity, Long> {

//    @Query(value = "SELECT * FROM post WHERE idCountry = :idCountry AND idCategory = :idCategory", nativeQuery = true) // BUSCAR ULTIMOS DIEZ
//    Page<PostEntity> findByIdCountryAndIdCategory(@Param("idCountry") Long idCountry, @Param("idCountry") Long idCategory, Pageable pageable);

//    @Query(value = "SELECT * FROM post " +
//            "WHERE country = :idCountry " +
//            "AND topic = :idCategory " +
//            "ORDER BY created_at DESC " +
//            "LIMIT 3",
//            nativeQuery = true)
//    Page<PostEntity> findByIdCountryAndIdCategory(@Param("idCountry") Long idCountry, @Param("idCategory") Long idCategory, Pageable pageable);


    @Query(value = "SELECT * FROM post " +
            "WHERE country = :idCountry " +
            "AND topic = :idCategory " +
            "ORDER BY created_at DESC",
            countQuery = "SELECT count(*) FROM post " +
                    "WHERE country = :idCountry " +
                    "AND topic = :idCategory ",
            nativeQuery = true)
    Page<PostEntity> findByIdCountryAndIdCategory(
            @Param("idCountry") Long idCountry,
            @Param("idCategory") Long idCategory,
            Pageable pageable
    );


    @Query(value = "SELECT * FROM post " +
            "WHERE country = :idCountry " +
            "ORDER BY created_at DESC " +
            "LIMIT 3",
            nativeQuery = true)
    Page<PostEntity> findByIdCountry(@Param("idCountry") Long idCountry, Pageable pageable);

    @Query(value = "SELECT * FROM post " +
            "WHERE topic = :idCategory " +
            "ORDER BY created_at DESC " +
            "LIMIT 3",
            nativeQuery = true)
    Page<PostEntity> findByIdCategory(@Param("idCategory") Long idCategory, Pageable pageable);

    @Query(value = "SELECT COUNT(p) FROM PostEntity p WHERE p.idUser = :userId")
    Integer countPostsByUserId(@Param("userId") Long userId);

    // TODO: VERFICIAR QUE idUser este correcto y que no deerror por ser id_user; ---------- >>>>
    @Query(value = "SELECT p FROM PostEntity p WHERE p.idUser = :userId",
            countQuery = "SELECT COUNT(p) FROM PostEntity p WHERE p.idUser = :userId")
    Page<PostEntity> findPostsByUserId(@Param("userId") Long userId, Pageable pageable);


    @Query(value = "SELECT * FROM post WHERE id = :postId AND idUser = :userId", nativeQuery = true)
    PostEntity findByIdAndIdUser(@Param("postId") Long postId, @Param("userId") Long userId);


}
