package com.riksasuviana.id.mydagger.detail;

/**
 * Created by flitzmare21 on 08/10/17.
 */

public interface DetailContract {
    interface View {
//        void ShowSlide();
        void ShowError();
    }
    interface Implement {
        void ShowData();
//        void ShowTrailer();
    }
}
