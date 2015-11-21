using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BadmintonWebClient.BadmintonServiceReference;

namespace BadmintonWebClient
{
    public partial class Clubs : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            BadmintonServiceClient client = new BadmintonServiceClient();
            OverzichtClubs.DataSource = client.GetSportClubs();
            OverzichtClubs.DataBind();
        }
    }
}