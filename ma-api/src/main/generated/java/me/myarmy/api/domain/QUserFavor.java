package me.myarmy.api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserFavor is a Querydsl query type for UserFavor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserFavor extends EntityPathBase<UserFavor> {

    private static final long serialVersionUID = -290904596L;

    public static final QUserFavor userFavor = new QUserFavor("userFavor");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath bokrihs = createString("bokrihs");

    public final StringPath cjhakryeok = createString("cjhakryeok");

    public final NumberPath<Integer> companyId = createNumber("companyId", Integer.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createdDate = _super.createdDate;

    public final StringPath eopjonggbcdnm = createString("eopjonggbcdnm");

    public final StringPath geunmujysido = createString("geunmujysido");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserFavor(String variable) {
        super(UserFavor.class, forVariable(variable));
    }

    public QUserFavor(Path<? extends UserFavor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserFavor(PathMetadata metadata) {
        super(UserFavor.class, metadata);
    }

}

