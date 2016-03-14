package kale.ui.view;

import android.content.Context;
import android.util.AttributeSet;

import kale.injection.SelectorInjection;

/**
 * @author Kale
 * @date 2016/3/14
 */
public interface SelectorView {

    int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked
    };

    SelectorInjection initSelectorInjection(Context context,AttributeSet attr);
    
    SelectorInjection getInjection();
}
