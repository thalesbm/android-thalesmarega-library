package bm.it.mobile.network.rest;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * VOLLEY
 */
public class BMVolley extends Request<JSONObject> {

    private Response.Listener<JSONObject> mResponse;
    private Map<String, String> mParams;
    private String mJsonObject;
    private Map<String, String> mHeaders;

    public BMVolley(int method, String url, Map<String, String> params, Response.Listener<JSONObject> response, Response.ErrorListener listener) {
        super(method, url, listener);
        this.mParams = params;
        this.mResponse = response;
    }

    public BMVolley(int method, String url, Response.Listener<JSONObject> response, Response.ErrorListener listener) {
        super(method, url, listener);
        this.mResponse = response;
    }

    public BMVolley(int method, String url, String jsonRequest, Map<String, String> headers, Response.Listener<JSONObject> response, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mJsonObject = jsonRequest;
        this.mResponse = response;
        this.mHeaders = headers;
    }

    public Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }

    @Override
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        int socketTimeout = 45000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        return super.setRetryPolicy(policy);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (mHeaders != null) {
            return mHeaders;
        }
        return new HashMap<String, String>();
    }

    public Request.Priority getPriority() {
        return (Priority.NORMAL);
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        if (mJsonObject != null) {
            return mJsonObject.getBytes();
        }
        return super.getBody();
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String js = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return (Response.success(new JSONObject(js), HttpHeaderParser.parseCacheHeaders(response)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void deliverResponse(JSONObject response) {
        this.mResponse.onResponse(response);
    }
}
