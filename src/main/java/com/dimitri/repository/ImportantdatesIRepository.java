package com.dimitri.repository;

import com.dimitri.domain.ImportantDates;
import com.dimitri.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;
@Repository
public interface ImportantdatesIRepository extends JpaRepository<ImportantDates, String> {
}
