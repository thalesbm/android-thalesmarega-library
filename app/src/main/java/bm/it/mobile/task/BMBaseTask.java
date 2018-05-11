package bm.it.mobile.task;

import android.os.AsyncTask;

import bm.it.mobile.entity.BMResponseTask;

public abstract class BMBaseTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private final String TAG = BMBaseTask.class.getSimpleName();

    protected BMResponseTask mResponses;

    public BMBaseTask() {
        this.mResponses = new BMResponseTask();
    }
}
