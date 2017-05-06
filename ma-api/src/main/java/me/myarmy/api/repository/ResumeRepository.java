package me.myarmy.api.repository;

import me.myarmy.api.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gain on 2017. 5. 6..
 */

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
