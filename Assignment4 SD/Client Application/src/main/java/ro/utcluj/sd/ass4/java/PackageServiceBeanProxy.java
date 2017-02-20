package ro.utcluj.sd.ass4.java;

public class PackageServiceBeanProxy implements PackageServiceBean {
  private String _endpoint = null;
  private PackageServiceBean packageServiceBean = null;
  
  public PackageServiceBeanProxy() {
    _initPackageServiceBeanProxy();
  }
  
  public PackageServiceBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initPackageServiceBeanProxy();
  }
  
  private void _initPackageServiceBeanProxy() {
    try {
      packageServiceBean = (new PackageServiceBeanServiceLocator()).getPackageServiceBean();
      if (packageServiceBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)packageServiceBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)packageServiceBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (packageServiceBean != null)
      ((javax.xml.rpc.Stub)packageServiceBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public PackageServiceBean getPackageServiceBean() {
    if (packageServiceBean == null)
      _initPackageServiceBeanProxy();
    return packageServiceBean;
  }
  
  public void deletePackage(PackageDTO p) throws java.rmi.RemoteException{
    if (packageServiceBean == null)
      _initPackageServiceBeanProxy();
    packageServiceBean.deletePackage(p);
  }
  
  public PackageDTO[] getAllPackages() throws java.rmi.RemoteException{
    if (packageServiceBean == null)
      _initPackageServiceBeanProxy();
    return packageServiceBean.getAllPackages();
  }
  
  public void setPackageTrackable(boolean trackable, long packageId) throws java.rmi.RemoteException{
    if (packageServiceBean == null)
      _initPackageServiceBeanProxy();
    packageServiceBean.setPackageTrackable(trackable, packageId);
  }
  
  public void addRouteItemToPackage(RouteItem routeItem, long packageId) throws java.rmi.RemoteException{
    if (packageServiceBean == null)
      _initPackageServiceBeanProxy();
    packageServiceBean.addRouteItemToPackage(routeItem, packageId);
  }
  
  public PackageDTO[] getPackagesByNameOrId(java.lang.String name, long id) throws java.rmi.RemoteException{
    if (packageServiceBean == null)
      _initPackageServiceBeanProxy();
    return packageServiceBean.getPackagesByNameOrId(name, id);
  }
  
  public void addPackage(PackageDTO p) throws java.rmi.RemoteException{
    if (packageServiceBean == null)
      _initPackageServiceBeanProxy();
    packageServiceBean.addPackage(p);
  }
  
  
}