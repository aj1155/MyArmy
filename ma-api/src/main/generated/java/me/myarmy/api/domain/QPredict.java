package me.myarmy.api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPredict is a Querydsl query type for Predict
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPredict extends EntityPathBase<Predict> {

    private static final long serialVersionUID = 1521986514L;

    public static final QPredict predict = new QPredict("predict");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath companyIdText = createString("companyIdText");

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createdDate = _super.createdDate;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QPredict(String variable) {
        super(Predict.class, forVariable(variable));
    }

    public QPredict(Path<? extends Predict> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPredict(PathMetadata metadata) {
        super(Predict.class, metadata);
    }

}

