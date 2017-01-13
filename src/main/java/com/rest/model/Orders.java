package com.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "url")
    private String url;

    @Column(name = "body")
    private String body;

    @Column(name = "executed")
    private boolean executed;

    @Column(name = "updated_datetime")
    private Timestamp timestamp;

    @Column(name = "response")
    private String response;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Orders{");
        sb.append("id=").append(id);
        sb.append(", url='").append(url).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", executed=").append(executed);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", response='").append(response).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
