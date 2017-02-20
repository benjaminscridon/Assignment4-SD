using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Assignment4_WS2
{
	public class PackageModel
	{
        private long id;
        private string name;
        private string description;
        private string senderCity;
        private string destinationCity;
        private bool tacking;
        private UserModel sender;
        private UserModel receiver;
        private List<RouteItemModel> route;

        public string Name
        {
            get
            {
                return name;
            }

            set
            {
                name = value;
            }
        }

        public string Description
        {
            get
            {
                return description;
            }

            set
            {
                description = value;
            }
        }

        public string SenderCity
        {
            get
            {
                return senderCity;
            }

            set
            {
                senderCity = value;
            }
        }

        public string DestinationCity
        {
            get
            {
                return destinationCity;
            }

            set
            {
                destinationCity = value;
            }
        }

        public bool Tacking
        {
            get
            {
                return tacking;
            }

            set
            {
                tacking = value;
            }
        }

        public UserModel Sender
        {
            get
            {
                return sender;
            }

            set
            {
                sender = value;
            }
        }

        public UserModel Receiver
        {
            get
            {
                return receiver;
            }

            set
            {
                receiver = value;
            }
        }

        public List<RouteItemModel> Route
        {
            get
            {
                return route;
            }

            set
            {
                route = value;
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

        public static PackageModel toModel(package item)
        {
            PackageModel model = new PackageModel
            {
                Id = item.id,
                Receiver = UserModel.toModelLazy(item.user1),
                Sender = UserModel.toModelLazy(item.user),
                Tacking = (bool)item.tracking,
                SenderCity = item.senderCity,
                DestinationCity = item.destinationCity,
                Name = item.name,
                Description = item.description
            };

            model.Route = new List<RouteItemModel>();

            foreach(route_item it in item.route_item)
            {
                model.Route.Add(RouteItemModel.toModel(it));
            }
            return model;
        }
    }
}