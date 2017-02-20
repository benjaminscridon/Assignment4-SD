using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Assignment4_WS2
{
    public class RouteItemModel
    {
        private string city;
        private long id;
        private DateTime date;

        public string City
        {
            get
            {
                return city;
            }

            set
            {
                city = value;
            }
        }

        public DateTime Date
        {
            get
            {
                return date;
            }

            set
            {
                date = value;
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

        public static RouteItemModel toModel(route_item item)
        {
            return new RouteItemModel
            {
                Date = item.date,
                City = item.city,
                Id = item.id
            };
        }
    }
}