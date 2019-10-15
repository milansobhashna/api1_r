package com.example.api1_r;

class AndroidVersion {

    String userId, id, title, body;

    public AndroidVersion(String userId, String id, String title, String body) {
        this.userId=userId;
        this.id=id;
        this.title=title;
        this.body=body;
    }
    public AndroidVersion() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
