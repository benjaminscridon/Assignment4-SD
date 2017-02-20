using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Assignment4_WS2
{
    public class UserModel
    {
        private long id;
        private string firstName;
        private string lastName;
        private string email;
        private string password;
        private int userType;
        private List<PackageModel> sentPackages;
        private List<PackageModel> receivedPackages;

        public string FirstName
        {
            get
            {
                return firstName;
            }

            set
            {
                firstName = value;
            }
        }

        public string LastName
        {
            get
            {
                return lastName;
            }

            set
            {
                lastName = value;
            }
        }

       

        public string Email
        {
            get
            {
                return email;
            }

            set
            {
                email = value;
            }
        }

        public string Password
        {
            get
            {
                return password;
            }

            set
            {
                password = value;
            }
        }

        public long Id
        {
            get
            {
                return id;
            }

            set
            {
                id = value;
            }
        }

        public int UserType
        {
            get
            {
                return userType;
            }

            set
            {
                userType = value;
            }
        }

        public List<PackageModel> ReceivedPackages
        {
            get
            {
                return receivedPackages;
            }

            set
            {
                receivedPackages = value;
            }
        }

        public List<PackageModel> SentPackages
        {
            get
            {
                return sentPackages;
            }

            set
            {
                sentPackages = value;
            }
        }

        public static UserModel toModel(user u)
        {
            UserModel uu =  new UserModel
            {
                Id = u.id,
                FirstName = u.firstName,
                LastName = u.lastName,
                Email = u.email,
                Password = u.password,
                UserType = (int)u.userType
            };

            uu.SentPackages = new List<PackageModel>();
            uu.ReceivedPackages =  new List<PackageModel>();

            foreach (package it in u.packages)
            {
                uu.SentPackages.Add(PackageModel.toModel(it));
            }
            foreach (package it in u.packages1)
            {
                uu.ReceivedPackages.Add(PackageModel.toModel(it));
            }
            return uu;
        }
        public static UserModel toModelLazy(user u)
        {
            UserModel uu = new UserModel
            {
                Id = u.id,
                FirstName = u.firstName,
                LastName = u.lastName,
                Email = u.email,
                Password = u.password,
                UserType = (int)u.userType
            };
            return uu;
        }
    }
}