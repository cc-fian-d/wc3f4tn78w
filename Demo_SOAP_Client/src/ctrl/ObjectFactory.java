
package ctrl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ctrl package. 
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

    private final static QName _CalculateResponse_QNAME = new QName("http://ctrl/", "calculateResponse");
    private final static QName _Calculate_QNAME = new QName("http://ctrl/", "calculate");
    private final static QName _Hello_QNAME = new QName("http://ctrl/", "hello");
    private final static QName _LongTimeCalculate_QNAME = new QName("http://ctrl/", "longTimeCalculate");
    private final static QName _HoleBuch_QNAME = new QName("http://ctrl/", "holeBuch");
    private final static QName _Buch_QNAME = new QName("http://ctrl/", "buch");
    private final static QName _HelloResponse_QNAME = new QName("http://ctrl/", "helloResponse");
    private final static QName _HoleBuchResponse_QNAME = new QName("http://ctrl/", "holeBuchResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ctrl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HoleBuch }
     * 
     */
    public HoleBuch createHoleBuch() {
        return new HoleBuch();
    }

    /**
     * Create an instance of {@link Buch }
     * 
     */
    public Buch createBuch() {
        return new Buch();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link HoleBuchResponse }
     * 
     */
    public HoleBuchResponse createHoleBuchResponse() {
        return new HoleBuchResponse();
    }

    /**
     * Create an instance of {@link CalculateResponse }
     * 
     */
    public CalculateResponse createCalculateResponse() {
        return new CalculateResponse();
    }

    /**
     * Create an instance of {@link Calculate }
     * 
     */
    public Calculate createCalculate() {
        return new Calculate();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link LongTimeCalculate }
     * 
     */
    public LongTimeCalculate createLongTimeCalculate() {
        return new LongTimeCalculate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctrl/", name = "calculateResponse")
    public JAXBElement<CalculateResponse> createCalculateResponse(CalculateResponse value) {
        return new JAXBElement<CalculateResponse>(_CalculateResponse_QNAME, CalculateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Calculate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctrl/", name = "calculate")
    public JAXBElement<Calculate> createCalculate(Calculate value) {
        return new JAXBElement<Calculate>(_Calculate_QNAME, Calculate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctrl/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LongTimeCalculate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctrl/", name = "longTimeCalculate")
    public JAXBElement<LongTimeCalculate> createLongTimeCalculate(LongTimeCalculate value) {
        return new JAXBElement<LongTimeCalculate>(_LongTimeCalculate_QNAME, LongTimeCalculate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoleBuch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctrl/", name = "holeBuch")
    public JAXBElement<HoleBuch> createHoleBuch(HoleBuch value) {
        return new JAXBElement<HoleBuch>(_HoleBuch_QNAME, HoleBuch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Buch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctrl/", name = "buch")
    public JAXBElement<Buch> createBuch(Buch value) {
        return new JAXBElement<Buch>(_Buch_QNAME, Buch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctrl/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoleBuchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctrl/", name = "holeBuchResponse")
    public JAXBElement<HoleBuchResponse> createHoleBuchResponse(HoleBuchResponse value) {
        return new JAXBElement<HoleBuchResponse>(_HoleBuchResponse_QNAME, HoleBuchResponse.class, null, value);
    }

}
