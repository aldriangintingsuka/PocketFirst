package com.smartmadsoft.xposed.pocketfirst;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Max implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        XposedHelpers.findAndHookMethod("com.android.internal.app.ResolverActivity.ResolverComparator", loadPackageParam.classLoader, "getPackageTimeSpent", String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                if (param.args[0].equals("com.ideashower.readitlater.pro"))
                    param.setResult(Long.MAX_VALUE);
            }
        });
    }
}
