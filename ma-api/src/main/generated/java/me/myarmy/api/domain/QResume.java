package me.myarmy.api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QResume is a Querydsl query type for Resume
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResume extends EntityPathBase<Resume> {

    private static final long serialVersionUID = -1429238252L;

    public static final QResume resume = new QResume("resume");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createdDate = _super.createdDate;

    public final StringPath grade = createString("grade");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<org.joda.time.DateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath license = createString("license");

    public final StringPath miscellaneous = createString("miscellaneous");

    public final StringPath objective = createString("objective");

    public final StringPath specialty = createString("specialty");

    public final StringPath uid = createString("uid");

    public QResume(String variable) {
        super(Resume.class, forVariable(variable));
    }

    public QResume(Path<? extends Resume> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResume(PathMetadata metadata) {
        super(Resume.class, metadata);
    }

}

