package com.example.baseproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Objects;


public class FragmentHelper {
    private static final String TAG = "FragmentHelper";

    public static void to(Fragment src, @IdRes int desc) {
        to(src, desc, null);
    }

    public static void to(Fragment src, @IdRes int desc, Bundle bundle) {
        try {
            NavHostFragment.findNavController(src).navigate(desc, bundle);
        } catch (Exception e) {
            Log.e(TAG, "to: " + e.getLocalizedMessage(), e);
        }
    }

    public static void to(View v, @IdRes int desc) {
        to(v, desc, null);
    }

    public static void to(View v, @IdRes int desc, Bundle bundle) {
        try {
            Navigation.findNavController(v).navigate(desc, bundle);
        } catch (Exception e) {
            Log.e(TAG, "to: " + e.getLocalizedMessage(), e);
        }
    }

    public static void toHome(View v) {
        try {
            Navigation.findNavController(v).navigate(R.id.HomeFragment);
        } catch (Exception e) {
            Log.e(TAG, "toHome: " + e.getLocalizedMessage(), e);
        }
    }

    public static void toHome(Fragment src) {
        try {
            Navigation.findNavController(src.requireView()).navigate(R.id.HomeFragment);
        } catch (Exception e) {
            Log.e(TAG, "toHome: " + e.getLocalizedMessage(), e);
        }
    }

    public static void back(View v) {
        try {
            Navigation.findNavController(v).navigateUp();
        } catch (Exception e) {
            Log.e(TAG, "back: " + e.getLocalizedMessage(), e);
        }
    }
}
