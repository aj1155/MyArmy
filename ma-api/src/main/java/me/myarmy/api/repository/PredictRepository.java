package me.myarmy.api.repository;

import me.myarmy.api.domain.Predict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Manki Kim on 2017-05-21.
 */
@Repository
public interface PredictRepository extends JpaRepository<Predict,Integer> {
    Predict findByUserId(long userId);
}
