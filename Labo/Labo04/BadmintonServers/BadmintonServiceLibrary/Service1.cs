using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace BadmintonServiceLibrary
{
    public class BadmintonService : IBadmintonService
    {
        public LidDAO[] GeefLeden(int clubID)
        {
            AutoMapper.Mapper.CreateMap<BadmintonInterface.Lid, LidDAO>();
            var service = new BadmintonInterface.BadmintonDAODummy();
            BadmintonInterface.Lid[] leden = service.GeefLeden(clubID);
            return AutoMapper.Mapper.Map<LidDAO[]>(leden);
        }

        public SportClubDAO[] GeefSportclubs()
        {
            AutoMapper.Mapper.CreateMap<BadmintonInterface.SportClub[], SportClubDAO[]>();
            var service = new BadmintonInterface.BadmintonDAODummy();
            return AutoMapper.Mapper.Map<SportClubDAO[]>(service.SportClubs);
        }
    }
}
