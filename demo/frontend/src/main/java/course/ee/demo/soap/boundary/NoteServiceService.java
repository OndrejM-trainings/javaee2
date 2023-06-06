package course.ee.demo.soap.boundary;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.0
 * 2023-06-06T07:24:07.709+02:00
 * Generated source version: 4.0.0
 *
 */
@WebServiceClient(name = "NoteServiceService",
                  wsdlLocation = "file:/home/ondro/workspaces/Lectures/JEE2/ee-advanced/demo/frontend/src/main/webapp/WEB-INF/wsdl/NoteServiceService.wsdl",
                  targetNamespace = "http://boundary.soap.demo.ee.course/")
public class NoteServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://boundary.soap.demo.ee.course/", "NoteServiceService");
    public final static QName NoteServicePort = new QName("http://boundary.soap.demo.ee.course/", "NoteServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/ondro/workspaces/Lectures/JEE2/ee-advanced/demo/frontend/src/main/webapp/WEB-INF/wsdl/NoteServiceService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(NoteServiceService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/ondro/workspaces/Lectures/JEE2/ee-advanced/demo/frontend/src/main/webapp/WEB-INF/wsdl/NoteServiceService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public NoteServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public NoteServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NoteServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public NoteServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public NoteServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public NoteServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns NoteService
     */
    @WebEndpoint(name = "NoteServicePort")
    public NoteService getNoteServicePort() {
        return super.getPort(NoteServicePort, NoteService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NoteService
     */
    @WebEndpoint(name = "NoteServicePort")
    public NoteService getNoteServicePort(WebServiceFeature... features) {
        return super.getPort(NoteServicePort, NoteService.class, features);
    }

}