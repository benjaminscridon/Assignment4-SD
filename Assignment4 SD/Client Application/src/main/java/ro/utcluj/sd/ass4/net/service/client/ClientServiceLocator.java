/**
 * ClientServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ro.utcluj.sd.ass4.net.service.client;

public class ClientServiceLocator extends org.apache.axis.client.Service implements ClientService {

    public ClientServiceLocator() {
    }


    public ClientServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClientServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ClientServiceSoap
    private java.lang.String ClientServiceSoap_address = "http://localhost:50499/ClientService.asmx";

    public java.lang.String getClientServiceSoapAddress() {
        return ClientServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClientServiceSoapWSDDServiceName = "ClientServiceSoap";

    public java.lang.String getClientServiceSoapWSDDServiceName() {
        return ClientServiceSoapWSDDServiceName;
    }

    public void setClientServiceSoapWSDDServiceName(java.lang.String name) {
        ClientServiceSoapWSDDServiceName = name;
    }

    public ClientServiceSoap getClientServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClientServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClientServiceSoap(endpoint);
    }

    public ClientServiceSoap getClientServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ClientServiceSoapStub _stub = new ClientServiceSoapStub(portAddress, this);
            _stub.setPortName(getClientServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClientServiceSoapEndpointAddress(java.lang.String address) {
        ClientServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ClientServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                ClientServiceSoapStub _stub = new ClientServiceSoapStub(new java.net.URL(ClientServiceSoap_address), this);
                _stub.setPortName(getClientServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ClientServiceSoap".equals(inputPortName)) {
            return getClientServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "ClientService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "ClientServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ClientServiceSoap".equals(portName)) {
            setClientServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
