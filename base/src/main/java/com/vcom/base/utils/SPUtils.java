package com.vcom.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lifa on 2020-05-29 12:24.
 */

public class SPUtils {
    private static SharedPreferences sharedPreferences;
    private static List<WeakReference<SharedPreferences.OnSharedPreferenceChangeListener>>
            onSharedPreferenceChangeListenerWeakList = new LinkedList<>();

    private SPUtils() {
        throw new AssertionError();
    }

    public static void init(Context context) {
        createSP(context);
    }

    private static void createSP(final Context context) {
        if (null == sharedPreferences) {
            synchronized (SPUtils.class) {
                if (null == sharedPreferences) {
                    sharedPreferences = context
                            .getSharedPreferences(context.getPackageName()
                                    , Context.MODE_PRIVATE);
                    sharedPreferences.registerOnSharedPreferenceChangeListener((sharedPreferences, key) -> {
                        synchronized (SPUtils.class) {
                            final Iterator<WeakReference<SharedPreferences.OnSharedPreferenceChangeListener>> iterator =
                                    onSharedPreferenceChangeListenerWeakList.iterator();
                            while (iterator.hasNext()) {
                                final SharedPreferences.OnSharedPreferenceChangeListener listener
                                        = iterator.next().get();
                                if (null == listener) {
                                    iterator.remove();
                                } else {
                                    listener.onSharedPreferenceChanged(sharedPreferences, key);
                                }
                            }
                        }
                    });
                    AsyncTask.THREAD_POOL_EXECUTOR.execute(() -> getAll(context));
                }
            }
        }
    }

    public static String getString(final Context context, final String key
            , final String defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            return sharedPreferences.getString(key, defValue);
        }
    }

    public static String getString(final Context context, final String key) {
        return getString(context, key, "");
    }


    public static void putString(final Context context, final String key
            , final String value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putString(key, value)
                    .commit();
        }
    }

    public static boolean getBoolean(final Context context, final String key
            , final boolean defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            return sharedPreferences.getBoolean(key, defValue);
        }
    }

    public static boolean getBoolean(final Context context, final String key) {
        return getBoolean(context, key, false);
    }

    public static void putBoolean(final Context context, final String key
            , final boolean value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putBoolean(key, value)
                    .commit();
        }
    }

    public static float getFloat(final Context context, final String key
            , final float defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            return sharedPreferences.getFloat(key, defValue);
        }
    }


    public static float getFloat(final Context context, final String key) {
        return getFloat(context, key, .0f);
    }

    public static void putFloat(final Context context, final String key
            , final float value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putFloat(key, value)
                    .commit();
        }
    }


    public static int getInt(final Context context, final String key
            , final int defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            return sharedPreferences.getInt(key, defValue);
        }
    }

    public static float getInt(final Context context, final String key) {
        return getInt(context, key, 0);
    }


    public static void putInt(final Context context, final String key
            , final int value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putInt(key, value)
                    .commit();
        }
    }

    public static long getLong(final Context context, final String key
            , final long defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            return sharedPreferences.getLong(key, defValue);
        }
    }

    public static long getLong(final Context context, final String key) {
        return getLong(context, key, 0L);
    }

    public static void putLong(final Context context, final String key
            , final long value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putLong(key, value)
                    .commit();
        }
    }

    public static Map<String, ?> getAll(final Context context) {
        createSP(context);
        synchronized (SPUtils.class) {
            return sharedPreferences.getAll();
        }
    }

    public static Set<String> getStringSet(final Context context, String key) {
        createSP(context);
        synchronized (SPUtils.class) {
            final HashSet<String> set = new HashSet<>();
            return sharedPreferences.getStringSet(key, set);
        }
    }

    public static void putStringSet(final Context context, final String key
            , final Set<String> value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putStringSet(key, value)
                    .commit();
        }
    }

    public static void remove(final Context context, final String key) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().remove(key)
                    .commit();
        }
    }


    public static void registerOnSharedPreferenceChangeListener(
            final Context context
            , final SharedPreferences.OnSharedPreferenceChangeListener listener) {
        createSP(context);
        synchronized (SPUtils.class) {
            onSharedPreferenceChangeListenerWeakList
                    .add(new WeakReference<>(listener));
        }
    }


    public static void unregisterOnSharedPreferenceChangeListener(
            final SharedPreferences.OnSharedPreferenceChangeListener listener) {
        if (null != listener) {
            synchronized (SPUtils.class) {
                final Iterator<WeakReference<SharedPreferences.OnSharedPreferenceChangeListener>> iterator
                        = onSharedPreferenceChangeListenerWeakList.iterator();
                while (iterator.hasNext()) {
                    final SharedPreferences.OnSharedPreferenceChangeListener item
                            = iterator.next().get();
                    if (null == item || item.equals(listener)) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    public static boolean contains(final Context context, final String key) {
        createSP(context);
        synchronized (SPUtils.class) {
            return !TextUtils.isEmpty(key)
                    && sharedPreferences.contains(key);
        }
    }

    public static int getValue(final Context context, final String key
            , final int defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            int value;
            try {
                value = sharedPreferences.getInt(key, defValue);
            } catch (ClassCastException exception) {
                Log.e("SPUtils", key + "：getInt ClassCastException");
                value = (int) sharedPreferences.getLong(key, defValue);
            }
            return value;
        }
    }

    public static long getValue(final Context context, final String key
            , final long defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            Long value;
            try {
                value = sharedPreferences.getLong(key, defValue);
            } catch (ClassCastException exception) {
                Log.e("SPUtils", key + "：getLong ClassCastException");
                value = (long) sharedPreferences.getInt(key, (int) defValue);
            }
            return value;
        }
    }

    public static String getValue(final Context context, final String key
            , final String defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            String value;
            try {
                value = sharedPreferences.getString(key, defValue);
            } catch (ClassCastException exception) {
                Log.e("SPUtils", key + "：getString ClassCastException");
                try {
                    value = String.valueOf(sharedPreferences.getInt(key, 0));
                } catch (ClassCastException e) {
                    Log.e("SPUtils", key + "：getInt ClassCastException");
                    value = String.valueOf(sharedPreferences.getFloat(key, 0f));
                }
            }
            return value;
        }
    }

    public static float getValue(final Context context, final String key
            , final float defValue) {
        createSP(context);
        synchronized (SPUtils.class) {
            return sharedPreferences.getFloat(key, defValue);
        }
    }

    public static void putValue(final Context context, final String key
            , final int value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putInt(key, value)
                    .commit();
        }
    }

    public static void putValue(final Context context, final String key
            , final long value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putLong(key, value)
                    .commit();
        }
    }

    public static void putValue(final Context context, final String key
            , final String value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putString(key, value)
                    .commit();
        }
    }

    public static void putValue(final Context context, final String key
            , final double value) {
        createSP(context);
        synchronized (SPUtils.class) {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
            sharedPreferences.edit().putFloat(key, bigDecimal.floatValue())
                    .commit();
        }
    }

    public static void putValue(final Context context, final String key
            , final float value) {
        createSP(context);
        synchronized (SPUtils.class) {
            sharedPreferences.edit().putFloat(key, value)
                    .commit();
        }
    }

    public static void clear() {
        synchronized (SPUtils.class) {
            sharedPreferences.edit().clear().apply();
        }
    }
}