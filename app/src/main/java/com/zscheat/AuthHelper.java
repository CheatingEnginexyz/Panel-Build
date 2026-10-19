package com.zscheat;

import android.content.Context;
import android.os.Build;
import org.json.JSONObject;

public class AuthHelper {

    private static String initToken = "LOCAL_CLEAN_TOKEN";

    public static class LoginResult {
        public boolean success;
        public String message;
        public String packageName;
        public String expiryDate;
        public String status;
        public String timeLeft;
        public String hwid;

        public LoginResult(boolean success, String message, String packageName, String expiryDate, String status, String timeLeft, String hwid) {
            this.success = success;
            this.message = message;
            this.packageName = packageName;
            this.expiryDate = expiryDate;
            this.status = status;
            this.timeLeft = timeLeft;
            this.hwid = hwid;
        }
    }

    public interface AuthCallback {
        void onSuccess(LoginResult result);
        void onFailure(String error);
    }

    public interface InitCallback {
        void onSuccess();
        void onFailure(String error);
    }

    public interface PackageValidationCallback {
        void onValidPackage(String packageName);
        void onInvalidPackage(String packageName);
        void onNoPackage();
    }

    public static String getDeviceId(Context context) {
        return "LOCAL_DEVICE_ID";
    }

    public static String getProcessorId() {
        return "LOCAL_HARDWARE";
    }

    public static void init(String appId, String secretKey, String version, InitCallback callback) {
        if (callback != null) {
            callback.onSuccess();
        }
    }

    public static void initAlternative(String appId, String secretKey, String version, InitCallback callback) {
        if (callback != null) {
            callback.onSuccess();
        }
    }

    public static void login(Context context, String appId, String secretKey, String username,
                             String password, String version, AuthCallback callback) {
        if (callback != null) {
            LoginResult result = new LoginResult(
                    true,
                    "Access Granted",
                    "AIMCOVER",
                    "2099-12-31",
                    "Active",
                    "Lifetime",
                    "LOCAL_DEVICE_ID"
            );
            callback.onSuccess(result);
        }
    }

    public static void clearSession() {
        initToken = "LOCAL_CLEAN_TOKEN";
    }

    public static void validatePackage(String userPackage, String[] allowedPackages, PackageValidationCallback callback) {
        if (callback != null) {
            callback.onValidPackage(userPackage != null && !userPackage.isEmpty() ? userPackage : "AIMCOVER");
        }
    }

    public static boolean isPackageValid(String userPackage, String requiredPackage) {
        return true;
    }

    public static void fetchUserExpiry(Context context, String appId, String secretKey, String username,
                                       String version, final java.util.function.Consumer<String> callback) {
        if (callback != null) {
            callback.accept("2099-12-31");
        }
    }

    public static void loginWithPackageValidation(Context context, String appId, String secretKey,
                                                  String username, String password, String version,
                                                  String[] allowedPackages, AuthCallback callback) {
        if (callback != null) {
            LoginResult result = new LoginResult(
                    true,
                    "Access Granted",
                    "AIMCOVER",
                    "2099-12-31",
                    "Active",
                    "Lifetime",
                    "LOCAL_DEVICE_ID"
            );
            callback.onSuccess(result);
        }
    }
}
