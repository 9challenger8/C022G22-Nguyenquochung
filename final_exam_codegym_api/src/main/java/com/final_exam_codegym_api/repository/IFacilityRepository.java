package com.final_exam_codegym_api.repository;

import com.final_exam_codegym_api.dto.IFacilityDto;
import com.final_exam_codegym_api.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer > {

    @Query(value = "select * from facility",nativeQuery = true)
    List<Facility> findAll();

    @Query(value = "select id, address, code_facility, name_facility, open_day, manager_id, is_deleted from facility where id = :id", nativeQuery = true)
    Optional<Facility> searchById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from facility where id = :id", nativeQuery = true)
    void removeById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update facility set is_deleted = 1 where id = :id", nativeQuery = true)
    void deleteFacility(@Param("id") int id);

    @Query(value = "select f.code_facility as codeFacility, f.name_facility as nameFacility, " +
            "f.address, f.open_day as openDay, m.name_manager as nameManager, f.is_deleted as isDeleted,f.id " +
            "from facility f join manager m on f.manager_id = m.id " +
            "where f.is_deleted = 0 and f.name_facility like concat('%',:nameFacility,'%') " +
            "and m.name_manager like concat('%',:nameManager,'%') " +
            "order by f.id desc"
            , nativeQuery = true,
            countQuery = "select count(*) from (select f.code_facility as codeFacility, f.name_facility as nameFacility, " +
                    "f.address, f.open_day as openDay, m.name_manager as nameManager, f.is_deleted as isDeleted, f.id " +
                    "from facility f join manager m on f.manager_id = m.id " +
                    "where f.is_deleted = 0 and f.name_facility like concat('%',:nameFacility,'%') " +
                    "and m.name_manager " +
                    "like concat('%',:nameManager,'%') " +
                    "order by f.id desc) abc")
    Page<IFacilityDto> findAllByName(@Param("nameFacility") String nameFacility,
                                     @Param("nameManager") String nameManager,
                                     Pageable pageable);

}
