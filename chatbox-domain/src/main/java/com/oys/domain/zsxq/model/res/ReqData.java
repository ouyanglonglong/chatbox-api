package com.oys.domain.zsxq.model.res;

import lombok.Data;

@Data
public class ReqData {

    private String text;

    private String[] image_ids = new String[]{};

    private boolean silenced;

    public ReqData(String text, boolean silenced) {
        this.text = text;
        this.silenced = silenced;
    }

}