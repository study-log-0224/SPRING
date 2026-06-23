package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Signature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignatureRepository extends JpaRepository<Signature, byte[]> {

}
