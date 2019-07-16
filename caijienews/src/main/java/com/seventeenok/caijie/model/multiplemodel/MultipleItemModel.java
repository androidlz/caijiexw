package com.seventeenok.caijie.model.multiplemodel;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.seventeenok.caijie.adapter.holder.MultipleEntityBuilder;
import com.seventeenok.caijie.constant.MultipleFields;

import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * Created by root on 2018/5/22.
 */

public class MultipleItemModel implements MultiItemEntity,Serializable {
    
    private final ReferenceQueue<LinkedHashMap<Object, Object>> ITEM_QUEUE = new ReferenceQueue<>();
    private final LinkedHashMap<Object, Object> MULTIPLE_FIELDS = new LinkedHashMap<>();
    private final SoftReference<LinkedHashMap<Object, Object>> FIELDS_REFERENCE = new SoftReference<>(MULTIPLE_FIELDS, ITEM_QUEUE);
    
    public MultipleItemModel(LinkedHashMap<Object, Object> fields) {
        FIELDS_REFERENCE.get().putAll(fields);
    }
    
    public static MultipleEntityBuilder builder(){
        return new MultipleEntityBuilder();
    }
    
    @Override
    public int getItemType() {
        return (int) FIELDS_REFERENCE.get().get(MultipleFields.ITEM_TYPE);
    }
    
    @SuppressWarnings("unchecked")
    public final <T> T getField(Object key){
        return (T) FIELDS_REFERENCE.get().get(key);
    }
    
    public final LinkedHashMap<?,?> getFields(){
        return FIELDS_REFERENCE.get();
    }
    
    public final MultipleItemModel setField(Object key,Object value){
        FIELDS_REFERENCE.get().put(key,value);
        return this;
    }
}

