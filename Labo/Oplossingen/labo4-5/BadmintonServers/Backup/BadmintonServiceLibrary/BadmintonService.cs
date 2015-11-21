using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace BadmintonServiceLibrary
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in both code and config file together.
    public class BadmintonService : IBadmintonService
    {
        private BadmintonInterface.BadmintonDAO dao;

        BadmintonService()
        {
            dao = new BadmintonInterface.BadmintonDAODummy();
        }

        public SportClub[] GetSportClubs()
        {
            BadmintonInterface.SportClub[] clubs = dao.SportClubs;
            return ConverteerSportClubs(clubs);
        }

        private SportClub[] ConverteerSportClubs(BadmintonInterface.SportClub[] clubs)
        {
            SportClub[] badmintonClubs = new SportClub[clubs.Length];
            for (int i = 0; i < badmintonClubs.Length; i++)
            {
                BadmintonInterface.SportClub club = clubs[i];
                SportClub badmintonClub = new SportClub();
                badmintonClub.ID = club.ID;
                badmintonClub.Naam = club.Naam;
                badmintonClub.Tornooien = ConverteerTornooien(club.Tornooien);
                badmintonClubs[i] = badmintonClub;
            }
            return badmintonClubs;
        }

        private Tornooi[] ConverteerTornooien(IList<BadmintonInterface.Tornooi> tornooien)
        {
            Tornooi[] webTornooien = new Tornooi[tornooien.Count];
            for (int i = 0; i < webTornooien.Length; i++)
            {
                BadmintonInterface.Tornooi tornooi = tornooien[i];
                Tornooi webTornooi = new Tornooi();
                webTornooi.ID = tornooi.ID;
                webTornooi.Naam = tornooi.Naam;
                webTornooien[i] = webTornooi;
            }
            return webTornooien;
        }


        public Lid[] GetLeden(int sportclubID)
        {
            BadmintonInterface.Lid[] leden = dao.GeefLeden(sportclubID);
            Lid[] webLeden = ConverteerLeden(leden);
            return webLeden;
        }

        private Lid[] ConverteerLeden(BadmintonInterface.Lid[] leden)
        {
            Lid[] webLeden = new Lid[leden.Length];
            for (int i = 0; i < webLeden.Length; i++)
            {
                BadmintonInterface.Lid lid = leden[i];
                Lid webLid = new Lid();
                webLid.ID = lid.ID;
                webLid.Naam = lid.Naam;
                webLeden[i] = webLid;
            }
            return webLeden;
        }
    }

    
}
