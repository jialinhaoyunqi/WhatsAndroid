package com.haiyunshan.whatsnote.record.entity;

import android.content.Context;
import com.haiyunshan.whatsnote.WhatsApp;

public class TagRecordSet extends BaseEntitySet<RecordEntity> {

    TagEntity tagEntity;

    TagRecordSet(Context context, TagEntity tag) {
        super(context);

        this.tagEntity = tag;
    }

    @Override
    public String getId() {
       return "";
    }

    public TagEntity getTag() {
        return tagEntity;
    }

    public RecordEntity get(String id) {
        if (childList == null || childList.isEmpty()) {
            return null;
        }

        for (RecordEntity e : childList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }

        return null;
    }

    @Override
    public int remove(RecordEntity entity) {
        int index = this.indexOf(entity);
        if (index < 0) {
            return index;
        }

        getManager().remove(entity.entry);
        childList.remove(entity);

        return index;
    }

    @Override
    public void save() {
        getManager().save();
    }

    public static final TagRecordSet create(String tag) {
        return TagFactory.createRecordSet(WhatsApp.getContext(), tag);
    }
}
