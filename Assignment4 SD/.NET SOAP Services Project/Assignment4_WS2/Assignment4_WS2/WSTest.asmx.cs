using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Assignment4_WS2
{
    /// <summary>
    /// Summary description for WSTest
    /// </summary>
    [WebService(Namespace = "http://WSTest", Name = "WSTest", Description = "Test Service By Anand Thakur")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WSTest : System.Web.Services.WebService
    {

        [WebMethod]
        public Class1 HelloWorld()
        {
            assignment4Entities context = new assignment4Entities();

            user[] users = context.users.ToArray();
            Console.WriteLine(users);
            return new Class1 { hello = users[0].lastName, word = "huhu" };
        }
    }
}
