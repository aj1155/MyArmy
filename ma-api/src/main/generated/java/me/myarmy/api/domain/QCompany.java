package me.myarmy.api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = -1503775882L;

    public static final QCompany company = new QCompany("company");

    public final StringPath bokrihs = createString("bokrihs");

    public final StringPath ccdatabalsaengDtm = createString("ccdatabalsaengDtm");

    public final StringPath cjdatabyeongyeongDtm = createString("cjdatabyeongyeongDtm");

    public final StringPath cjhakryeok = createString("cjhakryeok");

    public final StringPath cygonggoNo = createString("cygonggoNo");

    public final StringPath damdangjaFnm = createString("damdangjaFnm");

    public final StringPath ddeopmuNm = createString("ddeopmuNm");

    public final StringPath ddjyeonrakcheoNo = createString("ddjyeonrakcheoNo");

    public final StringPath dpyeonrakcheoNo = createString("dpyeonrakcheoNo");

    public final StringPath eopcheNm = createString("eopcheNm");

    public final StringPath eopjongGbcd = createString("eopjongGbcd");

    public final StringPath eopjongGbcdNm = createString("eopjongGbcdNm");

    public final StringPath geunmujy = createString("geunmujy");

    public final StringPath geunmujysido = createString("geunmujysido");

    public final StringPath gmjybjusoCd = createString("gmjybjusoCd");

    public final StringPath grNs = createString("grNs");

    public final StringPath gyeongryeokGbcdNm = createString("gyeongryeokGbcdNm");

    public final StringPath gyjogeonCd = createString("gyjogeonCd");

    public final StringPath gyjogeonCdNm = createString("gyjogeonCdNm");

    public final StringPath hmpgAddr = createString("hmpgAddr");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath jeopsubb = createString("jeopsubb");

    public final StringPath jggyeyeolCd = createString("jggyeyeolCd");

    public final StringPath jggyeyeolCdNm = createString("jggyeyeolCdNm");

    public final StringPath magamDt = createString("magamDt");

    public final StringPath oegukeo = createString("oegukeo");

    public final StringPath oegukeoCd = createString("oegukeoCd");

    public final StringPath ogegsneungryeokCdNm = createString("ogegsneungryeokCdNm");

    public final StringPath sschaeyongYn = createString("sschaeyongYn");

    public final StringPath yeokjongBrcd = createString("yeokjongBrcd");

    public final StringPath yeokjongBrcdNm = createString("yeokjongBrcdNm");

    public final StringPath yowonGbcd = createString("yowonGbcd");

    public final StringPath yowonGbcdNm = createString("yowonGbcdNm");

    public final StringPath yuhyoYn = createString("yuhyoYn");

    public QCompany(String variable) {
        super(Company.class, forVariable(variable));
    }

    public QCompany(Path<? extends Company> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompany(PathMetadata metadata) {
        super(Company.class, metadata);
    }

}

