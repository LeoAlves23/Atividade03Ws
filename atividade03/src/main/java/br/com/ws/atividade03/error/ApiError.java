package br.com.ws.atividade03.error;

public class ApiError {
    int status;
    String mensage;
    long timestamp;
    String path;


    public ApiError(int status, String mensage, String path) {
        this.status = status;
        this.mensage = mensage;
        this.path = path;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMensage() {
        return mensage;
    }
    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }


}
