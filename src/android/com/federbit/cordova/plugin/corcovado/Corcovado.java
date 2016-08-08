package com.federbit.cordova.plugin.corcovado;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.xwalk.core.XWalkCookieManager;
import android.util.Log;

public class Corcovado extends CordovaPlugin {
    private static final String TAG = "Corcovado";
    private static final String ACTION_GET_COOKIE = "getCookie";
    private static final String ACTION_SET_COOKIE = "setCookie";
    private static final String ACTION_CLEAR_COOKIES = "clearCookies";
    
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        try{
            if(ACTION_GET_COOKIE.equals(action)){
                String url = args.getString(0);
                PluginResult res = new PluginResult(PluginResult.Status.OK, new XWalkCookieManager().getCookie(url));
                callbackContext.sendPluginResult(res);
                return true;
            }else if(ACTION_SET_COOKIE.equals(action)){
                String url = args.getString(0);
                String cookies = args.getString(1);
                new XWalkCookieManager().setCookie(url,cookies);
                PluginResult res = new PluginResult(PluginResult.Status.OK);
                callbackContext.sendPluginResult(res);
                return true;
            }else if(ACTION_CLEAR_COOKIES.equals(action)){
                new XWalkCookieManager().removeAllCookie();
                PluginResult res = new PluginResult(PluginResult.Status.OK);
                callbackContext.sendPluginResult(res);
                return true;
            }else{
                callbackContext.error("Invalid action: "+action);
                return false;
            }
        }catch (Exception e){
            Log.e(TAG, "Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        }
    }
}
