using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Assignment4_WS2
{
    /// <summary>
    /// Summary description for ClientService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class ClientService : System.Web.Services.WebService
    {

        [WebMethod]
        public List<PackageModel> getAllPackagesByUserEmail(string email)
        {
            List<PackageModel> result = new List<PackageModel>();
            assignment4Entities context = new assignment4Entities();
            List<package> pkgs = context.packages.Where(p => p.user1.email == email ||
                            p.user.email == email).ToList();
            foreach (package it in pkgs)
            {
                result.Add(PackageModel.toModel(it));
            }
            return result;
        }
        [WebMethod]
        public List<PackageModel> getAllPackagesByUserEmailAndId(string email, long id, string name)
        {
            List<PackageModel> result = new List<PackageModel>();
            assignment4Entities context = new assignment4Entities();
            List<package> pkgs = context.packages.Where(p => (p.user1.email == email ||
                            p.user.email == email) && (p.id == id || p.name == name)).ToList();
            foreach (package it in pkgs)
            {
                result.Add(PackageModel.toModel(it));
            }
            return result;
        }

    }
}
