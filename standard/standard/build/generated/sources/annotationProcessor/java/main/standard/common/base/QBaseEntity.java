package standard.common.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseEntity extends EntityPathBase<BaseEntity> {

    private static final long serialVersionUID = -1076763201L;

    public static final QBaseEntity baseEntity = new QBaseEntity("baseEntity");

    public final DateTimePath<java.time.LocalDateTime> frstRgstDt = createDateTime("frstRgstDt", java.time.LocalDateTime.class);

    public final StringPath frstRgstId = createString("frstRgstId");

    public final DateTimePath<java.time.LocalDateTime> lastMdfyDt = createDateTime("lastMdfyDt", java.time.LocalDateTime.class);

    public final StringPath lastMdfyId = createString("lastMdfyId");

    public final NumberPath<Long> seqNo = createNumber("seqNo", Long.class);

    public final StringPath useYn = createString("useYn");

    public QBaseEntity(String variable) {
        super(BaseEntity.class, forVariable(variable));
    }

    public QBaseEntity(Path<? extends BaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntity(PathMetadata metadata) {
        super(BaseEntity.class, metadata);
    }

}

