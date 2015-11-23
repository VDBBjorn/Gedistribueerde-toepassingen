using BadmintonClientWeb.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BadmintonClientWeb.Controllers
{
    public class HomeController : Controller
    {
        private BadmintonServiceClient client;
        
        public HomeController()
        {
            client = new BadmintonServiceClient();
        }

        // GET: Home
        public ActionResult Index()
        {
            List<SportClub> clubs = client.GetSportClubs().ToList();
            return View(clubs);
        }

        public ActionResult GetLeden(int id)
        {
            var leden = client.GetLeden(id).ToList();
            return View(leden);
        }
    }
}