package com.example.coldstoragemanager.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

public class mActivityManager {
    private  static Stack<Activity> mActivityStack;
    //安卓活动页的栈，加载新页入栈，退出旧页出栈，返回上一页出栈并读栈。

    private static mActivityManager instance;

    private mActivityManager(){

    }//实例化

    public static mActivityManager getActivity(){
        if(instance == null){
            instance = new mActivityManager();
        }
        //获得活动用例，并返回到函数mActivityManger();【信息获取】
        return instance;
    }

    public void addActivity(Activity activity){
        if(mActivityStack == null){
            mActivityStack = new Stack<Activity>();
        }
        //将新活动压入活动栈【操作】
        mActivityStack.add(activity);
    }

    public Activity currentActivity(){
        Activity activity = mActivityStack.lastElement();
        return activity;
        //获取栈末的活动，最新/最后的活动。【信息获取】
    }

    public void finishActivity(){
        Activity activity = mActivityStack.lastElement();
        finishActivity(activity);
        //活动结束函数多态入口
    }

    //以下是几个关闭不同形态活动页的方法
    public void finishActivity(Activity activity){
        if(mActivityStack != null){
            mActivityStack.remove(activity);
        }
    }

    public void finishActivity(Class<?> cls){
        for(Activity activity : mActivityStack){
            if(activity.getClass().equals(cls)){
                finishActivity(activity);
            }
        }
    }

    public void finishActivity_All(){
        for(int i=0; i<mActivityStack.size(); i++){
            //??null != mActivityStack.get(i)
            if(mActivityStack.get(i) != null){
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }

    public void AppExit(Context context){
        try{
            finishActivity();
            ActivityManager atymgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            atymgr.restartPackage(context.getPackageName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}