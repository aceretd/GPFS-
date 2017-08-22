package com.gpfs.question.service.custom;

import com.google.common.collect.ImmutableMap;
import com.gpfs.core.service.GpfsJpaServiceCustom;
import com.gpfs.question.dto.PrincipalActivityInfo;
import com.gpfs.reference.PrincipalActivity;
import com.querydsl.core.types.Path;
import static com.gpfs.reference.QPrincipalActivity.principalActivity;

public interface PrincipalActivityServiceCustom extends GpfsJpaServiceCustom<PrincipalActivity, PrincipalActivityInfo> {

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.of("deleted", principalActivity.deleted,
        					"type", principalActivity.type,
        					"subtype", principalActivity.subtype,
        					"activity", principalActivity.activity);
    }

}
