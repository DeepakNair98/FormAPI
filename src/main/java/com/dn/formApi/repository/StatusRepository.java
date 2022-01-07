package com.dn.formApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.dn.formApi.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, String>{

}
