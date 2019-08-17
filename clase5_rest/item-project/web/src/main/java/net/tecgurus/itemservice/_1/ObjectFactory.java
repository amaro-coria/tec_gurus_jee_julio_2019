
package net.tecgurus.itemservice._1;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.tecgurus.itemservice._1 package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.tecgurus.itemservice._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindStockByIdResponse }
     * 
     */
    public FindStockByIdResponse createFindStockByIdResponse() {
        return new FindStockByIdResponse();
    }

    /**
     * Create an instance of {@link StockNumber }
     * 
     */
    public StockNumber createStockNumber() {
        return new StockNumber();
    }

    /**
     * Create an instance of {@link FindStockByIdRequest }
     * 
     */
    public FindStockByIdRequest createFindStockByIdRequest() {
        return new FindStockByIdRequest();
    }

    /**
     * Create an instance of {@link ItemIdElement }
     * 
     */
    public ItemIdElement createItemIdElement() {
        return new ItemIdElement();
    }

}
