using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using tijdWebserviceClient.TijdService;

namespace tijdWebserviceClient
{
    class Program
    {
        static void Main(string[] args)
        {
            ITijdService tijdDienst = new TijdServiceClient();
            Console.WriteLine("Tijd op server: " + tijdDienst.GetServerTime());
        }
    }
}
