using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ServiceModel;
using System.ServiceModel.Description;
using TijdService;

namespace tijdServer
{
    class Program
    {
        static void Main(string[] args)
        {
            Uri baseAddress = new Uri("http://localhost:49999/TijdService");
            using (ServiceHost host = 
                new ServiceHost(typeof(TijdService.TijdService), baseAddress))
            {

                host.AddServiceEndpoint(typeof(TijdService.ITijdService), 
                    new WSHttpBinding(), "VraagTijd");
                ServiceMetadataBehavior smb = 
                    new ServiceMetadataBehavior();
                smb.HttpGetEnabled = true;
                host.Description.Behaviors.Add(smb);

                host.Open();
                Console.WriteLine("The service is ready at {0}", baseAddress);
                Console.WriteLine("Press <Enter> to stop the service.");
                Console.ReadLine();

                host.Close();
            }

        }
    }
}
