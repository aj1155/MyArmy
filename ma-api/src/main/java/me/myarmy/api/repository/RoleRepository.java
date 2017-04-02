package me.myarmy.api.repository;

import me.myarmy.api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Manki Kim on 2017-04-01.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
