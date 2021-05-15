package helloworld;

public class ResponseDetails {
    private String response_id;
    private String reason;

    public ResponseDetails(String response_id, String reason) {
        this.response_id = response_id;
        this.reason = reason;
    }

    public ResponseDetails() {
    }

    @Override
    public String toString() {
        return "ResponseDetails{" +
                "response_id='" + response_id + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    public String getResponse_id() {
        return response_id;
    }

    public void setResponse_id(String response_id) {
        this.response_id = response_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
