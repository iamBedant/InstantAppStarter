
package com.iambedant.instantappstarter.data.remote.model.newsSource;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iambedant.instantappstarter.data.remote.rave.RaveValidatorFactory;
import com.uber.rave.annotation.Validated;

@Validated(factory = RaveValidatorFactory.class)
public class NewsSources {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sources")
    @Expose
    private List<Source> sources = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

}
