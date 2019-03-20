package com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CitiesWithStores {

        @SerializedName("data")
        @Expose

        public Data data;

        public CitiesWithStores(Data data) {
                this.data = data;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
                this.data = data;
        }
}
