package org.xl.mvvm.httpdemo.entity;

public class InfoEntity {
    /**
     * version : 1.0
     * versionCode : 100
     * url :
     */

    private String version;
    private int versionCode;
    private String url;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "[version] : " + version + " [versionCode] : " + versionCode + " [url] : " + url ;
    }
}
