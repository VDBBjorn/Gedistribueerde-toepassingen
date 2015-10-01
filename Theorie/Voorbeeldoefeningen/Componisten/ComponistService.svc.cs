using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Activation;
using System.ServiceModel.Web;
using System.Text;

namespace Componisten
{
    [ServiceContract(Namespace = "")]
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class ComponistService
    {
        // To use HTTP GET, add [WebGet] attribute. (Default ResponseFormat is WebMessageFormat.Json)
        // To create an operation that returns XML,
        //     add [WebGet(ResponseFormat=WebMessageFormat.Xml)],
        //     and include the following line in the operation body:
        //         WebOperationContext.Current.OutgoingResponse.ContentType = "text/xml";
        [OperationContract]
        public void DoWork()
        {
            // Add your operation implementation here
            return;
        }

        [OperationContract]
        [WebGet(ResponseFormat = WebMessageFormat.Json)]
        public IList<Componist> GetComponisten(string letters)
        {
            IList<Componist> resultaat = new List<Componist>(); // bevat mogelijke namen
            if (letters != null)
            {
                letters = letters.Trim().ToLower();

                // check if user sent empty string
                if (letters != "")
                {
                    ComponistenData componisten = new ComponistenData();
                    foreach (Componist componist in componisten.Componists.Values)
                    {
                        string firstname = componist.FirstName.ToLower();
                        string lastname = componist.LastName.ToLower();
                        string name = firstname + (" ") + lastname;
                        if ( // letters matches first name                            
                                firstname.StartsWith(letters)
                                || // letters matches last name                            
                                lastname.StartsWith(letters)
                                || // letters matches full name
                                name.StartsWith(letters))
                        {
                            resultaat.Add(componist);
                        }
                    }


                }
            }
            return resultaat;
        }
    }
}
