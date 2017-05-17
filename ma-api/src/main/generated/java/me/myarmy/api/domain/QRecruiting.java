package me.myarmy.api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRecruiting is a Querydsl query type for Recruiting
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRecruiting extends EntityPathBase<Recruiting> {

    private static final long serialVersionUID = 1858230859L;

    public static final QRecruiting recruiting = new QRecruiting("recruiting");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath bokrihs = createString("bokrihs");

    public final StringPath cjhakryeok = createString("cjhakryeok");

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createdDate = _super.createdDate;

    public final StringPath cyjemokNm = createString("cyjemokNm");

    public final StringPath damdangjaFnm = createString("damdangjaFnm");

    public final StringPath ddeopmuNm = createString("ddeopmuNm");

    public final StringPath ddjyeonrakcheoNo = createString("ddjyeonrakcheoNo");

    public final StringPath dpyeonrakcheoNo = createString("dpyeonrakcheoNo");

    public final StringPath eopcheNm = createString("eopcheNm");

    public final StringPath eopjongGbcdNm = createString("eopjongGbcdNm");

    public final StringPath geunmujy = createString("geunmujy");

    public final StringPath gyeongryeokGbcdNm = createString("gyeongryeokGbcdNm");

    public final StringPath gyjogeonCdNm = createString("gyjogeonCdNm");

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    public final StringPath jeopsubb = createString("jeopsubb");

    //inherited
    public final DateTimePath<org.joda.time.DateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath magamDt = createString("magamDt");

    public final StringPath sschaeyongYn = createString("sschaeyongYn");

    public final StringPath uid = createString("uid");

    public final StringPath yeokjongBrcdNm = createString("yeokjongBrcdNm");

    public final StringPath yowonGbcdNm = createString("yowonGbcdNm");

    public QRecruiting(String variable) {
        super(Recruiting.class, forVariable(variable));
    }

    public QRecruiting(Path<? extends Recruiting> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecruiting(PathMetadata metadata) {
        super(Recruiting.class, metadata);
    }

}

