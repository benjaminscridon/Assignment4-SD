package ro.utcluj.sd.ass4.net.service.login;

public class LoginServiceSoapProxy implements LoginServiceSoap {
  private String _endpoint = null;
  private LoginServiceSoap loginServiceSoap = null;
  
  public LoginServiceSoapProxy() {
    _initLoginServiceSoapProxy();
  }
  
  public LoginServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initLoginServiceSoapProxy();
  }
  
  private void _initLoginServiceSoapProxy() {
    try {
      loginServiceSoap = (new LoginServiceLocator()).getLoginServiceSoap();
      if (loginServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)loginServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)loginServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (loginServiceSoap != null)
      ((javax.xml.rpc.Stub)loginServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public LoginServiceSoap getLoginServiceSoap() {
    if (loginServiceSoap == null)
      _initLoginServiceSoapProxy();
    return loginServiceSoap;
  }
  
  public long addUser(java.lang.String firstName, java.lang.String lastName, java.lang.String password, java.lang.String email, int type) throws java.rmi.RemoteException{
    if (loginServiceSoap == null)
      _initLoginServiceSoapProxy();
    return loginServiceSoap.addUser(firstName, lastName, password, email, type);
  }
  
  public UserModel getUser(java.lang.String mail, java.lang.String password) throws java.rmi.RemoteException{
    if (loginServiceSoap == null)
      _initLoginServiceSoapProxy();
    return loginServiceSoap.getUser(mail, password);
  }
  
  
}