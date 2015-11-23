using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace BadmintonServerConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            using (ServiceHost host = new ServiceHost(typeof(BadmintonServiceLibrary.BadmintonService)))
            {
                host.Open();
                Console.WriteLine("De BadmintonServer is klaar.");
                Console.WriteLine("Klik <ENTER> om af te sluiten.");
                Console.WriteLine();
                Console.ReadLine();
            }
        }
    }
}
