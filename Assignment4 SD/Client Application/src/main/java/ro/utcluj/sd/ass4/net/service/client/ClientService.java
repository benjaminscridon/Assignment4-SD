/**
 * ClientService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ro.utcluj.sd.ass4.net.service.client;

public interface ClientService extends javax.xml.rpc.Service {
    public java.lang.String getClientServiceSoapAddress();

    public ClientServiceSoap getClientServiceSoap() throws javax.xml.rpc.ServiceException;

    public ClientServiceSoap getClientServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
