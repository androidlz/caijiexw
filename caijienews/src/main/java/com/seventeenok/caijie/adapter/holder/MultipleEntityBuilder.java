package com.seventeenok.caijie.adapter.holder;

import com.seventeenok.caijie.constant.MultipleFields;
import com.seventeenok.caijie.model.multiplemodel.MultipleItemModel;

import java.util.LinkedHashMap;

/**
 * Created by root on 2018/5/22.
 */

public class MultipleEntityBuilder {
    private static final LinkedHashMap<Object, Object> FIELDS = new LinkedHashMap<>();
    
    public MultipleEntityBuilder() {
        //先清除之前的数据
        FIELDS.clear();
    }
    
    public final MultipleEntityBuilder setItemType(int itemType) {
        FIELDS.put(MultipleFields.ITEM_TYPE, itemType);
        return this;
    }
    
    public final MultipleEntityBuilder setField(Object key, Object value) {
        FIELDS.put(key, value);
        return this;
    }
    
    public final MultipleEntityBuilder setFields(LinkedHashMap<?, ?> map) {
        FIELDS.putAll(map);
        return this;
    }
    
    public final MultipleItemModel build() {
        return new MultipleItemModel(FIELDS);
    }
}
