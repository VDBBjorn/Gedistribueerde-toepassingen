using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ServiceModel;


namespace BadmintonServerConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            // ServiceHost aanmaken
            using (ServiceHost serviceHost =
                   new ServiceHost(typeof(BadmintonServiceLibrary.BadmintonService)))
            {
                // ServiceHost openen en luisteren naar berichten
                serviceHost.Open();

                // Service actief
                Console.WriteLine("De BadmintonServer is klaar.");
                Console.WriteLine("Klik <ENTER> om af te sluiten.");
                Console.WriteLine();
                Console.ReadLine();
            }

        }
    }
}
