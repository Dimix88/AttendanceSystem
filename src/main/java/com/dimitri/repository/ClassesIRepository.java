package com.dimitri.repository;

import com.dimitri.domain.Classes;
import com.dimitri.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;
@Repository
public interface ClassesIRepository extends JpaRepository<Classes, String> {
}
