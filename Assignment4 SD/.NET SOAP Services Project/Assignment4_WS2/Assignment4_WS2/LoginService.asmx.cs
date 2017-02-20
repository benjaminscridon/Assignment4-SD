using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Assignment4_WS2
{
    /// <summary>
    /// Summary description for LoginService
    /// </summary>
    [WebService(Namespace = "http://net.login/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class LoginService : System.Web.Services.WebService
    {

        [WebMethod]
        public long addUser(string firstName, string lastName, string password, string email, int type)
        {
            user u = new user()
            {
                userType = type,
                firstName = firstName,
                lastName = lastName,
                email = email,
                password = password
            };
            assignment4Entities context = new assignment4Entities();
            context.users.Add(u);
            context.SaveChanges();

            user u1 = context.users.SingleOrDefault(user => user.email == email);
            return u1.id;
        }

        [WebMethod]
        public UserModel getUser(string mail, string password)
        {
            assignment4Entities context = new assignment4Entities();
            user u = context.users.SingleOrDefault(user => user.password == password && user.email ==mail);

            return UserModel.toModel(u);
        }
    }
}
