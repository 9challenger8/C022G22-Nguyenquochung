package com.back_end_final_module5_2.repository;

import com.back_end_final_module5_2.model.Doctor;
import com.back_end_final_module5_2.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,String> {

    @Query(value = "select * from patient where id_record = :id",nativeQuery = true)
    Optional<Patient> findById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "delete from patient where id_record = :id",nativeQuery = true)
    void removeById(@Param("id") String id);

    @Query(value = "select * from patient where name_patient like concat('%',:name,'%')",nativeQuery = true,
            countQuery = " select count(*) from (select * from patient where name_patient like concat('%',:name,'%')) abc")
    Page<Patient> findAllByNamePatient(@Param("name") String namePatient, Pageable pageable);

//    @Query(value = "insert into patient(id_record,id_patient,issue,name_patient,out_date,solution,start_date,id_doctor) " +
//            "values(:idRecord, :idPatient, :issue, :namePatient, :outdate, " +
//            " :solution, :startDate, :doctor)" ,nativeQuery = true)
//    Patient savePatient(@Param("idRecord") String idRecord, String idPatient, String issue, String namePatient, String outDate,
//                 String solution, String startDate,@Param("doctor") Doctor doctor);

//    @Query(value = "insert into patient(id_record,id_patient,issue,name_patient,out_date,solution,start_date,id_doctor) " +
//            " values (:#{#patient.idRecord} ,:#{#patient.idPatient}, :#{#patient.issue} , " +
//            " :#{#patient.namePatient},:#{#patient.outDate} ,  :#{#patient.solution} , " +
//            ":#{#patient.startDate}, :#{#patient.doctor.id}) ",nativeQuery = true)
//    Patient savePatient(Patient patient);
}
