package bm.it.mobile.task;

import android.os.AsyncTask;

import bm.it.mobile.entity.ResponseTask;

public abstract class BMBaseTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private final String TAG = BMBaseTask.class.getSimpleName();

    protected ResponseTask mResponses;

    public BMBaseTask() {
        this.mResponses = new ResponseTask();
    }
}
