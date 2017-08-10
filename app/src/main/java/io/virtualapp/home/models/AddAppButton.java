package io.virtualapp.home.models;

import android.content.Context;
import android.graphics.drawable.Drawable;

import io.virtualhook.R;

/**
 * @author Lody
 */

public class AddAppButton implements AppData {

    private Drawable icon;

    public AddAppButton(Context context) {
        icon = context.getResources().getDrawable(R.drawable.ic_add_circle);
    }

    @Override
    public boolean isLoading() {
        return false;
    }

    @Override
    public boolean isFirstOpen() {
        return false;
    }

    @Override
    public Drawable getIcon() {
        return icon;
    }

    @Override
    public String getName() {
        return "Add";
    }

    @Override
    public boolean canReorder() {
        return false;
    }

    @Override
    public boolean canLaunch() {
        return false;
    }

    @Override
    public boolean canDelete() {
        return false;
    }

    @Override
    public boolean canCreateShortcut() {
        return false;
    }

    @Override
    public boolean isHook() {
        return false;
    }
}
