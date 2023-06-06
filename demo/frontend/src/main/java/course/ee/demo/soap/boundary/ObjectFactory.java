
package course.ee.demo.soap.boundary;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the course.ee.demo.soap.boundary package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAll_QNAME = new QName("http://boundary.soap.demo.ee.course/", "getAll");
    private final static QName _GetAllResponse_QNAME = new QName("http://boundary.soap.demo.ee.course/", "getAllResponse");
    private final static QName _Note_QNAME = new QName("http://boundary.soap.demo.ee.course/", "note");
    private final static QName _Status_QNAME = new QName("http://boundary.soap.demo.ee.course/", "status");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: course.ee.demo.soap.boundary
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAll }
     * 
     * @return
     *     the new instance of {@link GetAll }
     */
    public GetAll createGetAll() {
        return new GetAll();
    }

    /**
     * Create an instance of {@link GetAllResponse }
     * 
     * @return
     *     the new instance of {@link GetAllResponse }
     */
    public GetAllResponse createGetAllResponse() {
        return new GetAllResponse();
    }

    /**
     * Create an instance of {@link Note }
     * 
     * @return
     *     the new instance of {@link Note }
     */
    public Note createNote() {
        return new Note();
    }

    /**
     * Create an instance of {@link User }
     * 
     * @return
     *     the new instance of {@link User }
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://boundary.soap.demo.ee.course/", name = "getAll")
    public JAXBElement<GetAll> createGetAll(GetAll value) {
        return new JAXBElement<>(_GetAll_QNAME, GetAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://boundary.soap.demo.ee.course/", name = "getAllResponse")
    public JAXBElement<GetAllResponse> createGetAllResponse(GetAllResponse value) {
        return new JAXBElement<>(_GetAllResponse_QNAME, GetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Note }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Note }{@code >}
     */
    @XmlElementDecl(namespace = "http://boundary.soap.demo.ee.course/", name = "note")
    public JAXBElement<Note> createNote(Note value) {
        return new JAXBElement<>(_Note_QNAME, Note.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Status }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Status }{@code >}
     */
    @XmlElementDecl(namespace = "http://boundary.soap.demo.ee.course/", name = "status")
    public JAXBElement<Status> createStatus(Status value) {
        return new JAXBElement<>(_Status_QNAME, Status.class, null, value);
    }

}
