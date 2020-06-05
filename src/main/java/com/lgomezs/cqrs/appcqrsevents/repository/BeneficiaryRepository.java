package com.lgomezs.cqrs.appcqrsevents.repository;


import com.lgomezs.cqrs.appcqrsevents.domain.Beneficiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends CrudRepository<Beneficiary,String> {


}
