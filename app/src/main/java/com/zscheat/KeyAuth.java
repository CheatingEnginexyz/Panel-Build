package com.zscheat;

import android.content.Context;
import org.json.JSONObject;

public class KeyAuth {
    private String appname;
    private String ownerid;
    private String version;
    private String url;
    private Context context;
    private String sessionid;

    public KeyAuth(String appname, String ownerid, String version, String url, Context context) {
        this.appname = appname;
        this.ownerid = ownerid;
        this.version = version;
        this.url = "";
        this.context = context;
        this.sessionid = "CLEAN_LOCAL_SESSION";
    }

    public void init() throws Exception {
        this.sessionid = "CLEAN_LOCAL_SESSION";
    }

    public JSONObject login(String username, String password) throws Exception {
        JSONObject res = new JSONObject();
        if ("1".equals(username) && "1".equals(password)) {
            res.put("success", true);
            res.put("message", "Logged In");
        } else {
            res.put("success", false);
            res.put("message", "Invalid username");
        }
        return res;
    }

    public void upgrade(String username, String key) throws Exception {
    }

    public void license(String key) throws Exception {
    }
}
