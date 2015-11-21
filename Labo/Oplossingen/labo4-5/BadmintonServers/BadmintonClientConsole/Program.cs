using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BadmintonClientConsole.BadmintonServiceReference;

namespace BadmintonClientConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            BadmintonServiceClient client = new BadmintonServiceClient();
            foreach (SportClub club in client.GetSportClubs())
            {
                Console.WriteLine(club.ID + " " + club.Naam);
                if (club.Tornooien.Length > 0)
                {
                    Console.WriteLine("Tornooien");
                    foreach (Tornooi tornooi in club.Tornooien)
                    {
                        Console.WriteLine(tornooi.Naam);
                    }
                }
            }

            Console.WriteLine("Geef id van club: ");
            string idString = Console.ReadLine();
            int id = int.Parse(idString);
            Console.WriteLine("Leden");
            foreach (Lid lid in client.GetLeden(id))
            {
                Console.WriteLine(lid.Naam);
            }
            client.Close();

        }
    }
}
