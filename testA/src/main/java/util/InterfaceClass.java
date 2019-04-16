package util;

/**
 * Created by Administrator on 2019/4/15.
 */
public class InterfaceClass {

    String interfacename;
    String method;
    String data;
    String url;
    String header;

    public InterfaceClass() {
    }

    public InterfaceClass(String interfacename, String method, String url, String header, String data){
        this.interfacename = interfacename;
        this.data = data;
        this.url = url;
        this.method = method;
        this.header = header;
    }

    public String getInterfacename() {
        return interfacename;
    }

    public void setInterfacename(String interfacename) {
        this.interfacename = interfacename;
    }

    public String getMethod() {
        return method;
    }

    public String getData() {
        return data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
