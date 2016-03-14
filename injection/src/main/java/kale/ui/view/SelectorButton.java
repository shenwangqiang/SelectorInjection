package kale.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.Checkable;

import kale.injection.SelectorInjection;

/**
 * @author Kale
 * @date 2016/3/14
 */
public class SelectorButton extends Button implements Checkable, SelectorView {

    private SelectorInjection injection;

    public SelectorButton(Context context) {
        this(context, null);
    }

    public SelectorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    public SelectorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        injection = initSelectorInjection(context, attrs);
        injection.injection(this);
    }

    @Override
    public SelectorInjection initSelectorInjection(Context context, AttributeSet attr) {
        return new SelectorInjection(context, attr);
    }

    @Override
    public SelectorInjection getInjection() {
        return injection;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setAlpha(!enabled ? 0.3f : 1);
    }

    ///////////////////////////////////////////////////////////////////////////
    // For checkable
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    private boolean mIsChecked = false;

    @Override
    public void setChecked(boolean checked) {
        if (mIsChecked != checked) {
            mIsChecked = checked;
            refreshDrawableState();
        }
    }

    @Override
    public boolean isChecked() {
        return mIsChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mIsChecked);
    }

}
