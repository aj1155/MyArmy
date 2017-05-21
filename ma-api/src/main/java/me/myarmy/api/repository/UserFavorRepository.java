package me.myarmy.api.repository;

import me.myarmy.api.domain.UserFavor;
import me.myarmy.api.repository.custom.UserFavorRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Manki Kim on 2017-05-17.
 */
@Repository
public interface UserFavorRepository extends JpaRepository<UserFavor,Long>,UserFavorRepositoryCustom{
}
