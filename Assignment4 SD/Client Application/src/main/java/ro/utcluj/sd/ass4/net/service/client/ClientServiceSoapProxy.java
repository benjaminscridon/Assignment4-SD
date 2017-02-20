package ro.utcluj.sd.ass4.net.service.client;

public class ClientServiceSoapProxy implements ClientServiceSoap {
  private String _endpoint = null;
  private ClientServiceSoap clientServiceSoap = null;
  
  public ClientServiceSoapProxy() {
    _initClientServiceSoapProxy();
  }
  
  public ClientServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initClientServiceSoapProxy();
  }
  
  private void _initClientServiceSoapProxy() {
    try {
      clientServiceSoap = (new ClientServiceLocator()).getClientServiceSoap();
      if (clientServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)clientServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)clientServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (clientServiceSoap != null)
      ((javax.xml.rpc.Stub)clientServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ClientServiceSoap getClientServiceSoap() {
    if (clientServiceSoap == null)
      _initClientServiceSoapProxy();
    return clientServiceSoap;
  }
  
  public PackageModel[] getAllPackagesByUserEmail(java.lang.String email) throws java.rmi.RemoteException{
    if (clientServiceSoap == null)
      _initClientServiceSoapProxy();
    return clientServiceSoap.getAllPackagesByUserEmail(email);
  }
  
  public PackageModel[] getAllPackagesByUserEmailAndId(java.lang.String email, long id, java.lang.String name) throws java.rmi.RemoteException{
    if (clientServiceSoap == null)
      _initClientServiceSoapProxy();
    return clientServiceSoap.getAllPackagesByUserEmailAndId(email, id, name);
  }
  
  
}