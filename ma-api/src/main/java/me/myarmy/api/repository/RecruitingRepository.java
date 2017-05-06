package me.myarmy.api.repository;

import me.myarmy.api.domain.Recruiting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gain on 2017. 5. 4..
 */
@Repository
public interface RecruitingRepository extends JpaRepository<Recruiting, Long>{

}
