package me.myarmy.api.repository.custom;

import me.myarmy.api.domain.UserFavor;

/**
 * Created by Manki Kim on 2017-05-21.
 */
public interface UserFavorRepositoryCustom {

    UserFavor findByUserIdAndCompanyId(long userId, int companyId);
}
