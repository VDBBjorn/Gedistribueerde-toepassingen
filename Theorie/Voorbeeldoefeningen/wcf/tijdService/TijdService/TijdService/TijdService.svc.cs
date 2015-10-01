using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace TijdService
{
    public class TijdService : ITijdService
    {

        public DateTime GetServerTime()
        {
            Console.WriteLine("Time requested by a client.");
            return DateTime.Now;
        }
       
    }
}
