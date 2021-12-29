package com.fstg.taxesejour.infrastructure.converter;

import com.fstg.taxesejour.domaine.pojo.TaxeSejourTrimPojo;
import com.fstg.taxesejour.infrastructure.entity.TaxeSejourTrim;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TaxeSejourTrimConverterImpl implements TaxeSejourTrimConverter {

    @Override
    public TaxeSejourTrim toEntity(TaxeSejourTrimPojo pojo) {
        TaxeSejourTrim entity = new TaxeSejourTrim();
        if (pojo != null) {
            BeanUtils.copyProperties(pojo, entity);
        }
        return entity;
    }

    @Override
    public TaxeSejourTrimPojo toPojo(TaxeSejourTrim entity) {
        TaxeSejourTrimPojo dto = new TaxeSejourTrimPojo();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

}
