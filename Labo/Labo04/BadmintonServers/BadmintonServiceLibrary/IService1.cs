using BadmintonInterface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace BadmintonServiceLibrary
{
    [ServiceContract(Namespace = "http://Microsoft.ServiceModel.Sample")]
    public interface IBadmintonService
    {
        [OperationContract]
        LidDAO[] GeefLeden(int clubID);
        [OperationContract]
        SportClubDAO[] GeefSportclubs();
    }

    [DataContract]
    public class LidDAO
    {
        [DataMember]
        int ID { get; set; }
        [DataMember]
        string Naam { get; set; }
    }

    [DataContract]
    public class SportClubDAO
    {
        public SportClubDAO()
        {
            Tornooien = new List<TornooiDAO>();
        }
        [DataMember]
        int ID { get; set; }
        [DataMember]
        string Naam { get; set; }
        [DataMember]
        List<TornooiDAO> Tornooien { get; set; }
    }

    [DataContract]
    public class TornooiDAO
    {
        [DataMember]
        int ID { get; set; }
        [DataMember]
        string Naam { get; set; }
    }
}
