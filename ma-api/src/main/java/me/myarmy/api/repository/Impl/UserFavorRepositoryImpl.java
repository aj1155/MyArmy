package me.myarmy.api.repository.Impl;

import com.querydsl.core.BooleanBuilder;
import me.myarmy.api.domain.QUserFavor;
import me.myarmy.api.domain.UserFavor;
import me.myarmy.api.repository.custom.UserFavorRepositoryCustom;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * Created by Manki Kim on 2017-05-21.
 */
public class UserFavorRepositoryImpl extends QueryDslRepositorySupport implements UserFavorRepositoryCustom {

    QUserFavor qUserFavor = QUserFavor.userFavor;

    public UserFavorRepositoryImpl(){
        super(UserFavor.class);
    }

    @Override
    public UserFavor findByUserIdAndCompanyId(long userId, int companyId) {
        BooleanBuilder whereClause = new BooleanBuilder();
        whereClause.and(qUserFavor.userId.eq(userId));
        whereClause.and(qUserFavor.companyId.eq(companyId));
        return from(qUserFavor)
                .where(whereClause)
                .fetchOne();
    }
}
